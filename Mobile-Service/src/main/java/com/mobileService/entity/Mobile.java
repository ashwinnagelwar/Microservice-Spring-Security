package com.mobileService.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Mobile {

	
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
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
