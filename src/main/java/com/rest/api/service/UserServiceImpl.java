package com.rest.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.api.exception.ResourceNotFoundException;
import com.rest.api.model.User;
import com.rest.api.repositary.UserRepository;

@Service
public class UserServiceImpl implements UserService {

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

	@Override
	public User getUserById(long id) {
		
		Optional<User> user=userRepository.findById(id);
		
		if(user.isPresent()) {
			return user.get();
		}else {
			throw new ResourceNotFoundException("User","ID",id);
		}
		
	}

	@Override
	public User updateUser(User user, long id) {
		//check if user id is exist
		User selectedUser=userRepository.findById(id).orElseThrow(
				()-> new ResourceNotFoundException("User","ID",id));
		
		//we update except password (Project Requirement)
		selectedUser.setEmail(user.getEmail());
		selectedUser.setFirstName(user.getFirstName());
		selectedUser.setLastName(user.getLastName());
		selectedUser.setUsername(user.getUsername());
		
		//save to db
		userRepository.save(selectedUser);
		return selectedUser;
	}

	@Override
	public void deleteUser(long id) {
		
		//check if user id is exist
		userRepository.findById(id).orElseThrow(
			()-> new ResourceNotFoundException("User","ID",id));
				
		userRepository.deleteById(id);
		
	}

	
}
