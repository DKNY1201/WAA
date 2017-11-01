package mum.edu.validator;

import java.util.ArrayList;
import java.util.List;

import mum.edu.domain.Calculator;

public class CalcValidator {
	public List<String> validator(Calculator calc) {
		List<String> errors = new ArrayList<String>();
		String add1 = calc.getAdd1();
		String add2 = calc.getAdd2();
		String mult1 = calc.getMult1();
		String mult2 = calc.getMult2();
		
		if (add1 == null || add1.trim().isEmpty()) {
			errors.add("First input for Adding is missing");
		} else {
			try {
				Float.parseFloat(add1);
			} catch(NumberFormatException e) {
				errors.add("Invalid Add1 value");
			}
		}
		
		if (add2 == null || add2.trim().isEmpty()) {
			errors.add("Second input for Adding is missing");
		} else {
			try {
				Float.parseFloat(add2);
			} catch(NumberFormatException e) {
				errors.add("Invalid Add2 value");
			}
		}
		
		if (mult1 == null || mult1.trim().isEmpty()) {
			errors.add("First input for Multiple is missing");
		} else {
			try {
				Float.parseFloat(mult1);
			} catch(NumberFormatException e) {
				errors.add("Invalid Mult1 value");
			}
		}
		
		if (mult2 == null || mult2.trim().isEmpty()) {
			errors.add("Second input for Multiple is missing");
		} else {
			try {
				Float.parseFloat(mult2);
			} catch(NumberFormatException e) {
				errors.add("Invalid Mult2 value");
			}
		}
		
		return errors;
	}
}
