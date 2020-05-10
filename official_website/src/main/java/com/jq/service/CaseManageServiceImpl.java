package com.jq.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jq.mapper.CaseManageMapper;
import com.jq.pojo.WebCase;
import com.jq.pojo.WebSubCase;
import com.jq.pojo.WebTopic;
import com.jq.vo.EasyUIResult;
@Service
public class CaseManageServiceImpl implements CaseManageService {	
@Autowired
CaseManageMapper caseManageMapper;	

	@Override
	@Transactional 
	public void addCase(WebCase webCase, String desc) {
		
      caseManageMapper.insertMainCase(webCase);
      Long mainCaseId = webCase.getSnId();
        WebSubCase  webSubCase = new WebSubCase();
        webSubCase.setMainCaseId(mainCaseId);
        webSubCase.setSubCaseInfo(desc);
        caseManageMapper.insertSubCase(webSubCase);
	}

	@Override
	public List<WebCase> findAllCase() {
		List<WebCase> resultList =	caseManageMapper.selectAllCase();
		return resultList;
	}

	@Override
	public EasyUIResult findCaseByPage(Integer pageNo, Integer rows) {
		//1.查询记录总数
		Integer total = caseManageMapper.selectCaseCount();
		//2.计算分页的其实位置
		Integer begin= (pageNo - 1) * rows;
		List<WebCase> webCaseList =  caseManageMapper.findCaseByPage(begin,rows);
		return EasyUIResult.success(total, webCaseList);
	}

	@Override
	@Transactional
	public void deleteCase(Long mainCaseId) {
	 // 删除主案例表信息
		caseManageMapper.deleteWebCase(mainCaseId);
	 // 删除子案例信息	
	caseManageMapper.deleteWebSubCase(mainCaseId);
	}
	
	
	

}
