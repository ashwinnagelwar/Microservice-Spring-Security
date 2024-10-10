package com.userService.User.Service.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.userService.User.Service.entity.User;
import com.userService.User.Service.repository.UserRepo;

@Service
public class UserService {

	@Autowired
	private UserRepo userServiceRepo;

	public User createUser(User user) {
		
		return userServiceRepo.save(user);
	}
	
	
	public User getUserById(Integer id)
	{
		Optional<User> optional = userServiceRepo.findById(id);
		return optional.get();
	}
}
