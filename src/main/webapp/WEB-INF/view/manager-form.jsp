<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<spring:message code=""/>
<html>
<head>
    <spring:message code="app.manager.form.choose.active" var="active"/>
    <spring:message code="app.manager.form.choose.completed" var="completed"/>
    <spring:message code="app.manager.form.choose.failed" var="failed"/>
    <title><spring:message code="app.manager.form.title"/></title>
    <link rel="stylesheet" href="/static/css/manager-form.css" type="text/css"/>
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
<section class="user-info">
    <div class="container">
        <form:form action="saveDeal" method="post" modelAttribute="deal">
            <input type="hidden" value="${deal.id}" name="dealId"/>
            <div class="information">
                <div>
                    <label class="label-info"><spring:message code="app.manager.form.info.date"/></label>
                    <form:input readonly="true" path="creatingDate"/>
                </div>
                <div>
                    <label class="label-info"><spring:message code="app.manager.form.info.name"/></label>
                    <form:input readonly="true" path="user.firstName"/>
                </div>
                <div>
                    <label class="label-info"><spring:message code="app.manager.form.info.lastName"/></label>
                    <form:input readonly="true" path="user.lastName"/>
                </div>
                <div>
                    <label class="label-info"><spring:message code="app.manager.form.info.country"/></label>
                    <form:input readonly="true" path="country"/>
                </div>
                <div>
                    <label class="label-info"><spring:message code="app.manager.form.info.city"/></label>
                    <form:input readonly="true" path="city"/>
                </div>
                <div>
                    <label class="label-info"><spring:message code="app.manager.form.info.phone"/></label>
                    <form:input readonly="true" path="phoneNumber"/>
                </div>
                <div>
                    <label class="label-info"><spring:message code="app.manager.form.info.model"/></label>
                    <form:input readonly="true" path="car.model"/>
                </div>
                <div>
                    <label class="label-info"><spring:message code="app.manager.form.info.price"/></label>
                    <form:input readonly="true" path="car.price"/>
                </div>
            </div>
            <div>
                <label class="label-info"><spring:message code="app.manager.form.info.status"/></label>
                <form:select path="status">
                    <form:option value="${active}"></form:option>
                    <form:option value="${completed}"></form:option>
                    <form:option value="${failed}"></form:option>
                </form:select>
            </div>
            <form:button><spring:message code="app.manager.form.info.submit"/></form:button>
        </form:form>
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
