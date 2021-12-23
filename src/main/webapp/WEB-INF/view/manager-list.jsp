<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<spring:message code=""/>
<html>
<head>
    <title><spring:message code="app.manager.list.title"/></title>
    <link rel="stylesheet" href="/static/css/manager-list.css" type="text/css"/>
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
            </div>
        </div>
    </div>
</header>
<section class="deals-table">
    <div class="container">
        <table class="deals">
            <caption class="title-tbl"><spring:message code="app.manager.list.title"/></caption>
            <th><spring:message code="app.manager.form.info.date"/></th>
            <th><spring:message code="app.manager.form.info.name"/></th>
            <th><spring:message code="app.manager.form.info.lastName"/></th>
            <th><spring:message code="app.manager.form.info.country"/></th>
            <th><spring:message code="app.manager.form.info.city"/></th>
            <th><spring:message code="app.manager.form.info.phone"/></th>
            <th><spring:message code="app.manager.form.info.model"/></th>
            <th><spring:message code="app.manager.form.info.price"/></th>
            <th><spring:message code="app.manager.form.info.status"/></th>
            <th><spring:message code="app.manager.form.info.actions"/></th>
            <c:forEach var="deal" items="${deals}">
                <tr>
                    <td>${deal.creatingDate}</td>
                    <td>${deal.user.firstName}</td>
                    <td>${deal.user.lastName}</td>
                    <td>${deal.country}</td>
                    <td>${deal.city}</td>
                    <td>${deal.phoneNumber}</td>
                    <td>${deal.car.model}</td>
                    <td>${deal.car.price}</td>
                    <td>${deal.status}</td>
                    <td><a href="deals/${deal.id}" class="changeStatus"><spring:message code="app.manager.list.change"/></a></td>
                </tr>
            </c:forEach>
        </table>
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