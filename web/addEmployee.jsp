<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>AddingEmployee</title>
</head>

<body>
<form action="${pageContext.request.contextPath}/AddEmployeeServlet" method="POST">
    <p>Добавление сотрудника в таблицу:</p>
    <p>Фамилия: <input type="text" value="" name="surname"></p>
    <p>Имя: <input type="text" value="" name="name"></p>
    <p>Отчество: <input type="text" value="" name="lastName"></p>
    <p>Пол: <input type="text" value="" name="sex"></p>
    <p>Дата рождения: <input type="text" value="" name="birthDate"></p>
    <p>Адрес: <input type="text" value="" name="address"></p>
    <p>Должность: <input type="text" value="" name="post"></p>
    <p><input type="submit" value="Записать данные" name="record">
        <input type="reset" value="Очистить"></p>
</form>
</body>
</html>
