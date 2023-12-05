package com.example.core_module.repository;

import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.core_module.model.Customer;
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{
	Optional<Customer> findBycustomeremail(String email);

	
	Optional<Customer> findBycustomerpassword(String password);
}
