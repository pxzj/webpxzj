package com.jq.service;

import org.springframework.stereotype.Service;

@Service
public interface UserService {


	int findUSer(String userName, String password);	
	
	
}
