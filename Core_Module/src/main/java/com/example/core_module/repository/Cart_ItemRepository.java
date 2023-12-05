package com.example.core_module.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.core_module.model.Cart_Item;

@Repository
public interface Cart_ItemRepository extends JpaRepository<Cart_Item, Long> {

}
