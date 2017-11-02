package com.peter.calc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.peter.calc.domain.Calculator;
import com.peter.calc.service.CalculatorService;
import com.peter.calc.validator.CalculatorValidator;

@Controller
public class CalcController {
	@Autowired
	private CalculatorService calculatorService;
	
	@Autowired
	private CalculatorValidator calculatorValidator;
	
	@RequestMapping(value = {"/", "/calculator"})
	public String showCalcForm(Model model) {
		return "calculator";
	}

	@RequestMapping(value = "/handleCalc", method = RequestMethod.POST)
	public String handleCalc(Calculator calculator, Model model, RedirectAttributes redirectAttributes) {

		List<String> errors = calculatorValidator.validate(calculator);
		if (errors.isEmpty()) {
			calculatorService.add(calculator);
			calculatorService.mult(calculator);
			redirectAttributes.addFlashAttribute("calculator", calculator);
			redirectAttributes.addAttribute("greeting", "Welcome to Calculator application");
			return "redirect:/result";
		} else {
			// store errors and calculator in a scope variable for the view
			model.addAttribute("errors", errors);
			model.addAttribute("calculator", calculator);
			return "calculator";
		}

	}
	
	@RequestMapping(value = "/result", method = RequestMethod.GET)
	public String result(Model model) {
		return "result";
	}
}