package com.example.dao;

import java.util.List;

import com.example.models.Item;
import com.example.models.Order;
import com.example.models.User;

public interface OrderDao {


			
		//Create
		void createOrder(Order order);
		List<Order> getOrdersByUser(User user);

		//view details of previous order
		Order getOrderById(String id);

		
		
		
		
	
	

}
