package com.example.core_module.service;

import java.util.List;
import java.util.Optional;

import com.example.core_module.dto.CustomerDto;
import com.example.core_module.model.Customer;

public interface CustomerService {
	
	List<Customer> findAll();
	Customer findById(Long customer_id);
	Customer save(CustomerDto customerDto);
	
}
