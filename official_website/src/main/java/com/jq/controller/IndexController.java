package com.jq.controller;

import java.util.List;
import java.util.Map;

import com.alibaba.druid.util.StringUtils;
import com.jq.pojo.WebCase;
import com.jq.pojo.WebTopic;
import com.jq.service.CaseService;
import com.jq.service.TopicManageService;
import com.jq.service.TopicService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {
    @Autowired
    CaseService caseService;

    @Autowired
    TopicService topicService;

    @Autowired
    TopicManageService topicManageService;

    @RequestMapping("/index")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView();
        List<WebCase> imgs = caseService.selectAll();
        if (imgs != null) {
            for (WebCase webCase : imgs) {
                webCase.imgurl = "background-image: url(" + webCase.getMainCasePhoto() + ");";
            }
        }
        modelAndView.addObject("imgs", imgs);
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @RequestMapping("/service")
    public String service() {
        return "service";
    }

    @RequestMapping("/work")
    public String work() {
        return "work";
    }

    @RequestMapping("/recuit")
    public String recuit() {
        return "recuit";
    }

    @RequestMapping("/contact")
    public String contact() {
        return "contact";
    }

    @RequestMapping("/topic")
    public ModelAndView topic(Model model) {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("topics", topicManageService.findAllTopic());
        modelAndView.setViewName("topic");
        return modelAndView;
    }

    @RequestMapping("/workdetail")
    public ModelAndView workdetail(@RequestParam("snId") String snId) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("id", snId);
        modelAndView.addObject("htmlcontent", "<p>显示编辑出来的案例详细</p>");
        modelAndView.setViewName("workdetail");
        return modelAndView;
    }
}
