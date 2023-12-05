package com.example.core_module.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.core_module.model.Product;
@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{
	@Query(value="SELECT * FROM product ORDER BY product.cost_price DESC",nativeQuery = true)
	List<Product> sortPriceHightoLow();

	@Query(value="SELECT * FROM product ORDER BY product.cost_price",nativeQuery = true)
	List<Product> sortPriceLowtoHigh();
	
//	@Query(value="select * from product join product_category \r\n"
//			+ "on product.product_id=product_category.product_id"
//			+ " where product_category.category_id=:category_id",nativeQuery = true)
//	List<Product> getByCategoryId(@Param("category_id")Long category_id);

	@Query(value="select a.*,b.product_id as pro_id_b,c.category_id "
			+ "			from product a \r\n"
			+ "			join product_category b \r\n"
			+ "			on a.product_id=b.product_id\r\n"
			+ "			join category c\r\n"
			+ "         on b.category_id=c.category_id\r\n "
			+ "			where c.category_id=?1 "
			+ "         group by a.product_id\r\n",nativeQuery = true)
List<Product> getProductByCategory(Long category_id);
	
	
	@Query(value="select a.*,b.product_id as pro_id_b,c.color_id\r\n"
			+ "            from product a \r\n"
			+ "            join product_image b\r\n"
			+ "            on a.product_id =b.product_id\r\n"
			+ "            join color c\r\n"
			+ "            on b.color_id=c.color_id\r\n"
			+ "            where c.color_id=?1  \r\n"
			+ "            group by a.product_id; ",nativeQuery = true)
List<Product> getProductByColor(Long color_id);
	
	
	@Query(value="select a.*,c.category_name,c.category_status,d.color_name\r\n"
			+ "			from product a \r\n"
			+ "			join product_category b \r\n"
			+ "			on a.product_id=b.product_id\r\n"
			+ "			join category c\r\n"
			+ "         on b.category_id=c.category_id\r\n"
			+ "         join product_image i\r\n"
			+ "         on i.product_id=a.product_id\r\n"
			+ "         join color d\r\n"
			+ "         on d.color_id=i.color_id\r\n"
			+ "         where lower(a.product_name) like lower(concat('%',:keyword,'%'))\r\n"
			+ "         and lower(a.description) like lower(concat('%',:keyword,'%'))\r\n"
			+ "         or lower(a.ram) like lower(concat('%',:keyword,'%'))\r\n"
			+ "         or lower(a.rom) like lower(concat('%',:keyword,'%'))\r\n"
			+ "         or lower(a.cpu) like lower(concat('%',:keyword,'%'))\r\n"
			+ "         or lower(c.category_name) like lower(concat('%',:keyword,'%'))\r\n"
			+ "         or lower(c.category_status) like lower(concat('%',:keyword,'%'))\r\n"
			+ "         or lower(d.color_name) like lower(concat('%',:keyword,'%'))\r\n"
			+ "           \r\n"
			+ "         group by a.product_id ",nativeQuery = true)
List<Product> searchproduct(String keyword);
	

	@Query(value="select c.*,b.customer_id from customer a	\r\n"
			+ "			 	join wishlist b					\r\n"
			+ "             on a.customer_id=b.customer_id	\r\n"
			+ "             join product c 					\r\n"
			+ "             on c.product_id=b.product_id	\r\n"
			+ "             where a.customer_id=?1",nativeQuery = true)
	List<Product> wistlistbycustomerId(Long customer_id);
	
	
	@Query(value="select * from product p",nativeQuery = true)
	List<Product> pagination(int start,int end);
	
	@Query(value="select * from product p"
			+ "				where p.is_activated=1",nativeQuery = true)
	public List<Product> findAll();
}
