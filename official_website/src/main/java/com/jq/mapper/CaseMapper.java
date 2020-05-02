package com.jq.mapper;

import java.util.List;

import com.jq.pojo.WebCase;

public interface CaseMapper {
     /*查询所有的主案例信息*/
    List<String> selectAll();
	
    /*查询主案例下所有子案例*/ 
    List<WebCase> selectSubCaseByMainCase(String mainCase);
	
}
