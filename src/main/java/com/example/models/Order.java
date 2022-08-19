package com.example.models;

import java.util.ArrayList;
import java.util.List;

public class Order {

	private int orderId;
	private String orderName;
	private User user;
	private List<Item> items;
	
	public Order() {
		super();
		this.items = new ArrayList<>();
	}
	
	public Order(String orderName, User user) {
		super();
		this.orderName = orderName;
		this.user = user;
		this.items = new ArrayList<>();
	}

	public Order(int orderId, String orderName, User user, List<Item> items) {
		super();
		this.orderId = orderId;
		this.orderName = orderName;
		this.user = user;
		this.items = items;
	}

	
	
	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getOrderName() {
		return orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "Order [listId=" + orderId + ", listName=" + orderName + ", user=" + user + ", items=" + items + "]";
	}
	
	
	
}
