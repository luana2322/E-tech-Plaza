package com.example.core_module.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.example.core_module.dto.CategoryDto;
import com.example.core_module.model.Category;

public interface CategoryService {
List<Category> findAll();
Category save(CategoryDto categoryDto,MultipartFile file);
Category findById(Long id);
Category update(CategoryDto categoryDto,Long cate_id);
Category deleteById(Long id);
Category backById(Long id);

}
