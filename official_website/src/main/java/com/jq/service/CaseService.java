package com.jq.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jq.pojo.WebCase;
import com.jq.pojo.WebSubCase;
import com.jq.vo.MainCaseDetail;
@Service
public interface CaseService {
	 /*查询所有的主案例信息*/
    List<WebCase> selectAll();
	
    /*查询主案例下所有子案例*/ 
    MainCaseDetail selectCaseDetailById(Long mainCaseId);
    
}
