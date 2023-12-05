package com.example.core_module.model;

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
@Table(name = "order_detail")
public class Order_Detail {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_detail_id")
	private Long order_detail_id;
	private int quantity;
	private double product_price;
	private double total_amount;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "product_id", referencedColumnName = "product_id")
	private Product product;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "order_id", referencedColumnName = "order_id")
	private Orders orders;

}
