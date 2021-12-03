<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title><c:out value="${car.model}"/></title>
    <%@ page isELIgnored="false" %>
    <link rel="stylesheet" href="/static/css/model.css" type="text/css"/>
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
<section class="title-sec">
    <div class="title-info">
        <h1 class="model-name"><c:out value="${car.model}"/></h1>
    </div>
    <div class="top-desc">
        <div class="wrapper">
            <div class="desc-info">
                <h2 class="title">Стоимость от (USD):</h2>
                <p class="char-top"><c:out value="${car.price}"/></p>
            </div>
            <div class="desc-info">
                <h2 class="title">Мощность(л.с.): </h2>
                <p class="char-top"><c:out value="${car.power}"/></p>
            </div>
            <div class="desc-info">
                <h2 class="title">Максимальная скорость, км/ч:</h2>
                <p class="char-top"><c:out value="${car.maxSpeed}"/></p>
            </div>
        </div>
    </div>
</section>
<section class="engine-sec">
    <div class="container">
        <h2 class="title">Двигатель</h2>
        <div class="char">
            <p>Объем: <c:out value="${car.engineDisplacement}"/></p>
            <p>Тип топлива: <c:out value="${car.fuelType}"/></p>
        </div>
    </div>
</section>
<section class="body-sec">
    <div class="container">
        <h2 class="title">Кузов</h2>
        <div class="char">
            <p>Тип кузова: <c:out value="${car.bodyType}"/></p>
            <p>Количество мест: <c:out value="${car.places}"/></p>
            <p>Длина, м: <c:out value="${car.length}"/></p>
            <p>Высота, м: <c:out value="${car.height}"/></p>
            <p>Вес, кг: <c:out value="${car.weight}"/></p>
            <p>Полезная загрузка, кг: <c:out value="${car.payload}"/></p>
            <p>Количетсво дверей: <c:out value="${car.numberOfDoors}"/></p>
            <p>Материал салона: <c:out value="${car.interior}"/></p>
        </div>
    </div>
</section>
<section class="expl-sec">
    <div class="container">
        <h2 class="title">Эксплуатационные характеристики</h2>
        <div class="char">
            <p>Разгон от 0 до 100 км/ч, с: <c:out value="${car.acceleration}"/></p>
            <p>Расход топлива на 100 км в городе, л: <c:out value="${car.fuelConsInTheCity}"/></p>
            <p>Расход топлива на 100 км за городом, л: <c:out value="${car.fuelConsOutsideTheCity}"/></p>
            <p>Комбинированный расход топлива на 100 км, л: <c:out value="${car.combinedFuelCons}"/></p>
            <p>Объем топливного бака, л: <c:out value="${car.fuelTankVolume}"/></p>
        </div>
    </div>
</section>
<section class="transmission-sec">
    <div class="container">
        <h2 class="title">Трансмиссия</h2>
        <div class="char">
            <p>Тип коробки передач: <c:out value="${car.typeOfTransmission}"/></p>
            <p>Количество передач: <c:out value="${car.transmission}"/></p>
            <p>Тип привода: <c:out value="${car.driveType}"/></p>
        </div>
    </div>
</section>
<section class="manuf-sec">
    <div class="container">
        <h2 class="title">Производство</h2>
        <div class="char">
            <p>Год выпуска: <c:out value="${car.yearOfManufacture}"/></p>
        </div>
    </div>
</section>
<section class="order-sec">
    <div class="container-links">
        <a href="/form/<c:out value="${car.model}"/>" class="order-btn">Оформить заказ</a>
    </div>
</section>
<section class="links-sec">
    <div class="container-links">
        <a href="/cars" class="links">Автомобили</a>
        <br>
        <a href="/main" class="links">На главную страницу</a>
    </div>
</section>
<footer class="footer">
    <div class="footer-info">
        <p>Информация взята из официальных источников</p>
    </div>
</footer>
</body>
</html>
