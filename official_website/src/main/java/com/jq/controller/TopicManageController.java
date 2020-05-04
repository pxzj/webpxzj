package com.jq.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jq.pojo.WebTopic;
import com.jq.service.TopicManageService;
import com.jq.vo.SysResult;
@Controller
public class TopicManageController {

private Logger logger = LoggerFactory.getLogger(this.getClass());	
@Autowired	
TopicManageService topicManageService;
	
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
    
    @RequestMapping("/manage/topicAdd")
    @ResponseBody
    public SysResult topicAdd(WebTopic webTopic, String desc){
    	
    	try{
    	topicManageService.addTopic(webTopic, desc);
    	} catch(Exception e){
    		logger.error("insert topic error, e= " + e.getMessage()); 
    		return SysResult.build(1, "topic add fail!!");
    	}
    	
    	return SysResult.Success();
    	
    }
	
}
