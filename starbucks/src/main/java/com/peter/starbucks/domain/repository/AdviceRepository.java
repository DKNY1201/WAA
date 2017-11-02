package com.peter.starbucks.domain.repository;

import java.util.List;
import java.util.Map;

public interface AdviceRepository {
	public Map<Integer, String> getAdvice();
	public List<String> getCoffeesByRoast(String toast);
}
