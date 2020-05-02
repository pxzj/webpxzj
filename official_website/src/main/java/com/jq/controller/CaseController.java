package com.jq.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jq.pojo.WebCase;
import com.jq.service.CaseService;

@RestController
public class CaseController {

 @Autowired	
  CaseService caseService;	
	
     @RequestMapping("/selectAll")
    public List<String> selectAll(){
    	
    	List<String>  mainCaseList = caseService.selectAll();
    	
    	return mainCaseList;
     }	
	
     @RequestMapping("/selectSubCaseByMainCase")
 public List<WebCase> selectSubCaseByMainCase(@RequestParam("mainCase") String mainCase){
    	
    	 List<WebCase> subCaseList = caseService.selectSubCaseByMainCase(mainCase);
    	 
    	 return subCaseList;
    	 
     }	
     

}
