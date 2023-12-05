package com.example.core_module.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.core_module.model.Role;
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
@Query(value="select * from role r "
		+ "			   where r.role_name='ADMIN'",nativeQuery = true)
public Role findByRoleAdmin();
}
