package com.stock.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stock.impl.UserImpl;
import com.stock.model.User;

/**
 * Servlet implementation class user
 */
@WebServlet("/reg")
public class RegisterServlet extends HttpServlet {



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("hello");
		// TODO Auto-generated method stub
		String userName=request.getParameter("userName");
		String address=request.getParameter("address");
		String mail=request.getParameter("email");
		long mobNum=Long.parseLong(request.getParameter("mobileNumber"));
		String pass=request.getParameter("password");
		
		
		User us=new User(userName,mail,address,pass,mobNum);
		
		UserImpl userDao=new UserImpl();
		userDao.insert(us);
		
		response.sendRedirect("index.jsp");
		
		
		
	
	}

}
