package com.example.core_module.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product_ImageDto {
	private String product_image_path;
	private int sort_order;
	private Long product_id;
	private Long color_id;
}
