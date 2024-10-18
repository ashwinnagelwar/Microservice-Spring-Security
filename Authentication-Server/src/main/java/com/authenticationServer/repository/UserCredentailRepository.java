package com.authenticationServer.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.authenticationServer.entity.UserCredential;

@Repository
public interface UserCredentailRepository extends JpaRepository<UserCredential, Integer>{

	UserCredential findByUsername(String username);

}
