package com.example.core_module.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.core_module.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

	@Query(value="select * from category where category.parent_id= ?1",nativeQuery = true)
	List<Category> getlistBrand(Long parent_id);
	
	@Query(value="select * from category where category.parent_id!=0",nativeQuery = true)
	List<Category> getlistnotBrand();

	@Query(value=" select a.*,b.product_id \r\n"
			+ "            from category a\r\n"
			+ "            join product_category b\r\n"
			+ "            on a.category_id=b.category_id\r\n"
			+ "            where b.product_id=?1",nativeQuery = true)
	List<Category> findCategoryByProduct(Long product_id);
	
	@Query(value="select * from category c"
			+ "			   where c.is_activated=1",nativeQuery = true)
	public List<Category> findAll();
	
	
	@Query(value="select c.*,a.product_name,a.description as 'des2' \r\n"
			+ "			from product a \r\n"
			+ "			join product_category b \r\n"
			+ "			on a.product_id=b.product_id\r\n"
			+ "			join category c\r\n"
			+ "            on b.category_id=c.category_id\r\n"
			+ "            where lower(a.product_name) like lower(concat('%',:keyword,'%'))\r\n"
			+ "            or lower(a.description) like lower(concat('%',:keyword,'%'))\r\n"
			+ "            or lower(c.category_name) like lower(concat('%',:keyword,'%'))\r\n"
			+ "            or lower(c.description) like lower(concat('%',:keyword,'%'))\r\n"
			+ "            or lower(c.category_status) like lower(concat('%',:keyword,'%'))\r\n"
			+ "           \r\n"
			+ "            group by c.category_id; ",nativeQuery = true )
	List<Category> search(String keyword);
}
