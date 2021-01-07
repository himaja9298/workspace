<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm"%>
<h1 style="color: blue; text-align: center">Person Details Form</h1>
<frm:form modelAttribute="perFrm">
	<table align="center" bgcolor="pink">
		<tr>
			<td>Person Name</td>
			<td><frm:input path="name"/></td>
	    </tr>
		<tr>
			<td>Person Addrs</td>
			<td><frm:input path="addrs"/></td>
		</tr>
		<tr>
			<td>Person MobileNo</td>
			<td><frm:input path="mobileNo"/></td>
		</tr>
		<tr>
			<td>Person Gender</td>
			<td><frm:radiobuttons path="gender" items="${gendersList}"/></td>
		</tr>
		<tr>
			<td>Person Hobbies</td>
			<td><frm:checkboxes path="hobbies" items="${hobbiesList}"/></td>
		</tr>
		<tr>
			<td>Person Qualification</td>
			<td><frm:select path="qlfy" multiple="multiple">
			        <frm:options  items="${qlfyList}"/>
			</frm:select></td>
		</tr>
		<tr>
			<td>Person colors</td>
			<td><frm:select path="colors" multiple="multiple">
			        <frm:options items="${colorsList}"/>
			    </frm:select>
			 </td>
		</tr>
		<tr>
		  <td>Date Of Birth(dd-mm-yyyy)</td>
		  <td><frm:input type="date" path="dob"/></td>
		</tr>
		<tr>
		  <td>Date Of Joining(dd-mm-yyyy)</td>
		  <td><frm:input type="date" path="doj"/></td>
		</tr>
		<tr>
		   <td colspan="2"><input type="submit" value="register"/></td>
		<tr>
	</table>
</frm:form>