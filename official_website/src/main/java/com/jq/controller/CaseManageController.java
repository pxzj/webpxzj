package com.jq.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jq.constant.Constant;
import com.jq.pojo.WebCase;
import com.jq.service.CaseManageService;
import com.jq.vo.EasyUIResult;
import com.jq.vo.SysResult;

@Controller
@RequestMapping("/manage")
public class CaseManageController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    CaseManageService caseManageService;

    // 增加案例
    @RequestMapping("/addwork")
    public String addwork() {
        return "manage/addwork";
    }

    // 新增案例
    @RequestMapping("/addCase")
    @ResponseBody
    public ModelAndView addCase(WebCase webCase, String desc) {
        ModelAndView success = new ModelAndView();
        try {
            caseManageService.addCase(webCase, desc);
            success.setViewName("redirect:/manage/manage");
        } catch (Exception e) {
            logger.error("insert case error, e=[" + e.getMessage() + "]");
            success.setViewName("allerror");
        }
        return success;
    }

    // 支持分页查询所有的案例里
    @RequestMapping("/findCaseByPage")
    @ResponseBody
    public EasyUIResult findCaseByPage(Integer pageNo, Integer rows) {

        return caseManageService.findCaseByPage(pageNo, rows);
    }
    
    // 持新闻的删除
    @RequestMapping("/deleteCaseById")
    @ResponseBody
    public SysResult deleteCaseById(String snId) {
    
    	try {
            caseManageService.deleteCase(Long.valueOf(snId));
        } catch (Exception e) {
            logger.error("delete case error, e=[" + e.getMessage() + "]");
            return SysResult.build(Constant.ONE, "deleteCase error!!");
        }
        return SysResult.Success();	
    }

    

   


}
