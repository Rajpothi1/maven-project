package com.stockproject.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.impl.UserDaoInterface;
import com.stockproject.model.Stock;
import com.stockproject.model.User;

public class UserDao implements UserDaoInterface {

	
	public  void insert(User users)  {
		Connection con;
		try {
			con = ConnectionUtil.gbConnection();
String query="insert into users(user_name,email,address,password,phonenumber)values(?,?,?,?,?)";
			
			PreparedStatement pstmt = null;
		
				pstmt = con.prepareStatement(query);
				pstmt.setString(1, users.getUserName());
				pstmt.setString(2, users.getEmail());
				pstmt.setString(3, users.getAddress());
				pstmt.setString(4, users.getPassword());
				pstmt.setLong(5, users.getPhoneNumber());
				int i=pstmt.executeUpdate();
				System.out.println("Register success");
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
					
	}

	public   int validateUser(User us)   {
		User user=null;
	String	emailid=null;
	String	password=null;
		ConnectionUtil connect=new ConnectionUtil();
		int i=0;
		try {
			
			
		
				Connection con = null;
				try {
					con = connect.gbConnection();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			System.out.println("hello"+us.getEmail()+" "+us.getPassword());
			String query="select * from users where email='"+us.getEmail()+"' and password='"+us.getPassword()+"'";
			
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(query);
			if(rs.next())
			{	
				i=1;
				System.out.println("hi"+i);
			user=new User(rs.getInt(1),rs.getString(2), emailid,password);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(" statement error");
		}
		System.out.println(i);
		// TODO Auto-generated method stub
		return i;
	}
	
	public void updated(User userupdate) {

		String updateQuery = "update users set  password=? where phonenumber=?";

		Connection con;
		try {
			con = ConnectionUtil.gbConnection();
			PreparedStatement pstmt = con.prepareStatement(updateQuery);

			pstmt.setString(1, userupdate.getPassword());
			pstmt.setLong(2, userupdate.getPhoneNumber());
			int i = pstmt.executeUpdate();
			System.out.println(i + "updated");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

	public void delete(User userdelete) {

		String deleteQuery = "delete from users where  email=?";

		Connection con;
		try {
			con = ConnectionUtil.gbConnection();
			PreparedStatement pstmt = con.prepareStatement(deleteQuery);

			pstmt.setString(1, userdelete.getEmail() );
			int i = pstmt.executeUpdate();
			System.out.println(i + "delete");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
}

	
	

