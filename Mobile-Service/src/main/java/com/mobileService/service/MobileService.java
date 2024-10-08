package com.mobileService.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobileService.entity.Mobile;
import com.mobileService.repository.MobileRepo;

@Service
public class MobileService {

	@Autowired
	private MobileRepo mobileRepo;
	
	public List<Mobile> getAllMobiles()
	{
		return mobileRepo.findAll();
	}
	
	public List<Mobile> getMobileByRam(String ram)
	{
		return mobileRepo.findAllByRam(ram);
	}
	
	public List<Mobile> getMobileByRom(String rom)
	{
		return mobileRepo.findByRom(rom);
	}
	
	public List<Mobile> getMobileByPrice(Long price)
	{
		return mobileRepo.findByPrice(price);
	}
}
