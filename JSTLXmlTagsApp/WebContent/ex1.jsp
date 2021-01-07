<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x"%>
  <!-- import XML document-->
  <c:import var="file" url="orders.xml"/>
  <!-- parse the XML doc-->
  <x:parse var="doc"  doc="${file}"/>
  <!--Display all the item names and prices-->
  <b>All item details are</</b><br>
  <x:forEach var="ord" select="$doc/orders/order">
     <x:out select="$ord/name"/>&nbsp;
     <x:out select="$ord/price"/><br>
  </x:forEach>
  <br>
 
 <!-- Display all items names and prices whose price is greater than 1000 -->  
 <b>All items details are whose price>1000</b><br>
 <x:forEach var="ord" select="$doc/orders/order">
   <x:if select="$ord/price>1000">
      <x:out select="$ord/name"/>
      <x:out select="$ord/price"/><br>
   </x:if>
 </x:forEach><br>