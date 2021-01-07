<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <c:choose>
   <c:when test="${param.p<0}">
     p is Negative
   </c:when>
   <c:when test="${param.p>0}">
     p  is Positive
   </c:when>
   <c:otherwise>
      p is  Zero 
   </c:otherwise>
 </c:choose>