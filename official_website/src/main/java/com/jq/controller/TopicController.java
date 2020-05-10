package com.jq.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.jq.pojo.WebTopic;
import com.jq.pojo.WebTopicDetail;
import com.jq.service.TopicService;
import com.jq.vo.SysResult;

@RestController
public class TopicController {
    @Autowired
    TopicService topicService;

    // 查询某个话题新闻明细
    @RequestMapping("/findTopicDetail/{topicId}")
    public ModelAndView selectCaseDetailById(@PathVariable Long topicId) {
        ModelAndView modelAndView = new ModelAndView();
        WebTopicDetail webTopicDetail = topicService.selectTopicDetailByTopicId(topicId);
        modelAndView.addObject("webTopicDetail", webTopicDetail);
        modelAndView.setViewName("topicDetail");
        return modelAndView;
    }

}