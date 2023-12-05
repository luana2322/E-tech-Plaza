package com.example.core_module.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.core_module.model.Product_Category;
import com.example.core_module.repository.Product_CategoryRepository;
import com.example.core_module.service.Product_CategoryService;
@Service
public class Product_CategoryServiceImpl implements Product_CategoryService {
@Autowired
private Product_CategoryRepository product_CategoryRepository;
	@Override
	public Product_Category save(Product_Category product_Category) {
		return product_CategoryRepository.save(product_Category) ; 
	}

}
