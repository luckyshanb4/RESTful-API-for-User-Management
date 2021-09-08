package com.rest.api.repositary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rest.api.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
