<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%//read form data
String name=request.getParameter("iname");
float price=Float.parseFloat(request.getParameter("iprice"));
float qty=Float.parseFloat(request.getParameter("iqty"));
//calculatebill amount
float billAmount=price*qty;
if(billAmount>=50000){%>
	<jsp:forward page="discount.jsp">
	  <jsp:param value="<%=billAmount%>" name="bAmt"/>
	</jsp:forward>
	<% }
else{
	%>
	<h1 style="color:red;text-align:"center">Bill Details</h1>
    <b>Item Name::<%=name%></b><br>
    <b>Item Price::<%=price%></b><br>
	 <b>Item Quantity::<%=qty%></b><br>
	 <b>Bill Amount::<%=billAmount%></b>
	 <%
	 }%>
	
