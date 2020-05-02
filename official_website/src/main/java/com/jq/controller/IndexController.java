package com.jq.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

    // 登陆页面
	@RequestMapping("/login")
	public String home() {
        
		return "login";
    }
    
    //话题新增
    @RequestMapping("/newsadd")
	public String topic() {
        
		return "newsadd";
    }

	@RequestMapping("/index")
	public String index() {
		ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        modelAndView.addObject("company", "纪青空间设计");
		return "index";
	}
}
