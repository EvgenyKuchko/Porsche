<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<spring:message code=""/>
<html>
<head>
    <spring:message code="app.form.city" var="city"/>
    <spring:message code="app.form.country" var="country"/>
    <spring:message code="app.form.phone" var="phone"/>
    <title><spring:message code="app.form.title"/></title>
    <link rel="stylesheet" href="/static/css/form.css" type="text/css"/>
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
                <div class="l10n" aria-labelledby="dropdownMenuButton">
                    <a class="dropdown-item" href="?lang=en"><spring:message code="app.lang.english"/></a>
                    <a class="dropdown-item" href="?lang=ru"><spring:message code="app.lang.russian"/></a>
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
                <div class="managerLink" id="managerLink">
                    <sec:authorize access="hasAuthority('MANAGER')">
                        <a href="/manager/list"><h3><spring:message code="app.deals"/></h3></a>
                    </sec:authorize>
                </div>
            </div>
        </div>
    </div>
</header>
<section class="form-sec">
    <div class="container">
        <div class="title">
            <h1 class="form-heading"><spring:message code="app.form.title"/></h1>
        </div>
        <div class="info">
            <p><spring:message code="app.form.info"/></p>
        </div>
        <form:form action="/form/{model}" method="post" modelAttribute="deal" class="form-signin">
            <div class="form-group ">
                <form:input path="city" type="text" autofocus="true" class="form-control"
                            placeholder="${city}"></form:input>
                <form:errors path="city" class="err"/> <br>
                <form:input path="country" type="text" class="form-control" placeholder="${country}"></form:input>
                <form:errors path="country" class="err"/> <br>
                <form:input path="phoneNumber" type="text" class="form-control" placeholder="${phone}"></form:input>
                <form:errors path="phoneNumber" class="err"/>
                <form:input path="creatingDate" type="hidden" value="${date}"/>
                <form:input path="status" type="hidden" value="Active"/>
                <form:input path="car" type="hidden" value="${car.id}"/>
                <form:input path="user" type="hidden" value="${user.id}"/>
                <br>
                <button class="btn-submit" type="submit"><spring:message code="app.form.submit"/></button>
            </div>
        </form:form>
    </div>
</section>
<br>
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
