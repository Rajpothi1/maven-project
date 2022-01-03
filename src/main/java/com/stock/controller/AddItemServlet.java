package com.stock.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stock.impl.StockImpl;
import com.stock.model.Stock;
@WebServlet("/additemservlet")
public class AddItemServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String proname=req.getParameter("proname");
		
		int quantity=Integer.parseInt(req.getParameter("quantity"));
		
		double price=Double.parseDouble(req.getParameter("price"));
		
		Stock stock=new Stock(proname,quantity,price);
		System.out.println(proname+quantity+price);
		StockImpl sdao=new StockImpl();
		sdao.insert(stock);
		resp.sendRedirect("stockItemsadmin.jsp");
	}
}
