<%@ page isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="frm"%>
<h1 style="color:red;text-align:center">Stuent Form</h1>
<frm:form action="register" method="POST" modelAttribute="student">
	<table align="center" bgcolor="cyan">
		<tr>
			<td>Student no::</td>
			<td><frm:input path="sno" /></td>
		</tr>
		<tr>
			<td>Student name::</td>
			<td><frm:input path="sname" /></td>
		</tr>
		<tr>
			<td>Student addrs::</td>
			<td><frm:input path="sadd" /></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="registerStudent" /></td>
		</tr>
	</table>


</frm:form>