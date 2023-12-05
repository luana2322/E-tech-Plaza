package com.customer_module.config;

import java.util.stream.Collector;

import java.util.stream.Collectors;

import com.example.core_module.model.Customer;
import com.example.core_module.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


public class CustomerServiceConfig implements UserDetailsService{

	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public UserDetails loadUserByUsername(String customeremail) throws UsernameNotFoundException {
		Customer customer=customerRepository.findBycustomeremail(customeremail).get();
		if(customer==null) {
			throw new UsernameNotFoundException("Could not find username");
		}
		System.out.println("CUsotneg"+customer.getCustomerpassword());
		return new User(customer.getCustomeremail()
							,customer.getCustomerpassword()
							,customer.getList_customer_role()
							.stream()
							.map(role->new SimpleGrantedAuthority(role.getRole().getRole_name())).collect(Collectors.toList()));
	}

}
