package com.Rest.RestAPI.repositary;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Rest.RestAPI.model.User;


public interface UserRepository extends JpaRepository<User, Long>{

}
