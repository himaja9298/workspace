<h1 style="color:red;text-align:center"></h1>
<form action="Servlet1" method="POST">   
   <table bgcolor="cyan" align="center">
     <tr>
       <td>Person Name::</td>
       <td><input type="text" name="pname"/></td>
      </tr>
      <tr>
       <td>FatherName::</td>
       <td><input type="text" name="fname"/></td>
      </tr>
       <tr>
       <td>Marital Status::</td>
       <td><input type="radio" name="ms" value="single" checked/>Single &nbsp;&nbsp;
           <input type="radio" name="ms" value="married"/>Married
       </td>
      </tr>
      <tr>
        <td colspan="2"><input type="submit" value="continue"></td>
      </tr> 
      <tr>
        <td clospoan="2"><input type="hidden" name="cToken" value="${sToken}"/>
      </tr>    
    </table> 
    </form><br><br>
    req count::${reqCount}