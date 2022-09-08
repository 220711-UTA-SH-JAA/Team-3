package com.example.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.ItemDao;
import com.example.dao.UserDao;
import com.example.models.Item;
import com.example.models.User;

@Service("UserServiceBean")
public class UserService {
    @Autowired
    private UserDao uDao;
	private ItemDao iDao;

    public UserService(UserDao uDao, ItemDao iDao) {
        this.uDao = uDao;
		this.iDao = iDao;
    }
    public List<User> printAllUsers() {
		List<User> allUsers = uDao.getAllUsers();
		return allUsers;
		
	}
    public User saveUser(User u) {
		
		
		uDao.createUser(u);
		
		User ret = uDao.getAllUsers().stream()
				.filter(User -> User.getUsername().equals(u.getUsername()))
				.findFirst().get();

		return ret;
	}
    public String login(String username, String password) {
		
		List<User> Users = uDao.getAllUsers();
		
		for(User u: Users) {
			if(u.getUsername().equals(username) && u.getPassword().equals(password)) {
				return u.getUsername();
			}
		}
		
		return null;
	}
    public User getByUsername(String username) {
		List<User> Users = uDao.getAllUsers();
		
		for(User u: Users) {
			if(u.getUsername().equals(username)) {
				return u;
			}
		}
		
		return null;
	}
	public List<Item> printAllItems() {
		List<Item> allItems = iDao.getAllItems();
		return allItems;
		
	}
	public Item saveItem(Item i) {
		
		
		iDao.createItem(i);
		
		Item ret = iDao.getAllItems().stream()
				.filter(Item -> Item.getItemName().equals(i.getItemName()))
				.findFirst().get();

		return ret;
	}
	

}
