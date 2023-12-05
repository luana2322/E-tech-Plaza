package com.example.core_module.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "product_review")
public class Product_Review {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="product_review_id")
	private Long product_review_id;
	private int rating;
	private String comment;
	private int num_comment;
	private Date created_At;
	private Date updated_At;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="product_id",referencedColumnName = "product_id")
	private Product product;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="customer_id",referencedColumnName = "customer_id")
	private Customer customer;
}
