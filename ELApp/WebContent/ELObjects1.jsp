<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <b> attr1(request) value</b>:::${requestScope.attr1})<br>
    <b>attr1 (request) value</b>:::${attr1}<br>
    -----------------------------------------------------<br>
    <b>Attr2(session) value</b>:::${sessionScope.attr2})<br>
    <b>Attr2(session) value</b>:::${attr2})<br>
    ------------------------------------------------------<br>
    <b>attr3(application) value</b>:::${applicationScope.attr3})<br>
    <b>attr3(application) value</b>:::${attr3})<br>
    -------------------------------------------------------<br>
    attr4 value</b>::::${attr4}<br>
    -------------------------------------------------------<br>
    <b>Context param dbuser</b>:::${initParam.dbuser}<br>
    <b>Context param pwd</b>:::${initParam.pwd}<br>
    -------------------------------------------------------<br>
    <b>session id related cookie name:::</b>${cookie.JSESSIONID.name}<br>
    <b>session id related cookie value:::</b>${cookie.JSESSIONID.value}<br>
    ---------------------------------------------------------------<br>
    <b>sname req param value::${param.sname}</b><br>
    <b>scrs req param values::${paramValues.scrs[0]},${paramValues.scrs[1]}</b><br>
    ------------------------------------------------------------------<br>
    <b>user agent request header value::${header["user-agent"]}</b><br>
    <b>accept language::${headerValues["accept-language"][0]},${headerValues["accept-language"][1]}</b>