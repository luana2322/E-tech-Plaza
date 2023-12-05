package com.customer_module.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.core_module.model.Category;
import com.example.core_module.model.Customer;
import com.example.core_module.model.Product;
import com.example.core_module.model.Wishlist;
import com.example.core_module.repository.CategoryRepository;
import com.example.core_module.repository.CustomerRepository;
import com.example.core_module.repository.ProductRepository;
import com.example.core_module.service.serviceImpl.ProductServiceImpl;
import com.example.core_module.service.serviceImpl.WishlistServiceImpl;

import jakarta.servlet.http.HttpSession;

@Controller
public class WishlistController {
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private WishlistServiceImpl wishlistServiceImpl;
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private ProductServiceImpl productServiceImpl;
	@Autowired
	private CategoryRepository categoryRepository;
	
	@GetMapping("/wishlist")
	public String wishlist(Principal principal,
							ModelMap modelMap) {
		
		modelMap.addAttribute("title","Wishlist");
		
		if(principal==null) {
			return "redirect:/login";
		}
		Customer cus=customerRepository.findBycustomeremail(principal.getName()).get();
		List<Product> wishlist=productRepository.wistlistbycustomerId(cus.getCustomer_id());
		
		modelMap.addAttribute("wishlist", wishlist);
		
		return "wishlist";
	}
//	はじめまして
	@GetMapping("/wishlist-index")
	public String index(Principal principal,
						HttpSession section,
						ModelMap modelMap,
						@RequestParam("product_id") Long product_id) {

		modelMap.addAttribute("title","Index");
		
		if(principal==null) {
			return "redirect:/login";
		}
		
		List<Product> listpro=productServiceImpl.findAll();
		
		wishlistServiceImpl.addwishlist(product_id, principal.getName());
	
		modelMap.addAttribute("listproduct", listpro);
		return "index";
	}
	@GetMapping("/delete-pro-wishlist")
	public String delete(Principal principal,
						 HttpSession section,
						 ModelMap modelMap,
						 @RequestParam("product_id") Long product_id) {

		modelMap.addAttribute("title","Wishlist");
		
		wishlistServiceImpl.deletebyproduct_id(product_id);
		
		Customer cus=customerRepository.findBycustomeremail(principal.getName()).get();
		List<Product> wishlist=productRepository.wistlistbycustomerId(cus.getCustomer_id());
		
		modelMap.addAttribute("wishlist", wishlist);
		
		return "wishlist";
	}
	
	@GetMapping("/wishlist-product-detail")
	public String productdetail(Principal principal,
								HttpSession section,
								ModelMap modelMap) {
		List<Category> listcategory=new ArrayList<>();

		Long product_id=(long)section.getAttribute("product_id_old");
		
		modelMap.addAttribute("title","Product Detail");
		
		Product pro=productServiceImpl.findById(product_id);
		listcategory=categoryRepository.findCategoryByProduct(product_id);
		
		wishlistServiceImpl.addwishlist(product_id, principal.getName());
		
		modelMap.addAttribute("listcate", listcategory );
		modelMap.addAttribute("pro",pro);
		return "single-product";
	}
}
