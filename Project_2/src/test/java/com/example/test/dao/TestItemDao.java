package com.example.test.dao;

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
  public void createItem()
  {
    Item item = new Item();
    item.itemName = "juice";
    item.itemPrice = 1.99;
    
    itemDAO.createItem(item);

    List<Item> items = itemDAO.getAllItems();
    Assert.assertTrue("", items.size() > 0);
    Assert.assertEquals(item.itemName, items.get(items.size() -1).itemName);
    //itemDAO.removeUser(user);
  }
  
  
}