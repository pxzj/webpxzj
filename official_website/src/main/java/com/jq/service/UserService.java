package com.jq.service;

import org.springframework.stereotype.Service;

import com.jq.pojo.WebUser;

@Service
public interface UserService {


	WebUser findUSer();
	
	
}
