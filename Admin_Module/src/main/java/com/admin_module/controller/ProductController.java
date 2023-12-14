package com.admin_module.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
import com.example.core_module.repository.ProductRepository;
import com.example.core_module.service.serviceImpl.CategoryServiceImpl;
import com.example.core_module.service.serviceImpl.ColorServiceImpl;
import com.example.core_module.service.serviceImpl.ProductExcelService;
import com.example.core_module.service.serviceImpl.ProductServiceImpl;

import ch.qos.logback.core.model.Model;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class ProductController {
@Autowired
private ProductServiceImpl productServiceImpl;
@Autowired
private CategoryServiceImpl categoryServiceImpl;
@Autowired
private ColorServiceImpl colorServiceImpl;
@Autowired
private ProductRepository productRepository;
@Autowired
private ProductExcelService productExcelService;

	List<Product> listpro=new ArrayList<>();
	List<Category> listcate=new ArrayList<>();
	List<Color> listcolor=new ArrayList<>();
	
	@GetMapping("/product")
	public String product(ModelMap modelMap,
						  Principal principal) {
		if(principal==null) {
			return "redirect:/pages/samples/login";
		}
		
	listpro=productServiceImpl.findAll();
		
		modelMap.addAttribute("listpro", listpro);
		return "product";
	}
	
	@GetMapping("/delete-product")
	public String delete(ModelMap modelMap,
						 Principal principal,
						 @RequestParam("product_id")Long product_id) {
		if(principal==null) {
			return "redirect:/pages/samples/login";
		}
		listpro=productServiceImpl.findAll();
		productServiceImpl.deleteById(product_id);
		modelMap.addAttribute("listpro", listpro);
		return "redirect:/product";
	}
	

	@GetMapping("/add-product")
	public String add(ModelMap modelMap,
					  Principal principal) {
		
		if(principal==null) {
			return "redirect:/pages/samples/login";
		}
		
		listcate=categoryServiceImpl.findAll();
		listcolor=colorServiceImpl.findAll();
		
		
		modelMap.addAttribute("listcolor", listcolor);
		modelMap.addAttribute("listcate", listcate);
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
	

	
	@RequestMapping(value = "/getupdate", method = RequestMethod.GET)
	public String getupdate(ModelMap modelMap,
							@RequestParam("product_id")Long product_id,
							Principal principal,	
							HttpSession section) {
		if(principal==null) {
			return "redirect:/pages/samples/login";
		}
		section.setAttribute("product_id_update", product_id);
		listcate=categoryServiceImpl.findAll();
		listcolor=colorServiceImpl.findAll();
		Product pro=productServiceImpl.findById(product_id);

		modelMap.addAttribute("pro",pro);
		modelMap.addAttribute("listcolor",listcolor);
		modelMap.addAttribute("listcate",listcate);
		
		return "edit";
	}

	@RequestMapping(value="/update",method= RequestMethod.POST)
	public String update(ModelMap modelMap,
						 @ModelAttribute("product_update")ProductDto productDto,
//						 @RequestParam("file1") MultipartFile file,
//						 @RequestParam("file2") MultipartFile file1,
//						 @RequestParam("file3") MultipartFile file2,
					     HttpSession section) {
		Long product_id=(long)section.getAttribute("product_id_update");
		
		productServiceImpl.update(productDto, null, product_id);
		
		
		
		listpro=productServiceImpl.findAll();
		modelMap.addAttribute("listpro", listpro);
		return "redirect:/product";
	}
	@GetMapping("/search-product")
	public String searchindex(ModelMap modelMap,
							  HttpSession section,
							  @RequestParam("key") String keyword) {

		
		
		listpro=productRepository.searchproduct(keyword);

		modelMap.addAttribute("listpro", listpro);
		
		Integer pageNumber=0; 
		
		List<Product> list1=new ArrayList<>();
		list1=productServiceImpl.findAll();
		
//	//	int allPage=list1.size()/productNumber;
//		
//		System.out.println("AllPage"+allPage);
//		
//		Page<Product> pagableProduct = productServiceImpl.getProductPagination(pageNumber, productNumber);
//
//
//	//	modelMap.addAttribute("listproduct", pagableProduct);
//		
//		modelMap.addAttribute("allPage", allPage);
		
		return "product";
	}
	//excel product
	@GetMapping("/product-excel")
	public void generateExcelReport(HttpServletResponse response) throws Exception{
		
		response.setContentType("application/octet-stream");
		
		String headerKey = "Content-Disposition";
		String headerValue = "attachment;filename=product.xls";

		response.setHeader(headerKey, headerValue);
		
		productExcelService.generateExcel(response);
		
		response.flushBuffer();
	}
	
}
