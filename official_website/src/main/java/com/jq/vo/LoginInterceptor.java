package com.jq.vo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

public class LoginInterceptor implements HandlerInterceptor{

	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		  Object webUser = request.getSession().getAttribute("webUser");
	      if (webUser == null || webUser.equals(""))  {
	            response.sendRedirect("/login");  
	            return false;  
	        }
	        return true;
	    }  
		
}
