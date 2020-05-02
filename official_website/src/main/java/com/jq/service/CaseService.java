package com.jq.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jq.pojo.WebCase;
@Service
public interface CaseService {
	  /*查询所有的主案例信息*/
    List<String> selectAll();
    
    /*查询主案例下所有子案例*/ 
    List<WebCase> selectSubCaseByMainCase(String mainCase);
}
