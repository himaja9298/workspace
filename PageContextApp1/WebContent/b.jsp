<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<h1 style="color:red;text-align:center">b.jsp</h1>
<!--  declaring page context attributes-->
Attr1 value(page scope)::<%pageContext.getAttribute("attr1");%><br>
Attr2 value(req scope)::<%pageContext.getAttribute("attr2",pageContext.REQUEST_SCOPE);%><br>
Attr3 value(ses scope)::<%pageContext.getAttribute("attr3",pageContext.SESSION_SCOPE);%><br>
Attr4 value(application scope)::<%pageContext.getAttribute("attr4",pageContext.APPLICATION_SCOPE);%><br>
%>
<!--send redirection of a.jsp to b.jsp-->
<jsp:forward page="c.jsp"/>