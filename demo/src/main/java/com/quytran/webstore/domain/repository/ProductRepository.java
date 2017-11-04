package com.quytran.webstore.domain.repository;

import java.util.List;
import java.util.Map;

import com.quytran.webstore.domain.Product;

public interface ProductRepository {
	List<Product> getAllProducts();
	void updateStock(String productId, long noOfUnits);
	List<Product> getProductsByCategory(String category);
	List<Product> getProductsByFilter(Map<String,List<String>> filterParams);
	Product getProductById(String productID);
	List<Product> getProductsByMultiCriteria(String category, String brand, Map<String,List<String>> filterParams);
	void addProduct(Product product);
}
