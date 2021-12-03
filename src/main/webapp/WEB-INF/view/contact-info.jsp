<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Контактная информация</title>
    <link rel="stylesheet" href="/static/css/contact-info.css" type="text/css"/>
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
<section class="social-media">
    <div class="container">
        <div class="title">
            <h2 class="social-media-title">
                Социальные сети
            </h2>
        </div>
        <div class="img-logo">
            <a class="logo-title" href="https://www.instagram.com/porsche/?hl=ru"><img src="/static/img/inst.png" alt="instagram logo"></a>
            <a class="logo-title" href="https://twitter.com/Porsche?ref_src=twsrc%5Egoogle%7Ctwcamp%5Eserp%7Ctwgr%5Eauthor"><img src="/static/img/twit.png" alt="twitter logo"></a>
        </div>
    </div>
</section>
<section class="off-page">
    <div class="container">
        <div class="title">
            <h2 class="social-media-title">
                Официальный сайт
            </h2>
        </div>
        <div class="img-logo">
            <a class="off-page-link" href="https://www.porsche.com"><h3>porsche</h3></a>
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
