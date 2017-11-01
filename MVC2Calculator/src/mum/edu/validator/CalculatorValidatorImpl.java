package mum.edu.validator;

import java.util.ArrayList;
import java.util.List;

import mum.edu.domain.Calculator;

public class CalculatorValidatorImpl implements CalculatorValidator {
	
	public List<String> validate(Object  object ) {
		List<String> errors = new ArrayList<String>();
		
		Calculator calc = (Calculator) object;
		
		Integer  add1 = calc.getAdd1();
		Integer  add2 = calc.getAdd2();
		Integer  mult1 = calc.getMult1();
		Integer  mult2 = calc.getMult2();

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
