package com.peter.starbucks.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

import com.peter.starbucks.domain.User;
import com.peter.starbucks.service.AdviceService;

@Controller
public class AdviceController {
	@Autowired
	AdviceService adviceService;
	
	@RequestMapping(value = "/advice", method = RequestMethod.GET)
	public String advice(Model model) {
		Map<Integer, String> roasts = adviceService.getRoast();
		model.addAttribute("roasts", roasts);
		User user = (User) model.asMap().get("user");
		return "advice";
	}
	
	@RequestMapping(value = "/advice", method = RequestMethod.POST)
	public String handleAdvice(String roast, Model model) {
		List<String> coffees = adviceService.getCoffeesByRoast(roast);
		model.addAttribute("coffees", coffees);
		return "display";
	}
	
//	@RequestMapping(value = "/logout", method = RequestMethod.GET)
//	public String logout(Model model, SessionStatus status, HttpSession session) {
//		status.setComplete();
//		model.asMap().remove("user");
//		return "redirect:/login";
//	}
}
