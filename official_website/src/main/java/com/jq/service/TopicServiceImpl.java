package com.jq.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jq.mapper.TopicMapper;
import com.jq.pojo.WebTopic;
import com.jq.pojo.WebTopicDetail;
import com.jq.vo.TopicInfomation;

@Service
public class TopicServiceImpl implements TopicService{
@Autowired
TopicMapper topicMapper;	
@Autowired
TopicInfomation topicInfomation;
private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public List<WebTopic> selectAll() {
		List<WebTopic>  resultList = topicMapper.selectAll();
		return resultList;
	}

	@Override
	public TopicInfomation selectTopicDetailByTopicId(Long topicId) {
		// 查询话题表
		WebTopic webTopic = topicMapper.selectTopicById(topicId);
	       if(webTopic == null){
				logger.debug("query webTopic no record, topicId = " + topicId);  
			 } 
	       topicInfomation.setWebTopic(webTopic);
		// 查询话题明细表
		WebTopicDetail  webTopicDetail = topicMapper.selectTopicDetatilByTopicId(topicId);
		 if(webTopicDetail == null){
			logger.debug("query web_topic_detail no record, topicId = " + topicId);  
		 }  
		 topicInfomation.setWebTopicDetail(webTopicDetail);
		return topicInfomation;
		
	}



}
