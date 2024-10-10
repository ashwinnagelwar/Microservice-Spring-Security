package com.orderService.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class User {

	private Integer userId;
	private String userName;
	private Long mobileNo;
	private String gender;
	private int	age;
	private String address;

}
