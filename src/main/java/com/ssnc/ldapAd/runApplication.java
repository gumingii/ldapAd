package com.ssnc.ldapAd;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.ssnc.ldapAd.config.sstopcCommonUtil;

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
public class runApplication implements CommandLineRunner{
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public void run(String... args) throws Exception {
		
		sstopcCommonUtil scu = new sstopcCommonUtil();
		
		String userid = scu.getUserId();
		String passwd = scu.getPasswd();
		String ldapIp = scu.getLdapIp();
		String ntUserId = scu.getBaseRdn();
		
		Hashtable<String, String> env = new Hashtable<String, String>();
		env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
		env.put(Context.SECURITY_AUTHENTICATION, "simple");
		env.put(Context.PROVIDER_URL, ldapIp);
		env.put(Context.SECURITY_PRINCIPAL, ntUserId);
		env.put(Context.SECURITY_CREDENTIALS, passwd);

		LdapContext ctx = new InitialLdapContext(env, null);

		logger.debug("\n\nActive Directory Connection: CONNECTED >> " + ctx.getNameInNamespace());
		
		//
		SearchControls ctls = new SearchControls();
		ctls.setSearchScope(SearchControls.SUBTREE_SCOPE);
		ctls.setReturningAttributes(new String[] {"CN"});

   // 인증이 확인 됬다면 usrId, usrPw, baseRdn(유저가 등록된 위치)으로 Admin에서 등록한 유저를 찾아봅시다!
		

		String searchFilter = String.format("(CN=%s)", userid);
		NamingEnumeration<SearchResult> results = ctx.search(ntUserId, searchFilter, ctls);
		logger.debug("results >>"+results.asIterator());
		
		
		while (results.hasMore()) {
			SearchResult sr = results.next();
			logger.debug("-------------");
			Attributes attrs = sr.getAttributes();
			NamingEnumeration<String> ids = attrs.getIDs();
			while (ids.hasMore()) {
				String id = ids.next();
				Attribute idattr = attrs.get(id);
				logger.debug(id + "(" + idattr.size() + ")");
				for (int ix = 0; ix < idattr.size(); ++ix) {
					logger.debug(", " + ix + "/" + idattr.get(ix));
				}
				logger.debug("\n");
			}
		}
		
	}
}
