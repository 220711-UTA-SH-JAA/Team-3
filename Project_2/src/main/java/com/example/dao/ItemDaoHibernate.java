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
	
	
	@Autowired
	public ItemDaoHibernate() {
		//this.sessFact = sessFact;
	}

	@Override
	public void createItem(Item p) {
		HibernateUtil.getSession().save(p);
		
	}

	@Override
	public Item getItemById(int id) {
		
		List<Item> item = HibernateUtil.getSession().createQuery("form Item where itemId=:id", Item.class).setParameter("id", id).list();
		
		if(item.size() < 1) {
			return null;
		}
		
		return item.get(0);
	}

	@Override
	public List<Item> getAllItems() {
		return HibernateUtil.getSession().createQuery("from Item", Item.class).list();
	}
		

	@Override
	public Item selectItemByName(String name) {
		
		Item p = HibernateUtil.getSession().createQuery("form Item where itemName=:name", Item.class).setParameter("name", name).uniqueResult();
		
		
		return p;
	}

	@Override
	public void updateItem(Item p) {
		HibernateUtil.getSession().update(p);
		
	}

	@Override
	public void deleteItem(Item p) {
		HibernateUtil.getSession().delete(p);
	
		
	}

}
