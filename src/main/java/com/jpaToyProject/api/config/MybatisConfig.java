package com.jpaToyProject.api.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import com.zaxxer.hikari.HikariDataSource;

// @Configuration(proxyBeanMethods = false)
@Configuration
public class MybatisConfig {

	@Bean(name = "dataSource")
	@ConfigurationProperties(prefix = "spring.datasource")
	public DataSource defaultDataSource() throws Exception {
		return DataSourceBuilder.create()
				.type(HikariDataSource.class)
				.build();
	}

	@Bean(name = "sqlSessionFactory")
	public SqlSessionFactory sqlSessionFactoryBean(@Autowired @Qualifier("dataSource") DataSource dataSource,
			ApplicationContext applicationContext) throws Exception {

		SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
		factoryBean.setDataSource(dataSource);

		// MyBatis의 type aliases package 설정 추가
		factoryBean.setTypeAliasesPackage("com.jpaToyProject.api");

		// 추가적인 설정 (매퍼 위치, 기타 등등)
		factoryBean.setMapperLocations(applicationContext.getResources("classpath*:com/jpaToyProject/api/**/mapper/*.xml"));

		// 경로를 배열로 추가하려했으나 오류 발생. ==> 경로를  com/esg/mng/**/mapper/로 맞추어서 해결	
		// // 여러 경로를 추가하는 방법
		// Resource[] resources1 = applicationContext.getResources("classpath*:com/esg/mng/**/mapper/*.xml");
		// Resource[] resources2 = applicationContext.getResources("classpath*:com/esg/mng/config/*.xml");

		// // 두 배열을 합쳐서 하나의 배열로 만든다.
		// Resource[] allResources = ArrayUtils.addAll(resources1, resources2);

		// factoryBean.setMapperLocations(allResources);

		return factoryBean.getObject();
	}

	@Bean(name = "sqlSessionTemplate")
	public SqlSessionTemplate sqlSessionTemplate(
			@Autowired @Qualifier("sqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
		return new SqlSessionTemplate(sqlSessionFactory);
	}

	@Bean(name = "transactionManager")
	public PlatformTransactionManager transactionManager(
			@Autowired @Qualifier("dataSource") DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}
}
