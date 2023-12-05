package com.example.core_module.config;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.example.core_module.model.Customer;
import com.example.core_module.service.serviceImpl.CartServiceImpl;
import com.example.core_module.service.serviceImpl.CustomerServiceImpl;

import jakarta.annotation.PostConstruct;

@Component
public class Monitor {
	@Autowired
	private CustomerServiceImpl customerServiceImpl;
	@Autowired
	private CartServiceImpl cartServiceImpl;
	
	
	


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
	
	@PostConstruct
	@Order(2)
	public void test() {
		System.out.println("This is test case");
	}
	
}
