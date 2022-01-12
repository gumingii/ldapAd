package com.ssnc.ldapAd.config;

import java.io.FileReader;
import java.util.Properties;

public class sstopcCommonUtil {
	
	//▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩
	// LDAP setting
	//▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩
	public String getUserId() throws Exception{
		FileReader resources= new FileReader("restapi.properties"); 
    	Properties properties = new Properties();
    	properties.load(resources);
    	// fit\administrator

    	String id = properties.getProperty("user_id");
		return id;
	}
	
	public String getPasswd() throws Exception{
		FileReader resources= new FileReader("restapi.properties"); 
    	Properties properties = new Properties();
    	properties.load(resources);
    	//Forcepoint1!
    	
    	String pw = properties.getProperty("passwd");
    	return pw;
	}
	
	public String getLdapIp() throws Exception{
		FileReader resources= new FileReader("restapi.properties"); 
    	Properties properties = new Properties();
    	properties.load(resources);
    	// LDAP://192.168.1.100
    	// LDAP://127.0.0.1:389
    	String pw = properties.getProperty("ldap_ip");
    	return pw;
	}
	
	public String getBaseRdn() throws Exception{
		FileReader resources= new FileReader("restapi.properties"); 
    	Properties properties = new Properties();
    	properties.load(resources);
    	// CN=Administrator,CN=Users,DC=FIT,DC=com
    	
    	String pw = properties.getProperty("base_rdn");
    	return pw;
	}
	
	
	//▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩
	// PSQL setting
	//▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩
	
	public String getPsql() throws Exception {
		FileReader resources= new FileReader("restapi.properties"); 
    	Properties properties = new Properties();
    	properties.load(resources);
      
    	String str = properties.getProperty("psql");
    	return str;
	}
	
	public String getPsqlUrl() throws Exception {
		FileReader resources= new FileReader("restapi.properties"); 
    	Properties properties = new Properties();
    	properties.load(resources);
      
    	String str = properties.getProperty("psql_url");
    	return str;
	}
	
	public String getPsqlUserNm() throws Exception {
		FileReader resources= new FileReader("restapi.properties"); 
    	Properties properties = new Properties();
    	properties.load(resources);
      
    	String str = properties.getProperty("psql_usernm");
    	return str;
	}
	
	public String getPsqlPw() throws Exception {
		FileReader resources= new FileReader("restapi.properties"); 
    	Properties properties = new Properties();
    	properties.load(resources);
      
    	String str = properties.getProperty("psql_pw");
    	return str;
	}
}
	