package com.admin_module.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.core_module.dto.AdminDto;
import com.example.core_module.model.Admin;
import com.example.core_module.repository.AdminRepository;
import com.example.core_module.service.serviceImpl.AdminServiceImpl;

import jakarta.validation.Valid;

@Controller
public class LoginController {
	@Autowired
	private AdminServiceImpl adminServiceImpl;
	@Autowired
	private AdminRepository adminRepository;

    @GetMapping("/login")
    public String login(){
        return "pages/samples/login";
    }
    
    @GetMapping("/register")
    public String  register(ModelMap modelMap){
    	modelMap.addAttribute("admindto", new AdminDto());
        return "pages/samples/register";
    }
    
    @PostMapping("/register-new")
    public String registernew(ModelMap modelMap,
    						  @Valid AdminDto adminDto,
    						  BindingResult bindingResult) {
    	
    	
    	// modelMap.addAttribute("tiltle","Login Page");
		if(bindingResult.hasErrors()) {
			System.out.println("eorr bindng");
			modelMap.addAttribute("eror", "Something went wrong!!!!");
			modelMap.addAttribute("admindto", new AdminDto());
			return "pages/samples/register";
		}
		
		Admin admin= adminRepository.findByemail(adminDto.getEmail()).isPresent()
				? adminRepository.findByemail(adminDto.getEmail()).get()
				: null;
		
		if (admin != null) {
			System.out.println("adminExisted");
			modelMap.addAttribute("admindto", new AdminDto());
			modelMap.addAttribute("message", "Username existed!!");
			return "pages/samples/register";
		}
		
		if(!adminDto.getPassword().equals(adminDto.getRepeatpassword())) {
			modelMap.addAttribute("admindto", new AdminDto());
			modelMap.addAttribute("message", "Password is not same!!");
			return "pages/samples/register";
		}
		
		adminServiceImpl.save(adminDto);
		
    	return "pages/samples/login";
    }

    @GetMapping("/index")
    public String index(){
        return "index";
    }

}
