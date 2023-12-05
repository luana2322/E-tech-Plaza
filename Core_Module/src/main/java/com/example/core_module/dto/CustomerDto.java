package com.example.core_module.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerDto {
	private String customeremail;
	private String customerpassword;

	private String confirmpassword;
	private String first_name;
	private String last_name;
	private String customer_phone;
}
