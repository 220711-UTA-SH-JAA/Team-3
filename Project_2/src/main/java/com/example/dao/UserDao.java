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

	boolean loginUser(String username, String password);
	
	
	

    void createUser(User user);
	

}

