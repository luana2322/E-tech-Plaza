package com.admin_module.controller;

import java.security.Principal;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.core_module.dto.AccountDto;
import com.example.core_module.exportExcel.AccountExcelService;
import com.example.core_module.model.Admin;
import com.example.core_module.model.Customer;
import com.example.core_module.service.serviceImpl.AdminServiceImpl;
import com.example.core_module.service.serviceImpl.CustomerServiceImpl;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class AccountController {
@Autowired
private CustomerServiceImpl customerServiceImpl;
@Autowired 
private AdminServiceImpl adminServiceImpl;
@Autowired
private PasswordEncoder passwordEncoder;
@Autowired
private AccountExcelService accountExcelService;

//start get list
@RequestMapping(value="/account",method=RequestMethod.GET)
public String listcus(ModelMap modelMap,
					  Principal principal) {
	if(principal==null) {
		return "redirect:/pages/samples/login";
	}
	List<Customer> listcus=customerServiceImpl.findAll();

	modelMap.addAttribute("listcus",listcus);
	return "account";
}

@RequestMapping(value="/list-admin",method=RequestMethod.GET)
public String admin(ModelMap modelMap,
					  Principal principal) {
	if(principal==null) {
		return "redirect:/pages/samples/login";
	}
	List<Admin> listadmin=adminServiceImpl.findAll();
	

	modelMap.addAttribute("listadmin",listadmin);
	return "admin";
}
//end get list
//start add account
@RequestMapping(value="/add-account",method=RequestMethod.GET)
public String add(ModelMap modelMap,
					  Principal principal) {
	if(principal==null) {
		return "redirect:/pages/samples/login";
	}
	modelMap.addAttribute("accountDto",new AccountDto());
	return "newaccount";
}

@RequestMapping(value="/upload_account",method=RequestMethod.POST)
public String uploadaccount(ModelMap modelMap,
					  		Principal principal,
					  		@ModelAttribute("accountDto") AccountDto accountDto) {
	if(principal==null) {
		return "redirect:/pages/samples/login";
	}
	if(accountDto.getRole()==1) {
		//admin
		adminServiceImpl.adminsave(accountDto);
	}else if(accountDto.getRole()==2) {
		//customer
	customerServiceImpl.adminsave(accountDto);
	}
	List<Customer> listcus=customerServiceImpl.findAll();
	modelMap.addAttribute("listcus",listcus);
	return "redirect:/account";
}
//end add account
//start delete
@RequestMapping(value="/delete-cus",method=RequestMethod.GET)
public String deletecus(ModelMap modelMap,
					  	Principal principal,
					  	@RequestParam("cus_id")Long customer_id) {
	if(principal==null) {
		return "redirect:/pages/samples/login";
	}
	
	customerServiceImpl.deleteById(customer_id);
	List<Customer> listcus=customerServiceImpl.findAll();

	modelMap.addAttribute("listcus",listcus);
	return "redirect:/account";
}


@RequestMapping(value="/delete-admin",method=RequestMethod.GET)
public String deleteadmin(ModelMap modelMap,
					  	  Principal principal,
					  	  @RequestParam("admin_id")Long admin_id) {
	if(principal==null) {
		return "redirect:/pages/samples/login";
	}
	adminServiceImpl.deleteById(admin_id);
	
	List<Admin> listadmin=adminServiceImpl.findAll();
	modelMap.addAttribute("listadmin",listadmin);
	return "redirect:/admin";
}

//end delete account

//start update
@RequestMapping(value="/edit-admin",method=RequestMethod.GET)
public String editadmin(ModelMap modelMap,
					  	  Principal principal,
					  	  @RequestParam("admin_id")Long admin_id,
					  	  HttpSession session) {
	if(principal==null) {
		return "redirect:/pages/samples/login";
	}
	session.setAttribute("admin_id_update", admin_id);
	Admin admin=adminServiceImpl.findById(admin_id);
	
	
	modelMap.addAttribute("admin",admin);
	modelMap.addAttribute("accountDto",new AccountDto());
	return "updateadmin";
}

@RequestMapping(value="/upload_update_admin",method=RequestMethod.POST)
public String updateadmin(ModelMap modelMap,
					  	  Principal principal,
					  	  HttpSession session,
					  	  @ModelAttribute("accountDto") AccountDto accountDto) {
	if(principal==null) {
		return "redirect:/pages/samples/login";
	}
	Long admin_id=(long)session.getAttribute("admin_id_update");
	
	adminServiceImpl.update(accountDto, admin_id);
	List<Admin> listadmin=adminServiceImpl.findAll();
	modelMap.addAttribute("listadmin",listadmin);
	return "admin";
}

@RequestMapping(value="/edit-cus",method=RequestMethod.GET)
public String editcustomer(ModelMap modelMap,
					  	  Principal principal,
					  	  @RequestParam("cus_id")Long cus_id,
					  	  HttpSession session) {
	if(principal==null) {
		return "redirect:/pages/samples/login";
	}
	session.setAttribute("cus_id_update", cus_id);
	Customer cus=customerServiceImpl.findById(cus_id);
	
	
	modelMap.addAttribute("cus",cus);
	modelMap.addAttribute("accountDto",new AccountDto());
	return "updatecustomer";
}
	
@RequestMapping(value="/upload_update_customer",method=RequestMethod.POST)
public String updatecustomer(ModelMap modelMap,
					  	  Principal principal,
					  	  HttpSession session,
					  	  @ModelAttribute("accountDto") AccountDto accountDto) {
	if(principal==null) {
		return "redirect:/pages/samples/login";
	}
	Long cus_id=(long)session.getAttribute("cus_id_update");
	
customerServiceImpl.update(accountDto, cus_id);

	List<Customer> listcus=customerServiceImpl.findAll();
	modelMap.addAttribute("listcus",listcus);
	return "account";
}
//end update
//excel product
@GetMapping("/account-excel")
public void generateExcelReport(HttpServletResponse response) throws Exception{
	
	response.setContentType("application/octet-stream");
	
	String headerKey = "Content-Disposition";
	String headerValue = "attachment;filename=account.xls";

	response.setHeader(headerKey, headerValue);
	
	accountExcelService.generateExcel(response);
	
	response.flushBuffer();
}

@GetMapping("/aaaa")
public String aaa(ModelMap modelMap) {
	
	return "a";
}
}
