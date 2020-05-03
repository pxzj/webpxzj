package com.jq.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jq.mapper.UserMapper;
@Service
public class UserServiceImpl implements UserService {
@Autowired
UserMapper userMapper;	
	@Override
	public int findUSer(String userName, String password)  {
		
	int result = userMapper.findUSer(userName, password);
 
		return result;
	}

}
