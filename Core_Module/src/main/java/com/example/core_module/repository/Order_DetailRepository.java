package com.example.core_module.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.core_module.model.Order_Detail;
@Repository
public interface Order_DetailRepository extends JpaRepository<Order_Detail, Long> {

}
