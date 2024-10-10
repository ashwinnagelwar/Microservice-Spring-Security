package com.userService.User.Service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.userService.User.Service.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer>{

}
