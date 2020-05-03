package com.jq.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jq.constant.Constant;
import com.jq.mapper.CaseMapper;
import com.jq.pojo.WebCase;
import com.jq.pojo.WebSubCase;
import com.jq.vo.MainCaseDetail;

@Service
public class CaseServiceImpl implements CaseService{
@Autowired
CaseMapper caseMapper;	

private Logger logger = LoggerFactory.getLogger(this.getClass());

@Override
public List<WebCase> selectAll() {
	 List<WebCase> resultList = caseMapper.selectAll();
	return resultList;
}

@Override
public MainCaseDetail selectCaseDetailById(Long mainCaseId) {
	logger.info("selectCaseDetailById start!! mainCaseId = " + mainCaseId);  		
	MainCaseDetail mainCaseDetail = new MainCaseDetail();
	WebCase webCase = caseMapper.selectOneByPK(mainCaseId);
	if(webCase == null){
	logger.debug("query web_case no record,mainCaseId = " + mainCaseId);  	
	}
	 WebSubCase  webSubCase = caseMapper.selectSubCaseByMainCaseId(mainCaseId);
	 if(webSubCase == null){
		logger.debug("query web_sub_case no record,mainCaseId = " + mainCaseId);  
	 }
	 mainCaseDetail.setWebCase(webCase);
	 mainCaseDetail.setWebSubCase(webSubCase);
		logger.info("selectCaseDetailById end!! mainCaseDetail = " + mainCaseDetail);  	
	return mainCaseDetail;
}

}
