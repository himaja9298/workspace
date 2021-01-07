<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- create scope data -->
<c:set var="msg" value="welcome" scope="request"/>
<!-- display scope data -->
value::<c:out value="${msg}"/><br>
value::${requestScope.msg}<br>
value::${msg}<br>
<!-- remove data from scope-->
<c:remove var="msg" scope="request"/>
<!-- dispaly scope data-->
value::<c:out value="${msg}"/><br>
value::${requestScope.msg}<br>
Value::${msg}<br>