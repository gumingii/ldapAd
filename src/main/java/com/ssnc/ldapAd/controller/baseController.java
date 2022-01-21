package com.ssnc.ldapAd.controller;
/*
*
*   시작일 : 2021-08-10
*	최종 수정일 : 2021-08-17
*   개발 : 연구소 강소연
*
*/


import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;
import javax.naming.ldap.InitialLdapContext;
import javax.naming.ldap.LdapContext;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ssnc.ldapAd.config.ldapAdConstant;
import com.ssnc.ldapAd.config.sstopcCommonUtil;
import com.ssnc.ldapAd.service.oasisServiceInterface;
import com.ssnc.ldapAd.vo.empVo;
import com.ssnc.ldapAd.vo.ldapListVo;
import com.ssnc.ldapAd.vo.returnMessageVo;

//@Controller
@RestController
@Component
public class baseController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private oasisServiceInterface oasisServiceInterface;
	
	@RequestMapping(value = "/system/ldap", method = { RequestMethod.GET, RequestMethod.POST })
	public ResponseEntity<String> ldap(Model model) throws Exception {
		LdapContext ctx;
		sstopcCommonUtil scu = new sstopcCommonUtil();
		
		String adminid = scu.getAdminId(); 
		String userid = scu.getUserId(); 
		String passwd = scu.getPasswd();
		String ldapUrl = scu.getLdapUrl();
		String baseRdn = scu.getBaseRdn();
		
		Hashtable<String, String> env = new Hashtable<String, String>();
		env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
		env.put(Context.SECURITY_AUTHENTICATION, "simple");
		env.put(Context.PROVIDER_URL, ldapUrl);
		env.put(Context.SECURITY_PRINCIPAL, adminid);
		//usrEnv.put(Context.SECURITY_PRINCIPAL, String.format("%s=%s,%s", "cn", userid, baseRdn));

		env.put(Context.SECURITY_CREDENTIALS, passwd);

		ctx = new InitialLdapContext(env, null);

		logger.debug("\n\n▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩ Active Directory Connection: CONNECTED ▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩\n\n");
		
		SearchControls ctls = new SearchControls();
		ctls.setSearchScope(SearchControls.SUBTREE_SCOPE);
//		ctls.setReturningAttributes(new String[] { "name", "sAMAccountName", "cn", "userPrincipalName", "memberOf" });

		/*
		 -- 사용자 전체
DirContext context = new InitialDirContext(properties);
         SearchControls searchCtrls = new SearchControls();
         searchCtrls.setSearchScope(SearchControls.SUBTREE_SCOPE);
         String filter = "(objectClass=*)";
         NamingEnumeration values = context.search(" ou=users,ou=system",filter,searchCtrls);
         while (values.hasMoreElements())
         {
            SearchResult result = (SearchResult) values.next();
            Attributes attribs = result.getAttributes();

            if (null != attribs)
            {
               for (NamingEnumeration ae = attribs.getAll(); ae.hasMoreElements();)
               {
                  Attribute atr = (Attribute) ae.next();
                  String attributeID = atr.getID();
                  for (Enumeration vals = atr.getAll(); 
                     vals.hasMoreElements(); 
                     System.out.println(attributeID +": "+ vals.nextElement()));
               }
            }
         }

-- 그룹 전체
 DirContext ctx = new InitialDirContext(env);
            SearchControls ctls = new SearchControls();
            String[] attrIDs = { "cn" };
            ctls.setReturningAttributes(attrIDs);
            ctls.setSearchScope(SearchControls.ONELEVEL_SCOPE);

            NamingEnumeration answer = ctx.search(usersContainer, "(objectclass=group)", ctls);
            while (answer.hasMore()) {
                SearchResult rslt = (SearchResult) answer.next();
                Attributes attrs = rslt.getAttributes();
                System.out.println(attrs.get("cn"));
            }
		 * */
		//sAMAccountName=Guest
		// 인증이 확인 됬다면 usrId, usrPw, baseRdn(유저가 등록된 위치)으로 Admin에서 등록한 유저를 찾아봅시다!
//		String searchFilter = String.format("(&(objectCategory=person)(objectClass=user))"); //user
//		String searchFilter = String.format("(objectClass=*)");
//		String searchFilter = String.format("(company=에스에스앤씨)");
//		String saearchFilter = String.format("(&(objectClass=user)(sAMAccountName=%s))", userid)
//		String searchFilter = String.format("(cn=%s)", userid);

		// ▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩  emp  ▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩
//		ctls.setReturningAttributes(new String[] { "SAMAccountName", "company",  "department", "name", "userPrincipalName" });
		String searchFilter = String.format(scu.getSearch());
		NamingEnumeration<SearchResult> results = ctx.search(baseRdn, searchFilter, ctls);

		ldapListVo ldaplist = new ldapListVo();
		List<Object> list = new ArrayList<Object>();
		while (results.hasMoreElements()) {
			logger.debug("--------------");
			SearchResult sr = results.next();
			Attributes attrs = sr.getAttributes();
			//NamingEnumeration<String> ids = attrs.getIDs();
			NamingEnumeration<Attribute> ids = (NamingEnumeration<Attribute>) attrs.getAll();
			Map<String, Object> map = new HashMap<String, Object>();
			
			
			
			while (ids.hasMore()) {
				Attribute atr = (Attribute) ids.next();
				String attributeID = atr.getID();
				
				Enumeration vals = atr.getAll();
				while (vals.hasMoreElements()) {
					String element = vals.nextElement().toString();
					 map.put(attributeID, element);
					 logger.debug(">> " +attributeID+" : "+element);
				}
				
			}
			
			list.add(map);
			
		}
		ldaplist.setLdapList(list);

		//setEmp2 : ex_emp2  기존 정보 삭제 후  DB insert
//		oasisServiceInterface.setEmp2(ldaplist);
//		ldaplist = oasisServiceInterface.getLdapListVo("emp");

		/*
		// ▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩  dept  ▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩
		SearchControls ctls2 = new SearchControls();
		ctls2.setSearchScope(SearchControls.SUBTREE_SCOPE);
		ctls2.setReturningAttributes(new String[] { "company",  "department" });
//		ctls.setReturningAttributes(new String[] { "objectClass"});

//		searchFilter = String.format(scu.getSearch());
		searchFilter = String.format("(&(sAMAccountName=*)(company=*))");
		results = ctx.search(baseRdn, searchFilter, ctls2);

		ldapListVo ldaplist2 = new ldapListVo();
		List<Object> list2 = new ArrayList<Object>();

		while (results.hasMoreElements()) {
			//logger.debug("--------------");
			SearchResult sr = results.next();
			Attributes attrs = sr.getAttributes();
			//NamingEnumeration<String> ids = attrs.getIDs();
			NamingEnumeration<Attribute> ids = (NamingEnumeration<Attribute>) attrs.getAll();
			Map<String, Object> map = new HashMap<String, Object>();
			while (ids.hasMore()) {
				Attribute atr = (Attribute) ids.next();
				String attributeID = atr.getID();

				for (Enumeration vals = atr.getAll();
					 vals.hasMoreElements();
					 map.put(attributeID, vals.nextElement())
				);
			}
			list2.add(map);
			logger.debug(String.valueOf(list2));
		}
		ldaplist2.setLdapList(list2);

		//setDept2 : ex_dept2  기존 정보 삭제 후  DB insert
//		oasisServiceInterface.setDept2(ldaplist2);
//		ldaplist2 = oasisServiceInterface.getLdapListVo("dept");
		*/
		return ResponseEntity.ok().body(String.valueOf(ldaplist));

	}
	
	// api호출시 실행
	@RequestMapping(value = "/", method = { RequestMethod.GET, RequestMethod.POST })
	public ResponseEntity<String> version() {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes())
				.getRequest();

		logger.debug("Receive IP Information");

		String ip = request.getHeader("X-Forwarded-For");
		logger.debug("X-FORWARDED-FOR : " + ip);

		if (ip == null) {
			ip = request.getHeader("Proxy-Client-IP");
			logger.debug("Proxy-Client-IP : " + ip);
		}
		if (ip == null) {
			ip = request.getHeader("WL-Proxy-Client-IP");
			logger.debug("WL-Proxy-Client-IP : " + ip);
		}
		if (ip == null) {
			ip = request.getHeader("HTTP_CLIENT_IP");
			logger.debug("HTTP_CLIENT_IP : " + ip);
		}
		if (ip == null) {
			ip = request.getHeader("HTTP_X_FORWARDED_FOR");
			logger.debug("HTTP_X_FORWARDED_FOR : " + ip);
		}
		if (ip == null) {
			ip = request.getRemoteAddr();
			logger.debug("getRemoteAddr : " + ip);
		}
		logger.debug("Result IP Address : " + ip);

		return ResponseEntity.ok().body("ldapAd API Service");

	}

	/*
	 * for System Controller
	 */
	@RequestMapping(value = "/system/getVersion", method = { RequestMethod.GET, RequestMethod.POST })
	public ResponseEntity<String> version2() throws Exception {
		return ResponseEntity.ok().body("ldapAd API Service 1.0.0.1");
	}

	/*
	 * DO NOT CREATE Mappers(Methods) below this Comments for Maintain
	 */

	// API NOT Found Error Class
	@RequestMapping(value = "/*", method = { RequestMethod.GET, RequestMethod.POST })
	public ResponseEntity<returnMessageVo> handlerGET() {
		returnMessageVo em = new returnMessageVo();
		em.setStatus(ldapAdConstant.NotFound);
		em.setError(ldapAdConstant.NotFoundMessage);
		em.setMessage("요청하신 URL을 찾을 수 없습니다. (GET)");
		em.setErrorclass("Global.NotFoundGET");
		return ResponseEntity.ok().body(em);
	}

	@RequestMapping(value = "/*", method = RequestMethod.POST)
	public ResponseEntity<returnMessageVo> handlerPOST() {
		returnMessageVo em = new returnMessageVo();
		em.setStatus(ldapAdConstant.NotFound);
		em.setError(ldapAdConstant.NotFoundMessage);
		em.setMessage("요청하신 URL을 찾을 수 없습니다. (POST)");
		em.setErrorclass("Global.NotFoundPOST");
		return ResponseEntity.ok().body(em);
	}

}
