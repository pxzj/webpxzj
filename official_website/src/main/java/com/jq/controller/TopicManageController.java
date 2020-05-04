package com.jq.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class TopicManageController {

	
    @RequestMapping("/addnews")
    public String addnews() {
        return "addnews";
    }
    @RequestMapping("/managnews")
    public String managnews() {
        return "managnews";
    }
	
	//TODO 话题insert数据库等案例测试通过在补充
}
