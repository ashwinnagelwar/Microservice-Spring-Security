package com.orderService.userServiceFeign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.orderService.entity.User;

@FeignClient(name="User-Service")
public interface UserServiceFeignClient {
	
	@GetMapping("/user/v1/getUserById/{id}")
	User getUserById(@PathVariable Integer id);

}
