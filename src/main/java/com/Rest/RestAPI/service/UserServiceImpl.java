package com.Rest.RestAPI.service;

import org.springframework.stereotype.Service;

import com.Rest.RestAPI.model.User;
import com.Rest.RestAPI.repositary.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	private UserRepository userRepository;
	
	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public User saveUser(User user) {	
		return userRepository.save(user);
	}

	
}
