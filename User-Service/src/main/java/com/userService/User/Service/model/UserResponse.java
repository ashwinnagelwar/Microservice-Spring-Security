package com.userService.User.Service.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserResponse {

	private String userId;
	private String userName;
	private Long mobileNo;
	private String gender;
	private int	age;
	private String address;
}
