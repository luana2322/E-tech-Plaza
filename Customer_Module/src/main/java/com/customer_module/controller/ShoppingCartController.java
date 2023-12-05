package com.customer_module.controller;

import java.security.Principal;
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
import com.example.core_module.service.serviceImpl.CartServiceImpl;
import com.example.core_module.service.serviceImpl.ColorServiceImpl;
import com.example.core_module.service.serviceImpl.ProductServiceImpl;

import jakarta.servlet.http.HttpSession;

@Controller
public class ShoppingCartController {

	@Autowired
	private CartServiceImpl cartServiceImpl;
	@Autowired
	private ProductServiceImpl productServiceImpl;
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private ColorServiceImpl colorServiceImpl;

	List<Product> listpro = new ArrayList<>();
	int productNumber=8;

	List<Category> listcategory = new ArrayList<>();

	List<Category> listbrand = new ArrayList<>();

	List<Color> listcolor = new ArrayList<>();

	Long a = (long) 0;


	@GetMapping("/addtocart-index")
	public String addtocartindex(Principal principal, 
								 HttpSession section, 
								 ModelMap modelMap,
								 @RequestParam("product_id") Long product_id) {

		modelMap.addAttribute("title","Home");
		int quantity = 1;
		if (principal == null) {
			return "redirect:/login";
		}

		cartServiceImpl.addtoCart(product_id, quantity, principal.getName());
		
		Integer pageNumber=0;
		List<Product> list1=new ArrayList<>();
		list1=productServiceImpl.findAll();
		int allPage=list1.size()/productNumber;
		System.out.println("AllPage"+allPage);
		Page<Product> pagableProduct = productServiceImpl.getProductPagination(pageNumber, productNumber);
		
		modelMap.addAttribute("allPage", allPage);
		modelMap.addAttribute("listproduct", pagableProduct);

	
//		listpro = productServiceImpl.findAll();
//		modelMap.addAttribute("listproduct", listpro);

		return "index";
	}

	@GetMapping("/addtocart-cate")
	public String addtocartcate(Principal principal,
								HttpSession section, 
								ModelMap modelMap,
								@RequestParam("product_id") Long product_id) {

		modelMap.addAttribute("title","Category");
		
		int quantity = 1;
		if (principal == null) {
			return "redirect:/login";
		}

		cartServiceImpl.addtoCart(product_id, quantity, principal.getName());
		
		listpro = productServiceImpl.findAll();
		
		section.setAttribute("color_id", 2);

		section.removeAttribute("cate_id");

		listbrand = categoryRepository.getlistBrand(a);

		listcategory = categoryRepository.getlistnotBrand();

		listcolor = colorServiceImpl.findAll();

		modelMap.addAttribute("listpro", listpro);

		modelMap.addAttribute("listcate", listcategory);

		modelMap.addAttribute("listbrand", listbrand);

		modelMap.addAttribute("listcolor", listcolor);

		return "category";
	}
	
	@GetMapping("/addtocart-product-detail")
	public String addtocartsingleproduct(Principal principal, 
										 HttpSession section, 
										 ModelMap modelMap,
										 @RequestParam("product_id") Long product_id) {
		
		modelMap.addAttribute("title","Product Detail");
		if(principal==null) {
			return "redirect:/login";
		}
		int quantity=1;
		
		Long product_id_old=(long)section.getAttribute("product_id_old");
		cartServiceImpl.addtoCart(product_id, quantity, principal.getName());

		Product pro=productServiceImpl.findById(product_id_old);
		listcategory=categoryRepository.findCategoryByProduct(product_id_old);
		
		
		modelMap.addAttribute("listcate", listcategory );
		modelMap.addAttribute("pro",pro);
		return "single-product";
	}
	
	
	
}
