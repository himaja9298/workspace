<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<h1 style="color:red;text-align:center">d.jsp</h1>
<!--  declaring page context attributes-->
Attr1 value(page scope)::<%pageContext.findAttribute("attr1");%><br>
Attr2 value(req scope)::<%pageContext.findAttribute("attr2");%><br>
Attr3 value(ses scope)::<%pageContext.findAttribute("attr3");%><br>
Attr4 value(application scope)::<%pageContext.findAttribute("attr4");%><br>
    <%-- <%pageContext.removeAttribute("attr4",pageContext.APPLICATION_SCOPE);%> --%>