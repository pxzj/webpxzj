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
}
