package com.orderService.mobileServiceFeign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.orderService.entity.Mobile;

@FeignClient(name="Mobile-Service")
public interface MobileServiceFeignClient {

	@GetMapping("/mobile/v1/getMobileById/{id}")
	Mobile getMobileById(@PathVariable Integer id);
}
