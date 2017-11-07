package com.quytran.webstore.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.quytran.webstore.domain.Cart;
import com.quytran.webstore.domain.repository.CartRepository;
import com.quytran.webstore.dto.CartDto;
import com.quytran.webstore.service.CartService;

@Service
public class CartServiceImpl implements CartService {
	@Autowired
	private CartRepository cartRepository;

	public void create(CartDto cartDto) {
		cartRepository.create(cartDto);
	}

	@Override
	public Cart read(String id) {
		return cartRepository.read(id);
	}

	@Override
	public void update(String id, CartDto cartDto) {
		cartRepository.update(id, cartDto);
	}

	@Override
	public void delete(String id) {
		cartRepository.delete(id);
	}

	@Override
	public void addItem(String cartId, String productId) {
		cartRepository.addItem(cartId, productId);
	}

	@Override
	public void removeItem(String cartId, String productId) {
		cartRepository.removeItem(cartId, productId);
	}
}