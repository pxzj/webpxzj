package com.jq.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Options;

import com.jq.pojo.WebCase;
import com.jq.pojo.WebSubCase;

public interface CaseMapper {
     /*查询所有的主案例信息*/
    List<WebCase> selectAll();
	
    /*查询主案例下所有子案例*/ 
    WebSubCase selectSubCaseByMainCaseId(Long mainCaseId);
     
    /*主案例id查主案例信息*/
     WebCase selectOneByPK(Long mainCaseId);
	
}
