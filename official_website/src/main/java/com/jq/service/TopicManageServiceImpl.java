package com.jq.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jq.mapper.TopicManageMapper;
import com.jq.pojo.WebTopic;
import com.jq.pojo.WebTopicDetail;
import com.jq.vo.EasyUIResult;

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

	@Override
	public List<WebTopic> findAllTopic() {
		List<WebTopic> resultList =	topicManageMapper.selectAllTopic();
		return resultList;
	}

	@Override
	public EasyUIResult findTopicByPage(Integer pageNo, Integer rows) {
		//1.查询记录总数
		Integer total = topicManageMapper.selectTopicCount();
		//2.计算分页的其实位置
		Integer begin= (pageNo - 1) * rows;
		List<WebTopic> webTopicList =  topicManageMapper.findTopicByPage(begin,rows);
		return EasyUIResult.success(total, webTopicList);
	}

	@Override
	@Transactional 
	public void deleteTopic(Long topicId) {
		
	  //根据话题id删除话题表记录
		topicManageMapper.deleteWebTopic(topicId);
	  //以及删除话题明细表记录	
		topicManageMapper.deleteWebTopicDetail(topicId);
	}
	
	
	
	
	
}
