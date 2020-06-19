package com.revature.cats.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.cats.models.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
