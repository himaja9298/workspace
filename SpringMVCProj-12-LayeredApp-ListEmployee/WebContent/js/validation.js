function validate(frm){
 alert("js");
 let ename=frm.ename.value;
 let desg=frm.desg.value
 let salary=frm.salary.value;
 let flag=true; 
 
 //empty the error messages
 document.getElementById("enameId").innerHTML="";
 document.getElementById("desgId").innerHTML="";
 document.getElementById("salaryId").innerHTML="";
 
frm.vflag.value="yes"
alert(frm.vflag.value)
 if(ename==""){
   flag=false;
   document.getElementById("enameId").innerHTML="Employee name is mandatory(js)";
 }
 else if(ename.length<5||ename.length>10){
   flag=false;
   document.getElementId("enameId").innerHTML="Employee name must have min of 5 chars max of 10 chars(js)"
 }
 
 if(desg==""){
   flag=false;
   document.getElementById("desgId").innerHTML="Employee desg is mandatory(js)";
 }
 else if(desg.length<5||desg.length>10){
   flag=false;
   document.getElementId("desgId").innerHTML="Employee desg must have min of 5 chars max of 10 chars(js)"
 }
 
  if(salary==""){
   flag=false;
   document.getElementById("salaryId").innerHTML="Employee salary is mandatory(js)";
 }
 else if(isNaN(salary)){
   flag=false;
   document.getElementId("salaryId").innerHTML="Employee salary must be numeric(js)"
 }
 
 else if(salary<1000||salary>1000000){
   flag=false;
   document.getElementId("salaryId").innerHTML="Employee salary must have min of 1000 max of 1000000(js)"
 }
 
 return flag;
 }