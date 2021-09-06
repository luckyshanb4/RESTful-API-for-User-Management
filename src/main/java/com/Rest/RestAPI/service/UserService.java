package com.Rest.RestAPI.service;

import java.util.List;

import com.Rest.RestAPI.model.User;


public interface UserService {
	User saveUser(User user);
	List<User> getAllUsers();

}
