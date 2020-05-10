package com.jq.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jq.constant.Constant;
import com.jq.pojo.WebUser;
import com.jq.service.UserService;
import com.jq.vo.SysResult;

@Controller
public class UserController {
    @Autowired
    UserService userService;
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    // 登陆页面
    @RequestMapping("/login")
    public String login() {

        return "login";
    }

    @RequestMapping("/loginadmin")
    public ModelAndView loginadmin(@RequestParam("username") String username, @RequestParam("password") String password,
            Map<String, Object> map, HttpServletRequest request) {
        ModelAndView success = new ModelAndView();
        WebUser webUser = userService.findUSer();

        if (webUser == null) {
            success.setViewName("loginerror");
            return success;
        }
        if (webUser.getUserName().equals(username) && webUser.getPassword().equals(password)) {
            // TODO 重定向到一个管理系统?
            success.setViewName("redirect:/manage/manage");
            // 登录成功,把对象放在request域中
            request.getSession().setAttribute("webUser", webUser);
        } else {
            success.setViewName("loginerror");
        }

        return success;
    }

}
