package com.admin_module.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.core_module.dto.FileDto;
import com.example.core_module.dto.ProductDto;
import com.example.core_module.model.Category;
import com.example.core_module.model.Color;
import com.example.core_module.model.Product;
import com.example.core_module.model.Product_Image;
import com.example.core_module.service.serviceImpl.CategoryServiceImpl;
import com.example.core_module.service.serviceImpl.ColorServiceImpl;
import com.example.core_module.service.serviceImpl.ProductServiceImpl;

@Controller
public class ProductController {
@Autowired
private ProductServiceImpl productServiceImpl;
@Autowired
private CategoryServiceImpl categoryServiceImpl;
@Autowired
private ColorServiceImpl colorServiceImpl;

	List<Product> listpro=new ArrayList<>();
	List<Category> listcate=new ArrayList<>();
	List<Color> listcolor=new ArrayList<>();
	
	@GetMapping("/product")
	public String product(ModelMap modelMap) {
		listpro=productServiceImpl.findAll();
		
		for (Product pro : listpro) {
			for (Product_Image pro1: pro.getList_product_image()) {
				System.out.println("Image Index 1:"+pro1.getProduct_image_path());
			}
		}
		
		modelMap.addAttribute("listpro", listpro);
		return "product";
	}
	
	@GetMapping("/delete-product")
	public String delete(ModelMap modelMap,
						 @RequestParam("product_id")Long product_id) {
		listpro=productServiceImpl.findAll();
		productServiceImpl.deleteById(product_id);
		modelMap.addAttribute("listpro", listpro);
		return "product";
	}
	
	@GetMapping("/edit-product")
	public String edit(ModelMap modelMap,
					   @RequestParam("product_id")Long product_id) {
		
		return "product";
	}
	
	@GetMapping("/add-product")
	public String add(ModelMap modelMap) {
		listcate=categoryServiceImpl.findAll();
		listcolor=colorServiceImpl.findAll();
		
		
		modelMap.addAttribute("listcolor", listcolor);
		for (Color category : listcolor) {

		}
		modelMap.addAttribute("listcate", listcate);
		System.out.println(listcate.size());
		modelMap.addAttribute("productDto", new ProductDto());
		
		return "addproduct";
	}
	
//	@RequestMapping(value = "/add-new-product", method = RequestMethod.POST)
//	public String addnewproduct(ModelMap modelMap,
//								@ModelAttribute("productDto") ProductDto productDto,
//								@RequestParam("file1") MultipartFile file,
//								@RequestParam("file2") MultipartFile file1,
//								@RequestParam("file3") MultipartFile file2) {
//		
//		List<MultipartFile> listfile=new ArrayList<>();
//		listfile.add(file);
//		listfile.add(file1);
//		listfile.add(file2);
//		
//		productServiceImpl.save(productDto, listfile);
//		
//		listpro=productServiceImpl.findAll();
//		modelMap.addAttribute("listpro", listpro);
//		return "product";
//	}
	
	@GetMapping("/ss")
	public String đ() {
		return "ssss";
	}
	
	@PostMapping("/upload_form")
	public String addnewproduct1(ModelMap modelMap,
			@ModelAttribute("productDto") ProductDto productDto,
			@RequestParam("file1") MultipartFile file,
			@RequestParam("file2") MultipartFile file1,
			@RequestParam("file3") MultipartFile file2) {

		System.out.println("ADD -Neww Product");

List<MultipartFile> listfile=new ArrayList<>();
listfile.add(file);	
listfile.add(file1);
listfile.add(file2);

productServiceImpl.save(productDto, listfile);

listpro=productServiceImpl.findAll();
modelMap.addAttribute("listpro", listpro);
return "redirect:/product";
}
	
}
