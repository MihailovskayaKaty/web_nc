<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Start page</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/MyServlet" method="POST">
  <input type="submit" value="Просмотреть">
</form>
</body>
</html>
