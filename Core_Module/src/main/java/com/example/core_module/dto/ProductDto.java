package com.example.core_module.dto;

import com.example.core_module.model.Category;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductDto {
	private String product_name;
	private String product_sku;
	private double cost_price;
	private double sale_price;
	private String cpu;
	private int ram;
	private int rom;
	private String camera;
	private int pin;
	private double weight;
	private double width;
	private double height;
	private double thick;
	private int current_quantity;
	private String description;
	private Category category;
	
	private Long color_id1;
	private Long color_id2;
	private Long color_id3;
}
