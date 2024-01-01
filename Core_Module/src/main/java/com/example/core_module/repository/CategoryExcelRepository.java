package com.example.core_module.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.core_module.model.Category;

public interface CategoryExcelRepository extends JpaRepository<Category, Serializable>{

}
