package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stockproject.dao.UserDao;
import com.stockproject.model.User;

/**
 * Servlet implementation class user
 */
@WebServlet("/Login1")
public class RegisterServlet extends HttpServlet {



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("hello");
		// TODO Auto-generated method stub
		String userName=request.getParameter("userName");
		String address=request.getParameter("address");
		String mail=request.getParameter("email");
		long mobNum=Long.parseLong(request.getParameter("mobileNumber"));
		String pass=request.getParameter("password");
		
		
		User us=new User(userName,address,mail,pass,mobNum);
		
		UserDao userDao=new UserDao();
		userDao.insert(us);
		
		
		
		
	
	}

}
