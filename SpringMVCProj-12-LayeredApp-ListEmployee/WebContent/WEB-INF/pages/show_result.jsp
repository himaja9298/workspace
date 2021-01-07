<%@ page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%-- <h3 style="color:red;text-align:center">${listDTO}</h3>
 --%>
<c:choose>
	<c:when test="${listDTO ne null && !empty listDTO}">
		<table border="1" align="center" bgcolor="cyan">
			<tr>
				<th>Eno</th>
				<th>Ename</th>
				<th>Desg</th>
				<th>Salary</th>
				<th>Deptno</th>
				<th colspan="2">Operations</th>
			</tr>
			<c:forEach var="dto" items="${listDTO}">
				<tr>
					<td>${dto.eno}</td> 
					<td>${dto.ename}</td>
					<td>${dto.desg}</td>
					<td>${dto.salary}</td>
					<td>${dto.deptno}</td>
					<td><a href="editEmp.htm?eno=${dto.eno}"><img src="images/edit.jpg" height="50" width="50"/></a></td>
					<td><a href="deleteEmp.htm?eno=${dto.eno}"><img src="images/delete.jpg" height="50" width="50"/></a></td>
      </tr>
			</c:forEach>
		</table>
	</c:when>
</c:choose><br><br>

<c:if test="${resultMsg ne null && !empty resultMsg}">
<marquee direction="right"><h3 style="color:red;text-align:center">${resultMsg}</h3></marquee>
</c:if>

<a href="saveEmp.htm"><img src="images/add.jpg" height="50" width="50"/></a>
&nbsp;&nbsp;<a href="welcome.htm"><img src="images/home.jpg" height="50" width="50"/></a>
&nbsp;&nbsp;<a href="javaScript:doPrint()"><img src="images/print.jpg" height="50" width="50"/></a>

<script language="javaScript">
     function doPrint(){
	    frames.focus();
	    frames.print();
     }
</script>