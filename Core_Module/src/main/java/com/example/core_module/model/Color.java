package com.example.core_module.model;


import java.util.List;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
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
@Table(name="color")
public class Color {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	@Column(name="color_id")
	private Long color_id;
	private String color_name;
	
	@OneToMany(mappedBy = "color")
	private List<Product_Image> list_product_image;

}
