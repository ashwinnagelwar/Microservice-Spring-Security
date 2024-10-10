package com.orderService.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Mobile {

	private Integer mobileId;
	private String name;
	private String modelNo;
	private String ram;
	private String rom;
	private String warrentyPeriod;
	private String companyName;
	private String camera;
	private Long price;
	private Long Quantity;
}
