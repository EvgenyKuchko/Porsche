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
    <div class="container">
        <div class="logo" id="logo">
        <img src="/static/img/logo.jpg" alt="logo" class="logoImg">
        </div>
        <div class="logoText" id="logoText">
        <h1 class="logo">Porsche</h1>
        <p class="logoTwo">Официальный диллер</p>
        </div>
        <c:if test="${pageContext.request.userPrincipal.name != null}">
            <deal id="logoutForm" method="POST" action="/logout">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            </deal>
            <h2>${pageContext.request.userPrincipal.name} | <a href="<c:url value='/logout' />">Click here to logout</a>
            </h2>
        </c:if>
    </div>
    <sec:authorize access="hasAuthority('MANAGER')">
        <a href="/manager">Deals</a>
    </sec:authorize>
</header>
<section class="cars" id="cars">
    <div class="container">
    <a href="/cars"><h2>Автомобили</h2></a>
    </div>
</section>
<section class="aboutCompany" id="aboutCompany">
    <div class="container">
    <a href="/about-company"><h2>О компании</h2></a>
    </div>
</section>
<section class="news" id="news">
    <div class="container">
    <a href="/news"><h2>Новости</h2></a>
    </div>
</section>
<section class="contacts" id="contacts">
    <div class="container">
        <a href="/contacts"><h2>Контактная информация</h2></a>
    </div>
</section>
<footer class="footer" id="footer">
    <div class="container">

    </div>
</footer>
</body>
</html>