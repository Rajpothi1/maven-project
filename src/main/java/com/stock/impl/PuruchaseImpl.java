package com.stock.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.stock.model.Purchase;
import com.stock.util.ConnectionUtil;

public class PuruchaseImpl {
public void insert(Purchase purchase) throws SQLException, ClassNotFoundException {
		String updateQuery="update users set wallet=(select wallet from users where user_id=?)-? where user_id=?";
		String insertQuery="insert into purchases_list (product_id,user_id,product_name,quantity,total_price )values (?,?,?,?,?)";
		
		Connection con=ConnectionUtil.gbConnection();
		PreparedStatement pstmt1= con.prepareStatement(updateQuery);
		pstmt1.setInt(1, purchase.getUserId());
		pstmt1.setDouble(2, purchase.getTotalPrice());
		pstmt1.setInt(3, purchase.getUserId());
		int j=pstmt1.executeUpdate();
		System.out.println("updated"+j);
		
		PreparedStatement pstmt= con.prepareStatement(insertQuery);
		pstmt.setInt(1, purchase.getProductId());
		pstmt.setInt(2, purchase.getUserId());
		pstmt.setString(3, purchase.getProductName());
		pstmt.setInt(4, purchase.getOrderQty());
		pstmt.setDouble(5, purchase.getTotalPrice());
		//pstmt.setDate(5, new java.sql.Date( purchase.getOrderDate().getTime()));
		int i=pstmt.executeUpdate();
		System.out.println(i+ "inserted");
		pstmt.close();
		con.close();
	}

public void updated(Purchase purchase1 ) throws SQLException, ClassNotFoundException {
		
		String insertQuery="update purchases set product_name=? where user_id=?";
		Connection con=ConnectionUtil.gbConnection();
		
		PreparedStatement pstmt= con.prepareStatement(insertQuery);
	
	     pstmt.setString(1, purchase1.getProductName());
         pstmt.setInt(2, purchase1.getUserId());
   	     int i=pstmt.executeUpdate();
	     System.out.println(i+"updated");
	
}
	
	public void delete(Purchase  purchase2) throws SQLException, ClassNotFoundException {
	
	String deleteQuery="delete from purchases where  product_name=?";
	
	Connection con=ConnectionUtil.gbConnection();
	PreparedStatement pstmt= con.prepareStatement(deleteQuery);

	pstmt.setString(1, purchase2.getProductName());
	int i=pstmt.executeUpdate();
	System.out.println(i+"delete");
	}
	
	public ResultSet showPurchase() {
		String showquery = "select * from purchases_list";
		Connection con;
		ResultSet rs=null;
		try {
			con = ConnectionUtil.gbConnection();
			Statement stmt = con.createStatement();
			rs = stmt.executeQuery(showquery);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rs;
	}

		
		


}

