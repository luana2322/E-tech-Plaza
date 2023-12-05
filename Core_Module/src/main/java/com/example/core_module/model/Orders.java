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
import jakarta.persistence.ManyToOne;
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
@Table(name = "orders")
public class Orders {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_id")
	private Long order_id;

	private Date order_date;
	private String order_status;
	private String first_name;
	private String last_name;
	private String email;
	private String phone;
	private String company_name;
	private String address_1;
	private String address_2;

	private String order_note;
	private String zipcode;
	private double total_amount;

	@OneToMany(mappedBy = "orders")
	private List<Order_Detail> list_order_detail;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "customer_id", referencedColumnName = "customer_id")
	private Customer customer;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "city_id", referencedColumnName = "city_id")
	private City city;

}
