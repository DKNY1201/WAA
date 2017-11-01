package com.quytran.webstore.service;
import java.util.List;

import com.quytran.webstore.domain.Product;

public interface ProductService {
	void updateAllStock();
	List <Product> getAllProducts();
}
