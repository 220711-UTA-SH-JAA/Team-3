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

import com.example.dao.ItemDao;
import com.example.dao.ItemDaoHibernate;
import com.example.dao.OrderDaoHibernate;
import com.example.dao.UserDao;
import com.example.dao.OrderDao;
import com.example.dao.UserDaoHibernate;
import com.example.models.Item;
import com.example.models.Order;
import com.example.models.User;


@ContextConfiguration(locations = "classpath:application-context-test.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class TestOrderDao 
{
   
  private UserDao userDAO = new UserDaoHibernate();
  public ItemDao itemDAO = new ItemDaoHibernate();
  public OrderDao orderDAO = new OrderDaoHibernate();
  
  @Test
  @Transactional
  @Rollback(true)
  public void testCreateOrder()
  {
    User user = userDAO.getAllUsers().get(0);
    
    Order order = new Order();
    //order.order_Id = new Random().nextInt();
    order.user = user;  //user.user_Id;
    order.items = itemDAO.getAllItems();
    orderDAO.createOrder(order);
   
    List<Order> orders = orderDAO.getOrdersByUser(user);
    Assert.assertEquals("", true, orders.size() > 0);
  }
  
  @Test
  @Transactional
  @Rollback(true)
  public void testGetOrderById()
  {

    Order order = orderDAO.getOrderById(12);
    Assert.assertEquals(order.user.user_Id, 9, 0);
  }

}