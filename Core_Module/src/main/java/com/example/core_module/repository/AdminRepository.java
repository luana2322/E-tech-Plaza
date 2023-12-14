package com.example.core_module.repository;

import java.util.List;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.core_module.model.Admin;
@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {

	Optional<Admin> findByemail(String email);

	
	Optional<Admin> findByPassword(String password);
	
	@Query(value="select * from admin a"
			+ "				where a.is_activated=1",nativeQuery = true)
	public List<Admin> findAll();
}
