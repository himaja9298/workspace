<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="p" value="${param.ss}" scope="request"/> 
<c:url var="googleUrl" value="https://www.google.com/search?q=${p}" scope="request"/>

<b> from ex6.jsp</b>
<c:redirect url="${googleUrl}"/>