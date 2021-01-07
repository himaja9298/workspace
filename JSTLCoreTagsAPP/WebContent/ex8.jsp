<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <c:catch var="e">
       <jsp:scriptlet>
       java.util.Date d=null;
       out.println("year is:"+d.getYear());
       </jsp:scriptlet>
     </c:catch>
     <c:if test="${!empty e}">
      exception is:::${e}
      </c:if>