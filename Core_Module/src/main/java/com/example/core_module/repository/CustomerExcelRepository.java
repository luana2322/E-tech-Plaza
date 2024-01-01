package com.example.core_module.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.core_module.model.Customer;

public interface CustomerExcelRepository extends JpaRepository<Customer, Serializable> {

}
