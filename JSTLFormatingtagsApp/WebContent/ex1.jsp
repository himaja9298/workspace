<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="hi_US"/>
   <fmt:formatNumber var="fnumber" value="300000033" type="currency"/>
   Formated Number is::${fnumber}
   <hr>
   <jsp:useBean id="dt" class="java.util.Date"/>
   <fmt:formatDate var="fdate"  value="${dt}" type="both"/><br>
     Formated Date::${fdate}
   <hr>
   <fmt:setBundle basename="com/nt/commons/App"/>
     <fmt:message var="fmsg" key="wish.msg"/> 
     Message is:${fmsg}
     