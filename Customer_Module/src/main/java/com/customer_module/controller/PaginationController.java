package com.customer_module.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.core_module.model.Category;
import com.example.core_module.model.Color;
import com.example.core_module.model.Product;
import com.example.core_module.repository.CategoryRepository;
import com.example.core_module.repository.ProductRepository;
import com.example.core_module.repository.Product_CategoryRepository;
import com.example.core_module.service.serviceImpl.CategoryServiceImpl;
import com.example.core_module.service.serviceImpl.ColorServiceImpl;
import com.example.core_module.service.serviceImpl.ProductServiceImpl;

import jakarta.servlet.http.HttpSession;

@Controller
public class PaginationController {
	@Autowired
	private ProductServiceImpl productServiceImpl;
	@Autowired
	private CategoryServiceImpl categoryServiceImpl;
	@Autowired
	private Product_CategoryRepository product_CategoryRepository;
	@Autowired
	private ColorServiceImpl colorServiceImpl;
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private CategoryRepository categoryRepository;

	List<Product> listproduct = new ArrayList<>();

	List<Category> listcategory = new ArrayList<>();

	List<Category> listbrand = new ArrayList<>();

	List<Color> listcolor = new ArrayList<>();

	List<Product> list1 = new ArrayList<>();
	
	Long a = (long) 0;
	
//	@GetMapping("/pagination-index")
//	public String paginationindex(ModelMap modelMap,
//								  HttpSession section) {
//		
//		return "index";
//	}
//	
//	@GetMapping("/pagination-category")
//	public String paginationcate(ModelMap modelMap,
//								 HttpSession section) {
//		
//		return "category";
//	}
//	
	@RequestMapping(value = "/pagination-index", method = RequestMethod.GET)
	public String productPagination(@RequestParam("pageNumber") Integer pageNumber,
																ModelMap modelMap) {
		list1 = productServiceImpl.findAll();
		Integer pageSize = 8;
		int allPage = list1.size() / (int) pageSize;
		
		Page<Product> pagableProduct = productServiceImpl.getProductPagination(pageNumber, pageSize);
		for (Product product : pagableProduct.getContent()) {
			System.out.println(product.getProduct_name());
		}
		modelMap.addAttribute("allPage", allPage);
		modelMap.addAttribute("listproduct", pagableProduct);
		return "index";
	}

	
	@RequestMapping(value = "/pagination-category", method = RequestMethod.GET)
	public String productPaginationcate(@RequestParam("pageNumber") Integer pageNumber,
																ModelMap modelMap) {
		list1 = productServiceImpl.findAll();
		Integer pageSize = 8;
		int allPage = list1.size() / (int) pageSize;
		
		Page<Product> pagableProduct = productServiceImpl.getProductPagination(pageNumber, pageSize);
		for (Product product : pagableProduct.getContent()) {
			System.out.println(product.getProduct_name());
		}
		listbrand = categoryRepository.getlistBrand(a);

		listcategory = categoryRepository.getlistnotBrand();

		listcolor = colorServiceImpl.findAll();
		
		
		modelMap.addAttribute("allPage", allPage);
		
		modelMap.addAttribute("listpro", pagableProduct);
		
		modelMap.addAttribute("listcate", listcategory);

		modelMap.addAttribute("listbrand", listbrand);

		modelMap.addAttribute("listcolor", listcolor);
		return "category";
	}

}
