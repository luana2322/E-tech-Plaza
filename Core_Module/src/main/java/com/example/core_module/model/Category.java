package com.example.core_module.model;



import java.util.Date;
import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="category")
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="category_id")
	private Long category_id;
	private String category_name;
	private String category_image_path;
	private String description;
	private int parent_id;
	
	private String category_status;
	private Date created_At;
	private Date update_At;
	
	private boolean is_activated;
	private boolean is_deleted;

	@OneToMany(mappedBy = "category")
	private List<Product_Category> list_product_category;

}
