package com.authenticationServer.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomeException{

	@ExceptionHandler(UsernameNotFoundException.class)
	public ResponseEntity<String> UsernameNotFoundException(UsernameNotFoundException ex)
	{
		return new ResponseEntity<String>(ex.getMessage(), HttpStatus.OK);
		
	}
}
