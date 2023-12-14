package com.example.core_module.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

import com.example.core_module.dto.ProductDto;
import com.example.core_module.model.Product;

public interface ProductService {
List<Product> findAll();
Product findById(Long id);
Product deleteById(Long id);
Page<Product> getProductPagination(Integer pageNumber,Integer pageSize);
Product save(ProductDto productDto,List<MultipartFile> listfile);
Product update(ProductDto productDto,List<MultipartFile> listfile,Long product_id);
void deleteByCategory_Id(Long category_id);
void backByCategory_Id(Long category_id);

Product increas_view_product(Long product_id);
}
