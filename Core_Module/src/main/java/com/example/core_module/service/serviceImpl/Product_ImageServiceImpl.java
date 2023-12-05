package com.example.core_module.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.core_module.model.Product_Image;
import com.example.core_module.repository.Product_ImageRepository;
import com.example.core_module.service.Product_ImageService;
@Service
public class Product_ImageServiceImpl implements Product_ImageService{
@Autowired
private Product_ImageRepository product_ImageRepository;
	@Override
	public Product_Image save(Product_Image product_Image) {
		return product_ImageRepository.save(product_Image);
	}

}
