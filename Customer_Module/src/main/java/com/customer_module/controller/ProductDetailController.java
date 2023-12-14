package com.customer_module.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
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
public class ProductDetailController {
@Autowired
private ProductServiceImpl productServiceImpl;
	@Autowired
	private Product_CategoryRepository product_CategoryRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private CategoryServiceImpl categoryServiceImpl;
	@Autowired
	private ColorServiceImpl colorServiceImpl;
	@Autowired
	private ProductRepository productRepository;
	
	List<Product> listproduct = new ArrayList<>();

	List<Category> listcategory = new ArrayList<>();

	List<Category> listbrand = new ArrayList<>();

	List<Color> listcolor = new ArrayList<>();

	Long a = (long) 0;
	
	List<Category> listcate=new ArrayList<>();
	
	int productNumber=8;
	
	@GetMapping("/single-product")
	public String product(@RequestParam Long product_id,
										ModelMap modelMap,
										HttpSession section) {
		
		section.setAttribute("product_id_old", product_id);
		
		modelMap.addAttribute("title","Product Detail");
		
		productServiceImpl.increas_view_product(product_id);
		Product pro=productServiceImpl.findById(product_id);
		listcate=categoryRepository.findCategoryByProduct(product_id);
		
		
		modelMap.addAttribute("listcate", listcate );
		modelMap.addAttribute("pro",pro);
		
		return "single-product";
	}
	
	@GetMapping("/search-index")
	public String searchindex(ModelMap modelMap,
							  HttpSession section,
							  @RequestParam("key") String keyword) {

		modelMap.addAttribute("title","Home");
		
		listproduct=productRepository.searchproduct(keyword);

		modelMap.addAttribute("listproduct", listproduct);
		
		Integer pageNumber=0; 
		
		List<Product> list1=new ArrayList<>();
		list1=productServiceImpl.findAll();
		
		int allPage=list1.size()/productNumber;
		
		System.out.println("AllPage"+allPage);
		
		Page<Product> pagableProduct = productServiceImpl.getProductPagination(pageNumber, productNumber);


	//	modelMap.addAttribute("listproduct", pagableProduct);
		
		modelMap.addAttribute("allPage", allPage);
		
		return "index";
	}
	
	@GetMapping("/search-cate")
	public String searchcate(ModelMap modelMap,
							  HttpSession section,
							  @RequestParam("key") String keyword) {

		modelMap.addAttribute("title","Category");
		
		section.setAttribute("color_id", 2);
		
		section.removeAttribute("cate_id");

		listproduct = productRepository.searchproduct(keyword);

		listbrand = categoryRepository.getlistBrand(a);

		listcategory = categoryRepository.getlistnotBrand();

		listcolor = colorServiceImpl.findAll();

		modelMap.addAttribute("listpro", listproduct);

		modelMap.addAttribute("listcate", listcategory);

		modelMap.addAttribute("listbrand", listbrand);

		modelMap.addAttribute("listcolor", listcolor);
		
		
		return "category";
	}
	
}
