package com.example.core_module.service.serviceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.core_module.dto.OrderDto;
import com.example.core_module.model.Cart;
import com.example.core_module.model.Cart_Item;
import com.example.core_module.model.Customer;
import com.example.core_module.model.Order_Detail;
import com.example.core_module.model.Order_Status;
import com.example.core_module.model.Orders;
import com.example.core_module.repository.CustomerRepository;
import com.example.core_module.repository.OrderRepository;
import com.example.core_module.service.OrderService;
@Service
public class OrderServiceImpl implements OrderService {
@Autowired
private CustomerRepository customerRepository;
@Autowired
private CartServiceImpl cartServiceImpl;
@Autowired
private OrderRepository orderRepository;
@Autowired
private CityServiceImpl cityServiceImpl;
@Autowired
private Order_DetailServiceImpl order_DetailServiceImpl;

	@Override
	public Orders order(String email,OrderDto orderDto) {
		Customer cus=customerRepository.findBycustomeremail(email).get();
		Cart cart=cus.getCart();
		Orders order=new Orders();
		orderRepository.save(order);
		//set properties
		order.setFirst_name(orderDto.getFirst_name());
		order.setLast_name(orderDto.getLast_name());
		order.setAddress_1(orderDto.getAddress_1());
		order.setAddress_2(orderDto.getAddress_2());
		order.setCompany_name(orderDto.getCompany_name());
		order.setOrder_date(new Date(System.currentTimeMillis()));
		order.setEmail(orderDto.getEmail());
		order.setOrder_note(orderDto.getOrder_note());
		order.setPhone(orderDto.getPhone());
		order.setZipcode(orderDto.getZipcode());
		order.setTotal_amount(cart.getTotal_amount());
		order.setCity(cityServiceImpl.findById((long)orderDto.getCity_id()));
		order.setCustomer(cus);
		// pending,approved,rejected
		order.setOrder_status(Order_Status.Pending.toString());
		
		List<Order_Detail> listorderdetail=new ArrayList<>();
		// set order_detail
		for (Cart_Item cartItem: cart.getList_cart_item()) {
			Order_Detail order_Detail=new Order_Detail();
			order_Detail.setProduct(cartItem.getProduct());
			order_Detail.setProduct_price(cartItem.getProduct_price());
			order_Detail.setQuantity(cartItem.getQuantity());
			order_Detail.setTotal_amount(cartItem.getTotal_price());
			order_Detail.setOrders(order);
			
			listorderdetail.add(order_Detail);
			
			order_DetailServiceImpl.save(order_Detail);
		}
		
		order.setList_order_detail(listorderdetail);
		cartServiceImpl.clearcart(email);
		
		return orderRepository.save(order);
	}
	
	
	
//	@Override
//	public Orders save(OrderDto orderDto) {
//		Orders order=new Orders();
//		order.setFirst_name(orderDto.getFirst_name());
//		order.setLast_name(orderDto.getLast_name());
//		order.setCompany_name(orderDto.getCompany_name());
//		order.set
//	}
	@Override
	public void deleteById(Long order_id) {
		orderRepository.deleteById(order_id);
	}
	@Override
	public List<Orders> findAll() {
		List<Orders> listorder=new ArrayList<>();
		listorder=orderRepository.findAll();
		return listorder;
	}
	@Override
	public Orders findById(Long order_id) {
		Orders order=orderRepository.findById(order_id).get();
		return order;
	}



	@Override
	public Orders cancelOrder(Long order_id) {
		// TODO Auto-generated method stub
		Orders order=findById(order_id);
		order.setOrder_status(Order_Status.Cancel.toString());
		return orderRepository.save(order);
	}



	@Override
	public Orders approveOrder(Long order_id) {
		Orders order=findById(order_id);
		order.setOrder_status(Order_Status.Approved.toString());
		return orderRepository.save(order);
	}



	@Override
	public Orders rejectOrder(Long order_id) {
		Orders order=findById(order_id);
		order.setOrder_status(Order_Status.Rejected.toString());
		return orderRepository.save(order);
	}
	

}
