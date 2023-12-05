package com.customer_module.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.core_module.dto.CustomerDto;
import com.example.core_module.model.Customer;
import com.example.core_module.model.Product;
import com.example.core_module.repository.CustomerRepository;
import com.example.core_module.service.serviceImpl.CustomerServiceImpl;
import com.example.core_module.service.serviceImpl.ProductServiceImpl;

import jakarta.validation.Valid;

@Controller
public class AuthenController {
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private CustomerServiceImpl customerServiceImpl;
	@Autowired
	private ProductServiceImpl productServiceImpl;
	
	@GetMapping("/login")
	public String login(ModelMap modelMap) {
		modelMap.addAttribute("title","Login");
		modelMap.addAttribute("cuslogin",new Customer());
		return "login";
	}
	
	@GetMapping("/register")
	public String register(ModelMap modelMap) {
		System.out.println("This is login page");

		modelMap.addAttribute("title","Register");
		modelMap.addAttribute("tiltle","Register");
		modelMap.addAttribute("newcustomer",new CustomerDto());
		return "registration";
	}
	
	@PostMapping("/register-new")
	public String registernew(@Valid CustomerDto customerDto,
									BindingResult bindingResult,
									ModelMap modelMap) {
		modelMap.addAttribute("tiltle","Login Page");
		if(bindingResult.hasErrors()) {
			System.out.println("eorr bindng");
			modelMap.addAttribute("eror", "Something went wrong!!!!");
			modelMap.addAttribute("newcustomer", new CustomerDto());
			return "login";
		}
		
		Customer customer= customerRepository.findBycustomeremail(customerDto.getCustomeremail()).isPresent()
				? customerRepository.findBycustomeremail(customerDto.getCustomeremail()).get()
				: null;
		
		if (customer != null) {
			System.out.println("custoemrexited");
			modelMap.addAttribute("newcustomer", new CustomerDto());
			modelMap.addAttribute("message", "Username existed!!");
			return "login";
		}
		
		if(!customerDto.getCustomerpassword().equals(customerDto.getConfirmpassword())) {
			modelMap.addAttribute("newcustomer", new CustomerDto());
			modelMap.addAttribute("message", "Password is not same!!");
			return "login";
		}
		
		customerServiceImpl.save(customerDto);
		return "login";
	}
	
	
	@GetMapping("/aa")
	public String fwnolmw() {
		Long a=(long) 1;
		Product p=productServiceImpl.findById(a);
		System.out.println(p.getDescription());
		
		return "index";
	}
	
}
