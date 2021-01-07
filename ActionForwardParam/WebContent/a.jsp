<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<h3 style="color:red;text-align:center">Start of a.jsp</h3>
<jsp:forward page="b.jsp">
  <jsp:param value="val1" name="p1"/>
  <jsp:param value="val2" name="p2"/>
 </jsp:forward>
<h3 style="color:red;text-align:center">End of a.jsp</h3>