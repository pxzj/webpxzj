package com.jq.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jq.mapper.TopicManageMapper;
import com.jq.pojo.WebTopic;
import com.jq.pojo.WebTopicDetail;

@Service
public class TopicManageServiceImpl implements TopicManageService{
@Autowired	
TopicManageMapper topicManageMapper;
	

	@Override
	@Transactional 
	public void addTopic(WebTopic webTopic, String desc) {
		
		topicManageMapper.insertWebTopic(webTopic);
		Long topicId = webTopic.getSnId();
		WebTopicDetail webTopicDetail = new WebTopicDetail();
		webTopicDetail.setTopicId(topicId);
		webTopicDetail.setTopicDesc(desc);
		topicManageMapper.insertWebTopicDetail(webTopicDetail);
		
	}
}
