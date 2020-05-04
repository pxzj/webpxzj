package com.jq.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jq.mapper.UserMapper;
import com.jq.pojo.WebUser;
@Service
public class UserServiceImpl implements UserService {
@Autowired
UserMapper userMapper;	
	@Override
	public WebUser findUSer()  {
		
		WebUser  webUser = userMapper.findUSer();
 
		return webUser;
	}

}
