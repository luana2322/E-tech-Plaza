package com.example.core_module.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.core_module.model.Customer;
import com.example.core_module.model.Customer_Role;
import com.example.core_module.model.Role;
import com.example.core_module.repository.Customer_RoleRepository;
import com.example.core_module.repository.RoleRepository;
import com.example.core_module.service.Customer_RoleService;

@Service
public class Customer_RoleServiceImpl implements Customer_RoleService {
	@Autowired
	private RoleRepository repository;
	@Autowired
	private Customer_RoleRepository customer_RoleRepository;

	@Override
	public Customer_Role save(Customer customer) {
		Role role = repository.findByRoleCustomer();

		Customer_Role cus = new Customer_Role();
		cus.setCustomer(customer);
		cus.setRole(role);

		return customer_RoleRepository.save(cus);
	}

	@Override
	public void deleteByCustomer_id(Long customer_id) {
		Customer_Role cus=customer_RoleRepository.findByCustomer_id(customer_id);
		customer_RoleRepository.delete(cus);
	}

}
