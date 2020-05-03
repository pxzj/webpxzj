package com.jq.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jq.mapper.CaseManageMapper;
import com.jq.pojo.WebCase;
import com.jq.pojo.WebSubCase;
@Service
public class CaseManageServiceImpl implements CaseManageService {
@Autowired
CaseManageMapper caseManageMapper;	

	@Override
	@Transactional 
	public void addCase(WebCase webCase, String desc) {
		caseManageMapper.insertMainCase(webCase);
        WebSubCase  webSubCase = new WebSubCase();
        webSubCase.setMainCaseId(webCase.getSnId());
        webSubCase.setSubCaseInfo(desc);
        caseManageMapper.insertSubCase(webSubCase);
	}



}
