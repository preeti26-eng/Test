<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>   
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style><%@include file="/WEB-INF/css/project.css"%></style>
<title>Home Page</title>
<style>
table{
border-collapse:collapse; 
}
</style>
</head>
<body>
<h1> Online Shopping Home Page</h1>
<c:choose>
<c:when test="${ilist.size()>0}">
<h2>Available Items</h2>
<table id="t1" bgcolor="#DCF0F4">
         <tr bgcolor="#8ED4E3">
         <td >Item Id</td>
            <td>Item Name</td>
            <td>Price(Rs)</td>
              <td>Category</td>
              <td>Quantity</td>
              </tr>
              <c:forEach var="itm" items="${ilist}">
               <tr>
            <td>${itm.id}</td>
            <td>${itm.name}</td>
              <td>${itm.price}</td>
              <td>${itm.category}</td>
              <td>${itm.quantity}</td>
              </tr>
              </c:forEach>
         </table>
         </c:when>
         <c:otherwise>
         <h3> No items were found</h3>
         </c:otherwise>
         </c:choose>
         <form:form action="placeOrder.obj" modelAttribute="sitem">
         <br><br>
         Enter item ID: <form:input path="id" type="text" value=""/><br><br>
         <input class="butt" type="submit" value="Place Order" />
         
         </form:form>
</body>
</html>