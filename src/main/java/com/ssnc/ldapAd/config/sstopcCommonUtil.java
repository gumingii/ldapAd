package com.ssnc.ldapAd.config;

import java.io.FileReader;
import java.util.Properties;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.io.support.ResourcePropertySource;

public class sstopcCommonUtil {
	
	//▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩
	// LDAP setting
	//▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩
	public String getAdminId() throws Exception{
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ConfigurableEnvironment env = ctx.getEnvironment();		
		MutablePropertySources prop = env.getPropertySources();
		
		prop.addLast(new ResourcePropertySource("classpath:restapi.properties"));
		String id = env.getProperty("admin_id"); 
		/*
		 * FileReader resources= new FileReader("restapi.properties"); Properties
		 * properties = new Properties(); properties.load(resources); //
		 * fit\administrator
		 * 
		 * String id = properties.getProperty("admin_id");
		 */
		return id;
	}
	public String getUserId() throws Exception{
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ConfigurableEnvironment env = ctx.getEnvironment();		
		MutablePropertySources prop = env.getPropertySources();
		
		prop.addLast(new ResourcePropertySource("classpath:restapi.properties"));
		String id = env.getProperty("user_id"); 
		/*
		 * FileReader resources= new FileReader("restapi.properties"); Properties
		 * properties = new Properties(); properties.load(resources); //
		 * fit\administrator
		 * 
		 * String id = properties.getProperty("user_id");
		 */
		return id;
	}
	
	public String getPasswd() throws Exception{
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ConfigurableEnvironment env = ctx.getEnvironment();		
		MutablePropertySources prop = env.getPropertySources();
		
		prop.addLast(new ResourcePropertySource("classpath:restapi.properties"));
		String pw = env.getProperty("passwd"); 
		/*
		 * FileReader resources= new FileReader("restapi.properties"); Properties
		 * properties = new Properties(); properties.load(resources); //Forcepoint1!
		 * 
		 * String pw = properties.getProperty("passwd");
		 */
    	return pw;
	}
	
	public String getLdapUrl() throws Exception{
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ConfigurableEnvironment env = ctx.getEnvironment();		
		MutablePropertySources prop = env.getPropertySources();
		
		prop.addLast(new ResourcePropertySource("classpath:restapi.properties"));
		String pw = env.getProperty("ldap_ip"); 
		/*
		 * FileReader resources= new FileReader("restapi.properties"); Properties
		 * properties = new Properties(); properties.load(resources); //
		 * LDAP://192.168.1.100 // LDAP://127.0.0.1:389 String pw =
		 * properties.getProperty("ldap_ip");
		 */
    	return pw;
	}
	
	public String getBaseRdn() throws Exception{
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ConfigurableEnvironment env = ctx.getEnvironment();		
		MutablePropertySources prop = env.getPropertySources();
		
		prop.addLast(new ResourcePropertySource("classpath:restapi.properties"));
		String pw = env.getProperty("base_rdn"); 
		/*
		 * FileReader resources= new FileReader("restapi.properties"); Properties
		 * properties = new Properties(); properties.load(resources); //
		 * CN=Administrator,CN=Users,DC=FIT,DC=com
		 * 
		 * String pw = properties.getProperty("base_rdn");
		 */
    	return pw;
	}
	
	
	//▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩
	// PSQL setting
	//▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩
	
	public String getPsql() throws Exception {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ConfigurableEnvironment env = ctx.getEnvironment();		
		MutablePropertySources prop = env.getPropertySources();
		
		prop.addLast(new ResourcePropertySource("classpath:restapi.properties"));
		String str = env.getProperty("psql"); 
		/*
		 * FileReader resources= new FileReader("restapi.properties"); Properties
		 * properties = new Properties(); properties.load(resources);
		 * 
		 * String str = properties.getProperty("psql");
		 */
    	return str;
	}
	
	public String getPsqlUrl() throws Exception {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ConfigurableEnvironment env = ctx.getEnvironment();		
		MutablePropertySources prop = env.getPropertySources();
		
		prop.addLast(new ResourcePropertySource("classpath:restapi.properties"));
		String str = env.getProperty("psql_url"); 
		/*
		 * FileReader resources= new FileReader("restapi.properties"); Properties
		 * properties = new Properties(); properties.load(resources);
		 * 
		 * String str = properties.getProperty("psql_url");
		 */
    	return str;
	}
	
	public String getPsqlUserNm() throws Exception {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ConfigurableEnvironment env = ctx.getEnvironment();		
		MutablePropertySources prop = env.getPropertySources();
		
		prop.addLast(new ResourcePropertySource("classpath:restapi.properties"));
		String str = env.getProperty("psql_usernm"); 
		/*
		 * FileReader resources= new FileReader("restapi.properties"); Properties
		 * properties = new Properties(); properties.load(resources);
		 * 
		 * String str = properties.getProperty("psql_usernm");
		 */
    	return str;
	}
	
	public String getPsqlPw() throws Exception {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ConfigurableEnvironment env = ctx.getEnvironment();		
		MutablePropertySources prop = env.getPropertySources();
		
		prop.addLast(new ResourcePropertySource("classpath:restapi.properties"));
		String str = env.getProperty("psql_pw"); 
		/*
		 * FileReader resources= new FileReader("restapi.properties"); Properties
		 * properties = new Properties(); properties.load(resources);
		 * 
		 * String str = properties.getProperty("psql_pw");
		 */
    	return str;
	}
}
	