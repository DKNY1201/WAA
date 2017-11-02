package com.peter.starbucks.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.peter.starbucks.domain.repository.UserRepository;
import com.peter.starbucks.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	
	@Override
	public boolean login(String username, String pass) {
		String password = userRepository.getPassword(username);
		
		if (password == null || !password.equals(pass)) {
			return false;
		}
		
		return true;
		
	}

}
