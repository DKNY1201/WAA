package com.peter.starbucks.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.peter.starbucks.service.AdviceService;

@Controller
public class AdviceController {
	@Autowired
	AdviceService adviceService;
	
	@RequestMapping(value = "/advice", method = RequestMethod.GET)
	public String advice(Model model) {
		Map<Integer, String> roasts = adviceService.getRoast();
		model.addAttribute("roasts", roasts);
		return "advice";
	}
	
	@RequestMapping(value = "/advice", method = RequestMethod.POST)
	public String handleAdvice(String roast, Model model) {
		List<String> coffees = adviceService.getCoffeesByRoast(roast);
		model.addAttribute("coffees", coffees);
		return "display";
	}
}
