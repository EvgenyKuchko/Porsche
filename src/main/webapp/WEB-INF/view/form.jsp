<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Форма для доставки</title>
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
                <div class="managerLink" id="managerLink">
                    <sec:authorize access="hasAuthority('MANAGER')">
                        <a href="/manager/list"><h3>Сделки</h3></a>
                    </sec:authorize>
                </div>
            </div>
        </div>
    </div>
</header>
<section class="form-sec">
    <div class="container">
        <div class="title">
            <h1 class="form-heading">Форма для заявки</h1>
        </div>
        <div class="info">
            <p>Заполните все поля формы, чтобы <br>
                наш менеджер смог с вами сязаться</p>
        </div>
        <form method="POST" action="/form/{model}" class="form-signin">
            <div class="form-group ">
                <input name="city" type="text" class="form-control" placeholder="City"
                       autofocus="true"/> <br>
                <input name="country" type="text" class="form-control" placeholder="Country"/> <br>
                <input name="phoneNumber" type="text" class="form-control" placeholder="Phone number"/>
                <input type="hidden" name="creatingDate" value="${date}">
                <input type="hidden" name="status" value="Active">
                <input type="hidden" name="car" value="${car.id}">
                <input type="hidden" name="user" value="${user.id}">
                <br>
                <button class="btn-submit" type="submit">Оформить заявку</button>
            </div>
        </form>
    </div>
</section>
<br>
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
