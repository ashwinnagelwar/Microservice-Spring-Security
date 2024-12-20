package com.authenticationServer.service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.authenticationServer.entity.UserCredential;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {

	@Value("${jwtSecret}") // Inject the JWT secret from application properties
	  private String jwtSecret;
	  
	  private Key getSignKey() 
	  {
		  byte[] keyBytes=Decoders.BASE64.decode(jwtSecret);
	        return Keys.hmacShaKeyFor(keyBytes);
//	        return Keys.hmacShaKeyFor(jwtSecret.getBytes());
	    }
	  
	  public String generateToken(UserCredential userCredential)
	  {
		  Map<String,Object>claims=new HashMap<>();
		  return createToken(claims,userCredential);
	  }

	   
	  private String createToken(Map<String, Object> claims, UserCredential userCredential) 
	  {
		return Jwts.builder()
                .claims(claims)
                .subject(userCredential.getUsername())
                .header().empty().add("typ","JWT")
                .and()
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 50)) // 5 minutes expiration time
                .signWith(getSignKey(),SignatureAlgorithm.HS256).compact();
               //I have used this depricated as because in gateway, while decoding the size was not matching,
		//so for temporary I have used depricated configuration for encoding and decoding secret key
	  }
	
}
