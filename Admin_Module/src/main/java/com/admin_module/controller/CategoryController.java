package com.admin_module.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CategoryController {

	
	@GetMapping("/category")
	public String category(ModelMap modelMap) {
		
		return "category";
	}
}
