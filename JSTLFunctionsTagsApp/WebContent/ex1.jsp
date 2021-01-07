<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<c:set var="msg" value="Hello,how are u?"/>
UpperCase:::${fn:toUpperCase(msg)}<br>
LowerCase:::${fn:toLowerCase(msg)}<br>
Length::${fn:length(msg)}<br>
Substring::${fn:substring(msg,0,5)}<br>
