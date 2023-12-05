package com.example.core_module.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.core_module.model.Customer_Role;

@Repository
public interface Customer_RoleRepository extends JpaRepository<Customer_Role, Long> {

}
