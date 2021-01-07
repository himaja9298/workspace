<%@taglib uri="http://www.springframework.org/tags/form" prefix="frm"%>
<h1 style="color: red; text-align: center">Employees Registration
	page</h1>
<script language="JavaScript" src="js/validation.js">
	
</script>
<frm:form modelAttribute="empFrm" onsubmit="return validate(this)">
	<table align="center" bgcolor="cyan">
		<tr>
			<td>Employee name ::</td>
			<td><frm:input path="ename" />
				<frm:errors cssClass="text-danger" path="ename" /><span id="enameId"></span></td>

		</tr>
		<tr>
			<td>Employee desg ::</td>
			<td><frm:input path="desg" />
				<frm:errors cssClass="text-danger" path="desg" /><span id="desgId"></span></td>

		</tr>
		<tr>
			<td>Employee salary ::</td>
			<td><frm:input path="salary" />
				<frm:errors cssClass="text-danger" path="salary" /><span id="salaryId"></span></td>

		</tr>
		<tr>

			<td>Employee deptno ::</td>
			<td><frm:select path="deptno">
					<frm:options items="${deptInfo}" />
				</frm:select></td>
		</tr>
		<tr>
		   <td><frm:hidden path="vflag"/></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="Register"></td>
		</tr>

	</table>
</frm:form>
