<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Таблица сделок</title>
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
<section class="deals-table">
    <div class="container">
        <table class="deals">
            <caption class="title-tbl">Сделки</caption>
            <th>Дата</th>
            <th>Имя</th>
            <th>Фамилия</th>
            <th>Страна</th>
            <th>Город</th>
            <th>Телефон</th>
            <th>Модель</th>
            <th>Цена</th>
            <th>Статус</th>
            <th>Действия</th>
            <c:forEach var="deal" items="${deals}">
                <c:url var="updateLink" value="/manager/updateForm">
                    <c:param name="dealId" value="${deal.id}"/>
                </c:url>
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
                    <td><a href="${updateLink}">Изменить сделку</a></td>
                </tr>
            </c:forEach>
        </table>
    </div>
</section>
<section class="link-sec">
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