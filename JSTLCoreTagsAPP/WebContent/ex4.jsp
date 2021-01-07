<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- traditional for loop -->
<table border="1" bgcolor="cyan">
  <c:forEach var="i" begin="1" end="10" step="1">
    <tr bgcolor="green">
     <td>2*${i} =</td>
     <td>${2*i}</td>
  </c:forEach>
 </table>
 <hr>
 <!-- enhanced for loop-->
 <jsp:scriptlet>
   String names[]=new String[]{"raja","rani","jani","mahi"};
   request.setAttribute("nameList",names);
 </jsp:scriptlet>
 <c:forEach var="name" items="${nameList}">
   ${name}<br>  
 </c:forEach>
 <hr>
 <!-- nested for loop-->
 <c:forEach var="p" items="${paramValues}">
   param name::${p.key}<br>
   param values::
   <c:forEach  var="pv" items="${p.value}">
      ${pv}
   </c:forEach>
   <br>
 </c:forEach> 