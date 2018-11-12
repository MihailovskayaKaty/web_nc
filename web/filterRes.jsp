<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Filter</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/TableServlet" method="POST">
    <table border="=1">
        <tr>
            <th>id</th>
            <th>Surname</th>
            <th>Name</th>
            <th>Lastname</th>
            <th>Sex</th>
            <th>Birthday</th>
            <th>Address</th>
            <th>Post</th>
        </tr>
        <c:forEach var="employee" items="${list}">
            <c:if test="${employee.sex == sex}">
                <tr>
                    <td>${employee.idworkers}</td>
                    <td>${employee.surname}</td>
                    <td>${employee.name}</td>
                    <td>${employee.lastName}</td>
                    <td>${employee.sex}</td>
                    <td>${employee.birthDate}</td>
                    <td>${employee.address}</td>
                    <td>${employee.post}</td>
                </tr>
            </c:if>
        </c:forEach>
    </table>
</form>
</body>
</html>
