package com.example.dao;

import java.util.List;

import com.example.models.User;

public interface UserDao {

	void userRegistration(User u);
	
	User userLogin(String username, String password);
	
	User readByUsername(String username);
	
	//Not sure if we need this
	//List<User> viewUserInformation();
	
	void updateUser(User u);

	


	

}
	

