package com.authenticationServer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.authenticationServer.config.CustomeUserDetailsService;
import com.authenticationServer.entity.UserCredential;
import com.authenticationServer.repository.UserCredentailRepository;

@Service
public class UserCredentailService {

	@Autowired
	private UserCredentailRepository userCredentailRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private CustomeUserDetailsService userDetailsService;
	
	public String signUpUser(UserCredential userCredential)
	{
		userCredential.setPassword(passwordEncoder.encode(userCredential.getPassword()));
		userCredentailRepository.save(userCredential);
		return "User Added Successfully";
	}
}
