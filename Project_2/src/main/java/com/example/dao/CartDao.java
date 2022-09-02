package com.example.dao;

import java.util.List;



import com.example.models.User;
import com.example.models.Item;
import com.example.models.Cart;

public interface CartDao {
	
	//stuck on these
	//Create
	void createCart(Cart cart);
	
	

	
	
	
	Cart readCartByUser(User user);
	
	
	
	
	
	//to add products to the  cart
	void addItemToCart(Cart cart, Item item);
	
	
	
	
	
	
	//to delete items from the cart
	void deleteItemFromCart(Cart cart, Item item);
	
	
	void emptyCart(Cart cart);
	
	

}
