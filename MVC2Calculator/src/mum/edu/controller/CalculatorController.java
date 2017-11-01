package mum.edu.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mum.edu.domain.Calculator;
import mum.edu.framework.annotation.AutoWired;
import mum.edu.framework.annotation.RequestMapping;
import mum.edu.framework.annotation.Controller;
import mum.edu.service.CalculatorService;
import mum.edu.validator.CalculatorValidator;

@Controller
public class CalculatorController implements mum.edu.framework.controller.Controller {

	@AutoWired
	CalculatorValidator calculatorValidator;

	@AutoWired
	CalculatorService calculatorService;

	@RequestMapping(value = { "/"})
	public String homepage() {
		return "/WEB-INF/jsp/index.jsp";
	}
	
	@RequestMapping(value = { "/calc" })
	public String inputCalc(Calculator calculator) {
		return "/WEB-INF/jsp/calculator.jsp";
	}

	@RequestMapping(value = "/result")
	public String handleCalc(Calculator calculator, HttpServletRequest request, HttpServletResponse response) {

		List<String> errors = calculatorValidator.validate(calculator);
		if (errors.isEmpty()) {
			calculatorService.add(calculator);
			calculatorService.mult(calculator);

			request.setAttribute("calc", calculator);
			return "/WEB-INF/jsp/result.jsp";
		} else {
			// store errors and calculator in a scope variable for the view
			request.setAttribute("errors", errors);
			request.setAttribute("calc", calculator);
			return "/WEB-INF/jsp/calculator.jsp";
		}

	}

}
