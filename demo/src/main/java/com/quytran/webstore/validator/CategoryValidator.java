package com.quytran.webstore.validator;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CategoryValidator implements ConstraintValidator<Category, String> {
	List<String> allowedCategories = new ArrayList<>();
	
	CategoryValidator() {
		allowedCategories.add("Smartphone");
		allowedCategories.add("Tablet");
		allowedCategories.add("Laptop");
	}

	public void initialize(Category constraintAnnotation) {
		// intentionally left blank; this is the place to initialize the constraint
		// annotation for any sensible default values.
	}

	public boolean isValid(String value, ConstraintValidatorContext context) {
		if (!allowedCategories.contains(value)) {
			return false;
		}
		return true;
	}
}
