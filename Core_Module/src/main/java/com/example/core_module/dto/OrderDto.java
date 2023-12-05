package com.example.core_module.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
public class OrderDto {

	private String first_name;
	private String last_name;
	private String email;
	private String phone;
	private String company_name;
	private String address_1;
	private String address_2;

	private String order_note;
	private String zipcode;
	private int city_id;
		
}
