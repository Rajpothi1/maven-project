<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import="java.sql.ResultSet"
 import ="com.stock.impl.*" import = "javax.servlet.http.HttpSession" %>   
 
    <%
    String pName=request.getParameter("pname");

    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>purchase</title>
</head>
<body>
<form action="purchase" method="post">
	<%int user_id=Integer.parseInt(session.getAttribute("user id").toString());
    String productName=session.getAttribute("productName").toString();
	CartImpl cimpl=new CartImpl();
    ResultSet rs=  cimpl.allcart(user_id);
	if(rs.next()) { %>
            
          
            <label>Product Id :</label> <input type="text" name="prodid" value="<%=rs.getInt(3)%>" ><br>
            
            <label>user Id :</label> <b><%=rs.getInt(2)%></b> <br>
            <label>Product Name :</label><%=productName%><br>
			<lable>Product Quantity :</lable><%=rs.getInt(4)%><br>
			<lable>total Price :</lable><%=rs.getDouble(5)%><br>
			<% session.setAttribute("product id",rs.getInt(3) );
			session.setAttribute("price",rs.getDouble(5));
			session.setAttribute("productname",productName );
			session.setAttribute("quantity", rs.getInt(4));
			
			
			
			
			%>
       <%} %> 
       
      
       

       
       <button type="submit" >confirm</button>
       </form>


</body>
</html>