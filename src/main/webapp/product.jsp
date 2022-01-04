<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import="java.sql.ResultSet"
 import ="com.stock.impl.*" import = "javax.servlet.http.HttpSession" %>   
 
    <%
    String pName=request.getParameter("pname");
    StockImpl stock=new StockImpl();
    
 ResultSet rs=stock.validateProduct(pName);   
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>product Details</title>
</head>

<body>
<form action="cart" method="post">
	<%if(rs.next()) { %>
            
            <label>Product Id :</label> <b><%=rs.getInt(1)%></b> <br>
            <label>Product Name :</label><%=rs.getString(2)%><br>
			<lable>Product Quantity :</lable><%=rs.getInt(3)%><br>
			<lable>Product Price :</lable><%=rs.getDouble(4)%><br>
			
			
			<% session.setAttribute("product id",rs.getInt(1) );
			session.setAttribute("price",rs.getDouble(4));
			session.setAttribute("productName", rs.getString(2));
			%>
      <%} %>  
       
      
       
       <lable>How much do you want to buy :</lable>
       <input type="number" name="quantity" id="quantity" ><br>
        <lable>Expected no of days :</lable>
       <input type="number" name="date" id="date" ><br>
             <button type="submit" >submit</button>
      
       </form>
</body>
</html>
