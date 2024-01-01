package com.admin_module.controller;

import java.security.Principal;

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

import com.example.core_module.dto.CategoryDto;
import com.example.core_module.dto.ProductDto;
import com.example.core_module.exportExcel.CategoryExcelService;
import com.example.core_module.model.Category;
import com.example.core_module.model.Product;
import com.example.core_module.repository.CategoryRepository;
import com.example.core_module.service.serviceImpl.CategoryServiceImpl;

import ch.qos.logback.core.model.Model;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class CategoryController {
@Autowired
private CategoryServiceImpl categoryServiceImpl;
@Autowired 
private CategoryRepository categoryRepository;
@Autowired
private CategoryExcelService categoryExcelService;
	List<Category> listcate=new ArrayList<>();
	@GetMapping("/category")
	public String category(ModelMap modelMap,
						   Principal principal) {
		if(principal==null) {
			return "redirect:/pages/samples/login";
		}
		
		
		listcate=categoryServiceImpl.findAll();
		modelMap.addAttribute("listcate",listcate);	
		return "category";
	}
	
	@RequestMapping(value="/getupdatecate",method=RequestMethod.GET)
	public String getupdatecate(ModelMap modelMap,
				  Principal principal,
				  HttpSession section,
				  @RequestParam("cate_id")Long category_id) {
		if(principal==null) {
			return "redirect:/pages/samples/login";
		}
		section.setAttribute("cateupdate_id", category_id);
		
		Category category=categoryServiceImpl.findById(category_id);
		modelMap.addAttribute("cate",category);
		
		return "editcate";
	}
	@RequestMapping(value="/updatecate",method=RequestMethod.POST)
	public String updatecate(ModelMap modelMap,
							 Principal principal,
							 HttpSession section,
							 @ModelAttribute("categoryDto")CategoryDto categoryDto) {
		if(principal==null) {
			return "redirect:/pages/samples/login";
		}
		section.getAttribute("cateupdate_id");
		
		
		
		return "redirect:/category";
	}
	
	@RequestMapping(value="/deletecate",method=RequestMethod.GET)
	public String deletecate(ModelMap modelMap,
							 Principal principal,
							 @RequestParam("cate_id")Long cate_id) {
		if(principal==null) {
			return "redirect:/pages/samples/login";
		}
		
		categoryServiceImpl.deleteById(cate_id);
		listcate=categoryServiceImpl.findAll();
		
		modelMap.addAttribute("listcate",listcate);
		return  "redirect:/category";
	}
	
	@RequestMapping(value="/add-category",method=RequestMethod.GET)
	public String deletecate(ModelMap modelMap,
							 Principal principal) {
		if(principal==null) {
			return "redirect:/pages/samples/login";
		}
		
		modelMap.addAttribute("cateDto",new CategoryDto());
		return  "addcate";
	}
	

	@PostMapping("/upload_cate")
	public String addnewproduct1(ModelMap modelMap,
			@ModelAttribute("cateDto") CategoryDto cateDto,
			@RequestParam("file") MultipartFile file) {

		
		categoryServiceImpl.save(cateDto, file);
		
		listcate=categoryServiceImpl.findAll();
		modelMap.addAttribute("listcate", listcate);
		return "redirect:/category";
	}
	
	@GetMapping("/search-cate")
	public String searchindex(ModelMap modelMap,
							  HttpSession section,
							  @RequestParam("key") String keyword) {

		
		
		listcate=categoryRepository.search(keyword);

		modelMap.addAttribute("listcate", listcate);
		
		return "category";
	}
	
	//excel product
	@GetMapping("/category-excel")
	public void generateExcelReport(HttpServletResponse response) throws Exception{
		
		response.setContentType("application/octet-stream");
		
		String headerKey = "Content-Disposition";
		String headerValue = "attachment;filename=category.xls";

		response.setHeader(headerKey, headerValue);
		
		categoryExcelService.generateExcel(response);
		
		response.flushBuffer();
	}
	
}
