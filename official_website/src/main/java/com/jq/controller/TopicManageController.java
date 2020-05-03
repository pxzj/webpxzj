package com.jq.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class TopicManageController {

	
    //话题新增
    @RequestMapping("/manage/newsadd")
	public String topic() {
        
		return "newsadd";
    }
	
	
}
