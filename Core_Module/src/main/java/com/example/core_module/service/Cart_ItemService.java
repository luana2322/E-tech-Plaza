package com.example.core_module.service;

import java.util.List;

import com.example.core_module.model.Cart_Item;

public interface Cart_ItemService {
List<Cart_Item> findAll();
Cart_Item findById(Long cartItem_id);
void deleteById(Long cartItem_id);
}
