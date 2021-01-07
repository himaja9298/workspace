<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!-- Create or Locate DTO class object-->
<jsp:useBean id="dto" class="com.nt.dto.EmployeeDTO" scope="request"/>

<!-- create or locate service class object-->
<jsp:useBean id="service" class="com.nt.service.SalartReportMgmtServiceImpl" scope="application"/>

<!-- set form data to DTO class object properties-->
<jsp:setProperty property="*" name="dto"/>

<%
//call b.method of service class
service.generateReport(dto);
%>
<h1 style="color:red;text-align:center">Employee Details are</h1>
<b>Employee Name::<jsp:getProperty name="dto" property="ename"/><br>
<b>Employee Address::<jsp:getProperty name="dto" property="eadd"/></b></b>
<b>Employee basic salary::<jsp:getProperty name="dto" property="basicSalary"/><br></b>
<b>Employee gross salary::<jsp:getProperty name="dto" property="grossSalary"/><br></b>
<b>Employee net salary::<jsp:getProperty name="dto" property="netSalary"/><br></b>

<!-- add home hyperlink -->
<a href="input.html">Home</a>