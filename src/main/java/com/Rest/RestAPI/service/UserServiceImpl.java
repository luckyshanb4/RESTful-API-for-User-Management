package com.Rest.RestAPI.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Rest.RestAPI.model.User;
import com.Rest.RestAPI.repositary.UserRepository;

@Service
@Transactional //not necessary
public class UserServiceImpl implements UserService{

	private UserRepository userRepository;
	
	@Autowired //not necessary
	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public User saveUser(User user) {	
		return userRepository.save(user);
	}

	@Override
	public List<User> getAllUsers() {
	
		return userRepository.findAll();
	}

	
}
