<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<h1 style="color:red;text-align:center">c.jsp</h1>
<!--  read and display different scope of attribute values-->
Attr1 value(page scope)::<%pageContext.findAttribute("attr1");%><br>
Attr2 value(req scope)::<%pageContext.findAttribute("attr2");%><br>
Attr3 value(ses scope)::<%pageContext.findAttribute("attr3");%><br>
Attr4 value(application scope)::<%pageContext.findAttribute("attr4");%><br>

