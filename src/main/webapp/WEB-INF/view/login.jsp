<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<spring:message code=""/>
<html>
<head>
    <title><spring:message code="app.login.title"/></title>
    <link rel="stylesheet" href="/static/css/login.css" type="text/css"/>
</head>
<body>
<div class="container">
    <form method="POST" action="/login" class="form-signin">
        <h1 class="form-heading"><spring:message code="app.login.title"/></h1>
        <div class="err">
            <c:if test="${not empty error}">
                <div class="error">${error}</div>
            </c:if>
        </div>
        <div class="form-group">
            <input name="username" type="text" class="form-control"
                   placeholder="<spring:message code="app.login.login"/>" autofocus="true"/><br>
            <br>
            <input name="password" type="password" class="form-control"
                   placeholder="<spring:message code="app.login.password"/>"/>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/><br>
            <br>
            <button class="btn-submit" type="submit"><spring:message code="app.login.submit"/></button>
        </div>
    </form>
    <div class="registration">
        <p><spring:message code="app.login.reg"/> <a href="/registration" class="link-registration"><spring:message
                code="app.login.reg.link"/></a></p>
    </div>
    <a href="/main" class="main-page-link"><h2><spring:message code="app.link.main.page"/></h2></a>
</div>
<footer class="footer">
    <div class="footer-info">
        <p><spring:message code="app.footer"/></p>
    </div>
</footer>
</body>
</html>