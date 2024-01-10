package com.example.core_module.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.core_module.model.Admin;
@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {

	Optional<Admin> findByemail(String email);

	
	Optional<Admin> findByPassword(String password);
	
}
