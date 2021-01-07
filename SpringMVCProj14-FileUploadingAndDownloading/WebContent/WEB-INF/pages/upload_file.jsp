<%@taglib uri="http://www.springframework.org/tags/form" prefix="frm"%>
<h1 style="color:blue;text-align:center">JobSeeker Registration Form</h1>
<frm:form modelAttribute="jFrm" enctype="multipart/form-data">
	<table align="center" bgcolor="pink">
		<tr>
			<td>Name::</td><td><frm:input path="name" /></td>
		</tr>
		<tr>
			<td>Address::</td><td><frm:input path="addrs" /></td>
		</tr>
		<tr>
			<td>Resume::</td><td><input type="file" name="resume" /></td>
		</tr>
		<tr>
			<td>Photo::</td><td><input type="file" name="photo" /></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="register" /><input type="reset" value="cancel" /></td>
			
		</tr>
			
		
	</table>
</frm:form>
