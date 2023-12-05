package com.example.core_module.service;

import java.util.List;

import com.example.core_module.model.Category;

public interface CategoryService {
List<Category> findAll();
Category save();
Category findById(Long id);
void deleteById(Long id);
}
