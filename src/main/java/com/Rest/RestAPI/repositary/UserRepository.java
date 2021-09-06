package com.Rest.RestAPI.repositary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Rest.RestAPI.model.User;

@Repository //not necessary
public interface UserRepository extends JpaRepository<User, Long>{

}
