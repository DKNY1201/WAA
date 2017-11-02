package com.peter.starbucks.domain.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.peter.starbucks.database.Database;
import com.peter.starbucks.domain.User;
import com.peter.starbucks.domain.repository.UserRepository;

@Repository
public class UserRepositoryImpl implements UserRepository {
	@Autowired
	Database database;
	
	@Override
	public String getPassword(String username) {
		User user = database.users.get(username);
		
		if (user != null) {
			return database.users.get(username).getPassword();
		}
		
		return "";
	}

}
