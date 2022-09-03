package com.example.test.dao;

import java.util.ArrayList;
import java.util.List;

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
  public void testOrder()
  {
    User user = new User();
    user.firstName = "john";
    userDAO.createUser(user);
    Item item  = new Item();
    item.itemName = "juice";
    item.itemPrice = 2.00;
    itemDAO.createItem(item);
    List<Item> itemList = new ArrayList<Item>();
    itemList.add(item);
    Order order = new Order();
    order.userId = user.user_Id;
    order.items = itemList;
    orderDAO.createOrder(order);
    List<Order> orderList = orderDAO.getOrdersByUser(user);
    Order o = orderDAO.getOrderById(order.order_Id);
    Assert.assertEquals(order.items, o.items);
    Assert.assertEquals(1, orderList.size());
    
    
     
  
  }
}