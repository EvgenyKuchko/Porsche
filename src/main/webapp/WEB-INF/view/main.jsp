<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<html lang="en">
<head>
    <title>Главная страница</title>
</head>
<body>
<header>
    <div class="container">
        <c:if test="${pageContext.request.userPrincipal.name != null}">
        <form id="logoutForm" method="POST" action="/logout">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>
            <h2>${pageContext.request.userPrincipal.name} | <a href="<c:url value='/logout' />">Click here to logout</a></h2>
        </c:if>
    </div>
    <sec:authorize access="hasAuthority('MANAGER')">
        <a href="/manager">Deals</a>
    </sec:authorize>
</header>
<h2><a href="/login">Вход в аккаунт</a></h2>
<h2><a href="/contacts">Контактная информация</a></h2>
<h2><a href="/about-company">О компании</a></h2>
<h2><a href="/cars">Автомобили</a></h2>
<h2><a href="/news">Новости</a></h2>
<h2><a href="/manager">Сделки(Толькo для мaнагера)</a></h2>
</body>
</html>