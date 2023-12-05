package com.example.core_module.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.core_module.model.Product_Review;
@Repository
public interface Product_ReviewRepository extends JpaRepository<Product_Review, Long> {

}
