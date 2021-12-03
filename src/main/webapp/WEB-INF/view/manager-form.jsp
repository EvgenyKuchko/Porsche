<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Title</title>
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
                    <label class="label-info">Дата заявки</label>
                    <form:input readonly="true" path="creatingDate"/>
                </div>
                <div>
                    <label class="label-info">Имя</label>
                    <form:input readonly="true" path="user.firstName"/>
                </div>
                <div>
                    <label class="label-info">Фамилия</label>
                    <form:input readonly="true" path="user.lastName"/>
                </div>
                <div>
                    <label class="label-info">Страна</label>
                    <form:input readonly="true" path="country"/>
                </div>
                <div>
                    <label class="label-info">Город</label>
                    <form:input readonly="true" path="city"/>
                </div>
                <div>
                    <label class="label-info">Номер телефона</label>
                    <form:input readonly="true" path="phoneNumber"/>
                </div>
                <div>
                    <label class="label-info">Модель</label>
                    <form:input readonly="true" path="car.model"/>
                </div>
                <div>
                    <label class="label-info">Цена</label>
                    <form:input readonly="true" path="car.price"/>
                </div>
            </div>
            <div>
                <label class="label-info">Статус</label>
                <form:select path="status">
                    <form:option value="Active"></form:option>
                    <form:option value="Completed"></form:option>
                    <form:option value="Failed"></form:option>
                </form:select>
            </div>
            <form:button>Подтвердить</form:button>
        </form:form>
    </div>
</section>
<section class="link-sec">
    <div class="container">
        <a href="/manager/list" class="manager-list-link">К таблице сделок</a>
    </div>
</section>
<footer class="footer">
    <div class="footer-info">
        <p>Информация взята из официальных источников</p>
    </div>
</footer>
</body>
</html>
