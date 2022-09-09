package com.example.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.models.Item;
import com.example.utils.HibernateUtil;


@Transactional
@Repository("ItemDaoBean")
public class ItemDaoHibernate implements ItemDao {
	
	private SessionFactory sessFact;

	
	@Autowired
	public ItemDaoHibernate(SessionFactory sessFact) {
		this.sessFact = sessFact;
	}

	@Override
	public void createItem(Item item) {
		sessFact.getCurrentSession().save(item);
		
	}

	@Override
	public Item getItemById(int id) {
		
		List<Item> item = sessFact.getCurrentSession().createQuery("from Item where itemId=:id", Item.class).setParameter("id", id).list();
		
		if(item.size() < 1) {
			return null;
		}
		
		return item.get(0);
	}

	@Override
	public List<Item> getAllItems() {
		return sessFact.getCurrentSession().createQuery("from Item", Item.class).list();
	}
		

	@Override
	public Item getItemByName(String name) {
		
		Item p = sessFact.getCurrentSession().createQuery("from Item where itemName=:name", Item.class).setParameter("name", name).uniqueResult();
		
		
		return p;
	}

	@Override
	public void updateItem(Item item) {
		sessFact.getCurrentSession().update(item);
		
	}

	@Override
	public void deleteItem(Item item) {
		sessFact.getCurrentSession().delete(item);
	
		
	}

}
