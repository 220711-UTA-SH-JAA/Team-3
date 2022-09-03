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
    item.itemPrice = 2.00;
    /*System.out.println(items);
    for (int i = 0; i < items.size() - 1; i++) {
    		itemDAO.deleteItem(items.get(i));
    		System.out.println(items.get(i));
    		System.out.println(items);
    	}*/
    itemDAO.createItem(item);
    //System.out.println(items);
    List<Item> items = itemDAO.getAllItems();
    Item Item2 = new Item();
    Item2 = itemDAO.selectItemByName(item.itemName);
    Assert.assertEquals(Item2.itemName, "juice");
    Item Item3 = new Item();
    
    Item3 = itemDAO.getItemById(item.itemId);
    Assert.assertEquals(Item3.itemName, "juice");
    
    Item3.itemName = "testing";
    itemDAO.updateItem(Item3);
    Assert.assertEquals(Item3.itemName, "testing");
    //Assert.assertTrue("", items.size() > 0);
    Assert.assertEquals(Item3.itemName, items.get(items.size() -1).itemName);
    itemDAO.deleteItem(Item3);
    //Assert.assertEquals(0 , items.size());
    
  }
  
  
}