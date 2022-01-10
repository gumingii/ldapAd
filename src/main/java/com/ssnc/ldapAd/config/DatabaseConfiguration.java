package com.ssnc.ldapAd.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//@PropertySource("classpath:/application.yml")	
@EnableTransactionManagement
@Configuration
public class DatabaseConfiguration {
	
	@Autowired
	private ApplicationContext applicationContext;
	
	/***********************************
	 * oasis db
	 ***********************************/
	
	@Autowired
    @Qualifier("datasource")
    private DataSource dataSource;

	@Bean("sqlSessionFactory")
	@Primary
	public SqlSessionFactory sqlSessionFactory() throws Exception {
		//DataSource dataSource
		/*SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource);
		sqlSessionFactoryBean.setMapperLocations(applicationContext.getResources("classpath:mybatis-config.xml"));

		return sqlSessionFactoryBean.getObject();*/
		
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        /* 맵퍼 xml 파일 경로 설정 */
        //com.ssnc.secu
        Resource[] resources = new PathMatchingResourcePatternResolver()
                .getResources("classpath:mybatis-mapper/*Mapper.xml");
        //.getResources("classpath:com/ssnc/secu/mybatis-mapper/*Mapper.xml");
        sqlSessionFactoryBean.setMapperLocations(resources);
        /* alias 설정 com.package..entity.Board -> resultType"Board" */
        sqlSessionFactoryBean.setTypeAliasesPackage("com.ssnc.ldapAd.*.entity");
 
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBean.getObject();
 
        org.apache.ibatis.session.Configuration configuration = sqlSessionFactory.getConfiguration();
        /* 실제DB컬럼명 스네이크 표기법 = 카멜케이스 표기법 맵핑 */
        configuration.setMapUnderscoreToCamelCase(true);
 
        return sqlSessionFactory;
	}
	
	@Bean("sqlSession")
	@Primary
    public SqlSession getSqlSession(@Qualifier("sqlSessionFactory") SqlSessionFactory factory) throws Exception {
        return new SqlSessionTemplate(factory);
    }
	
}