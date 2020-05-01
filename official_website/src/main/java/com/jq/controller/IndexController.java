package com.jq.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {
	
	 @RequestMapping("/")
	    public String index(){
	        return "欢迎登陆网页";
	    }
	
}
