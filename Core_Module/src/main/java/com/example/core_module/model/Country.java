package com.example.core_module.model;

import java.util.List;

import jakarta.persistence.CascadeType;
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
@AllArgsConstructor
@NoArgsConstructor
@Table(name="country")
public class Country {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="country_id")
	private Long country_id;
	private String country_name;
	

	@OneToMany(mappedBy = "country",cascade =CascadeType.ALL )
	private List<Customer> list_customer;
	
	@OneToMany(mappedBy = "country",cascade =CascadeType.ALL )
	private List<City> list_city;
	
	
}
