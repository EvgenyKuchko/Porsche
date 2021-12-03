<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Вход</title>
    <link rel="stylesheet" href="/static/css/login.css" type="text/css"/>
</head>
<body>
<div class="container">
    <form method="POST" action="/login" class="form-signin">
        <h1 class="form-heading">Вход в аккаунт</h1>
        <div class="form-group ">
            <input name="username" type="text" class="form-control" placeholder="Login"
                   autofocus="true"/> <br>
            <input name="password" type="password" class="form-control" placeholder="Password"/>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <br>
            <button class="btn-submit" type="submit">Вход</button>
        </div>
    </form>
    <div class="registration">
        <p>Чтобы создать аккаунт пройдите по ссылке<a href="/registration" class="link-registration">регистрации</a></p>
    </div>
    <a href="/main" class="main-page-link"><h2>На главную страницу</h2></a>
</div>
</body>
</html>
