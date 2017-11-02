package com.peter.starbucks.domain.repository.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.peter.starbucks.database.Database;
import com.peter.starbucks.domain.repository.AdviceRepository;

@Repository
public class AdviceRepositoryImpl implements AdviceRepository {
	@Autowired
	Database database;
	
	@Override
	public Map<Integer, String> getAdvice() {
		return database.roasts;
	}

	@Override
	public List<String> getCoffeesByRoast(String toast) {
		return database.advice.get(toast);
	}

}
