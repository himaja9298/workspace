<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!--  //read billAmount-->
<%float billAmt=Float.parseFloat(request.getParameter("bAmt"));
//calcuate discount
float discount=billAmt*0.3f;
//calculate final a,mnt
float finalAmount=billAmt-discount;%>
<!-- Display the details -->
<h1 style="color:red;text-alignm:center">From dicount.jsp--Bill Details are</h1>
<b>Item Name::<%=request.getParameter("iname")%></b>
<b>Item Price::<%=request.getParameter("iprice")%></b>
<b>Item Quantity::<%=request.getParameter("iqty")%></b>
Bill Amount::<%=billAmt%><br>
Discount Amount::<%=discount%>
Final BillAmount<%=finalAmount%><br><br><br>
<a href="item.html">Home</a>