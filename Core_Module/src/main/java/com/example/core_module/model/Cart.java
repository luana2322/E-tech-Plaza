package com.example.core_module.model;

import java.util.Date;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
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
@Table(name="cart")
public class Cart {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY )
	@Column(name="cart_id")
	private Long cart_id;
	private double total_amount;
	private int total_item;
	private Date created_At;
	private Date updated_At;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "customer_id",referencedColumnName = "customer_id")
	private Customer customer;
	
	@OneToMany(mappedBy = "cart",fetch = FetchType.EAGER)
	private List<Cart_Item> list_cart_item;
}
