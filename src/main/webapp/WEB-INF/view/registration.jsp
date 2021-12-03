<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Регистрация</title>
    <link rel="stylesheet" href="/static/css/registration.css" type="text/css"/>
</head>
<body>
<div class="container">
    <div class="title">
        <h1>Регистрация пользователя</h1>
    </div>
    <div class="info">
        <p>Для успешной регистрации необходимо<br> заполнить ВСЕ поля</p>
    </div>
    <form:form action="/registration" method="post" modelAttribute="user">
        <form:input path="firstName" type="text" placeholder="Имя" class="form-control"></form:input>
        <form:errors path="firstName" class="err"/> <br>
        <form:input path="lastName" type="text" placeholder="Фамилия" class="form-control"></form:input>
        <form:errors path="lastName" class="err"/> <br>
        <form:input path="age" type="number" placeholder="Возраст" class="form-control"></form:input>
        <form:errors path="age" class="err"/> <br>
        <form:input path="login" type="text" placeholder="Логин" class="form-control"></form:input>
        <form:errors path="login" class="err"/> <br>
        <form:input path="password" type="password" placeholder="Пароль" class="form-control"></form:input>
        <form:errors path="password" class="err"/> <br>
        <button class="btn-submit" type="submit">Регистрация</button>
    </form:form>
    <a href="/main" class="main-page-link"><h2>На главную страницу</h2></a>
</div>
</body>
</html>
