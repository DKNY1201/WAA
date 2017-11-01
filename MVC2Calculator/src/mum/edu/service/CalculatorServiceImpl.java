package mum.edu.service;

import mum.edu.domain.Calculator;

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
