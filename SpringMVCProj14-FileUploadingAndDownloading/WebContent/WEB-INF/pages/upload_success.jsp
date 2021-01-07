<%@page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%-- <h1 style="color:red;text-align:center">Result Page</h1>
<h3 style="color:blue;text-align:center">${resumeFileName}<br><br>${photoFileName}</h3>
 --%>
<c:choose>
	<c:when test="${filesList ne null && !empty filesList}">
		<table align="center" bgcolor="pink">
		  	<c:forEach var="file" items="${filesList}">
				<tr>
					<td style="color: blue">${file}</td><td><a href="download?filename=${file}">download</a></td>
				</tr>                                       
		 	</c:forEach>
		</table>
	</c:when>
	<c:otherwise>
		<h1 style="color: red; text-align: center">No files found</h1>
	</c:otherwise>
</c:choose>
