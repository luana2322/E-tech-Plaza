package com.customer_module.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.core_module.model.Cart;
import com.example.core_module.model.Cart_Item;
import com.example.core_module.model.Country;
import com.example.core_module.model.Customer;
import com.example.core_module.repository.CustomerRepository;
import com.example.core_module.service.serviceImpl.CartServiceImpl;
import com.example.core_module.service.serviceImpl.CityServiceImpl;
import com.example.core_module.service.serviceImpl.CountryServiceImpl;

import jakarta.servlet.http.HttpSession;

@Controller
public class ShoppingCartDetailController {
@Autowired
private CustomerRepository customerRepository;
@Autowired
private CountryServiceImpl countryServiceImpl;
@Autowired 
private CityServiceImpl cityServiceImpl;
@Autowired
private CartServiceImpl cartServiceImpl;
	
List<Country> listcountry=new ArrayList<>();

	@GetMapping("/cart")
	public String cart(Principal principal,
					   ModelMap modelMap,
					   HttpSession section) {
		modelMap.addAttribute("title","Shopping Cart");
		
		if(principal==null) {
			return "redirect:/login";
		}
		listcountry=countryServiceImpl.findAll();
		
		Customer cus=customerRepository.findBycustomeremail(principal.getName()).get();
		
		Cart shopppingCart=cus.getCart();
		if(shopppingCart!=null) {
			modelMap.addAttribute("cart", cus.getCart());
			List<Cart_Item> liscartItem=cus.getCart().getList_cart_item();
			modelMap.addAttribute("listcartItem", liscartItem);
			modelMap.addAttribute("totalItem", shopppingCart.getTotal_item());		
		}else {
			modelMap.addAttribute("totalItem", 0);

		}
		
		modelMap.addAttribute("country",listcountry);
		
		return "cart";
	}
	
	@GetMapping("/delete-cartItem")
	public String  deletecartItem(ModelMap modelMap,
						 		  HttpSession section,
						 		  @RequestParam("cartItem_id") Long cartItem_id,
						 		  Principal principal) {
		modelMap.addAttribute("title","Shopping Cart");
		
		cartServiceImpl.deleteItemFromCart(principal.getName(), cartItem_id);

		listcountry=countryServiceImpl.findAll();
		
		Customer cus=customerRepository.findBycustomeremail(principal.getName()).get();
		
		Cart shopppingCart=cus.getCart();
		if(shopppingCart!=null) {
			System.out.println("Cart null");
			modelMap.addAttribute("cart", cus.getCart());
			List<Cart_Item> liscartItem=cus.getCart().getList_cart_item();
			modelMap.addAttribute("listcartItem", liscartItem);
			modelMap.addAttribute("totalItem", shopppingCart.getTotal_item());		
		}else {
			modelMap.addAttribute("totalItem", 0);

		}
		
		modelMap.addAttribute("country",listcountry);
		
		return "cart";
	}
	
	@GetMapping("/clear-cart")
	public String clearcart(Principal principal,
							ModelMap modelMap,
							HttpSession section) {
		
		modelMap.addAttribute("title","Shopping Cart");
		cartServiceImpl.clearcart(principal.getName());
		
		listcountry=countryServiceImpl.findAll();
		
		Customer cus=customerRepository.findBycustomeremail(principal.getName()).get();
		
		Cart shopppingCart=cus.getCart();
		if(shopppingCart!=null) {
			System.out.println("Cart null");
			modelMap.addAttribute("cart", cus.getCart());
			List<Cart_Item> liscartItem=cus.getCart().getList_cart_item();
			modelMap.addAttribute("listcartItem", liscartItem);
			modelMap.addAttribute("totalItem", shopppingCart.getTotal_item());		
		}else {
			modelMap.addAttribute("totalItem", 0);

		}
		
		modelMap.addAttribute("country",listcountry);
		
		return "cart";
	}
	
	@GetMapping("/minusNumProduct")
	public String minusNumProduct(Principal principal,
								  ModelMap modelMap,
								  HttpSession section,
								  @RequestParam("cartItem_id")Long cartItem_id) {
		
		modelMap.addAttribute("title","Shopping Cart");
		
		cartServiceImpl.minusNumProduct(cartItem_id,principal.getName());
		
		listcountry=countryServiceImpl.findAll();
		
		Customer cus=customerRepository.findBycustomeremail(principal.getName()).get();
		
		Cart shopppingCart=cus.getCart();
		if(shopppingCart!=null) {
			System.out.println("Cart null");
			modelMap.addAttribute("cart", cus.getCart());
			List<Cart_Item> liscartItem=cus.getCart().getList_cart_item();
			modelMap.addAttribute("listcartItem", liscartItem);
			modelMap.addAttribute("totalItem", shopppingCart.getTotal_item());		
		}else {
			modelMap.addAttribute("totalItem", 0);

		}
		
		modelMap.addAttribute("country",listcountry);
		
		return "cart";
	}
	
	
	@GetMapping("/addNumProduct")
	public String addNumProduct(Principal principal,
								  ModelMap modelMap,
								  HttpSession section,
								  @RequestParam("cartItem_id")Long cartItem_id) {
		
		modelMap.addAttribute("title","Shopping Cart");
		
		cartServiceImpl.addNumProduct(cartItem_id);
		
		listcountry=countryServiceImpl.findAll();
		
		Customer cus=customerRepository.findBycustomeremail(principal.getName()).get();
		
		Cart shopppingCart=cus.getCart();
		if(shopppingCart!=null) {
			System.out.println("Cart null");
			modelMap.addAttribute("cart", cus.getCart());
			List<Cart_Item> liscartItem=cus.getCart().getList_cart_item();
			modelMap.addAttribute("listcartItem", liscartItem);
			modelMap.addAttribute("totalItem", shopppingCart.getTotal_item());		
		}else {
			modelMap.addAttribute("totalItem", 0);

		}
		
		modelMap.addAttribute("country",listcountry);
		
		return "cart";
	}
	
	
}
