package com.customer_module.config;

import java.util.ArrayList;

import java.util.Collection;
import java.util.List;

import com.example.core_module.model.Customer;
import com.example.core_module.model.Customer_Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;



public class CustomerDetails implements UserDetails{
	private Customer customer;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<SimpleGrantedAuthority> authorities=new ArrayList<>();
		for(Customer_Role role:customer.getList_customer_role()) {
			authorities.add(new SimpleGrantedAuthority(role.getRole().getRole_name()));
		}
		return authorities;
	}

	@Override
	public String getPassword() {
		return customer.getCustomerpassword();
	}

	@Override
	public String getUsername() {
		return customer.getCustomeremail();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
