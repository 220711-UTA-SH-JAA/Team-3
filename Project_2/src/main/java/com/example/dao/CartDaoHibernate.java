package com.example.dao;

import java.util.List;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.models.User;
import com.example.utils.HibernateUtil;
import com.example.models.Item;
import com.example.models.Cart;



@Transactional //Spring ORM manages our tranactions
@Repository("CartDaoBean")
public class CartDaoHibernate implements CartDao {
	
	
	//private SessionFactory sessFact;
	
	@Autowired
	public CartDaoHibernate() {
		
		//this.sessFact = HibernateUtil.getSession();
	}
	
	
	

	@Override
	public void createCart(Cart cart) {
		
		HibernateUtil.getSession().save(cart);
		
	
	}
	



	@Override
	public void addItemToCart(Cart cart, Item item) {
		HibernateUtil.getSession().save(item);
	
			
	}

	@Override
	public void deleteItemFromCart(Cart cart, Item item) {
		HibernateUtil.getSession().delete(item);
		
	}
	
	
	@Override
	public Cart readCartByUser(User user) {	
		List<Cart> userCarts = HibernateUtil.getSession().createQuery("from Cart cart where user=:user orderby cart.CartId", Cart.class).setParameter("user",user).list();
	
		if (userCarts.size() < 1) {
			return null;
		}
		return userCarts.get(0);
 
	}




	@Override
	public void emptyCart(Cart cart) {
		
		
	}




	
	
	
		
}


