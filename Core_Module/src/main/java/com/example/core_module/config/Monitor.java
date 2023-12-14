package com.example.core_module.config;


import java.util.Date;

import java.util.Enumeration;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.example.core_module.model.Category;
import com.example.core_module.model.Customer;
import com.example.core_module.model.Orders;
import com.example.core_module.model.Product;
import com.example.core_module.repository.CategoryRepository;
import com.example.core_module.repository.OrderRepository;
import com.example.core_module.repository.ProductRepository;
import com.example.core_module.service.serviceImpl.CartServiceImpl;
import com.example.core_module.service.serviceImpl.CategoryServiceImpl;
import com.example.core_module.service.serviceImpl.CustomerServiceImpl;
import com.example.core_module.service.serviceImpl.ProductServiceImpl;

import jakarta.annotation.PostConstruct;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpSession;

@Component
public class Monitor {
	@Autowired
	private CustomerServiceImpl customerServiceImpl;
	@Autowired
	private CartServiceImpl cartServiceImpl;
	@Autowired
	private ProductServiceImpl productServiceImpl;
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private CategoryServiceImpl categoryServiceImpl;
	@Autowired
	private OrderRepository orderRepository;
	
//	@PostConstruct 
//	public void update() {
//		long a=2;
//		categoryServiceImpl.backById(a);
//	}
	

//	@PostConstruct 
//	@Order(2)
//public void takeodernotification(HttpSession session) {
//	List<Orders> listpending=orderRepository.getListAllPending();
//	if(listpending.size()>0) {
//		
//		session.setAttribute("pen", listpending.size()+"");
//		System.out.println(listpending.size());
//	}else {
//		session.removeAttribute("pen");
//		System.out.println("remove");
//	}
//	
//}
//	

	// 購入せずに 5 日以上カートを放置した場合、カート全体が自動的に削除されます
	// nếu hold giỏ hàng quá 5 ngày mà không mua sẽ tự động xoá toàn bộ giỏ hàng
	// thời gian được tính là lần cuối có sự kiện với giỏ hàng như thêm xoá sửa
	@PostConstruct 
	@Order(1)
	public void destroycart() {
		int numofcus=1;
		List<Customer> listcus = customerServiceImpl.findAll();

		Date date1 = new Date(System.currentTimeMillis());

		long diffIn5Day = 5 * (24 * 60 * 60 * 1000);
		
		long diffin1minute=60*1000;
		
		for (Customer customer : listcus) {
			if (customer.getCart() != null) {
				long diffInMillies = Math.abs(customer.getCart().getUpdated_At().getTime() - date1.getTime());
				
				System.out.println(diffInMillies + "s of cus "+numofcus);
				System.out.println(diffIn5Day + " millies in 5 day");
					System.out.println("ok");
					System.out.println(customer.getCustomeremail());
//					if (diffInMillies > (diffIn5Day)) {
//						System.out.println("error");
//						cartServiceImpl.clearcart(customer.getCustomeremail());
//					}
//					if (diffInMillies > (diffin1minute)) {
//						System.out.println("error");
//						cartServiceImpl.clearcart(customer.getCustomeremail());
//					}
				numofcus+=1;
			}

		}

	}
	
	
}
