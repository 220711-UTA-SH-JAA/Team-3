/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.dao;


import com.example.models.User;

import java.util.List;


import org.hibernate.SessionFactory;
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
		// Session ses = HibernateUtil.getSession();

		// Transaction transaction = ses.beginTransaction();

		// ses.save(user);

		// transaction.commit();
		sessFact.getCurrentSession().save(user);

	}

	

	@Override
	public List<User> getAllUsers() {

		return sessFact.getCurrentSession().createQuery("from User", User.class).list();

	}

	@Override
	public void removeUser(User user) {
		sessFact.getCurrentSession().delete(user);
	}

	@Override
	public void updateUser(User user) {
		sessFact.getCurrentSession().update(user);
		
	}
}
