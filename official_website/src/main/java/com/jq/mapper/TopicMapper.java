package com.jq.mapper;

import java.util.List;

import com.jq.pojo.WebTopic;
import com.jq.pojo.WebTopicDetail;


public interface TopicMapper {
	
	/*查询所有话题标题*/
	List<WebTopic> selectAll();
	
	/*根据新闻ID话题新闻明细*/
	WebTopic selectOneByPK(Long topicId);
	
	 /*查询话题下的明细图文*/ 
	WebTopicDetail selectTopicDetatilByTopicId(Long topicId);
	
	

}
