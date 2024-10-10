package com.orderService.orderDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderInput {

	private Integer userId;
	private Integer mobileId;
	private String paymentMethod;
}
