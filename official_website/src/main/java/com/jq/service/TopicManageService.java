package com.jq.service;

import org.springframework.stereotype.Service;

import com.jq.pojo.WebTopic;
@Service
public interface TopicManageService {

	/*新增话题明细*/
    void  addTopic(WebTopic webTopic, String desc);	
}
