<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<h1 style="color: blue; text-align: center"><spring:message code="person.title"/></h1>
<frm:form modelAttribute="perFrm">
	<table align="center" bgcolor="pink">
		<tr>
			<td><spring:message code="person.name"/></td>
			<td><frm:input path="name"/></td>
	    </tr>
		<tr>
			<td><spring:message code="person.addrs"/></td>
			<td><frm:input path="addrs"/></td>
		</tr>
		<tr>
			<td><spring:message code="person.mobileNo"/></td>
			<td><frm:input path="mobileNo"/></td>
		</tr>

		<tr>
		   <td colspan="2"><input type="submit" value="<spring:message code="person.submit.cap"/>"/></td>
		<tr>
	</table>
</frm:form>
<h3 style="color:pink;text-align:center">
<a href="?lang=fr_FR">French</a>&nbsp;&nbsp;<a href="?lang=de_DE">German</a>&nbsp;&nbsp;
<a href="?lang=hi_IN">Hindi</a>&nbsp;&nbsp;<a href="?lang=zh_CN">Chinese</a>&nbsp;&nbsp;
<a href="?lang=en_US">English</a>&nbsp;&nbsp;</h3>
<fmt:setLocale value="${response.locale}"/>

<jsp:useBean id="dt" class="java.util.Date"/>
<fmt:formatDate var="fdt" value="${dt}" dateStyle="FULL" type="both"/><br><br>
<h3 style="color:blue;text-align:center">Formated Date::${fdt}</h3>

<fmt:formatNumber var="fno" value="1234567478954032" type="currency"/>
<h3 style="color:blue;text-align:center">Formated Number::${fno}</h3>

