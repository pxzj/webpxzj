package com.jq.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jq.pojo.WebTopic;
import com.jq.vo.EasyUIResult;
@Service
public interface TopicManageService {

	/*新增话题明细*/
    void  addTopic(WebTopic webTopic, String desc);	
    /*查询所有的话题*/
    List<WebTopic> findAllTopic();
    /*分页查询所有的话题*/
    EasyUIResult findTopicByPage(Integer pageNo, Integer rows);
}
