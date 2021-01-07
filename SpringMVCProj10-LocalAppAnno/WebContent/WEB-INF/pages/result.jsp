<%@ page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1 style="color: red; text-align: center">All ${operation}</h1>

<c:choose>
	<c:when test="${countries ne null && !empty countries}">
	<div style="float:left">
		<table align="center" bgcolor="pink">
		  
			<c:forEach var="country" items="${countries}">
			
				<tr>
					<td style="color: blue">${country}</td>
				</tr>
		 	</c:forEach>
		</table>
	</div><br><br>
		<%-- <b>countries count:${CountriesCount}</b>
 --%>	</c:when>
	<c:otherwise>
		<h1 style="color: red; text-align: center">No matching countries found</h1>
	</c:otherwise>
</c:choose>
<c:choose>
  <c:when test="${languages ne null && !empty languages}">
	<div style="float:center">
		<table align="center" bgcolor="pink">
		
			<c:forEach var="language" items="${languages}">
		      <tr>
					<td style="color: green">${language}</td>
				</tr>
		 	</c:forEach>
		</table>
	</div><br><br>
	<%-- 	<b>languages count:${languagesCount}</b> --%>
	</c:when>
	<c:otherwise>
		<h1 style="color: red; text-align: center">No matching countries found</h1>
	</c:otherwise>
  
</c:choose><br><br>

    <a href="welcome">Home</a>
