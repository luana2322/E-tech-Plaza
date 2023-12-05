package com.example.core_module.service.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.core_module.model.Customer;
import com.example.core_module.model.Product;
import com.example.core_module.model.Wishlist;
import com.example.core_module.repository.CustomerRepository;
import com.example.core_module.repository.WishlistRepository;
import com.example.core_module.service.WishlistService;

@Service
public class WishlistServiceImpl implements WishlistService {
	@Autowired
	private ProductServiceImpl productServiceImpl;
	@Autowired
	private CustomerServiceImpl customerServiceImpl;
	@Autowired
	private WishlistRepository wishlistRepository;
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public Wishlist addwishlist(Long product_id, String email) {

		List<Wishlist> listwish = findAll();

		for (Wishlist wishlist : listwish) {
			if (wishlist.getProduct().getProduct_id() == product_id) {
				return null;
			}
		}

		Product pro = productServiceImpl.findById(product_id);
		Customer cus = customerRepository.findBycustomeremail(email).get();
		Wishlist wishlist = new Wishlist();
		wishlist.setCustomer(cus);
		wishlist.setProduct(pro);

		return wishlistRepository.save(wishlist);
	}

	@Override
	public void deleteBywishlistId(Long id) {
		wishlistRepository.deleteById(id);
	}

	@Override
	public void deletebyproduct_id(Long product_id) {
		Wishlist wishlist = wishlistRepository.findByProduct_id(product_id);

		wishlistRepository.delete(wishlist);

	}

	@Override
	public List<Wishlist> findAll() {
		List<Wishlist> list = new ArrayList<>();
		list = wishlistRepository.findAll();
		return list;
	}

}
