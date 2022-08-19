package com.example.service;

import java.util.List;

import com.example.dao.ItemDao;
import com.example.dao.OrderDao;
import com.example.models.Item;
import com.example.models.Order;
import com.example.models.User;

public class OrderService {
	
	private OrderDao orderDao;
	private ItemDao itemDao;
	
	public OrderService(OrderDao orderDao, ItemDao itemDao) {
		this.orderDao = orderDao;
		this.itemDao = itemDao;
	}

	public Order createOrder(User u, String orderName) {
		Order o = new Order(orderName, u);
		orderDao.createOrder(o);
		return o;
	}

	public List<Order> getAllOrders() {
		return orderDao.getAllOrders();
	}

	public Order getOrderByName(String orderName) {
			return orderDao.getOrderByName(orderName);
		}
	

	public void AddItemToCart(String orderName, String itemName) {
		Order order = orderDao.getOrderByName(orderName);
		
		Item i = itemDao.getItemByName(itemName);
		List<Item> items = order.getItems();
		items.add(i);
		orderDao.AddItemToCart(order, i);
	}
		

	public void RemoveItemFromCart(String orderName, String itemName) {
		Order order = orderDao.getOrderByName(orderName);
		Item item = itemDao.getItemByName(itemName);
		List<Item> items = order.getItems();

		for(int i=0; i<items.size(); i++) {
			if(items.get(i).getItemName().equals(itemName)) {
				items.remove(i);
			}
		}
		
		orderDao.RemoveItemFromCart(order, item);
	}

}
