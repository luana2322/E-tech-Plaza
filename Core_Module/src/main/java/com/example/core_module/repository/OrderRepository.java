package com.example.core_module.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.core_module.model.Orders;
import com.example.core_module.model.Thongke;
@Repository
public interface OrderRepository extends JpaRepository<Orders, Long> {
	
	//CUSTOMER getbyemail
	@Query(value="select o.*,c.customer_id as cus_id \r\n"
			+ "	     		from orders o\r\n"
			+ "		 		join customer c\r\n"
			+ "        	    on c.customer_id=o.customer_id\r\n"
			+ "        	    where  c.customeremail=?1\r\n"
			+ "         	and o.order_status=\"Pending\"",nativeQuery = true)
	List<Orders> getListPending(String email);
	
	@Query(value="select o.*,c.customer_id as cus_id \r\n"
			+ "	     		from orders o\r\n"
			+ "		 		join customer c\r\n"
			+ "        	    on c.customer_id=o.customer_id\r\n"
			+ "        	    where  c.customeremail=?1\r\n"
			+ "         	and o.order_status=\"Approved\"",nativeQuery = true)
	List<Orders> getListApproved(String email);
	
	
	@Query(value="select o.*,c.customer_id as cus_id \r\n"
			+ "	     		from orders o\r\n"
			+ "		 		join customer c\r\n"
			+ "        	    on c.customer_id=o.customer_id\r\n"
			+ "        	    where  c.customeremail=?1\r\n"
			+ "         	and o.order_status=\"Rejected\"",nativeQuery = true)
	List<Orders> getListRejected(String email);
	
	//ADMIN getALL
	@Query(value="select o.*,c.customer_id as cus_id \r\n"
			+ "	     		from orders o\r\n"
			+ "		 		join customer c\r\n"
			+ "        	    on c.customer_id=o.customer_id\r\n"
			+ "         	and o.order_status=\"Pending\"",nativeQuery = true)
	List<Orders> getListAllPending();
	
	@Query(value="select o.*,c.customer_id as cus_id \r\n"
			+ "	     		from orders o\r\n"
			+ "		 		join customer c\r\n"
			+ "        	    on c.customer_id=o.customer_id\r\n"
			+ "         	and o.order_status=\"Approved\"",nativeQuery = true)
	List<Orders> getListAllApproved();
	
	
	@Query(value="select o.*,c.customer_id as cus_id \r\n"
			+ "	     		from orders o\r\n"
			+ "		 		join customer c\r\n"
			+ "        	    on c.customer_id=o.customer_id\r\n"
			+ "         	and o.order_status=\"Rejected\"",nativeQuery = true)
	List<Orders> getListAllRejected();
	
	@Query(value="select o.*,c.customer_id as cus_id \r\n"
			+ "	     		from orders o\r\n"
			+ "		 		join customer c\r\n"
			+ "        	    on c.customer_id=o.customer_id\r\n"
			+ "         	and o.order_status=\"Cancel\"",nativeQuery = true)
	List<Orders> getListAllCancel();
	
	
	@Query(value="select sum(orders.total_amount) from orders",nativeQuery = true)
	int LoiNhuan();
	
	@Query(value="select sum(p.sale_price)-sum(p.cost_price) as loinhuan\r\n"
			+ " from order_detail o join product p\r\n"
			+ "on o.product_id=p.product_id",nativeQuery = true)
	double TongLoiNhuan();
	
	@Query(value="select sum(orders.total_amount) from orders"
			+ "   where month(orders.order_date)=?1",nativeQuery = true)
	Optional<Double> LoiNhuanOfMonth(int month);
	
	@Query(value="select month(orders.order_date) as thang,sum(orders.total_amount) as money from orders\r\n"
			+ "	group by  month(orders.order_date)",nativeQuery = true)
	List<Orders> LoiNhuanOfMonthaaaaaa();
	
	
	
	
	
}
