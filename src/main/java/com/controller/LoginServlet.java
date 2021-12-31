package com.controller;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.stockproject.dao.StackDao;
import com.stockproject.dao.UserDao;
import com.stockproject.model.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login1")
public class LoginServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("login");
		String mail=request.getParameter("email");
		String pass=request.getParameter("password");
		System.out.println();
		User us=new User(mail,pass);
		
		UserDao userDao=new UserDao();
		int i=userDao.validateUser(us);
		System.out.println(i);
		if(i>0) {
			StackDao stackdao= new StackDao();
			ResultSet rs=stackdao.showProduct();
			HttpSession session=request.getSession();
			session.setAttribute("showProduct", rs);
			response.sendRedirect("stock items.jsp");
			
		}
		else {
			response.sendRedirect("register.jsp");
		}
		

		
		
		
		
	}

}
