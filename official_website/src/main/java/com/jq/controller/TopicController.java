package com.jq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import com.jq.pojo.WebTopic;
import com.jq.service.TopicService;
import com.jq.vo.TopicInfomation;

@RestController
public class TopicController {
    @Autowired
    TopicService topicService;
    @RequestMapping("/topic")
    // 查询所有的主案例
    public ModelAndView selectAll() {
        ModelAndView modelAndView = new ModelAndView();
        List<WebTopic> topics = topicService.selectAll();
        modelAndView.addObject("topics", topics);
        if (topics != null) {
            for (WebTopic topic : topics) {
                topic.imgurl = "background-image: url(" + topic.getTopicPhoto()+ ");";
            }
        }
        modelAndView.addObject("imgs", topics);
        modelAndView.setViewName("topic");
        return modelAndView;
    }

    // 查询某个话题新闻明细
    @RequestMapping("/findTopicDetail/{topicId}")
    public ModelAndView selectCaseDetailById(@PathVariable Long topicId) {
        ModelAndView modelAndView = new ModelAndView();
        TopicInfomation topicInfomation = topicService.selectTopicDetailByTopicId(topicId);
        modelAndView.addObject("topicInfomation", topicInfomation);
        modelAndView.setViewName("topicDetail");
        return modelAndView;
    }

}