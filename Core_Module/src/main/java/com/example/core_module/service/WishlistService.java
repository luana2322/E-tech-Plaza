package com.example.core_module.service;

import java.util.List;

import com.example.core_module.model.Wishlist;

public interface WishlistService {
Wishlist addwishlist(Long product_id,String email);
void deleteBywishlistId(Long wishlist_id);
void deletebyproduct_id(Long product_id);
List<Wishlist> findAll();
}
