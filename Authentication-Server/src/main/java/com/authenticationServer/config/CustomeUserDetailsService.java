package com.authenticationServer.config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.authenticationServer.entity.UserCredential;
import com.authenticationServer.repository.UserCredentailRepository;

@Component
public class CustomeUserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService{

	@Autowired
	private UserCredentailRepository userCredentailRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		UserCredential userCredential = userCredentailRepository.findByUsername(username);
		
		if (userCredential != null) {
			CustomeUserDetails customeUserDetails=new CustomeUserDetails(userCredential);
            return customeUserDetails;
                    
        }
        throw new UsernameNotFoundException("User not found with username: " + username);
	}

}
