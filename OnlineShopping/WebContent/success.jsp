<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Item Purchased</title>
</head>
<body>
<h1>Item successfully purchased</h1>
<h2> Order details:</h2>
Order Id: ${oitem.id}<br>
Order Name: ${oitem.custName}
<br>Mobile: ${oitem.custMobile}
<br>Item Id: ${oitem.itemId}
<br>Quantity: ${oitem.quantity}
</body>
</html>