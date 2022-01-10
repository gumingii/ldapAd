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
import javax.naming.ldap.InitialLdapContext;
import javax.naming.ldap.LdapContext;

import org.apache.http.auth.AuthenticationException;

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


		logger.debug("\n\nActive Directory Connection: CONNECTED >> "+ctx.getNameInNamespace());
	}
}
