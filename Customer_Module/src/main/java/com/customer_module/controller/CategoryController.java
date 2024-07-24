package com.customer_module.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
import ch.qos.logback.core.model.Model;
import jakarta.servlet.http.HttpSession;

@Controller
public class CategoryController {
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

	Long a = (long) 0;
	
	int productNumber=8;

	@GetMapping("/category")
	public String category(ModelMap modelMap,
							HttpSession section) {
		List<Product> list1=productServiceImpl.findAll();
		
		int allPage=list1.size()/productNumber;
		 
		modelMap.addAttribute("title","Category");

		section.setAttribute("color_id", 2);
		
		section.removeAttribute("cate_id");
		
		Integer pageNumber=0;
		
		Page<Product> pagableProduct = productServiceImpl.getProductPagination(pageNumber, productNumber);
		

		listbrand = categoryRepository.getlistBrand(a);

		listcategory = categoryRepository.getlistnotBrand();

		listcolor = colorServiceImpl.findAll();

		modelMap.addAttribute("listpro", pagableProduct);
		
		modelMap.addAttribute("allPage", allPage);

		modelMap.addAttribute("listcate", listcategory);

		modelMap.addAttribute("listbrand", listbrand);

		modelMap.addAttribute("listcolor", listcolor);

		return "category";
	}

	@GetMapping("/sorthightolow")
	public String sorthightolow(ModelMap modelMap,
								HttpSession section) {

		List<Product> list1=productServiceImpl.findAll();
		
		int allPage=list1.size()/productNumber;
		
		modelMap.addAttribute("title","Category");

		section.setAttribute("color_id", 2);
		
		section.removeAttribute("cate_id");
		
		listproduct = productRepository.sortPriceHightoLow();
		
		listbrand = categoryRepository.getlistBrand(a);

		listcategory = categoryRepository.getlistnotBrand();

		listcolor = colorServiceImpl.findAll();
		
		modelMap.addAttribute("listpro", listproduct);

		modelMap.addAttribute("allPage", allPage);
		
		modelMap.addAttribute("listcate", listcategory);

		modelMap.addAttribute("listbrand", listbrand);

		modelMap.addAttribute("listcolor", listcolor);

		return "category";
	}

	@GetMapping("/sortlowtohigh")
	public String sortlowtohigh(ModelMap modelMap,
								HttpSession section) {
		List<Product> list1=productServiceImpl.findAll();
		
		int allPage=list1.size()/productNumber;
		
		modelMap.addAttribute("title","Category");
		
		section.setAttribute("color_id", 2);
		
		section.removeAttribute("cate_id");
		
		listproduct = productRepository.sortPriceLowtoHigh();
		
		listbrand = categoryRepository.getlistBrand(a);

		listcategory = categoryRepository.getlistnotBrand();

		listcolor = colorServiceImpl.findAll();
		
		modelMap.addAttribute("listpro", listproduct);

		modelMap.addAttribute("allPage", allPage);
		
		modelMap.addAttribute("listcate", listcategory);

		modelMap.addAttribute("listbrand", listbrand);

		modelMap.addAttribute("listcolor", listcolor);


		return "category";
	}

	
	@GetMapping("/productBycategory_id")
	public String productBycategory_id(@RequestParam Long category_id,
													ModelMap modelMap,
													HttpSession section) {
		List<Product> list1=productServiceImpl.findAll();
		
		int allPage=list1.size()/productNumber;
		
		modelMap.addAttribute("title","Category");
		
		section.setAttribute("cate_id", category_id);
		
		section.setAttribute("color_id", 2);
		
		listproduct=productRepository.getProductByCategory(category_id);
		
		listbrand = categoryRepository.getlistBrand(a);

		listcategory = categoryRepository.getlistnotBrand();

		listcolor = colorServiceImpl.findAll();
		
		modelMap.addAttribute("allPage", allPage);
		
		modelMap.addAttribute("listpro", listproduct);

		modelMap.addAttribute("listcate", listcategory);

		modelMap.addAttribute("listbrand", listbrand);

		modelMap.addAttribute("listcolor", listcolor);
		
		return "category";
	}

	@GetMapping("/productBycolor_id")
	public String productBycolor_id(@RequestParam Long color_id,
												  ModelMap modelMap,
												  HttpSession section) {
		List<Product> list1=productServiceImpl.findAll();
		
		int allPage=list1.size()/productNumber;

		modelMap.addAttribute("title","Category");
		
		section.setAttribute("color_id", color_id);
		
		listproduct=productRepository.getProductByColor(color_id);
		
		listbrand = categoryRepository.getlistBrand(a);

		listcategory = categoryRepository.getlistnotBrand();

		listcolor = colorServiceImpl.findAll();
		
		modelMap.addAttribute("allPage", allPage);
		
		modelMap.addAttribute("listpro", listproduct);

		modelMap.addAttribute("listcate", listcategory);

		modelMap.addAttribute("listbrand", listbrand);

		modelMap.addAttribute("listcolor", listcolor);
		
		return "category";
	}


//	@GetMapping("/sss")
//	public String test() {
//		List<Product> listtest=productRepository.test();
//		
//		for (Product product : listtest) {
//			System.out.println(product.getProduct_name());
//		}
//		
//		
//	return "category";
//	}

}
