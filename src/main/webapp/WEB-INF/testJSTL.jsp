<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	
<!DOCTYPE html>
<html>
<head>

<title>Tennis</title>
</head>
<body>

	
	<c:forEach items="${titres}" var="titre">
	<p> <c:out value="${titre}" /> </p>
	</c:forEach>
</body>
</html>