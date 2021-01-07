<%@ page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<h3 style="color:red;text-align:center">${StudDTO}</h3>

<%-- <c:choose>
	<c:when test="${StudDTO ne null && !empty StudDTO}">
		<table border="1" align="center" bgcolor="cyan">
			<tr>
				<th>Sno</th>
				<th>Sname</th>
				<th>Sadd</th>
			</tr>
			<c:forEach var="dto" items="${StudDTO}">
				<tr>
					<td>${dto.sno}</td> 
					<td>${dto.sname}</td>
					<td>${dto.saddrs}</td>
      </tr>
			</c:forEach>
		</table>
	</c:when>
</c:choose>
 --%>