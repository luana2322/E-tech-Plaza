package com.example.core_module.model;

import jakarta.persistence.*;

import lombok.*;

import java.util.List;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "product")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_id")
	private Long product_id;
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
	private boolean is_activated;
	private boolean is_deleted;
	
	
	@Column(name="description")
	private String description;

	@OneToMany(mappedBy = "product")
	private List<Product_Image> list_product_image;

	@OneToMany(mappedBy = "product")
	private List<Product_Category> list_product_category;


	@OneToMany(mappedBy = "product")
	private List<Cart_Item> list_cart_item;

	@OneToMany(mappedBy = "product")
	private List<Order_Detail> list_order_detail;

	@OneToMany(mappedBy = "product")
	private List<Product_Review> list_product_review;

	@OneToMany(mappedBy = "product")
	private List<Wishlist> list_wishlist; 

}
