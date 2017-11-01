package mum.edu.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mum.edu.domain.Calculator;
import mum.edu.validator.CalcValidator;

public class ResultController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		String add1 = request.getParameter("add1");
		String add2 = request.getParameter("add2");
		String mult1 = request.getParameter("mult1");
		String mult2 = request.getParameter("mult2");
		
		Calculator calc = new Calculator(add1, add2, mult1, mult2);
		
		CalcValidator calcValidator = new CalcValidator(); 
		List<String> errors = calcValidator.validator(calc);

		if (errors.isEmpty()) {
			calc.add();
			calc.mult();
			Float sum = calc.getSum();
			Float product = calc.getProduct();

			request.setAttribute("sum", sum);
			request.setAttribute("product", product);
			return "/WEB-INF/jsp/result.jsp";
		} else {
			request.setAttribute("calc", calc);
			request.setAttribute("errors", errors);
			return "/WEB-INF/jsp/calculator.jsp";
		}
	}

}
