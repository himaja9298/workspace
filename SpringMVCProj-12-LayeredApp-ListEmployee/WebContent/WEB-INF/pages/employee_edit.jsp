<%@taglib uri="http://www.springframework.org/tags/form"  prefix="frm"%>
<h1 style="color:blue;text-align:center"> Employees Editing page </h1>
<script language="JavaScript" src="js/validation.js">
</script>
<frm:form  modelAttribute="employee" onsubmit="return validate(this)">
   <table align="center" bgcolor="pink" >
      <tr>
        <td>Employee name :: </td>
        <td> <frm:input path="ename"/><frm:errors path="ename" cssClass="text-danger"/><span id="enameId"></span></td>
      </tr>
      <tr>
        <td>Employee desg :: </td>
        <td> <frm:input path="desg"/><frm:errors path="desg" cssClass="text-danger"/><span id="desgId"></span></td>
      </tr>
      <tr>
        <td>Employee salary :: </td>
        <td> <frm:input path="salary"/><frm:errors path="salary" cssClass="text-danger"/><span id="salaryId"></span></td>
      </tr>
      <tr>
        <td>Employee deptno :: </td>
        <td>  <frm:select path="deptno">
                    <frm:options items="${deptInfo}"/>
             </frm:select> 
        
             </td>  
      </tr>
      <tr>
		   <td><frm:hidden path="vflag"/></td>
		</tr>
      <tr>
        <td colspan="2" > <input type="submit"  value="update Employee"> </td> 
      </tr>
      
   </table>
</frm:form>
 