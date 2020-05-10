package com.jq.mapper;

import java.util.List;

import com.jq.pojo.WebTopic;
import com.jq.pojo.WebTopicDetail;

public interface TopicManageMapper {

	
	/*新增话题表记录*/
	void  insertWebTopic(WebTopic webTopic);
	
	/*新增话题明细*/
    void  insertWebTopicDetail(WebTopicDetail webTopicDetail);
    
    /*查询所有的话题*/
    List<WebTopic> selectAllTopic();
    
    /*查询所有的记录*/
    Integer selectTopicCount();
    
    /*分页查询话题记录*/
    List<WebTopic> findTopicByPage(Integer begin, Integer pageSize);
    
    /*删除话题表记录*/
    void deleteWebTopic(Long topicId);
    
    /*删除话题明细表记录*/
    void deleteWebTopicDetail(Long topicId);
}
