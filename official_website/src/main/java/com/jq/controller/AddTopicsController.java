package com.jq.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController("/topic/*")
public class AddTopicsController {
    // 新增话题
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(String job) {
        return "";
    }
}