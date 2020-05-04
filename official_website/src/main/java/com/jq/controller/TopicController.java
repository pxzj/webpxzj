package com.jq.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jq.pojo.WebTopic;
import com.jq.pojo.WebTopicDetail;
import com.jq.service.TopicService;
import com.jq.vo.SysResult;

@RestController
public class TopicController {
 @Autowired
TopicService topicService;	
	// 查询所有话题新闻
    @RequestMapping("/findTopicAll")
   public SysResult selectAll(){
   	
   	List<WebTopic>  webTopicList = topicService.selectAll();
   	return SysResult.success(webTopicList);
    }	
	
    // 查询某个话题新闻明细
    @RequestMapping("/findTopicDetail/{topicId}")
    public SysResult selectCaseDetailById(@PathVariable Long topicId){
   	 WebTopicDetail result = topicService.selectTopicDetailByTopicId(topicId);
   	 return SysResult.success(result);
    }	
    
}