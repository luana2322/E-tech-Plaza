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
@Table(name="product_category")
public class Product_Category {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name="product_category_id")
private Long product_category_id;


@ManyToOne(fetch = FetchType.EAGER)
@JoinColumn(name="product_id",referencedColumnName = "product_id")
private Product product;

@ManyToOne(fetch = FetchType.EAGER)
@JoinColumn(name="category_id",referencedColumnName = "category_id")
private Category category;

}
