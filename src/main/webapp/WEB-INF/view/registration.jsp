<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Регистрация</title>
</head>
<body>
<div id="header">
<%--    ШАПКА--%>
</div>
<center>
<div>
<h1>Регистрация пользователя</h1>
    <form:form action="/registration" modelAttribute="user"  method="post">

        <div>
            <form:label path="firstName">First Name:</form:label>
            <form:input path="firstName" id="firstname"/>
            <form:errors path="firstName"></form:errors>
        </div>

        <div>
            <form:label path="lastName">Last Name:</form:label>
            <form:input path="lastName" id="lastname"/>
            <form:errors path="lastName"></form:errors>
        </div>

        <div>
            <form:label path="age">Age:</form:label>
            <form:input path="age" id="age"/>
            <form:errors path="age"></form:errors>
        </div>

        <div>
            <form:label path="login">Login:</form:label>
            <form:input path="login" id="login"/>
            <form:errors path="login"></form:errors>
        </div>

        <div>
            <form:label path="password">Password:</form:label>
            <form:password path="password"/>
            <form:errors path="password"></form:errors>
        </div>

        <div><input type="submit" value="Зарегистрироваться"/></div>
    </form:form>

</div>
</div>

<a href="/main">На главную страницу</a>
</center>
</body>
</html>
