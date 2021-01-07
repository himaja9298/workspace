<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!-- to create or locate java bean class object -->
<jsp:useBean id="cb" class="com.nt.beans.CustomerBean" scope="session"/>
<!-- set values to bean properties -->
<%-- <jsp:setProperty property="cno" name="cb" value="1001"/>
<jsp:setProperty property="cname" name="cb" value="raja"/>
<jsp:setProperty property="cadd" name="cb" value="hyd"/>
<jsp:setProperty property="billAmt" name="cb" value="5000"/> --%>

<!-- set form data bean values by specifying request param names by using param attribute -->
<%-- <jsp:setProperty property="cno" name="cb" param="cNo"/>
<jsp:setProperty property="cname" name="cb" param="cName"/>
<jsp:setProperty property="cadd" name="cb" param="cAdd"/>
<jsp:setProperty property="billAmt" name="cb" param="bAmt"/> --%>

<jsp:setProperty property="*" name="cb"/>
<h1 style="color:red;text-align:center">Values have setted</h1>