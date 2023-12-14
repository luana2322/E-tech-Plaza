package com.example.core_module.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.core_module.model.Customer_Role;

@Repository
public interface Customer_RoleRepository extends JpaRepository<Customer_Role, Long> {
	@Query(value="select * from customer_role a"
			+ "				where a.customer_id=?1",nativeQuery = true)
	Customer_Role findByCustomer_id(Long admin_id);
}
