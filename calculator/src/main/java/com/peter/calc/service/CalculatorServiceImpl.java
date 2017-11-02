package com.peter.calc.service;

import org.springframework.stereotype.Service;

import com.peter.calc.domain.Calculator;

@Service
public class CalculatorServiceImpl implements CalculatorService {

	public void add(Calculator calculator) {
		calculator.add();
		return;
	}

	public void mult(Calculator calculator) {
		calculator.mult();
		return;
	}

}
