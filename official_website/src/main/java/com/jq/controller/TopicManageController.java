package com.jq.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class TopicManageController {

	
    //话题新增
    @RequestMapping("/newsadd")
	public String topic() {
        
		return "newsadd";
    }
	
	//TODO 话题insert数据库等案例测试通过在补充
}
