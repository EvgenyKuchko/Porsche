<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<html lang="en">
<head>
    <title>Главная страница</title>
    <link rel="stylesheet" href="/static/css/main.css" type="text/css"/>
</head>
<body>
<header class="header" id="header">
    <div class="headerContainer">
        <div class="wrapper">
            <div class="logoImg" id="logoImg">
                <img src="/static/img/logoP.png" alt="logo" class="logoImg">
            </div>
            <div class="logoText" id="logoText">
                <h1 class="logoText">Porsche</h1>
            </div>
            <div class="security" id="security">
                <c:if test="${pageContext.request.userPrincipal.name != null}">
                    <deal id="logoutForm" method="POST" action="/logout">
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                    </deal>
                    <div class="userName">
                        <h4>Приветствуем вас,<br> ${pageContext.request.userPrincipal.name}
                            <a href="<c:url value='/logout' />" class="btnR">Выйти из аккаунта</a><br>
                        </h4>
                    </div>
                </c:if>
                <sec:authorize access="!isAuthenticated()">
                    <h4><a href="/login" class="btnR">Вход в аккаунт</a></h4>
                </sec:authorize>
                <div class="managerLink" id="managerLink">
                    <sec:authorize access="hasAuthority('MANAGER')">
                        <a href="/manager/list"><h3>Сделки</h3></a>
                    </sec:authorize>
                </div>
            </div>
        </div>
    </div>
</header>
<section class="cars" id="cars">
    <div class="container">
        <a href="/cars" class="links"><h2>Автомобили</h2></a>
        <p class="info">
            Ознакомьтесь с нашим модельным рядом
        </p>
    </div>
</section>
<section class="aboutCompany" id="aboutCompany">
    <div class="container">
        <a href="/about-company" class="links"><h2>О компании</h2></a>
        <p class="info">
            Узнайте больше о нашей компании
        </p>
    </div>
</section>
<section class="news" id="news">
    <div class="container">
        <a href="/news" class="links"><h2>Новости</h2></a>
        <p class="info">
            Будьте в курсе новостей
        </p>
    </div>
</section>
<section class="contacts" id="contacts">
    <div class="container">
        <a href="/contacts" class="links"><h2>Контактная информация</h2></a>
        <p class="info" id="info">
            Наши социальные сети
        </p>
    </div>
</section>
<footer class="footer" id="footer">
    <div class="footerInfo">
        <p>Информация взята из официальных источников</p>
    </div>
</footer>
</body>
</html>