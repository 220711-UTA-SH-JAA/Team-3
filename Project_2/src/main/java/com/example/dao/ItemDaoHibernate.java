package com.example.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.models.Item;


@Transactional
@Repository("ItemDaoBean")
public class ItemDaoHibernate implements ItemDao {
	
	private SessionFactory sessFact;
	
	
	
	@Autowired
	public ItemDaoHibernate(SessionFactory sessFact) {
		this.sessFact = sessFact;
	}

	@Override
	public void createItem(Item p) {
		sessFact.getCurrentSession().save(p);
		
	}

	@Override
	public Item selectItemById(int id) {
		
		List<Item> item = sessFact.getCurrentSession().createQuery("form Item where itemId=:id", Item.class).setParameter("id", id).list();
		
		if(item.size() < 1) {
			return null;
		}
		
		return item.get(0);
	}

	@Override
	public List<Item> readAllItems() {
		return sessFact.getCurrentSession().createQuery("from Item", Item.class).list();
	}
		

	@Override
	public Item selectItemByName(String name) {
		
		Item p = sessFact.getCurrentSession().createQuery("form Item where itemName=:name", Item.class).setParameter("name", name).uniqueResult();
		
		
		return p;
	}

	@Override
	public void updateItem(Item p) {
		sessFact.getCurrentSession().update(p);
		
	}

	@Override
	public void deleteItem(Item p) {
		sessFact.getCurrentSession().delete(p);
	
		
	}

}
