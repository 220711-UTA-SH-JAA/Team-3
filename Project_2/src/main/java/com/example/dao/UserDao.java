/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.dao;

import java.util.List;

import com.example.models.User;

/**
 *

 */
public interface UserDao {

	
	
	
	List<User> getAllUsers();
    void createUser(User user);
    void updateUser(User user);
	void removeUser(User user);
   


}

