package com.customer_module.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.core_module.model.Customer;
import com.example.core_module.model.Order_Detail;
import com.example.core_module.model.Orders;
import com.example.core_module.repository.CustomerRepository;
import com.example.core_module.repository.OrderRepository;
import com.example.core_module.service.serviceImpl.OrderServiceImpl;

@Controller
public class OrderdController {
@Autowired
private CustomerRepository customerRepository;
@Autowired
private OrderRepository orderRepository;
@Autowired
private OrderServiceImpl orderServiceImpl;

	@GetMapping("/confirmation")
	public String confirmation(ModelMap modelMap,
							   Principal principal) {

		modelMap.addAttribute("title","Confirmation");
		if(principal==null) {
			return "redirect:/login";
		}
		Customer cus=customerRepository.findBycustomeremail(principal.getName()).get();
		
		List<Orders> listorderapproved=orderRepository.getListApproved(principal.getName());
		
		
		modelMap.addAttribute("listorderd", listorderapproved);
		return "confirmation";
	}
	
	@GetMapping("/pending")
	public String ordered(ModelMap modelMap,
						  Principal principal) {
		modelMap.addAttribute("title", "Pending");
		if(principal==null) {
			return "redirect:/login";
		}
		
		List<Orders> listorderPending=orderRepository.getListPending(principal.getName());

		for (Orders orders : listorderPending) {
			System.out.println(orders.getOrder_id());
		
			for (Order_Detail orders2 : orders.getList_order_detail()) {
				
			}
		}
		
		modelMap.addAttribute("listpending", listorderPending);
		return "pending";
	}
	
	@GetMapping("/cancelorder")
	public String cancelorder(ModelMap modelMap,
							  Principal principal,
							  @RequestParam("order_id")Long order_id) {
		modelMap.addAttribute("title", "Pending");
		if(principal==null) {
			return "redirect:/login";
		}
		
		orderServiceImpl.cancelOrder(order_id);
		
		List<Orders> listorderPending=orderRepository.getListPending(principal.getName());

		
		modelMap.addAttribute("listpending", listorderPending);
		return "pending";
	}
}
