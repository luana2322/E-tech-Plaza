package com.example.core_module.repository;

import java.util.List;

import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.core_module.model.Customer;
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{
	Optional<Customer> findBycustomeremail(String email);

	
	Optional<Customer> findBycustomerpassword(String password);
	
	@Query(value="select * from customer p"
			+ "				where p.is_activated=1",nativeQuery = true)
	public List<Customer> findAll();
	
	@Query(value="SELECT * FROM customer u WHERE u.verificationCode = ?1",nativeQuery = true)
    public Customer findByVerificationCode(String code);
}
