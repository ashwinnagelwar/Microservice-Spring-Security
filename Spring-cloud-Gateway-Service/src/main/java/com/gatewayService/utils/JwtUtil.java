package com.gatewayService.utils;

import java.security.Key;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoder;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
@Component
public class JwtUtil {


	@Value("${jwtSecret}") // Inject the JWT secret from application properties
	  private String jwtSecret;
	  
	private Key getSignKey() 
	  {
	        byte[] keyBytes=Decoders.BASE64.decode(jwtSecret);
	        return Keys.hmacShaKeyFor(keyBytes);
	    }
		
		   public void validateToken(String token) {
		        Jwts.parser()
		                .setSigningKey(getSignKey()) // Set your signing key
		                .build()
		                .parseClaimsJws(token)
		                .getBody(); 
		        //I have used this depricated as because in gateway, while decoding the size was not matching,
				//so for temporary I have used depricated configuration for encoding and decoding secret key
		        
		    }
}
