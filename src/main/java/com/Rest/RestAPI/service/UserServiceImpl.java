package com.Rest.RestAPI.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Rest.RestAPI.exception.ResourceNotFoundException;
import com.Rest.RestAPI.model.User;
import com.Rest.RestAPI.repositary.UserRepository;

@Service
@Transactional //not necessary
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
