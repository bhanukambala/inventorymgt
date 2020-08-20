<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<title>All Suppliers</title>
</head>
<body>

<h1>Suppliers</h1>

id is <c:out value="${supplier.id}"  />
<br>
name is <c:out value="${supplier.name}"  />




<a href="/logout"> Log out </a>

</body>
</html>