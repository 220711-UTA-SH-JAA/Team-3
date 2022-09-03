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

import com.example.dao.UserDao;
import com.example.dao.UserDaoHibernate;
import com.example.models.User;
 

@ContextConfiguration(locations = "classpath:application-context-test.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class TestUserDao 
{
   
  private UserDao userDAO = new UserDaoHibernate();
   
  @Test
  @Transactional
  @Rollback(true)
  public void testCreateUser()
  {
    User user = new User();
    user.firstName = "john";
    userDAO.createUser(user);
     
    List<User> users = userDAO.getAllUsers();
    Assert.assertTrue("", users.size() > 0);
    Assert.assertEquals(user.firstName, users.get(users.size() -1).firstName);
    userDAO.removeUser(user);
  }
  
  
  @Test
  @Transactional
  @Rollback(true)
  public void testLoginUser()
  {
    User user = new User();
    user.username = "john";
    user.password = "pwd";
    userDAO.createUser(user);
     
    Assert.assertTrue("", userDAO.loginUser(user.username, user.password));
    
    userDAO.removeUser(user);
  }
}