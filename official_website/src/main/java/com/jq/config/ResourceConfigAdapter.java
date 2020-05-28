package com.jq.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SuppressWarnings("deprecation")
@Configuration
public class ResourceConfigAdapter extends WebMvcConfigurerAdapter {
 
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //获取文件的真实路径 work_project代表项目工程名 需要更改
        String path = System.getProperty("user.dir")+ "\\src\\main\\resources\\static\\images\\";
       System.err.println("path:" + path);
       registry.addResourceHandler("/photo/**").
                    addResourceLocations("file:" + path);
      
    }
}