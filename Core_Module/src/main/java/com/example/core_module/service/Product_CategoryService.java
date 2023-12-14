package com.example.core_module.service;
import com.example.core_module.model.Product_Category;

public interface Product_CategoryService {
Product_Category save(Product_Category product_Category);
void deleteByProduct_id(Long product_id);
}
