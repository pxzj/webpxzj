package com.jq.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jq.constant.Constant;
import com.jq.pojo.WebCase;
import com.jq.service.CaseService;
import com.jq.vo.MainCaseDetail;
import com.jq.vo.SysResult;

@RestController
public class CaseController {
	
    @Autowired
    CaseService caseService;
	
     @RequestMapping("/case/findAll")
    public SysResult selectAll(){
    	
    	List<WebCase>  mainCaseList = caseService.selectAll();
    	return SysResult.success(mainCaseList);
     }	
	
     @RequestMapping("/case/findCaseDetail/{mainCaseId}")
  public SysResult selectCaseDetailById(@PathVariable Long mainCaseId){
    	
    	 MainCaseDetail result = caseService.selectCaseDetailById(mainCaseId);
    	 return SysResult.success(result);
    	 
     }	
     @RequestMapping("/allImgs")
     public List<WebCase> allImgs(){
         List<WebCase> mainCaseList = new ArrayList<>();
         WebCase web = new WebCase();
         web.setMainCasePhoto("http://localhost:8080/img/gallery-img-01-tn.jpg");
         web.setHeight("300");
         web.setWidth("400");
         mainCaseList.add(web);

         web.setHeight("400");
         web.setWidth("530");

         mainCaseList.add(web);

         web.setHeight("300");
         web.setWidth("500");

         mainCaseList.add(web);
         return mainCaseList;
     }
  
}
