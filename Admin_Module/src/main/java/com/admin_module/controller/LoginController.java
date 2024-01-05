package com.admin_module.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.core_module.dto.AdminDto;
import com.example.core_module.model.Admin;
import com.example.core_module.model.Category;
import com.example.core_module.model.Orders;
import com.example.core_module.model.Product;
import com.example.core_module.model.Thongke;
import com.example.core_module.repository.AdminRepository;
import com.example.core_module.repository.CategoryRepository;
import com.example.core_module.repository.OrderRepository;
import com.example.core_module.repository.ProductRepository;
import com.example.core_module.service.serviceImpl.AdminServiceImpl;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class LoginController {
	@Autowired
	private AdminServiceImpl adminServiceImpl;
	@Autowired
	private AdminRepository adminRepository;
	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private CategoryRepository categoryRepository;

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
    public String index(Principal principal,
    					HttpSession sesstion,
    					ModelMap map){
    	if(principal==null) {
    		return "redirect:/pages/samples/login";
    	}
 	double loiwnhun;
    	for(int i=1;i<13;i++) {
    		if(orderRepository.LoiNhuanOfMonth(i).isPresent()) {
    			System.out.println(i);
    				
    		 loiwnhun=orderRepository.LoiNhuanOfMonth(i).get();
    		 System.out.println(loiwnhun);
 			sesstion.setAttribute("thang"+i, loiwnhun);
    		}else {
    			sesstion.setAttribute("thang"+i, 0);
    		}
    	
    	}
    	
    	
//    		 double loiwnhun;
//    		 loiwnhun=orderRepository.LoiNhuanOfMonth(11).get();
// 			sesstion.setAttribute("thang"+11, loiwnhun);
// 		
// 			 loiwnhun=orderRepository.LoiNhuanOfMonth(12).get();
// 			sesstion.setAttribute("thang"+12, loiwnhun);
// 		
// 			 loiwnhun=orderRepository.LoiNhuanOfMonth(1).get();
// 			sesstion.setAttribute("thang"+1, loiwnhun);
 		
 			List<Category> listcate=new ArrayList<>();
 			listcate=categoryRepository.findAll();
 		
 			sesstion.setAttribute("categorynum", listcate.size());
        
    	Admin admin=adminRepository.findByemail(principal.getName()).get();
    	String name=admin.getFirst_name() +" "+admin.getLast_name();
    	sesstion.setAttribute("name", name);
    	sesstion.setAttribute("tongloinhuan", orderRepository.LoiNhuan());
    	sesstion.setAttribute("tongloinhuan1", orderRepository.TongLoiNhuan());
         sesstion.setAttribute("tongsanpham", productRepository.findAll().size());
        map.addAttribute("listproduct",productRepository.findAll());
        
    	return "index";
    }

}
