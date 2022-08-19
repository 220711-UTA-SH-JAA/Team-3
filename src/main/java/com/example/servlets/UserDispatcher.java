package com.example.servlets;

import java.io.IOException;

import javax.servlet.ServletException;

import com.example.controllers.UserController;


public class UserDispatcher {

	
	public static void process(javax.servlet.http.HttpServletRequest request,
			javax.servlet.http.HttpServletResponse response)  throws IOException {
			
			//Here, we would pass the requests and responses onto the correct controllers
			System.out.println("In the servlet dispatcher with URI: " + request.getRequestURI());
			
			//We will switch/determine which controller to call based on the uri
			switch(request.getRequestURI()) {
				case "/EcommerceApp/api/registration/employee":
					System.out.println("Call the controller to handle the register logic");
					UserController.employeeRegistration(request, response);
					break;
				case "/EcommerceApp/api/employeeLogin":
					System.out.println("Call the controller to handle the login logic");
					UserController.employeeLogin(request, response);
					break;
				/*
				 * case "/ERAPI/api/auth/login":
				 * System.out.println("We would store the users info in a session");
				 * EmployeeSessionController.createSession(request, response);
				 * System.out.println("HEY"); break; case "/ERAPI/api/session/employee/create":
				 * System.out.println("We would store the users info in a session");
				 * EmployeeSessionController.createSession(request, response); break; case
				 * "/ERAPI/api/session/employee/check": System.out.
				 * println("Call the session controller to handle the session authentication logic"
				 * ); EmployeeSessionController.checkSession(request, response); break;
				 */
				}
	
}
	
}
