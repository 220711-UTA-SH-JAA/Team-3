package com.example.dao;

import java.util.List;

import org.hibernate.Session;

import com.example.models.Item;
import com.example.utils.HibernateUtil;

public class ItemDaoHibernate implements ItemDao {

	@Override
	public List<Item> getAllItems() {
		Session ses = HibernateUtil.getSession();
		
		List<Item> items = ses.createQuery("from Item", Item.class).list();
		
		return items;
	}
	

	@Override
	public Item getItemByName(String itemName) {
		Session ses = HibernateUtil.getSession();
		
		Item i = ses.createQuery("from Item where itemName=:name", Item.class).setParameter("itemName", itemName).uniqueResult();
		
		return i;
	}
	
}

