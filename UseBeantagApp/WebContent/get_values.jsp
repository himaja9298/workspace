<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!-- to create or locate java bean class object -->
<jsp:useBean id="cb" class="com.nt.beans.CustomerBean" scope="session"/>
<!-- get values to bean properties -->
<jsp:getProperty name="cb" property="cno"/>
<jsp:getProperty name="cb" property="cname"/>
<jsp:getProperty name="cb" property="cadd"/>
<jsp:getProperty name="cb" property="billAmt"/>
<h1 style="color:red;text-align:center">Values have setted</h1>