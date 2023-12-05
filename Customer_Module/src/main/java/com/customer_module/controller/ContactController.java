package com.customer_module.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.core_module.dto.ContactDto;
import com.example.core_module.service.serviceImpl.ContactServiceImpl;

@Controller
public class ContactController {
@Autowired
private ContactServiceImpl contactServiceImpl;
	
	@GetMapping("/contact")
	public String contact(ModelMap modelMap) {
		
		modelMap.addAttribute("title","Contact Us");
		modelMap.addAttribute("newcontact",new ContactDto());
		return "contact";
	}
	
	@PostMapping("/add-contact")
	public String addcontact(ModelMap modelMap,
							 Principal principal,
							 @ModelAttribute("contactDto")ContactDto contactDto) {
		if(principal==null) {
			return "redirect:/login";
		}
		contactServiceImpl.save(contactDto,principal.getName());
		modelMap.addAttribute("title","Contact Us");
		return "contact";
	}
}
