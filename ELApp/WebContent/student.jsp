<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<h1 style=color:red;text-align:center>Student Form</h1>
<form action="controller" method="POST">
<table align="center" bgcolor="cyan">
  <tr> 
      <td>Student name</td>
      <td><input type="text" name="sname"></td>
  </tr>
  <tr>
      <td>Student course</td>
      <td><input type="checkbox" name="scrs" value="java">Java
          <input type="checkbox" name="scrs" value=".net">.Net
          <input type="checkbox" name="scrs" value="python">Python
          <input type="checkbox" name="scrs" value="Devops">Devops</td>
   </tr>
   <tr>
      <td colspan="2"><input type="submit" value="Submit">
                      <input type="reset" value="Reset">
   </tr>
 </table>
</form>
<jsp:include page="ELObjects1.jsp"/>
    