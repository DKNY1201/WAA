package com.quytran.webstore.service;

import java.util.List;
import java.util.Map;

import com.quytran.webstore.domain.Product;

public interface ProductService {
	void updateAllStock();

	List<Product> getAllProducts();

	List<Product> getProductsByCategory(String category);

	List<Product> getProductsByFilter(Map<String, List<String>> filterParams);

	Product getProductById(String productID);

	List<Product> getProductsByMultiCriteria(String category, String brand, Map<String, List<String>> filterParams);
	
	void addProduct(Product product);
}
