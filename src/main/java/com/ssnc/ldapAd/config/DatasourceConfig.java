package com.ssnc.ldapAd.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class DatasourceConfig{
	
	private sstopcCommonUtil scu = new sstopcCommonUtil();
	
	@Bean("datasource")
	@Primary
	@ConfigurationProperties(prefix = "spring.datasource.hikari")
	public DataSource hikariConfig() throws Exception{
		DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName(scu.getPsql());
        dataSourceBuilder.url(scu.getPsqlUrl());
        dataSourceBuilder.username(scu.getPsqlUserNm());
        dataSourceBuilder.password(scu.getPsqlPw());
        return dataSourceBuilder.build();
		
		//return DataSourceBuilder.create().type(HikariDataSource.class).build();
	}
	
}
