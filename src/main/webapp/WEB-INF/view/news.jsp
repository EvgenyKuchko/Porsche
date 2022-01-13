<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<spring:message code=""/>
<html>
<head>
    <title><spring:message code="app.news.title"/></title>
    <link rel="stylesheet" href="/static/css/news.css" type="text/css"/>
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
                <div class="locale" aria-labelledby="dropdownMenuButton">
                    <a class="l10n" href="?lang=en"><spring:message code="app.lang.english"/></a>
                    <a class="l10n" href="?lang=ru"><spring:message code="app.lang.russian"/></a>
                </div>
                <c:if test="${pageContext.request.userPrincipal.name != null}">
                    <deal id="logoutForm" method="POST" action="/logout">
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                    </deal>
                    <div class="userName">
                        <h4><spring:message code="app.greeting"/>,<br> ${pageContext.request.userPrincipal.name}
                            <a href="<c:url value='/logout' />" class="btnR"><spring:message code="app.logout"/></a><br>
                        </h4>
                    </div>
                </c:if>
                <sec:authorize access="!isAuthenticated()">
                    <h4><a href="/login" class="btnR"><spring:message code="app.login"/></a></h4>
                </sec:authorize>
                <div class="manager">
                    <sec:authorize access="hasAuthority('MANAGER')">
                        <a href="/deals" class="managerLink"><h3><spring:message code="app.deals"/></h3></a>
                    </sec:authorize>
                </div>
            </div>
        </div>
    </div>
</header>
<hr>
<section class="news-one">
    <div class="wrapper">
        <div class="pic">
            <img class="pics" src="/static/img/news-one.jpg" alt="<spring:message code="app.news.one.img.desc"/>">
        </div>
        <div class="info">
            <div class="news-title">
                <h2 class="ttl"><spring:message code="app.news.one.title"/></h2>
            </div>
            <p class="infos">
                <spring:message code="app.news.one.desc"/>
            </p>
        </div>
    </div>
</section>
<hr>
<section class="news-two">
    <div class="wrapper">
        <div class="pic">
            <img class="pics" src="/static/img/news-two.jpg" alt="<spring:message code="app.news.two.img.desc"/>">
        </div>
        <div class="info">
            <div class="news-title">
                <h2 class="ttl"><spring:message code="app.news.two.title"/></h2>
            </div>
            <p class="infos">
                <spring:message code="app.news.two.desc"/>
            </p>
        </div>
    </div>
</section>
<hr>
<section class="news-three">
    <div class="wrapper">
        <div class="pic">
            <img class="pics" src="/static/img/news-three.jpg" alt="<spring:message code="app.news.three.img.desc"/>">
        </div>
        <div class="info">
            <div class="news-title">
                <h2 class="ttl"><spring:message code="app.news.three.title"/></h2>
            </div>
            <p class="infos">
                <spring:message code="app.news.three.desc"/>
            </p>
        </div>
    </div>
</section>
<hr>
<section class="main-page">
    <div class="container">
        <a href="/main" class="main-page-link"><spring:message code="app.link.main.page"/></a>
    </div>
</section>
<footer class="footer">
    <div class="footer-info">
        <p><spring:message code="app.footer"/></p>
    </div>
</footer>
</body>
</html>