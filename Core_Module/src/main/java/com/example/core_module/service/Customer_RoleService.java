package com.example.core_module.service;

import com.example.core_module.model.Customer;
import com.example.core_module.model.Customer_Role;

public interface Customer_RoleService {
Customer_Role save(Customer customer);
void deleteByCustomer_id(Long customer_id);
}
