package com.example.core_module.service;

import java.util.List;

import com.example.core_module.model.Order_Detail;

public interface Order_DetailService {
Order_Detail save(Order_Detail order_Detail);
List<Order_Detail> findAll();
void deleteById(Long order_detail_id);
Order_Detail findById(Long order_detail_id);
}
