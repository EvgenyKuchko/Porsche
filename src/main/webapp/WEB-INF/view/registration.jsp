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
    <form method="post" action="/registration" class="form-registration">
        <input name="firstName" type="text" class="form-control" placeholder="First Name"
               autofocus="true"/> <br>
        <input name="lastName" type="text" class="form-control" placeholder="Last Name"/> <br>
        <input name="age" type="number" class="form-control" placeholder="Age"/> <br>
        <input name="login" type="text" class="form-control" placeholder="Login"/> <br>
        <input name="password" type="password" class="form-control" placeholder="Password"/> <br>
        <button class="btn-submit" type="submit">Регистрация</button>
    </form>
    <a href="/main" class="main-page-link"><h2>На главную страницу</h2></a>
</div>
</body>
</html>
