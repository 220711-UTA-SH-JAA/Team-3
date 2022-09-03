package com.example.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.models.Order;
import com.example.models.Order;
import com.example.models.Order;
import com.example.models.User;
import com.example.utils.HibernateUtil;

public class OrderDaoHibernate implements OrderDao {

	
	@Autowired
	public OrderDaoHibernate() {
		
	}
	
	
	

	@Override
	public void createOrder(Order order) {
		
		HibernateUtil.getSession().save(order);
		
	
	}

	

	@Override
	public List<Order> getOrdersByUser(User user) {
		List<Order> userOrders = HibernateUtil.getSession().createQuery("from Order order where user=:user orderby order.orderId", Order.class).setParameter("user",user).list();
		
		return userOrders;

	}
	@Override
	public Order getOrderById(String id) {
		List<Order> userOrders = HibernateUtil.getSession().createQuery("from Order order where orderId=:orderId orderby order.orderId", Order.class).setParameter("orderId",id).list();
		
		return userOrders.get(0);
	}

	
	
}
