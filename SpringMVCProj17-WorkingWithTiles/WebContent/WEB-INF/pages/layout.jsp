<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<head>
   <title><tiles:insertAttribute name="title"/></title>
</head>
<table width="100%" height="100%" border="0">
  <tr height="15%" bgcolor="cyan">
    <td colspan="2"><tiles:insertAttribute name="header"/></td>
  </tr>
  <tr height="70%">
    <td width="20%"><tiles:insertAttribute name="menu"/></td>
    <td width="80%" bgcolor="pink"><tiles:insertAttribute name="body"/></td>
  </tr>
<tr height="15%" bgcolor="yellow">
    <td colspan="2"><tiles:insertAttribute name="footer"/></td>
  </tr>
</table>