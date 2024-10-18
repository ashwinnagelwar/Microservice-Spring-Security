package com.authenticationServer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.authenticationServer.entity.UserCredential;
import com.authenticationServer.service.JwtService;
import com.authenticationServer.service.UserCredentailService;

@RestController
@RequestMapping("/auth-server/v1")
public class UserCredentailController {

	@Autowired
	private UserCredentailService userCredentailService;
	
	@Autowired
	private JwtService jwtService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@PostMapping("/signUpUser")
	public ResponseEntity<String> signUpUser(@RequestBody UserCredential userCredential)
	{
		String msg = userCredentailService.signUpUser(userCredential);
		return new ResponseEntity<String>(msg, HttpStatus.OK);
	}
	
	@PostMapping("/generate-token")
	public ResponseEntity<String> generateToken(@RequestBody UserCredential userCredential)
	{
		Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userCredential.getUsername(), userCredential.getPassword()));
		if(authenticate.isAuthenticated()) {
		String token = jwtService.generateToken(userCredential);
		return new ResponseEntity<String>(token, HttpStatus.OK);
		}else
		{
			return new ResponseEntity<String>("Invalid Access", HttpStatus.UNAUTHORIZED);
		}
	}
}
