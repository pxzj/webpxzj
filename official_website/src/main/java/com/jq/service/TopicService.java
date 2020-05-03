package com.jq.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jq.pojo.WebTopic;
import com.jq.pojo.WebTopicDetail;
@Service
public interface TopicService {
	/*查询所有话题标题*/
	List<WebTopic> selectAll();
	
	 /*查询选中话题明细信息*/ 
	WebTopicDetail selectTopicDetailByTopicId(Long topicId);
	
	

}
