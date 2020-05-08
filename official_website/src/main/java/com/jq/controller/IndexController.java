package com.jq.controller;

import java.util.Map;

import com.alibaba.druid.util.StringUtils;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

    @RequestMapping("/index")
    public String index() {
        return "index";
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

    @RequestMapping("/workdetail")
    public ModelAndView workdetail(@RequestParam("snId") String snId) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("id", snId);
        modelAndView.addObject("htmlcontent", "<p>显示编辑出来的案例详细</p>");
        modelAndView.setViewName("workdetail");
        return modelAndView;
    }
}
