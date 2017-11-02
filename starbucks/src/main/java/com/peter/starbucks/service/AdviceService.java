package com.peter.starbucks.service;

import java.util.List;
import java.util.Map;

public interface AdviceService {
	Map<Integer, String> getRoast();
	public List<String> getCoffeesByRoast(String toast);
}
