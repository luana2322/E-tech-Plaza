package com.example.core_module.service.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.core_module.model.Order_Detail;
import com.example.core_module.repository.Order_DetailRepository;
import com.example.core_module.service.Order_DetailService;
@Service
public class Order_DetailServiceImpl implements Order_DetailService {
@Autowired
private Order_DetailRepository order_DetailRepository;
	@Override
	public Order_Detail save(Order_Detail order_Detail) {
		return order_DetailRepository.save(order_Detail);
	}

	@Override
	public List<Order_Detail> findAll() {
		List<Order_Detail> list=new ArrayList<>();
		list=order_DetailRepository.findAll();
		return list;
	}

	@Override
	public void deleteById(Long order_detail_id) {
		order_DetailRepository.deleteById(order_detail_id);
	}

	@Override
	public Order_Detail findById(Long order_detail_id) {
		Order_Detail order_detail=order_DetailRepository.findById(order_detail_id).get();
		return order_detail;
	}

}
