package com.example.core_module.service.serviceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.core_module.model.Cart;
import com.example.core_module.model.Cart_Item;
import com.example.core_module.model.Customer;
import com.example.core_module.model.Product;
import com.example.core_module.repository.CartRepository;
import com.example.core_module.repository.Cart_ItemRepository;
import com.example.core_module.repository.CustomerRepository;
import com.example.core_module.repository.ProductRepository;
import com.example.core_module.service.CartService;
@Service
public class CartServiceImpl implements CartService {
	@Autowired
	private ProductServiceImpl productServiceImpl;
	@Autowired
	private Cart_ItemRepository cart_ItemRepository;
	@Autowired
	private CartRepository cartRepository;
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private Cart_ItemServiceImpl cart_ItemServiceImpl;
	
	
	private Product product;
	private Customer customer;
	
	@Override
	public Cart addtoCart(Long product_id, int quantity, String email) {
		product=productServiceImpl.findById(product_id);
		customer=customerRepository.findBycustomeremail(email).get();
		
		Cart shoppingcart=customer.getCart();
		if(shoppingcart==null) {
			System.out.println("Cart null");
			shoppingcart=new Cart();
		cartRepository.save(shoppingcart);
		
		}
		
		List<Cart_Item> listcart=shoppingcart.getList_cart_item();
		Cart_Item cartItem = findcartitem(listcart, product.getProduct_id());
		
		double unitPrice=product.getSale_price();
		
		int itemQuantity=0;
		
		if(listcart==null) {
			listcart=new ArrayList<>();
		}
		
	if (cartItem == null) {
				cartItem = new Cart_Item();
				cartItem.setProduct(product);
				cartItem.setCart(shoppingcart);
				cartItem.setQuantity(quantity);
				cartItem.setProduct_price(unitPrice);
				cartItem.setTotal_price((cartItem.getQuantity()*cartItem.getProduct().getSale_price()));
				listcart.add(cartItem);
				cart_ItemRepository.save(cartItem);
			} else {
				itemQuantity = cartItem.getQuantity() + quantity;
				cartItem.setQuantity(itemQuantity);
				
				cartItem.setTotal_price((cartItem.getQuantity()*cartItem.getProduct().getSale_price()));
				cart_ItemRepository.save(cartItem);
			}
		product.setCurrent_quantity(product.getCurrent_quantity()-quantity);
		productRepository.save(product);
	
		shoppingcart.setList_cart_item(listcart);
		shoppingcart.setCreated_At(new Date(System.currentTimeMillis()));
		shoppingcart.setUpdated_At(new Date(System.currentTimeMillis()));
		shoppingcart.setCustomer(customer);
		shoppingcart.setTotal_amount(gettotalPrice(listcart));
		shoppingcart.setTotal_item(listcart.size());
		return cartRepository.save(shoppingcart);
	}
	
	public double gettotalPrice(List<Cart_Item> listcartitem ) {
		double totalPrice=0;
		for (Cart_Item cart_Item : listcartitem) {
			totalPrice+=cart_Item.getProduct_price()*cart_Item.getQuantity();
		}
		
		return totalPrice;
	}
	
	public Cart_Item findcartitem(List<Cart_Item> cartitemList,Long id) {
		if(cartitemList==null) {
			return null;
		}
		
		for (Cart_Item cart_Item : cartitemList) {
			if(cart_Item.getProduct().getProduct_id()==id) {
				return cart_Item;
			}
		}
		return null;
		
	}

	@Override
	public Cart updateCart(Long product_id, int quantity, Long customer_id) {
		// TODO Auto-generated method stub
		return null;
	}

	

