package com.jq.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class TopicManageController {

	//增加新闻
    @RequestMapping("/manage/addnews")
    public String addnews() {
        return "manage/addnews";
    }
    //新闻管理
    @RequestMapping("/manage/managnews")
    public String managnews() {
        return "manage/managnews";
    }
	
}
