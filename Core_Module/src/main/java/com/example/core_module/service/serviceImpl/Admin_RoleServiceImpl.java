package com.example.core_module.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.core_module.model.Admin;
import com.example.core_module.model.Admin_Role;
import com.example.core_module.model.Role;
import com.example.core_module.repository.Admin_RoleRepository;
import com.example.core_module.repository.RoleRepository;
import com.example.core_module.service.Admin_RoleService;
@Service
public class Admin_RoleServiceImpl implements Admin_RoleService {
@Autowired
private Admin_RoleRepository admin_RoleRepository;
@Autowired
private RoleRepository repository;
	@Override
	public Admin_Role save(Admin admin) {
		Admin_Role admin_Role=new Admin_Role();
		admin_Role.setAdmin(admin);
		Role role=repository.findByRoleAdmin();
		admin_Role.setRole(role);
		return admin_RoleRepository.save(admin_Role);
	}
	

}
