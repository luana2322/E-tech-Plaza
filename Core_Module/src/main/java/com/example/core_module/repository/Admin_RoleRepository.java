package com.example.core_module.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.core_module.model.Admin_Role;
@Repository
public interface Admin_RoleRepository extends JpaRepository<Admin_Role, Long> {

	@Query(value="select * from admin_role a"
			+ "				where a.admin_id=?1",nativeQuery = true)
	Admin_Role findByAdmin_id(Long admin_id);
}
