<%@ page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h3 style="color:blue;text-align:center">Wish Message---->${wmsg}</h3>
<h3 style="color:red;text-align:center">Date and Time---->${sysdate}</h3>


<%-- <b>Names Info</b><br><br>
<c:forEach var="name" items="${namesInfo}">
    ${name}<br>
</c:forEach>
<hr>
<c:forEach var="fruit" items="${fruitsInfo}">
    ${fruit}<br>
</c:forEach>
<hr>
<c:forEach var="phone" items="${phonenumsInfo}">
    ${phone}<br>
</c:forEach>
<hr>
<c:forEach var="age" items="${ageInfo}">
    ${age}<br>
</c:forEach>
 --%>

<%-- <h3 style="color:red;text-align:center">${StudDTO}</h3> --%>

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