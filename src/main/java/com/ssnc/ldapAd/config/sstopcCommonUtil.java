package com.ssnc.ldapAd.config;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.io.support.ResourcePropertySource;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class sstopcCommonUtil {
	
	//▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩
	// LDAP setting
	//▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩
	public String getAdminId() throws Exception{
//		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
//		ConfigurableEnvironment env = ctx.getEnvironment();		
//		MutablePropertySources prop = env.getPropertySources();
//		
//		prop.addLast(new ResourcePropertySource("classpath:restapi.properties"));
//		String id = env.getProperty("admin_id"); 
		
		 FileReader resources= new FileReader("restapi.properties"); 
		 Properties properties = new Properties(); 
		 properties.load(resources); 
		 //fit\administrator
		 
		 String id = properties.getProperty("admin_id");
		 
		return id;
	}
	public String getUserId() throws Exception{
//		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
//		ConfigurableEnvironment env = ctx.getEnvironment();		
//		MutablePropertySources prop = env.getPropertySources();
//		
//		prop.addLast(new ResourcePropertySource("classpath:restapi.properties"));
//		String id = env.getProperty("user_id"); 
		FileReader resources= new FileReader("restapi.properties"); 
		 Properties properties = new Properties(); 
		 properties.load(resources); 
		 //fit\administrator
		 
		 String id = properties.getProperty("user_id");
		return id;
	}
	
	public String getPasswd() throws Exception{
//		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
//		ConfigurableEnvironment env = ctx.getEnvironment();		
//		MutablePropertySources prop = env.getPropertySources();
//		
//		prop.addLast(new ResourcePropertySource("classpath:restapi.properties"));
//		String pw = env.getProperty("passwd"); 
		FileReader resources= new FileReader("restapi.properties"); 
		 Properties properties = new Properties(); 
		 properties.load(resources); 
		 //fit\administrator
		 
		 String pw = properties.getProperty("passwd");
    	return pw;
	}
	
	public String getLdapUrl() throws Exception{
//		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
//		ConfigurableEnvironment env = ctx.getEnvironment();		
//		MutablePropertySources prop = env.getPropertySources();
//		
//		prop.addLast(new ResourcePropertySource("classpath:restapi.properties"));
//		String pw = env.getProperty("ldap_ip"); 
		FileReader resources= new FileReader("restapi.properties"); 
		 Properties properties = new Properties(); 
		 properties.load(resources); 
		 //fit\administrator
		 
		 String pw = properties.getProperty("ldap_ip");
    	return pw;
	}

	public String getSearch() throws IOException {
		FileReader resources = new FileReader("classpath:restapi.properties");
		Properties properties = new Properties();
		properties.load(resources);
		String str = properties.getProperty("search");

//		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
//		ConfigurableEnvironment env = ctx.getEnvironment();
//		MutablePropertySources prop = env.getPropertySources();
//
//		prop.addLast(new ResourcePropertySource("classpath:restapi.properties"));
//		String str = env.getProperty("search");
		return str;
	}
	
	public String getBaseRdn() throws Exception{
//		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
//		ConfigurableEnvironment env = ctx.getEnvironment();		
//		MutablePropertySources prop = env.getPropertySources();
//		
//		prop.addLast(new ResourcePropertySource("classpath:restapi.properties"));
//		String str = env.getProperty("base_rdn");
		FileReader resources= new FileReader("restapi.properties"); 
		 Properties properties = new Properties(); 
		 properties.load(resources); 
		 //fit\administrator
		 
		 String str = properties.getProperty("base_rdn");
    	return str;
	}
	
	
	//▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩
	// PSQL setting
	//▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩
	
	public String getPsql() throws Exception {
//		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
//		ConfigurableEnvironment env = ctx.getEnvironment();		
//		MutablePropertySources prop = env.getPropertySources();
//		
//		prop.addLast(new ResourcePropertySource("classpath:restapi.properties"));
//		String str = env.getProperty("psql"); 
		FileReader resources= new FileReader("restapi.properties"); 
		 Properties properties = new Properties(); 
		 properties.load(resources); 
		 //fit\administrator
		 
		 String str = properties.getProperty("psql");
    	return str;
	}
	
	public String getPsqlUrl() throws Exception {
//		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
//		ConfigurableEnvironment env = ctx.getEnvironment();		
//		MutablePropertySources prop = env.getPropertySources();
//		
//		prop.addLast(new ResourcePropertySource("classpath:restapi.properties"));
//		String str = env.getProperty("psql_url"); 
		FileReader resources= new FileReader("restapi.properties"); 
		 Properties properties = new Properties(); 
		 properties.load(resources); 
		 //fit\administrator
		 
		 String str = properties.getProperty("psql_url");
    	return str;
	}
	
	public String getPsqlUserNm() throws Exception {
//		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
//		ConfigurableEnvironment env = ctx.getEnvironment();		
//		MutablePropertySources prop = env.getPropertySources();
//		
//		prop.addLast(new ResourcePropertySource("classpath:restapi.properties"));
//		String str = env.getProperty("psql_usernm"); 
		FileReader resources= new FileReader("restapi.properties"); 
		 Properties properties = new Properties(); 
		 properties.load(resources); 
		 //fit\administrator
		 
		 String str = properties.getProperty("psql_usernm");
    	return str;
	}
	
	public String getPsqlPw() throws Exception {
//		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
//		ConfigurableEnvironment env = ctx.getEnvironment();		
//		MutablePropertySources prop = env.getPropertySources();
//		
//		prop.addLast(new ResourcePropertySource("classpath:restapi.properties"));
//		String str = env.getProperty("psql_pw"); 
		FileReader resources= new FileReader("restapi.properties"); 
		 Properties properties = new Properties(); 
		 properties.load(resources); 
		 //fit\administrator
		 
		 String str = properties.getProperty("psql_pw");
    	return str;
	}
}
	