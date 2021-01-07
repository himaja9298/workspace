<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!-- create or locate service class object-->
<jsp:useBean id="service" class="com.nt.service.RotatorService" scope="application"/>
<%
//call b.method
service.nextAdvertisement();
//enable auto refresh for the webpage
response.setIntHeader("refresh",3);
%>
<!-- display advertisement-->
<div style="text-align:center">
  <a href="<jsp:getProperty property="link" name= "service"/>"><img src="<jsp:getProperty property="image" name="service"/>" align="center" width="400" height="200"/></a>
</div><br><br>
<p style="color:red;text-align:center">This is rest of the page having main content of the webpage</p>
