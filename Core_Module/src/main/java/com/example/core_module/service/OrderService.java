package com.example.core_module.service;

import java.util.List;


import com.example.core_module.dto.OrderDto;
import com.example.core_module.model.Orders;

public interface OrderService {
Orders order(String email,OrderDto orderDto);
//Orders save(OrderDto orderDto);
void deleteById(Long order_id);
List<Orders> findAll();
Orders findById(Long order_id);
Orders cancelOrder(Long order_id);
Orders approveOrder(Long order_id);
Orders rejectOrder(Long order_id);
}
