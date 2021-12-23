<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<spring:message code=""/>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<html lang="en">
<head>
    <title><spring:message code="app.main.title"/></title>
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
<section class="cars" id="cars">
    <div class="container">
        <a href="/cars" class="links"><h2><spring:message code="app.link.cars"/></h2></a>
        <p class="info">
            <spring:message code="app.desc.link.cars"/>
        </p>
    </div>
</section>
<section class="aboutCompany" id="aboutCompany">
    <div class="container">
        <a href="/about-company" class="links"><h2><spring:message code="app.link.company"/></h2></a>
        <p class="info">
            <spring:message code="app.desc.link.company"/>
        </p>
    </div>
</section>
<section class="news" id="news">
    <div class="container">
        <a href="/news" class="links"><h2><spring:message code="app.link.news"/></h2></a>
        <p class="info">
            <spring:message code="app.desc.link.news"/>
        </p>
    </div>
</section>
<section class="contacts" id="contacts">
    <div class="container">
        <a href="/contacts" class="links"><h2><spring:message code="app.link.media"/></h2></a>
        <p class="info" id="info">
            <spring:message code="app.desc.link.media"/>
        </p>
    </div>
</section>
<footer class="footer" id="footer">
    <div class="footerInfo">
        <p><spring:message code="app.footer"/></p>
    </div>
</footer>
</body>
</html>