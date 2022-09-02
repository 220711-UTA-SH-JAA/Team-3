/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.dao;

import com.example.models.Item;
import com.example.models.User;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.example.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *

 */
@Transactional
@Repository("UserDaoBean")
public class UserDaoHibernate implements UserDao {
	private SessionFactory sessFact;
	
	
	
	@Autowired
	public UserDaoHibernate(SessionFactory sessFact) {
		this.sessFact = sessFact;
	}
	
	@Override
	public void createUser(User user) {
		// Builtin save method from hibernate
		Session ses = HibernateUtil.getSession();

		Transaction transaction = ses.beginTransaction();

		ses.save(user);

		transaction.commit();

	}

	@Override
	public boolean loginUser(String username, String password) {
		// TODO Auto-generated method stub

		List<User> users = sessFact.getCurrentSession().createQuery("from user where username=:username and password=:password", User.class)
				.setParameter("username", username).setParameter("password", password).list();

		if (users.size() < 1) {
			return false;
		}
		return true;
	}
}
