package com.jq.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jq.constant.Constant;
import com.jq.pojo.WebCase;
import com.jq.pojo.WebTopic;
import com.jq.service.CaseManageService;
import com.jq.vo.EasyUIResult;
import com.jq.vo.SysResult;

@Controller
@RequestMapping("/manage")
public class CaseManageController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    CaseManageService caseManageService;

    // 新增案例
    @RequestMapping("/addCase")
    @ResponseBody
    public SysResult addCase(WebCase webCase, String desc) {
        try {
            caseManageService.addCase(webCase, desc);
        } catch (Exception e) {
            logger.error("insert case error, e= " + e.getMessage());
            return SysResult.build(Constant.ONE, "addCase error!!");
        }
        return SysResult.Success();
    }

    // 支持查询所有的案例
    @RequestMapping("/findAllCase")
    @ResponseBody
    public SysResult findAllCase() {
        List<WebCase> webCaseList = caseManageService.findAllCase();
        return SysResult.success(webCaseList);
    }

    // 支持分页查询所有的案例里
    @RequestMapping("/findCaseByPage")
    @ResponseBody
    public EasyUIResult findCaseByPage(Integer pageNo, Integer rows) {

        return caseManageService.findCaseByPage(pageNo, rows);
    }

    // TODO 回显更改的案例

    // TODO 更新编辑的新闻

    // TODO 支持新闻的删除

    // TODO 支持新闻的批量删除

}
