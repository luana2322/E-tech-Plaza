package com.example.core_module.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.core_module.model.Product;

public interface ProductExcelRepository extends JpaRepository<Product, Serializable> {

}
