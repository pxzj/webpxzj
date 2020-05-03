package com.jq;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

	@SpringBootApplication
	@MapperScan("com.jq.mapper")
	public class StarterAppaction {

		public static void main(String[] args) {
			SpringApplication.run(StarterAppaction.class, args);
		}

	}
