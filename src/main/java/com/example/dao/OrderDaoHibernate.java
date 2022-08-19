package com.example.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.example.models.Item;
import com.example.models.Order;
import com.example.utils.HibernateUtil;

public class OrderDaoHibernate implements OrderDao{

	@Override
	public void createOrder(Order o) {
		Session ses = HibernateUtil.getSession();
		
		//Start a transaction
		Transaction transaction = ses.beginTransaction();
		
		//Save the order
		ses.save(o);
		
		//Commit the user to the database
		transaction.commit();
	}
		
	

	@Override
	public List<Order> getAllOrders() {
		Session ses = HibernateUtil.getSession();
		
		List<Order> orders = ses.createQuery("from Order", Order.class).list();
		
		return orders;
	}
	

	@Override
	public Order getOrderByName(String orderName) {
		Session ses = HibernateUtil.getSession();
		
		Order o = ses.createQuery("from Item where orderName=:name", Order.class).setParameter("orderName", orderName).uniqueResult();
		
		return o;
	}
	

	@Override
	public void AddItemToCart(Order o, Item i) {
		Session ses = HibernateUtil.getSession();
		
		Transaction transaction = ses.beginTransaction();
		
		ses.save(i);
		
		
		transaction.commit();
	}
		
	

	@Override
	public boolean RemoveItemFromCart(Order o, Item i) {
		Session ses = HibernateUtil.getSession();
		
		Transaction transaction = ses.beginTransaction();
		
		ses.delete(i);
		
		transaction.commit();

		return true;
	}
		
	}


