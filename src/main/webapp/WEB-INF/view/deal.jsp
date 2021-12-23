<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<spring:message code=""/>
<html>
<head>
    <title><spring:message code="app.deal.title"/></title>
    <link rel="stylesheet" href="/static/css/deal.css" type="text/css"/>
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
                        <a href="/manager/list" class="managerLink"><h3><spring:message code="app.deals"/></h3></a>
                    </sec:authorize>
                </div>
            </div>
        </div>
    </div>
</header>
<section class="info"></section>
<div class="container">
    <h2 class="text-thnx">
        <spring:message code="app.deal.text.three"/>
        <br>
        <spring:message code="app.deal.text.one"/>
        <br>
        <spring:message code="app.deal.text.two"/></h2>
</div>
</section>
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
