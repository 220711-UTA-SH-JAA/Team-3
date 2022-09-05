package com.example.test.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.CartDao;
import com.example.dao.CartDaoHibernate;
import com.example.dao.ItemDao;
import com.example.dao.ItemDaoHibernate;
import com.example.dao.OrderDaoHibernate;
import com.example.dao.UserDao;
import com.example.dao.OrderDao;
import com.example.dao.UserDaoHibernate;
import com.example.models.Cart;
import com.example.models.Item;
import com.example.models.Order;
import com.example.models.User;


@ContextConfiguration(locations = "classpath:application-context-test.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class TestCartDao 
{
   
  private UserDao userDAO = new UserDaoHibernate();
  public ItemDao itemDAO = new ItemDaoHibernate();
  public OrderDao orderDAO = new OrderDaoHibernate();
  public CartDao cartDAO = new CartDaoHibernate();
  
  @Test
  @Transactional
  @Rollback(true)
  public void testCreateCart()
  {
    User user = userDAO.getAllUsers().get(0);
    
    Cart cart = new Cart();
    //order.order_Id = new Random().nextInt();
    cart.user = user;  //user.user_Id;
    cart.items = itemDAO.getAllItems();
    cartDAO.createCart(cart);
   
    Cart cart1 = cartDAO.getCartByUser(user);
    Assert.assertEquals(cart1.items.size(), cart.items.size());
  }
  
  

}