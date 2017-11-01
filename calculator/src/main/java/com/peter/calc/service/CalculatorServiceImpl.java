package com.peter.calc.service;

import org.springframework.stereotype.Service;

import com.peter.calc.domain.Calculator;

@Service
public class CalculatorServiceImpl implements CalculatorService {

	public void add(Calculator calculator) {
		calculator.add();

		/*
		 * if calculator.getSum() <= 0 register debit notify debit processor
		 */
		return;
	}

	public void mult(Calculator calculator) {
		calculator.mult();

		/*
		 * if calculator.getMult() > maxLimit register over budget notify overflow
		 * processor
		 */

		return;
	}

}
