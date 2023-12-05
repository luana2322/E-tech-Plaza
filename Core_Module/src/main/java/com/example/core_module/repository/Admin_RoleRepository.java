package com.example.core_module.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.core_module.model.Admin_Role;
@Repository
public interface Admin_RoleRepository extends JpaRepository<Admin_Role, Long> {

}
