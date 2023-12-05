package com.customer_module.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.core_module.model.Customer;
import com.example.core_module.model.Product;
import com.example.core_module.model.Product_Image;
import com.example.core_module.repository.CustomerRepository;
import com.example.core_module.service.serviceImpl.CustomerServiceImpl;
import com.example.core_module.service.serviceImpl.ProductServiceImpl;
@Controller
public class PageController {
	@Autowired
	private ProductServiceImpl productServiceImpl;
	int productNumber=8;
	
	@GetMapping("/index")
	public String index(ModelMap modelMap,
						Principal principal) {
	
		modelMap.addAttribute("title","Home");
		Integer pageNumber=0;
		List<Product> list1=new ArrayList<>();
		list1=productServiceImpl.findAll();
		int allPage=list1.size()/productNumber;
		System.out.println("AllPage"+allPage);
		Page<Product> pagableProduct = productServiceImpl.getProductPagination(pageNumber, productNumber);
		
		modelMap.addAttribute("allPage", allPage);
		modelMap.addAttribute("listproduct", pagableProduct);
	
		return "index";
	}

	




	


	@GetMapping("/single-blog")
	public String single_blog(ModelMap modelMap) {

		modelMap.addAttribute("title","Blog Detail");
		return "single-blog";
	}

	@GetMapping("/tracking")
	public String tracking(ModelMap modelMap) {

		modelMap.addAttribute("title","Tracking");
		
		return "tracking";
	}



	@GetMapping("/elements")
	public String elements() {
		return "elements";
	}

	

	@GetMapping("/profile")
	public String profile(ModelMap modelMap) {

		modelMap.addAttribute("title","Profile");
		
		return "profile";
	}

	@GetMapping("/blog")
	public String blog(ModelMap modelMap) {

		modelMap.addAttribute("title","Blog");
		
		return "blog";
	}

	@GetMapping("/registration")
	public String registration(ModelMap modelMap) {
		
		modelMap.addAttribute("title","Registration");
		
		return "registration";
	}
}
