<%@ page import="java.sql.*" %>
<%!//declare variables
   String pname=null,pval=null;
   int pprice=0;
   int pquant=0;
   
  %>
 <% 
    //read input params
	 pname=request.getParameter("pname");
	 pprice=Integer.parseInt(request.getParameter("pprice"));
	 pquant=Integer.parseInt(request.getParameter("pquant"));
	 %>
	<center>Product Name::<%=pname%><br>
	 Product Price::<%=pprice%><br>
	 Product Quantity::<%=pquant%><br></center>
	
	 
	
	 
 


   