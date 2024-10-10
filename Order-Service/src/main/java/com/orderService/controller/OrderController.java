package com.orderService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orderService.entity.MyOrder;
import com.orderService.entity.User;
import com.orderService.orderDto.OrderInput;
import com.orderService.service.OrderService;
import com.orderService.userServiceFeign.UserServiceFeignClient;

@RestController
@RequestMapping("/order/v1")
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	
	@PostMapping("/placeBuyOrder")
	public ResponseEntity<MyOrder> placeBuyOrder(@RequestBody OrderInput orderInput)
	{
		MyOrder order = orderService.placeBuyOrder(orderInput);
		return new ResponseEntity<MyOrder>(order, HttpStatus.OK);
			
	}
	
}
