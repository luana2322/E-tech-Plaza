package com.customer_module.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.example.core_module.service.serviceImpl.CustomerServiceImpl;

@Controller
public class CommentController {
@Autowired
private CustomerServiceImpl customerServiceImpl;
	
}
