package com.jq.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jq.constant.Constant;
import com.jq.pojo.WebCase;
import com.jq.pojo.WebTopic;
import com.jq.service.CaseManageService;
import com.jq.service.TopicManageService;
import com.jq.vo.EasyUIResult;
import com.jq.vo.SysResult;

@Controller
@RequestMapping("/manage")
public class TopicManageController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    TopicManageService topicManageService;
    @Autowired
    CaseManageService caseManageService;

    // 增加新闻
    @RequestMapping("/addtopic")
    public String addnews() {
        return "manage/addtopic";
    }

    // 新闻管理
    @RequestMapping("/manage")
    public ModelAndView managnews() {
        ModelAndView modelAndView = new ModelAndView();
        List<WebCase> imgs = caseManageService.findAllCase();
        
        if (imgs != null) {
            for (WebCase webCase : imgs) {
                webCase.imgurl = "background-image: url(../" + webCase.getMainCasePhoto() + ");";
            }
        }
        modelAndView.addObject("works", imgs);
        modelAndView.addObject("topics", topicManageService.findAllTopic());
        modelAndView.setViewName("manage/manage");
        return modelAndView;
    }
    
    // 添加的新闻插入库
    @RequestMapping("/addTopic")
    @ResponseBody
    public ModelAndView addTopic(WebTopic webTopic, String desc) {
        ModelAndView success = new ModelAndView();
        try {
            topicManageService.addTopic(webTopic, desc);
            success.setViewName("redirect:/manage/manage");
        } catch (Exception e) {
            logger.error("insert topic error, e=[" + e.getMessage() + "]");
            success.setViewName("allerror");
        }
        
        return success;

    }

    // 支持分页查询所有的新闻
    @RequestMapping("/findTopicByPage")
    @ResponseBody
    public EasyUIResult findTopicByPage(Integer pageNo, Integer rows) {

        return topicManageService.findTopicByPage(pageNo, rows);
    }

    
    // 支持新闻的删除
    @RequestMapping("/deleteTopicById")
    @ResponseBody
    public SysResult deleteTopicById(String snId) {
     
    	   try {
               topicManageService.deleteTopic(Long.valueOf(snId));
           } catch (Exception e) {
               logger.error("delete topic error, e=[ " + e.getMessage() + "]");
               return SysResult.build(Constant.ONE, " delete topic fail!!");
           }
           return SysResult.Success();
    }



}