package com.jq.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jq.mapper.CaseMapper;
import com.jq.pojo.WebCase;
@Service
public class CaseServiceImpl implements CaseService{
@Autowired
CaseMapper caseMapper;	
   
@Override
	public List<String> selectAll() {
		List<String>  resultList  = caseMapper.selectAll();
		
		return resultList;
	}

@Override
public List<WebCase> selectSubCaseByMainCase(String mainCase) {
	
	List<WebCase> list = caseMapper.selectSubCaseByMainCase(mainCase);

	
	return list;
}

}
