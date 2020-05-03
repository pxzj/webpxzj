package com.jq.controller;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jq.pojo.WebCase;
import com.jq.service.CaseManageService;
import com.jq.vo.SysResult;


@Controller
public class CaseManageController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
	CaseManageService caseManageService;
	
    @RequestMapping("/manage/addCasePage")
    public String addCasePage(){
    	
    	//TODO 待前端新增添加案例页面
    	return "newsadd";
    }
    
    
	@RequestMapping("/manage/addCase")
	@ResponseBody
   public SysResult addCase(WebCase webCase, String desc){
		
  try{
		caseManageService.addCase(webCase, desc);
		}
	   catch(Exception e){
		   logger.error("insert error, e= " + e.getMessage());   
		  return  SysResult.build(1, "addCase error!!");
	   }
		return SysResult.Success();
	}
	
}
