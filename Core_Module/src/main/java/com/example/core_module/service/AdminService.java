package com.example.core_module.service;

import java.util.List;

import com.example.core_module.dto.AccountDto;
import com.example.core_module.dto.AdminDto;
import com.example.core_module.model.Admin;

public interface AdminService {
List<Admin> findAll();
Admin findById(Long admin_id);
Admin save(AdminDto adminDto);
Admin adminsave(AccountDto accountDto);
void deleteById(Long admin_id);

Admin update(AccountDto accountDto,Long admin_id);
}
