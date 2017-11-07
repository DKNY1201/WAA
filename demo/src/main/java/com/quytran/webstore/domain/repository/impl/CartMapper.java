package com.quytran.webstore.domain.repository.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import com.quytran.webstore.domain.Cart;
import com.quytran.webstore.domain.CartItem;
import com.quytran.webstore.service.ProductService;

public class CartMapper implements RowMapper<Cart> {
	private CartItemMapper cartItemMapper;
	private NamedParameterJdbcTemplate jdbcTempleate;

	public CartMapper(NamedParameterJdbcTemplate jdbcTempleate, ProductService productService) {
		this.jdbcTempleate = jdbcTempleate;
		cartItemMapper = new CartItemMapper(productService);
	}

	public Cart mapRow(ResultSet rs, int rowNum) throws SQLException {
		String id = rs.getString("ID");
		Cart cart = new Cart(id);
		String SQL = String.format("SELECT * FROM CART_ITEM WHERE CART_ID = '%s'", id);
		
		// Get a collection of CART_ITEM
		// Map that each element of that collection to each Domain object CartItem
		List<CartItem> cartItems = jdbcTempleate.query(SQL, cartItemMapper);
		cart.setCartItems(cartItems);
		return cart;
	}
}