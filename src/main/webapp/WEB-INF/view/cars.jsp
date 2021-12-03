<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Автомобили</title>
    <link rel="stylesheet" href="/static/css/cars.css" type="text/css"/>
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
<section class="911">
    <div class="container">
        <h2 class="model-title">911</h2>
        <div class="info-about-model">
            <p>
                Настоящий атлет. Икона дизайна. Эталон практичности. 911 сочетает в себе мощность спортивного автомобиля
                с высоким комфортом салона и самыми севременными технологиями, которые облегчают Вашу повседневную
                жизнь.
            </p>
        </div>
        <a href="/model/Turbo" class="model-link">Turbo</a> | <a href="/model/Carrera" class="model-link">Carrera</a>
    </div>
</section>
<section class="cayenne">
    <div class="container">
        <h2 class="model-title">Cayenne</h2>
        <div class="info-about-model">
            <p>
                Нас всех объединяет интерес к спортивным автомобилям. Он пробуждается еще до поездки – при первом
                взгляде
                на динамичные пропорции моделей Cayenne. Они сразу же выдают гены Porsche. Уже при посадке в салон
                ощущается спортивная атмосфера, которую подчеркивает высококачественная базовая комплектация.
            </p>
        </div>
        <a href="/model/GTS" class="model-link">GTS</a> | <a href="/model/Coupe" class="model-link">Coupe</a>
    </div>
</section>
<section class="panamera">
    <div class="container">
        <h2 class="model-title">Panamera</h2>
        <div class="info-about-model">
            <p>
                Что делает модели Panamera такими особенными? Их мощность, динамические характеристики, дизайн,
                просторный
                салон. Но прежде всего – среднемоторная концепция, которая позволяет реализовать все
                перечисленные выше достоинства.
            </p>
        </div>
        <div class="model-link">
            <a href="/model/970" class="model-link">970</a> | <a href="/model/Turismo" class="model-link">Turismo</a>
        </div>
    </div>
</section>
<section class="main-page">
    <div class="container">
        <a href="/main" class="main-page-link">На главную страницу</a>
    </div>
</section>
<footer class="footer">
    <div class="footer-info">
        <p>Информация взята из официальных источников</p>
    </div>
</footer>
</body>
</html>