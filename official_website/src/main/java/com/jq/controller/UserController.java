package com.jq.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jq.constant.Constant;
import com.jq.service.UserService;
import com.jq.vo.SysResult;

@Controller
public class UserController {
@Autowired
UserService userService;
private Logger logger = LoggerFactory.getLogger(this.getClass());


// 登陆页面
  @RequestMapping("/manage/login") 
  public String home() {
    
	return "login";
   }

	@RequestMapping("/manage/findUser")
	@ResponseBody
	//TODO 我这边链接? 还是前端通过returnCode来判断? 日志需要统一封装工具类
	public SysResult findUser(String userName, String password){
	   	int loginResult =  userService.findUSer(userName, password);
	   	//输入账户或者密码有误
	   	if(loginResult == 0){
	   	logger.debug("username or password is error!! username = " + userName + ", password = " + password);
	     return  SysResult.build(1,Constant.INSERT_USER_OR_PASSWORD_ERROR);
	   	}
	   	return SysResult.Success();
	}
	
	
}
