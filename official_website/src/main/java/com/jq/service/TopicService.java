package com.jq.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jq.pojo.WebTopic;
import com.jq.pojo.WebTopicDetail;
import com.jq.vo.TopicInfomation;
@Service
public interface TopicService {
	/*查询所有话题标题*/
	List<WebTopic> selectAll();
	
	 /*查询选中话题明细信息*/ 
	TopicInfomation selectTopicDetailByTopicId(Long topicId);
	
	

}
