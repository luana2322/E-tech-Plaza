package com.example.core_module.service.serviceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.core_module.dto.AccountDto;
import com.example.core_module.dto.CustomerDto;
import com.example.core_module.model.Customer;
import com.example.core_module.repository.CustomerRepository;
import com.example.core_module.service.CustomerService;
@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private Customer_RoleServiceImpl customer_RoleServiceImpl;
	@Override
	public List<Customer> findAll() {
		List<Customer> listcus=new ArrayList<>();
		listcus=customerRepository.findAll();
		return listcus;
	}

	@Override
	public Customer findById(Long customer_id) {
		Customer cus=customerRepository.findById(customer_id).get();
		return cus;
	}

	@Override
	public Customer save(CustomerDto customerDto) {
		
		Customer customer=new Customer();
		customer.setCustomeremail(customerDto.getCustomeremail());
		customer.setRegistration_date(new Date(System.currentTimeMillis()).toString());
		customer.setCustomerpassword(passwordEncoder.encode(customerDto.getCustomerpassword()));
		customer.set_activated(true);
		customer.set_deleted(false);
		
		Customer cus1=customerRepository.save(customer);
		customer_RoleServiceImpl.save(cus1);
		
		 
		return customerRepository.save(cus1);	
	}

	@Override
	public Customer adminsave(AccountDto accountDto) {
		Customer customer=new Customer();
		customer.setCustomeremail(accountDto.getEmail());
		customer.setFirst_name(accountDto.getFirstname());
		customer.setLast_name(accountDto.getLastname());
		customer.setCustomerpassword(passwordEncoder.encode(accountDto.getPass()));
		customer.set_activated(true);
		customer.set_deleted(false);
				
		Customer cus1=customerRepository.save(customer);
		customer_RoleServiceImpl.save(cus1);
		
		return customerRepository.save(cus1);	
	}

	@Override
	public void deleteById(Long customer_id) {
		Customer cus=findById(customer_id);
		cus.set_activated(false);
		cus.set_deleted(true);
		customerRepository.save(cus);
		
	}

	@Override
	public Customer update(AccountDto accountDto, Long customer_id) {
		customer_RoleServiceImpl.deleteByCustomer_id(customer_id);
		Customer customer=findById(customer_id);
		customer.setCustomer_id(customer_id);
		customer.setCustomeremail(accountDto.getEmail());
		customer.setFirst_name(accountDto.getFirstname());
		customer.setLast_name(accountDto.getLastname());
	//	customer.setCustomerpassword(passwordEncoder.encode(accountDto.getPass()));
		customer.set_activated(true);
		customer.set_deleted(false);
				
		Customer cus1=customerRepository.save(customer);
		customer_RoleServiceImpl.save(cus1);
		
		return customerRepository.save(cus1);	
	}

}
