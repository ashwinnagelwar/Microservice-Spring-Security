package com.orderService.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orderService.entity.Mobile;
import com.orderService.entity.MyOrder;
import com.orderService.entity.User;
import com.orderService.mobileServiceFeign.MobileServiceFeignClient;
import com.orderService.orderDto.OrderInput;
import com.orderService.repository.OrderRepo;
import com.orderService.userServiceFeign.UserServiceFeignClient;

@Service
public class OrderService {

	@Autowired
	private OrderRepo orderRepo;
	
	@Autowired
	private UserServiceFeignClient userServiceFeignClient;
	
	@Autowired
	private MobileServiceFeignClient mobileServiceFeignClient;
	
	
	public MyOrder placeBuyOrder(OrderInput orderInput)
	{
		User user = userServiceFeignClient.getUserById(orderInput.getUserId());
		Mobile mobile = mobileServiceFeignClient.getMobileById(orderInput.getMobileId());
		MyOrder order=new MyOrder();
		order.setCustomerName(user.getUserName());
		order.setProductName(mobile.getName());
		order.setOrderDate(LocalDate.now());
		order.setOrderValue(mobile.getPrice());
		order.setPaymentMethod(orderInput.getPaymentMethod());
		order.setDeliveryAddress(user.getAddress());
		order.setDeliveryStatus("In-Transit");
		MyOrder order2 = orderRepo.save(order);
		return order2;
	}
}
