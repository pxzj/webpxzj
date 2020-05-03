package com.jq.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jq.mapper.TopicMapper;
import com.jq.pojo.WebTopic;
import com.jq.pojo.WebTopicDetail;

@Service
public class TopicServiceImpl implements TopicService{
@Autowired
TopicMapper topicMapper;	
private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public List<WebTopic> selectAll() {
		List<WebTopic>  resultList = topicMapper.selectAll();
		return resultList;
	}

	@Override
	public WebTopicDetail selectTopicDetailByTopicId(Long topicId) {
	
		logger.info("selectTopicDetailByTopicId start!! topicId = " + topicId);  
		
		WebTopicDetail  webTopicDetail = topicMapper.selectTopicDetatilByTopicId(topicId);
		 if(webTopicDetail == null){
			logger.debug("query web_topic_detail no record,mainCaseId = " + topicId);  
		 }
		 logger.info("selectTopicDetailByTopicId end!! webTopicDetail = " + webTopicDetail);  
		return webTopicDetail;
		
	}



}
