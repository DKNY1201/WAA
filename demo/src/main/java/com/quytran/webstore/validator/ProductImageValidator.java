package com.quytran.webstore.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.quytran.webstore.domain.Product;

@Component
public class ProductImageValidator implements Validator {
	private long allowedSize = 10240000;
	public boolean supports(Class<?> clazz) {
		return Product.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors errors) {
		Product product = (Product) target;
		if (product.getProductImage() != null 
				&& product.getProductImage().getSize() > allowedSize) {
			errors.rejectValue("productImage", "com.quytran.webstore.validator.ProductImageValidator.message");
		}
	}
}