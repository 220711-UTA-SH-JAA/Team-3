package com.example.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.example.models.User;
import com.example.utils.HibernateUtil;

public class UserDaoHibernate implements UserDao {

	@Override
	public void userRegistration(User u) {
		//Hibernate has built in crud functionality, so we can create a user very easily
		
				//Get our session
				Session ses = HibernateUtil.getSession();
				
				//Start a transaction
				Transaction transaction = ses.beginTransaction();
				
				//Save the user
				ses.save(u);
				
				//Commit the user to the database
				transaction.commit();
			}
	
	@Override
	public User readByUsername(String username) {

		Session ses = HibernateUtil.getSession();
		
		//User u = ses.createNativeQuery("select * from users where username ='" + username + "'").;
		
		User u = ses.createQuery("from User where username=:username", User.class).setString("username", username).uniqueResult();

				
		return u;
	}
		
	

	@Override
	public User userLogin(String username, String password) {
		Session ses = HibernateUtil.getSession();
		
		User u = (User) ses.createNativeQuery("select * from users where username ='" + username + 
				"' select * from users where password ='" + password + "'");
		
		//User u = ses.createQuery("from User where username=:user_Username", User.class).setString("username\\\", user_username).uniqueResult();
		//User u = ses.createQuery("from User where password=:user_Password", User.class).setString("password\\\", user_password).uniqueResult();

				
		return u;
	}
	

	/*
	 * @Override public List<User> viewUserInformation() { // TODO Auto-generated
	 * method stub return null; }
	 */

	@Override
	public void updateUser(User u) {
		Session ses = HibernateUtil.getSession();
		
		Transaction transaction = ses.beginTransaction();
		
		ses.update(u);
		
		transaction.commit();
		
	}

	
	
}
