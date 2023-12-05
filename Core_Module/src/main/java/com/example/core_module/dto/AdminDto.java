package com.example.core_module.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor	
@Data
public class AdminDto {
	private String email;
	private String first_name;
	private String password;
	private String repeatpassword;
}
