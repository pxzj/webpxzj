package com.jq.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.jq.vo.LoginInterceptor;

@Configuration
public class LoginInterceptorConfig implements WebMvcConfigurer{
 
	@Override
	public void addInterceptors(InterceptorRegistry registry) {	
		
		   InterceptorRegistration registration = registry.addInterceptor(new LoginInterceptor());
		   
		   registration.addPathPatterns("/manage/**");
		   registration.excludePathPatterns("/static/**");
	}

}
