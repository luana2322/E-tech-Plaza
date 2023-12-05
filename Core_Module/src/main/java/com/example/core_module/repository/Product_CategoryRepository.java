package com.example.core_module.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.core_module.model.Product_Category;
@Repository
public interface Product_CategoryRepository extends JpaRepository<Product_Category, Long> {
//	@Query(value="select count(*) from product_category where category_id=:category_id")
//	int countProductByCategoryId(@Param("category_id") Long category_id);
}
