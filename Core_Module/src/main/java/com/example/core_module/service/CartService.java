package com.example.core_module.service;

import com.example.core_module.model.Cart;

public interface CartService {

	Cart addtoCart(Long product_id,int quantity,String email);
	Cart updateCart(Long product_id,int quantity,Long customer_id);
	Cart deleteItemFromCart(String email,Long cartItem_id);
	Cart clearcart(String email);
	
	Cart minusNumProduct(Long cart_Item_id,String email);
	Cart addNumProduct(Long cart_Item_id);
}
