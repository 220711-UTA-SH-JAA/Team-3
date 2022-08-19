package com.example.service;

import com.example.dao.UserDao;
import com.example.exception.InvalidCredentialsException;
import com.example.models.User;

public class UserService {

	private UserDao userDao;
	//private TicketService ticketService;
		

		public UserService(UserDao userDao) {
			this.userDao = userDao;
			
		}
		/*
		 * 
		 * public EmployeeService(TicketService ticketService) { this.ticketService =
		 * ticketService; }
		 */

		public User userRegistration(String firstName, String lastName, String email,
				  String username,  String password) {
			try {
				User u = new User(firstName, lastName, email, username, password);
				userDao.userRegistration(u);
				return userDao.readByUsername(username);
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}
		
		public User userLogin (String username, String password) throws InvalidCredentialsException {
			if(username.equals("emcgill") && password.equals("password")) {
				return new User("Ethan", "McGill", "email@email.com", username, password);
			}
				
				throw new InvalidCredentialsException();
			
		}	
		
		public User updateUser(User u, String firstName, String lastName, String email,
				  String username,  String password) {
			if(!firstName.equals("")) {
				u.setLastName(firstName);
			}
			
			if(!lastName.equals("")) {
				u.setLastName(lastName);
			}
			
			if(!email.equals("")) {
				u.setEmail(email);
			}
			if(!username.equals("")) {
				u.setUsername(username);
			}
			
			
			if(!password.equals("")) {
				u.setPassword(password);
			}
			
			userDao.updateUser(u);
			
			return u;
		}
		
	}
		
		
	

