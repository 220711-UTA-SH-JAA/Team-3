package com.example.test.dao;

import java.util.Date;
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
import com.example.dao.UserDao;
import com.example.dao.UserDaoHibernate;
import com.example.models.Item;
import com.example.models.User;
 

@ContextConfiguration(locations = "classpath:application-context-test.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class TestItemDao 
{
   
  private ItemDao itemDAO = new ItemDaoHibernate();
   
  @Test
  @Transactional
  @Rollback(true)
  public void testCreateItem()
  {
	String timeStr = new Date().toString();
    Item item = new Item();
    item.itemName = timeStr;
    item.itemPrice = 2.00;
 
    itemDAO.createItem(item);

    List<Item> items = itemDAO.getAllItems();
    Item item2 =items.get(items.size() -1);
   
    Assert.assertEquals(item2.itemName, timeStr);
    Assert.assertEquals(item2.itemPrice, 2.00, 0);
    
  }
  
  @Test
  @Transactional
  @Rollback(true)
  public void testGetItemById()
  {
	
   Item item = itemDAO.getItemById(21);

    Assert.assertEquals(item.itemName, "juice");
    
  }
  
  @Test
  @Transactional
  @Rollback(true)
  public void testGetItemByName()
  {
	
   Item item = itemDAO.getItemByName("Mon Sep 05 10:28:31 EDT 2022");

    Assert.assertEquals(item.itemId, 23, 0);
    
  }
  
}