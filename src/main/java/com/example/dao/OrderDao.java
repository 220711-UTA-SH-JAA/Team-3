package com.example.dao;

import java.util.List;

import com.example.models.Item;
import com.example.models.Order;

public interface OrderDao {

	void createOrder(Order o);
	
	List<Order> getAllOrders();

	Order getOrderByName(String orderName);
	
	void AddItemToCart(Order o, Item i);
	
	boolean RemoveItemFromCart(Order o, Item i);
	
	
	
}
