package com.jq.service;

import java.sql.Date;
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
@Autowired
MainCaseDetail mainCaseDetail;

private Logger logger = LoggerFactory.getLogger(this.getClass());

@Override
public List<WebCase> selectAll() {
	 List<WebCase> resultList = caseMapper.selectAll();
	return resultList;
}

@Override
public MainCaseDetail selectCaseDetailById(Long mainCaseId) {	

	WebCase webCase = caseMapper.selectOneByPK(mainCaseId);
	// 查询数据库日期,截图拼接给页面展示
	if(webCase == null){
	logger.debug("query web_case no record, mainCaseId = [" + mainCaseId + "]");  	
	}
	 webCase.setWorkEndDateStr(dateInterception(webCase.getEndDate()));
	 
	 WebSubCase  webSubCase = caseMapper.selectSubCaseByMainCaseId(mainCaseId);
	 if(webSubCase == null){
		logger.debug("query web_sub_case no record, mainCaseId =[ " + mainCaseId + "]");  
	 }
	 mainCaseDetail.setWebCase(webCase);
	 mainCaseDetail.setWebSubCase(webSubCase);
	return mainCaseDetail;
}

  public String dateInterception(Date date){
  StringBuffer sb = new StringBuffer(); 
  String workEndDate = date.toString();
  String year = workEndDate.substring(0, 4);
  String month = workEndDate.substring(5,7);
  sb.append(year).append(" 年  ").append(month).append(" 月  ");
  
  return sb.toString();
  }
}
