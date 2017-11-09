package com.quytran.webstore.domain.repository;

import com.quytran.webstore.domain.Order;

public interface OrderRepository {
	long saveOrder(Order order);
}
