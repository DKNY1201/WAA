package com.peter.starbucks.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.peter.starbucks.domain.repository.AdviceRepository;
import com.peter.starbucks.domain.repository.UserRepository;
import com.peter.starbucks.service.AdviceService;

@Service
public class AdviceServiceImpl implements AdviceService {

	@Autowired
	AdviceRepository adviceRepository;
	
	@Override
	public Map<Integer, String> getRoast() {
		return adviceRepository.getAdvice();
	}

	@Override
	public List<String> getCoffeesByRoast(String toast) {
		return adviceRepository.getCoffeesByRoast(toast);
	}

}
