package com.peter.calc.validator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.peter.calc.domain.Calculator;

@Service
public class CalculatorValidatorImpl implements CalculatorValidator {

	public List<String> validate(Object object) {
		List<String> errors = new ArrayList<String>();

		Calculator calculator = (Calculator) object;

		Integer  add1 = calculator.getAdd1();
		Integer  add2 = calculator.getAdd2();
		Integer  mult1 = calculator.getMult1();
		Integer  mult2 = calculator.getMult2();

		if (add1 == null) {
			errors.add("First input for Adding is missing");
		}
		
		if (add2 == null) {
			errors.add("Second input for Adding is missing");
		}
		
		if (mult1 == null) {
			errors.add("First input for Multiplication is missing");
		}
		
		if (mult2 == null) {
			errors.add("Second input for Multiplication is missing");
		}
		
		return errors;
	}
}
