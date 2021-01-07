<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="msg" value="Hello how are u ?" scope="request"/>
<c:forTokens var="str" items="${msg}" delims=" ">${str}<br>
</c:forTokens> 
