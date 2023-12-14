package com.example.core_module.service;

import java.util.List;
import java.util.Optional;

import com.example.core_module.dto.AccountDto;
import com.example.core_module.dto.CustomerDto;
import com.example.core_module.model.Customer;

public interface CustomerService {
	
	List<Customer> findAll();
	Customer findById(Long customer_id);
	Customer save(CustomerDto customerDto);
	Customer adminsave(AccountDto accountDto);
	void deleteById(Long customer_id);
	Customer update(AccountDto accountDto,Long customer_id);
}
