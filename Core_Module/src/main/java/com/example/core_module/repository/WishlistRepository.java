package com.example.core_module.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.core_module.model.Wishlist;
@Repository
public interface WishlistRepository extends JpaRepository<Wishlist, Long> {

	@Query(value="select * from wishlist w where w.product_id=?1",nativeQuery = true)
	public Wishlist findByProduct_id(Long product_id);
}
