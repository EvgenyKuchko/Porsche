<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Регистрация</title>
</head>
<body>
<div class="container text-center">
<h1>Регистрация пользователя</h1>
    <form:form action="/registration" modelAttribute="user"  method="post">

        <div>
            <form:label path="firstName">First Name:</form:label>
            <form:input path="firstName" id="firstname"/>
        </div>

        <div>
            <form:label path="lastName">Last Name:</form:label>
            <form:input path="lastName" id="lastname"/>
        </div>

        <div>
            <form:label path="age">Age:</form:label>
            <form:input path="age" id="age"/>
        </div>

        <div>
            <form:label path="login">Login:</form:label>
            <form:input path="login" id="login"/>
        </div>

        <div>
            <form:label path="password">Password:</form:label>
            <form:password path="password"/>
        </div>

        <div><input type="submit" value="Зарегистрироваться"/></div>
    </form:form>

</div>
</div>
</body>
</html>
