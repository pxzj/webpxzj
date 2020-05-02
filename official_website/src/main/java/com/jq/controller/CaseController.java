package com.jq.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
    public List<String> selectAll() {

        List<String> mainCaseList = caseService.selectAll();

        return mainCaseList;
    }

    @RequestMapping("/selectSubCaseByMainCase")
    public List<WebCase> selectSubCaseByMainCase(@RequestParam("mainCase") String mainCase) {

        List<WebCase> subCaseList = caseService.selectSubCaseByMainCase(mainCase);

        return subCaseList;

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