	@Override
	public Cart clearcart(String email) {
		Customer cus=customerRepository.findBycustomeremail(email).get();
		
		Cart shoppingcart=cus.getCart();
		List<Cart_Item> listcart=shoppingcart.getList_cart_item();
		for (Cart_Item cart_Item : listcart) {
			
			Product pro=productServiceImpl.findById(cart_Item.getProduct().getProduct_id());
			pro.setCurrent_quantity(pro.getCurrent_quantity()+cart_Item.getQuantity());
			productRepository.save(pro);
			
			cart_ItemRepository.deleteById(cart_Item.getCart_item_id());
		}
		
		shoppingcart.setCreated_At(null);
		shoppingcart.setUpdated_At(null);
		shoppingcart.getList_cart_item().clear();
		shoppingcart.setTotal_amount(0);
		shoppingcart.setTotal_item(0);
		shoppingcart.setCustomer(null);
		
		return cartRepository.save(shoppingcart);
	}

	@Override
	public Cart deleteItemFromCart(String email, Long cartItem_id) {
		Customer customer=customerRepository.findBycustomeremail(email).get();
		Cart cart=customer.getCart();
		List<Cart_Item> listcart=cart.getList_cart_item();
		
		
		Cart_Item cartitem;
		for (Cart_Item item : listcart) {
			if(item.getCart_item_id()==cartItem_id) {
				cartitem=item;
				Product product=item.getProduct();
				product.setCurrent_quantity(product.getCurrent_quantity()+cartitem.getQuantity());
				productRepository.save(product);
						
					listcart.remove(cartitem);
					cart_ItemRepository.delete(cartitem);
					cart.setList_cart_item(listcart);
					cart.setTotal_amount(gettotalPrice(listcart));
					cart.setTotal_item(listcart.size());
					cart.setCustomer(customer);
					cart.setUpdated_At(new Date(System.currentTimeMillis()));
					return cartRepository.save(cart);	
			}
		}
		return cartRepository.save(cart);
	}

	@Override
	public Cart minusNumProduct(Long cart_Item_id,String email) {
	Cart_Item cart_Item=cart_ItemServiceImpl.findById(cart_Item_id);
	if(cart_Item.getQuantity()==1) {
		return deleteItemFromCart(email, cart_Item_id);
	}
	
	cart_Item.setQuantity(cart_Item.getQuantity()-1);
	cart_Item.setTotal_price(cart_Item.getQuantity()*cart_Item.getProduct_price());
	cart_ItemRepository.save(cart_Item);
	
	Cart shoppingCart=cart_Item.getCart();
	List<Cart_Item> listcart=shoppingCart.getList_cart_item();
	
	for (Cart_Item cart_Item2 : listcart) {
		if(cart_Item2.getCart_item_id()==cart_Item_id) {
			cart_Item2=cart_Item;
		}
	}
	
	shoppingCart.setList_cart_item(listcart);
	shoppingCart.setUpdated_At(new Date(System.currentTimeMillis()));
	shoppingCart.setTotal_item(listcart.size());
	shoppingCart.setTotal_amount(gettotalPrice(listcart));
	return cartRepository.save(shoppingCart);
	
	}

	@Override
	public Cart addNumProduct(Long cart_Item_id) {
		Cart_Item cart_Item=cart_ItemServiceImpl.findById(cart_Item_id);
		cart_Item.setQuantity(cart_Item.getQuantity()+1);
		cart_Item.setTotal_price(cart_Item.getQuantity()*cart_Item.getProduct_price());
		cart_ItemRepository.save(cart_Item);
		
		Cart shoppingCart=cart_Item.getCart();
		List<Cart_Item> listcart=shoppingCart.getList_cart_item();
		
		for (Cart_Item cart_Item2 : listcart) {
			if(cart_Item2.getCart_item_id()==cart_Item_id) {
				cart_Item2=cart_Item;
			}
		}
		
		shoppingCart.setList_cart_item(listcart);
		shoppingCart.setUpdated_At(new Date(System.currentTimeMillis()));
		shoppingCart.setTotal_item(listcart.size());
		shoppingCart.setTotal_amount(gettotalPrice(listcart));
		return cartRepository.save(shoppingCart);
	}

	

}

