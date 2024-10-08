package com.mobileService.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mobileService.entity.Mobile;

@Repository
public interface MobileRepo extends JpaRepository<Mobile, Integer>{

	
	List<Mobile> findAllByRam(String ram);
	
	List<Mobile> findByRom(String rom);
	
	List<Mobile> findByPrice(Long price);
	
}