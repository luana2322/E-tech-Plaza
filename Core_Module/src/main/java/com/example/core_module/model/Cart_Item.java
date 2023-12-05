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
@Table(name="cart_item")
public class Cart_Item {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name="cart_item_id")
private Long cart_item_id;
private String cart_item_sku;
private double product_price;
private int quantity;
private double total_price;

@ManyToOne(fetch = FetchType.EAGER)
@JoinColumn(name="product_id",referencedColumnName = "product_id")
private Product product;

@ManyToOne(fetch = FetchType.EAGER)
@JoinColumn(name="cart_id",referencedColumnName = "cart_id")
private Cart cart;
}
