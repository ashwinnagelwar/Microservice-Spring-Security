package com.userService.User.Service.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Data
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonProperty("userId")
	private Integer userId;
	@JsonProperty("userName")
	private String userName;
	@JsonProperty("mobileNo")
	private Long mobileNo;
	@JsonProperty("gender")
	private String gender;
	@JsonProperty("age")
	private int	age;
	@JsonProperty("address")
	private String address;
}
