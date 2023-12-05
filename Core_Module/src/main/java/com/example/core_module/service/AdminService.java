package com.example.core_module.service;

import java.util.List;

import com.example.core_module.dto.AdminDto;
import com.example.core_module.model.Admin;

public interface AdminService {
List<Admin> findAll();
Admin findById(Long admin_id);
Admin save(AdminDto adminDto);
void deleteById(Long admin_id);
}
