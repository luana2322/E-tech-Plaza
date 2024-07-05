package com.customer_module.controller;

import jakarta.mail.MessagingException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.io.UnsupportedEncodingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
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
		return "sendmail";
	}
	
//	@GetMapping("/register")
//	public String register(ModelMap modelMap) {
//		System.out.println("This is login page");
//
//		modelMap.addAttribute("title","Register");
//		modelMap.addAttribute("tiltle","Register");
//		modelMap.addAttribute("newcustomer",new CustomerDto());
//		return "registration";
//	}
	
	
	@PostMapping("/register-new")
	public String registernew(@Valid CustomerDto customerDto,
									BindingResult bindingResult,
									ModelMap modelMap,
							  		HttpServletRequest request) throws UnsupportedEncodingException, MessagingException {
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
		
		customerServiceImpl.save(customerDto,getSiteURL(request));
		return "login";
	}
	
	private String getSiteURL(HttpServletRequest request) {
		String siteURL = request.getRequestURL().toString();
		return siteURL.replace(request.getServletPath(), "");
	}
	

	@PostMapping("/process_register")
    public String processRegister(CustomerDto customerDto, HttpServletRequest request,HttpSession section)
            throws UnsupportedEncodingException, MessagingException {
	  System.out.println("register");
	String email= (String) section.getAttribute("emailregister");
	section.removeAttribute("emailregister");
	  customerDto.setCustomeremail(email);
	  
	  String code=(String) section.getAttribute("code");
	  System.out.println("code1"+code);
	  System.out.println("code2"+customerDto.getCode());
	  if(code.equals(customerDto.getCode())) {
		   customerServiceImpl.save(customerDto, getSiteURL(request)); 
	  }else {
		  return "wrongcode";
	  }
	   
        return "login";
    }
	
	@PostMapping("/sendemail")
    public String sendemail(CustomerDto customerDto, HttpServletRequest request,HttpSession section)
            throws UnsupportedEncodingException, MessagingException {
	  System.out.println("register");
	  section.setAttribute("emailregister", customerDto.getCustomeremail());
	  Customer cus=new Customer();
	  cus.setCustomeremail(customerDto.getCustomeremail());
		customerServiceImpl.sendVerificationEmail(cus, getSiteURL(request),section);
        return "registration";
    }
	
	  @GetMapping("/verify")
	  public String verifyUser(@Param("code") String code) {
	      if (customerServiceImpl.verify(code)) {
	          return "verify_success";
	      } else {
	          return "verify_fail";
	      }
	  }
	   
	
	@GetMapping("/aa")
	public String fwnolmw() {
		Long a=(long) 1;
		Product p=productServiceImpl.findById(a);
		System.out.println(p.getDescription());
		
		return "index";
	}
	
}
