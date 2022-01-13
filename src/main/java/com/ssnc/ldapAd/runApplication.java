package com.ssnc.ldapAd;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.ssnc.ldapAd.config.sstopcCommonUtil;

import java.util.Enumeration;
import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;
import javax.naming.ldap.InitialLdapContext;
import javax.naming.ldap.LdapContext;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;

@Component
public class runApplication implements CommandLineRunner {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public void run(String... args) throws Exception {
		/*
		 * LdapContext ctx; sstopcCommonUtil scu = new sstopcCommonUtil();
		 * 
		 * String adminid = scu.getAdminId(); String userid = scu.getUserId(); String
		 * passwd = scu.getPasswd(); String ldapUrl = scu.getLdapUrl(); String baseRdn =
		 * scu.getBaseRdn();
		 * 
		 * Hashtable<String, String> env = new Hashtable<String, String>();
		 * env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
		 * env.put(Context.SECURITY_AUTHENTICATION, "simple");
		 * env.put(Context.PROVIDER_URL, ldapUrl); env.put(Context.SECURITY_PRINCIPAL,
		 * adminid); //usrEnv.put(Context.SECURITY_PRINCIPAL, String.format("%s=%s,%s",
		 * "cn", userid, baseRdn));
		 * 
		 * env.put(Context.SECURITY_CREDENTIALS, passwd);
		 * 
		 * ctx = new InitialLdapContext(env, null);
		 * 
		 * logger.
		 * debug("\n\n▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩ Active Directory Connection: CONNECTED ▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩\n\n"
		 * );
		 * 
		 * SearchControls ctls = new SearchControls();
		 * ctls.setSearchScope(SearchControls.SUBTREE_SCOPE);
		 * //ctls.setReturningAttributes(new String[] { "DN", "cn" });
		 * 
		 * 
		 * -- 사용자 전체 DirContext context = new InitialDirContext(properties);
		 * SearchControls searchCtrls = new SearchControls();
		 * searchCtrls.setSearchScope(SearchControls.SUBTREE_SCOPE); String filter =
		 * "(objectClass=*)"; NamingEnumeration values =
		 * context.search(" ou=users,ou=system",filter,searchCtrls); while
		 * (values.hasMoreElements()) { SearchResult result = (SearchResult)
		 * values.next(); Attributes attribs = result.getAttributes();
		 * 
		 * if (null != attribs) { for (NamingEnumeration ae = attribs.getAll();
		 * ae.hasMoreElements();) { Attribute atr = (Attribute) ae.next(); String
		 * attributeID = atr.getID(); for (Enumeration vals = atr.getAll();
		 * vals.hasMoreElements(); System.out.println(attributeID +": "+
		 * vals.nextElement())); } } }
		 * 
		 * -- 그룹 전체 DirContext ctx = new InitialDirContext(env); SearchControls ctls =
		 * new SearchControls(); String[] attrIDs = { "cn" };
		 * ctls.setReturningAttributes(attrIDs);
		 * ctls.setSearchScope(SearchControls.ONELEVEL_SCOPE);
		 * 
		 * NamingEnumeration answer = ctx.search(usersContainer, "(objectclass=group)",
		 * ctls); while (answer.hasMore()) { SearchResult rslt = (SearchResult)
		 * answer.next(); Attributes attrs = rslt.getAttributes();
		 * System.out.println(attrs.get("cn")); }
		 * 
		 * 
		 * // 인증이 확인 됬다면 usrId, usrPw, baseRdn(유저가 등록된 위치)으로 Admin에서 등록한 유저를 찾아봅시다!
		 * String searchFilter = String.format("(objectClass=user)"); //user // String
		 * searchFilter = String.format("(objectClass=*)"); // String searchFilter =
		 * String.format("(&(objectClass=user)(sAMAccountName=%s))", userid); //String
		 * searchFilter = String.format("(cn=%s)", userid);
		 * NamingEnumeration<SearchResult> results = ctx.search(baseRdn, searchFilter,
		 * ctls);
		 * 
		 * 
		 * while (results.hasMoreElements()) { logger.debug("--------------");
		 * SearchResult sr = results.next(); Attributes attrs = sr.getAttributes();
		 * //NamingEnumeration<String> ids = attrs.getIDs();
		 * NamingEnumeration<Attribute> ids = (NamingEnumeration<Attribute>)
		 * attrs.getAll();
		 * 
		 * while (ids.hasMore()) { Attribute atr = (Attribute) ids.next(); String
		 * attributeID = atr.getID(); for (Enumeration vals = atr.getAll();
		 * vals.hasMoreElements(); logger.debug(attributeID +": "+ vals.nextElement()));
		 * // String id = ids.next(); Attribute idattr = attrs.get(id); logger.debug(id
		 * + "(" + idattr.size() + ")");
		 * 
		 * for (int ix = 0; ix < idattr.size(); ++ix) { logger.debug(", " + ix + "/" +
		 * idattr.get(ix)); } logger.debug("\n"); } }
		 */

	}
}
