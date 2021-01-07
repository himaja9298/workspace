<%@ page language="java" import="java.util.*" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<h3 style="color:red;text-align:center">Start of b.jsp</h3>
<center><%=new java.util.Date()%></center><br>
p1 param value:::<%=request.getParameter("p1")%>
p2 param value:::<%=request.getParameter("p2")%>
<h3 style="color:red;text-align:center">End of b.jsp</h3>