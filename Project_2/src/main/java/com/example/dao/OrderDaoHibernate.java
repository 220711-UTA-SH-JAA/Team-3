package com.example.dao;

import java.util.List;

import org.hibernate.Session;
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
		
		//HibernateUtil.getSession().save(order);
		
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		session.persist(order);
		session.getTransaction().commit();
		
	}

	

	@Override
	public List<Order> getOrdersByUser(User user) {
		List<Order> userOrders = HibernateUtil.getSession().createQuery("from Order where user=:user ORDER BY order_Id", Order.class).setParameter("user",user).list();
		
		return userOrders;

	}
	@Override
	public Order getOrderById(Integer id) {
		List<Order> userOrders = HibernateUtil.getSession().createQuery("from Order where order_id=:order_id ", Order.class).setParameter("order_id",id).list();
		
		return userOrders.get(0);
	}

	
	
}
