package com.example.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import com.example.dao.UserDaoHibernate;
import com.example.models.User;
import com.example.service.UserService;
import com.example.utils.HibernateUtil;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

public class UserController {

	UserService userService = new UserService(new UserDaoHibernate());
	
	public static void employeeLogin(HttpServletRequest req, HttpServletResponse res) {
		
	}
	
	public static void employeeRegistration(HttpServletRequest req, HttpServletResponse res) throws JsonParseException, JsonMappingException, IOException {
		
		/*
		RegisterObject ro = om.readValue(req.getInputStream(), RegisterObject.class);
		
		System.out.println(ro);
		
		User registered = userService.registerUser(ro.firstName, ro.lastName, ro.email, ro.username, ro.password);
		
		res.setStatus(201);
		res.getWriter().write(om.writeValueAsString(registered));
		*/
		Session ses = HibernateUtil.getSession();
		System.out.println(ses.save(new User("Ethan", "McGill", "email", "username", "password")));
	}
	
	public static void getAccounts(HttpServletRequest req, HttpServletResponse res) {
		
	}

}
	
