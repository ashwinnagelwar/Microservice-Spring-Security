package com.userService.User.Service.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.userService.User.Service.entity.User;
import com.userService.User.Service.service.UserService;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.core.MediaType;

@RestController
@RequestMapping("/user/v1")
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping(value="/createUser",consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
	public ResponseEntity<Integer> createUser(@RequestBody User user)
	{
		User createUser = userService.createUser(user);
		Integer userId = createUser.getUserId();
		return new ResponseEntity<Integer>(userId, org.springframework.http.HttpStatus.OK);
	}
	
	@GetMapping(value="/getUserById/{id}")
	public ResponseEntity<User> createUser(@PathVariable Integer id)
	{
		User user = userService.getUserById(id);
		return new ResponseEntity<User>(user, org.springframework.http.HttpStatus.OK);
	}
}
