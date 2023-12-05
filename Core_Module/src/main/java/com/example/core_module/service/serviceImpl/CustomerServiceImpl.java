package com.example.core_module.service.serviceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

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
		return customerRepository.save(customer);	
	}

}
