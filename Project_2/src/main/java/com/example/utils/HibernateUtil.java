package com.example.utils;


import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	
	
	private static Session ses = null;
	
	public static Session getSession() {
		
		if(ses == null) {
			try {
				
				//Configuration class
				Configuration cfg = new Configuration();
				//Load in the properties from the xml file
				cfg.configure("hibernate.cfg.xml");
				
				//Set the environment variable settings
				cfg.setProperty("hibernate.connection.username", System.getenv("DB_USERNAME"));
				cfg.setProperty("hibernate.connection.password", System.getenv("DB_PASSWORD"));
				cfg.setProperty("hibernate.connection.url", (System.getenv("DB_URL") + "/gamedb"));
				
				//Build the session factory
				SessionFactory sf = cfg.buildSessionFactory();
				ses = sf.openSession();
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		
		return ses;
	}

}