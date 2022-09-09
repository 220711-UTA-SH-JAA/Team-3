package com.example.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.models.Order;
import com.example.models.Order;
import com.example.models.Order;
import com.example.models.User;
import com.example.utils.HibernateUtil;

@Transactional
@Repository("OrderDaoBean")
public class OrderDaoHibernate implements OrderDao {

	private SessionFactory sessFact;
	@Autowired
	public OrderDaoHibernate(SessionFactory sessFact) {
		this.sessFact = sessFact;
	}
	
	
	

	@Override
	public void createOrder(Order order) {
		
		//sessFact.getCurrentSession().save(order);
		
		sessFact.getCurrentSession().save(order);
		
	}

	

	@Override
	public List<Order> getOrdersByUser(User user) {
		List<Order> userOrders = sessFact.getCurrentSession().createQuery("from Order where user=:user ORDER BY order_Id", Order.class).setParameter("user",user).list();
		
		return userOrders;

	}
	@Override
	public Order getOrderById(Integer id) {
		List<Order> userOrders = sessFact.getCurrentSession().createQuery("from Order where order_id=:order_id ", Order.class).setParameter("order_id",id).list();
		
		return userOrders.get(0);
	}

	
	
}
