package com.mobileService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mobileService.entity.Mobile;
import com.mobileService.service.MobileService;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.core.MediaType;

@RequestMapping("/mobile/v1")
@RestController
public class MobileController {

	@Autowired
	private MobileService mobileService;
	
	@GetMapping(value = "/getAllMobiles", produces = MediaType.APPLICATION_JSON)
	public ResponseEntity<List<Mobile>> getAllMobiles()
	{
		List<Mobile> allMobiles = mobileService.getAllMobiles();
		return new ResponseEntity<List<Mobile>>(allMobiles, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getMobileByRam/{ram}", produces = MediaType.APPLICATION_JSON)
	public ResponseEntity<List<Mobile>> getMobileByRam(@PathVariable String ram)
	{
		List<Mobile> allMobiles = mobileService.getMobileByRam(ram);
		return new ResponseEntity<List<Mobile>>(allMobiles, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getMobileByRom", consumes = { MediaType.APPLICATION_JSON,MediaType.APPLICATION_ATOM_XML}, produces = MediaType.APPLICATION_JSON)
	public ResponseEntity<List<Mobile>> getMobileByRom(@PathVariable String rom)
	{
		List<Mobile> allMobiles = mobileService.getMobileByRom(rom);
		return new ResponseEntity<List<Mobile>>(allMobiles, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getMobileByPrice", consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
	public ResponseEntity<List<Mobile>> getMobileByPrice(@PathVariable Long price)
	{
		List<Mobile> allMobiles = mobileService.getMobileByPrice(price);
		return new ResponseEntity<List<Mobile>>(allMobiles, HttpStatus.OK);
	}
	
	@GetMapping("/getMobileById/{id}")
	public ResponseEntity<Mobile> getMobileById(@PathVariable Integer id)
	{
		Mobile mobile = mobileService.getMobileById(id);
		return new ResponseEntity<Mobile>(mobile, HttpStatus.OK);
	}
}
