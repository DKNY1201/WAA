package com.packt.webstore.interceptor;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class MessageBaseRoleInterceptor extends HandlerInterceptorAdapter {

	public boolean preHandle(HttpServletRequest request, HttpServletResponse arg1, Object arg2) throws Exception {
		Principal principal = request.getUserPrincipal();
		System.out.println("principal: " + principal);
		String userMessage = "Welcome to web security demo!";
		if(request.isUserInRole("ROLE_ADMIN")) {
			userMessage += " YOUR ROLE IS ADMIN";
		} else if(request.isUserInRole("ROLE_USER")) {
			userMessage += " YOUR ROLE IS USER";
		} else if(request.isUserInRole("ROLE_DBA")) {
			userMessage += " YOUR ROLE IS DBA";
		}
		request.setAttribute("userMessage", userMessage);
		return true;
	}

}
