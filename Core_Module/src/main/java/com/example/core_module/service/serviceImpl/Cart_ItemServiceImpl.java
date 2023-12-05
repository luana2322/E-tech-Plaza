package com.example.core_module.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.core_module.model.Cart_Item;
import com.example.core_module.repository.Cart_ItemRepository;
import com.example.core_module.service.Cart_ItemService;
@Service
public class Cart_ItemServiceImpl implements Cart_ItemService {
	@Autowired
	private Cart_ItemRepository cart_ItemRepository;

	@Override
	public List<Cart_Item> findAll() {
		List<Cart_Item> listcart=cart_ItemRepository.findAll();
		return listcart;
	}

	@Override
	public Cart_Item findById(Long cartItem_id) {
		Cart_Item cartItem=cart_ItemRepository.findById(cartItem_id).get();
		return cartItem;
	}

	@Override
	public void deleteById(Long cartItem_id) {
		cart_ItemRepository.deleteById(cartItem_id);
	}

}
