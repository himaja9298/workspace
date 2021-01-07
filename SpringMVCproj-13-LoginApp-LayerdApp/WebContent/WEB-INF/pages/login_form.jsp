<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h1 style="color: red; text-align: center">User Form</h1>
<frm:form modelAttribute="user">
	<table align="center" bgcolor="cyan">
		<tr>
			<td>Username</td>
			<td><frm:input path="uname" /></td>
		</tr>
		<tr>
			<td>Password</td>
			<td><frm:input path="pwd" /></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="validate" /></td>
		</tr>
	</table>
</frm:form>
<br><br>
<h1 style="color: blue; text-align: center">${ResultMsg}</h1>