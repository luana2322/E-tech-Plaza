package com.example.core_module.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "product_image")
public class Product_Image {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="product_image_id")
	private Long product_image_id;
	private String product_image_path;
	private int sort_order;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "product_id", referencedColumnName = "product_id")
	private Product product;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="color_id",referencedColumnName = "color_id")
	private Color color;
}
