package com.quytran.webstore.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CartTest {
	private Cart cart;

	@Before
	public void setup() {
		cart = new Cart("1");
	}

	@Test
	public void cart_grand_total_should_equal_to_total_of_total_price_of_all_cartitem_in_cart() {
		// Arrange
		List<CartItem> cartItems = new ArrayList<>();
		Product iphone = new Product("P1234", "iPhone 5s", new BigDecimal(500));
		Product iphonex = new Product("P1235", "iPhone X", new BigDecimal(1000));
		CartItem cartItem1 = new CartItem("1");
		cartItem1.setProduct(iphone);
		CartItem cartItem2 = new CartItem("2");
		cartItem2.setQuantity(10);
		cartItem2.setProduct(iphonex);
		cartItems.add(cartItem1);
		cartItems.add(cartItem2);
		cart.setCartItems(cartItems);
		// Act
		BigDecimal totalPrices = cartItem1.getTotalPrice().add(cartItem2.getTotalPrice());
		BigDecimal grandPrice = cart.getGrandTotal();
		// Assert
		Assert.assertEquals(grandPrice, totalPrices);
	}
}