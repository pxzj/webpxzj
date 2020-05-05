package com.jq.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jq.pojo.WebCase;
import com.jq.pojo.WebTopic;
import com.jq.vo.EasyUIResult;

@Service
public interface CaseManageService {

	
		 /*添加案例*/
		  void addCase(WebCase webCase, String desc);
		  
		  /*查询所有的话题*/
		  List<WebCase> findAllCase();
		    
		    /*分页查询所有的话题*/
		  EasyUIResult findCaseByPage(Integer pageNo, Integer rows);  
	
}
