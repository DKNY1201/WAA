package com.peter.calc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.peter.calc.domain.Calculator;
import com.peter.calc.service.CalculatorService;
import com.peter.calc.validator.CalculatorValidator;

@Controller
public class CalcController {
	@Autowired
	private CalculatorService calculatorService;
	
	@Autowired
	private CalculatorValidator calculatorValidator;
	
	@RequestMapping("/")
	public String showCalcForm(Model model) {
		return "calculator";
	}

	@RequestMapping(value = "/handleCalc")
	public String handleCalc(Calculator calculator, Model model) {

		List<String> errors = calculatorValidator.validate(calculator);
		if (errors.isEmpty()) {
			calculatorService.add(calculator);
			calculatorService.mult(calculator);

			model.addAttribute("calculator", calculator);
			return "result";
		} else {
			// store errors and calculator in a scope variable for the view
			model.addAttribute("errors", errors);
			model.addAttribute("calculator", calculator);
			return "calculator";
		}

	}
}