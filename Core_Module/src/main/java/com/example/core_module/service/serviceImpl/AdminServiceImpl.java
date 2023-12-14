package com.example.core_module.service.serviceImpl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.core_module.dto.AccountDto;
import com.example.core_module.dto.AdminDto;
import com.example.core_module.model.Admin;
import com.example.core_module.repository.AdminRepository;
import com.example.core_module.service.AdminService;
@Service
public class AdminServiceImpl implements AdminService {
@Autowired
private AdminRepository adminRepository;
@Autowired 
private PasswordEncoder passwordEncoder;
@Autowired
private Admin_RoleServiceImpl admin_RoleServiceImpl;
	@Override
	public List<Admin> findAll() {
		List<Admin> list=adminRepository.findAll();
		return list;
	}

	@Override
	public Admin findById(Long admin_id) {
		Admin admin=adminRepository.findById(admin_id).get();
		return admin;
	}

	@Override
	public Admin save(AdminDto adminDto) {
		Admin admin=new Admin();
		admin.setEmail(adminDto.getEmail());
		admin.setFirst_name(adminDto.getFirst_name());
		admin.setRegistration_date(new Date(System.currentTimeMillis()));
		admin.set_activated(true);
		admin.set_deleted(false);
		
		admin.setPassword(passwordEncoder.encode(adminDto.getPassword()));
		Admin admin1=adminRepository.save(admin);
		 admin_RoleServiceImpl.save(admin);
		 return admin1;
	}

	@Override
	public void deleteById(Long admin_id) {
		Admin admin=findById(admin_id);
		admin.set_activated(false);
		admin.set_deleted(true);
		adminRepository.save(admin);
	}

	@Override
	public Admin adminsave(AccountDto accountDto) {
		Admin admin=new Admin();
		admin.setEmail(accountDto.getEmail());
		admin.setFirst_name(accountDto.getFirstname());
		admin.setLast_name(accountDto.getLastname());
		admin.setRegistration_date(new Date(System.currentTimeMillis()));
		admin.setPassword(passwordEncoder.encode(accountDto.getPass()));
		admin.set_activated(true);
		admin.set_deleted(false);
		
		Admin admin1=adminRepository.save(admin);
		 admin_RoleServiceImpl.save(admin);
		 return admin1;
	}

	@Override
	public Admin update(AccountDto accountDto, Long admin_id) {
		admin_RoleServiceImpl.deleteByAdmin_id(admin_id);
		
		Admin admin=findById(admin_id);
		admin.setAdmin_id(admin_id);
		admin.setEmail(accountDto.getEmail());
		admin.setFirst_name(accountDto.getFirstname());
		admin.setLast_name(accountDto.getLastname());
		admin.setRegistration_date(new Date(System.currentTimeMillis()));
		//admin.setPassword(passwordEncoder.encode(accountDto.getPass()));
		admin.set_activated(true);
		admin.set_deleted(false);
		
		Admin admin1=adminRepository.save(admin);
		 admin_RoleServiceImpl.save(admin);
		 return admin1;
	}
	
	

}
