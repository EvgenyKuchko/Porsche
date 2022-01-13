<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<spring:message code=""/>
<html>
<head>
    <spring:message code="app.reg.form.first.name" var="firstName"/>
    <spring:message code="app.reg.form.last.name" var="lastName"/>
    <spring:message code="app.reg.form.age" var="age"/>
    <spring:message code="app.reg.form.login" var="login"/>
    <spring:message code="app.reg.form.password" var="password"/>
    <title><spring:message code="app.reg.title"/></title>
    <link rel="stylesheet" href="/static/css/registration.css" type="text/css"/>
</head>
<body>
<div class="container">
    <div class="title">
        <h1><spring:message code="app.reg.title"/></h1>
    </div>
    <div class="info">
        <p><spring:message code="app.reg.info"/></p>
    </div>
    <form:form action="/registration" method="post" modelAttribute="user">
        <form:errors path="firstName" class="err"/><br>
        <form:input path="firstName" type="text" placeholder="${firstName}" class="form-control"></form:input>
        <br><form:errors path="lastName" class="err"/><br>
        <form:input path="lastName" type="text" placeholder="${lastName}" class="form-control"></form:input>
        <br><form:errors path="age" class="err"/><br>
        <form:input path="age" type="number" placeholder="${age}" class="form-control"></form:input>
        <br><form:errors path="login" class="err"/><br>
        <form:input path="login" type="text" placeholder="${login}" class="form-control"></form:input>
        <br><form:errors path="password" class="err"/><br>
        <form:input path="password" type="password" placeholder="${password}" class="form-control"></form:input><br>
        <br>
        <button class="btn-submit" type="submit"><spring:message code="app.reg.submit"/></button>
    </form:form>
    <a href="/main" class="main-page-link"><h2><spring:message code="app.link.main.page"/></h2></a>
</div>
<footer class="footer">
    <div class="footer-info">
        <p><spring:message code="app.footer"/></p>
    </div>
</footer>
</body>
</html>