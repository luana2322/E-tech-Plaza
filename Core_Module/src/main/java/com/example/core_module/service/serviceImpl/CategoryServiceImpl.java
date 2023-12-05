package com.example.core_module.service.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.core_module.model.Category;
import com.example.core_module.repository.CategoryRepository;
import com.example.core_module.service.CategoryService;
@Service
public class CategoryServiceImpl implements CategoryService {
@Autowired
private CategoryRepository categoryRepository;
	@Override
	public List<Category> findAll() {
		List<Category> list1=new ArrayList<>();
		list1=categoryRepository.findAll();
		return list1;
	}

	@Override
	public Category save() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Category findById(Long id) {
		Category cate=categoryRepository.findById(id).get();
		return cate;
	}

	@Override
	public void deleteById(Long id) {
		categoryRepository.deleteById(id);
	}

}
