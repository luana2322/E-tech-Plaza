package com.example.core_module.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.core_module.model.Product;
import com.example.core_module.model.Product_Category;
@Repository
public interface Product_CategoryRepository extends JpaRepository<Product_Category, Long> {
//	@Query(value="select count(*) from product_category where category_id=:category_id")
//	int countProductByCategoryId(@Param("category_id") Long category_id);
	
	
//	@Modifying
//	@Query(value="delete from product_image "
//			+ "where product_id= :product_id ",nativeQuery = true)
//	void deleteByProduct_id(@Param("product_id")Long product_id);

	@Query(value="select * from product_category p"
			+ " where p.product_id=?1",nativeQuery = true)
	Product_Category findbyProduct_Id(Long product_id);
}
