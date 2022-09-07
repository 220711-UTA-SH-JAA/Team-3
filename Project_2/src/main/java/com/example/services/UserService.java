package com.example.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.UserDao;
import com.example.models.User;

@Service("UserServiceBean")
public class UserService {
    @Autowired
    private UserDao uDao;

    public UserService(UserDao uDao) {
        this.uDao = uDao;
    }
    public void printAllUsers() {
		List<User> allUsers = uDao.getAllUsers();
		
		for(User u: allUsers) {
			System.out.println(u);
		}
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

}
