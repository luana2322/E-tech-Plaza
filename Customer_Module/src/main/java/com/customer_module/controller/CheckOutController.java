package com.customer_module.controller;

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

import com.example.core_module.dto.OrderDto;
import com.example.core_module.model.Cart;
import com.example.core_module.model.Cart_Item;
import com.example.core_module.model.Country;
import com.example.core_module.model.Customer;
import com.example.core_module.model.Order_Detail;
import com.example.core_module.model.Orders;
import com.example.core_module.model.Product;
import com.example.core_module.repository.CustomerRepository;
import com.example.core_module.repository.OrderRepository;
import com.example.core_module.service.serviceImpl.CityServiceImpl;
import com.example.core_module.service.serviceImpl.CountryServiceImpl;
import com.example.core_module.service.serviceImpl.CustomerServiceImpl;
import com.example.core_module.service.serviceImpl.OrderServiceImpl;

import ch.qos.logback.core.model.Model;
import jakarta.servlet.http.HttpSession;

@Controller
public class CheckOutController {
@Autowired
private CountryServiceImpl countryServiceImpl;
@Autowired
private CityServiceImpl cityServiceImpl;
@Autowired
private CustomerServiceImpl customerServiceImpl;
@Autowired
private CustomerRepository customerRepository;
@Autowired
private OrderServiceImpl orderServiceImpl;
@Autowired
private OrderRepository orderRepository;

List<Country> listcountry=new ArrayList<>();

	
	@GetMapping("/checkout")
	public String checkout(ModelMap modelMap,
						   Principal principal) {
		if(principal==null) {
			return "redirect:/login";
		}
		// th:checked="${checked}"
		Customer cus=customerRepository.findBycustomeremail(principal.getName()).get();
		
			
			Cart shopppingCart=cus.getCart();
			if(shopppingCart!=null) {
				modelMap.addAttribute("cart", cus.getCart());
				List<Cart_Item> liscartItem=cus.getCart().getList_cart_item();
				modelMap.addAttribute("listcartItem", liscartItem);
				modelMap.addAttribute("cart", cus.getCart());
				modelMap.addAttribute("orderDto", new OrderDto());
				modelMap.addAttribute("totalItem", shopppingCart.getTotal_item());		
				System.out.println("Exists Product");
			}else {
				modelMap.addAttribute("totalItem", 0);
				System.out.println("No Productsss");
			}
			
			
		
		modelMap.addAttribute("title","Check Out");
		return "checkout";
	}
	
	@GetMapping("/termofservice")
	public String termofservice() {
		return "termofservice";
	}
	
	@GetMapping("/accept")
	public String accept(ModelMap modelMap,
			   			 Principal principal) {
		if(principal==null) {
			return "redirect:/login";
		}
		
		Customer cus=customerRepository.findBycustomeremail(principal.getName()).get();
		
		
		
			List<Cart_Item> listcartItem=cus.getCart().getList_cart_item();
			modelMap.addAttribute("listcartItem", listcartItem);
			modelMap.addAttribute("cart", cus.getCart());	
			
			modelMap.addAttribute("checked", "checked");
		
		modelMap.addAttribute("title","Check Out");
		return "checkout";
	}
	
	@GetMapping("/deny")
	public String deny(ModelMap modelMap,
			   Principal principal) {

		
		return "redirect:/index";
	}
	
	@PostMapping("/order")
	public String order(ModelMap modelMap,
						HttpSession section,
						Principal principal,
						@ModelAttribute("orderDto")OrderDto orderDto) {
		modelMap.addAttribute("title", "Pending");
		if(principal==null) {
			return "redirect:/login";
		}	
		if(orderDto==null) {
			System.out.println("OrderDTO is NULL");
		}
		
		Customer cus=customerRepository.findBycustomeremail(principal.getName()).get();
		List<Orders> list_order=cus.getList_order();
	
		orderServiceImpl.order(principal.getName(), orderDto);
		
		List<Orders> listorderPending=orderRepository.getListPending(principal.getName());
		
		modelMap.addAttribute("listpending", listorderPending);
		
		return "pending";
	}
	
	
	

	
	
	
}
