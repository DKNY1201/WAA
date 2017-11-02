package com.peter.starbucks.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.peter.starbucks.domain.User;
import com.peter.starbucks.service.UserService;

@Controller
public class UserControler {
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value= {"/", "/login"}, method = RequestMethod.GET)
	public String login() {
		return "login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginHandle(User user, Model model) {
		boolean isLoggedIn = userService.login(user.getUsername(), user.getPassword());
		
		if (isLoggedIn) {
			return "login-successful";
		}
		
		model.addAttribute("error", "Username or password is wrong");
		return "login";
	}
}
