package com.example.core_module.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.core_module.model.Product_Image;
@Repository
public interface Product_ImageRepository extends JpaRepository<Product_Image, Long> {
@Query(value="delete from product_image p"
		+ "			 where p.product_id=?1",nativeQuery = true)
void deleteByProduct_id(Long product_id);
}
