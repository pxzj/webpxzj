package com.jq.config;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.pool.DruidDataSource;

@Configuration
public class MybayisConfig {
	
	@Bean
	@ConfigurationProperties("spring.datasource")
	public DataSource dataSource(){
		
		return new DruidDataSource();
		
		
	}
	
	

}
