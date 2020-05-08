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
import org.springframework.web.servlet.ModelAndView;

import com.jq.constant.Constant;
import com.jq.pojo.WebCase;
import com.jq.service.CaseService;
import com.jq.vo.MainCaseDetail;
import com.jq.vo.SysResult;

@RestController
public class CaseController {

    @Autowired
    CaseService caseService;

    // 查询所有的主案例
    @RequestMapping("/findCaseAll")
    public List<WebCase> selectAll() {
        return caseService.selectAll();
    }

    // 查询某个主案例下的明细 (restful格式传参)
    @RequestMapping("/findCaseDetail/{mainCaseId}")
    public ModelAndView selectCaseDetailById(@PathVariable Long mainCaseId) {
        ModelAndView modelAndView = new ModelAndView();
        MainCaseDetail mainCaseDetail = caseService.selectCaseDetailById(mainCaseId);
        modelAndView.addObject("mainCaseDetail", mainCaseDetail);
        modelAndView.setViewName("workdetail");
        return modelAndView;
    }

    @RequestMapping("/allImgs")
    public List<WebCase> allImgs() {
        List<WebCase> mainCaseList = new ArrayList<>();
        WebCase web = new WebCase();
        web.setMainCasePhoto("http://localhost:8080/images/work01.jpg");
        web.setHeight("2744");
        web.setWidth("2607");
        web.setSnId(1L);
        mainCaseList.add(web);

        web = new WebCase();
        web.setMainCasePhoto("http://localhost:8080/images/work02.jpg");
        web.setHeight("8688");
        web.setWidth("5792");
        web.setSnId(2L);

        mainCaseList.add(web);
        web = new WebCase();
        web.setHeight("300");
        web.setWidth("500");
        web.setSnId(3L);

        mainCaseList.add(web);
        web = new WebCase();
        web.setMainCasePhoto("http://localhost:8080/images/work01.jpg");
        web.setHeight("2744");
        web.setWidth("2607");
        web.setSnId(4L);
        mainCaseList.add(web);
        web = new WebCase();
        web.setMainCasePhoto("http://localhost:8080/images/work02.jpg");
        web.setHeight("8688");
        web.setWidth("5792");
        web.setSnId(5L);
        mainCaseList.add(web);

        return mainCaseList;
    }

}
