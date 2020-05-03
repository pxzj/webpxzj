package com.jq.service;

import org.springframework.stereotype.Service;

import com.jq.pojo.WebCase;

@Service
public interface CaseManageService {

	
		 /*添加案例*/
		  void addCase(WebCase webCase, String desc);
	
}
