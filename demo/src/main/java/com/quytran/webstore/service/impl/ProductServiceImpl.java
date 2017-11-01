package com.quytran.webstore.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.quytran.webstore.domain.Product;
import com.quytran.webstore.domain.repository.ProductRepository;
import com.quytran.webstore.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductRepository productRepository;

	@Override
	public void updateAllStock() {
		List<Product> allProducts = productRepository.getAllProducts();
		for (Product product : allProducts) {
			if (product.getUnitsInStock() < 500)
				productRepository.updateStock(product.getProductId(), product.getUnitsInStock() + 1000);
		}
	}

	@Override
	public List<Product> getAllProducts() {
		return productRepository.getAllProducts();
	}
}