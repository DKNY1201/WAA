package com.quytran.webstore.domain.repository;

import java.util.List;
import com.quytran.webstore.domain.Product;

public interface ProductRepository {
	List<Product> getAllProducts();
	void updateStock(String productId, long noOfUnits);
	List<Product> getProductsByCategory(String category);
}
