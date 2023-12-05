package com.example.core_module.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.core_module.model.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {

}
