package com.admin_module.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.example.core_module.repository.OrderRepository;

@Controller
public class LoiNhuanController {
@Autowired
private OrderRepository orderRepository;


}
