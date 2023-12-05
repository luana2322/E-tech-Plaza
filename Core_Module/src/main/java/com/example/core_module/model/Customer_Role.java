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
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="customer_role")
public class Customer_Role {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="customer_role_id")
	private Long customer_role_id;
	
	@ManyToOne(fetch =FetchType.EAGER )
	@JoinColumn(name="role_id",referencedColumnName = "role_id")
	private Role role;
	
	@ManyToOne(fetch =FetchType.EAGER )
	@JoinColumn(name="customer_id",referencedColumnName = "customer_id")
	private Customer customer;
	
}
