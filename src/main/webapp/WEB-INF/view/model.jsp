<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<spring:message code=""/>
<html>
<head>
    <title><c:out value="${car.model}"/></title>
    <%@ page isELIgnored="false" %>
    <link rel="stylesheet" href="/static/css/model.css" type="text/css"/>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/gh/fancyapps/fancybox@3.5.7/dist/jquery.fancybox.min.css" />
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
<section class="title-sec">
    <div class="title-info">
        <h1 class="model-name"><c:out value="${car.model}"/></h1>
    </div>
    <div class="top-desc">
        <div class="wrapper">
            <div class="desc-info">
                <h2 class="title"><spring:message code="app.model.price"/></h2>
                <p class="char-top"><c:out value="${car.price}"/></p>
            </div>
            <div class="desc-info">
                <h2 class="title"><spring:message code="app.model.power"/></h2>
                <p class="char-top"><c:out value="${car.power}"/></p>
            </div>
            <div class="desc-info">
                <h2 class="title"><spring:message code="app.model.maxSpeed"/></h2>
                <p class="char-top"><c:out value="${car.maxSpeed}"/></p>
            </div>
        </div>
    </div>
</section>
<section class="pics">
    <div class="wrapper">
        <div class="pics-show">
            <c:forEach var="pic" items="${car.pics}">
                <a data-fancybox="images" data-caption="My caption" href="${pic.filePath}">
                <img src="${pic.filePath}" class="pictures"/>
                </a>
            </c:forEach>
        </div>
    </div>
</section>
<hr>
<section class="engine-sec">
    <div class="container">
        <h2 class="title"><spring:message code="app.model.engine"/></h2>
        <div class="char">
            <p><spring:message code="app.model.engine.val"/> <c:out value="${car.engineDisplacement}"/></p>
            <p><spring:message code="app.model.engine.fuelType"/> <c:out value="${car.fuelType}"/></p>
        </div>
    </div>
</section>
<hr>
<section class="body-sec">
    <div class="container">
        <h2 class="title"><spring:message code="app.model.body"/></h2>
        <div class="char">
            <p><spring:message code="app.model.body.type"/> <c:out value="${car.bodyType}"/></p>
            <p><spring:message code="app.model.body.passengers"/> <c:out value="${car.places}"/></p>
            <p><spring:message code="app.model.body.length"/> <c:out value="${car.length}"/></p>
            <p><spring:message code="app.model.body.height"/> <c:out value="${car.height}"/></p>
            <p><spring:message code="app.model.body.weight"/> <c:out value="${car.weight}"/></p>
            <p><spring:message code="app.model.body.payload"/> <c:out value="${car.payload}"/></p>
            <p><spring:message code="app.model.body.doors"/> <c:out value="${car.numberOfDoors}"/></p>
            <p><spring:message code="app.model.body.interior"/> <c:out value="${car.interior}"/></p>
        </div>
    </div>
</section>
<hr>
<section class="expl-sec">
    <div class="container">
        <h2 class="title"><spring:message code="app.model.perf"/></h2>
        <div class="char">
            <p><spring:message code="app.model.perf.acceleration"/> <c:out value="${car.acceleration}"/></p>
            <p><spring:message code="app.model.perf.inCity"/> <c:out value="${car.fuelConsInTheCity}"/></p>
            <p><spring:message code="app.model.perf.outCity"/> <c:out value="${car.fuelConsOutsideTheCity}"/></p>
            <p><spring:message code="app.model.perf.comb"/> <c:out value="${car.combinedFuelCons}"/></p>
            <p><spring:message code="app.model.perf.fuelVol"/> <c:out value="${car.fuelTankVolume}"/></p>
        </div>
    </div>
</section>
<hr>
<section class="transmission-sec">
    <div class="container">
        <h2 class="title"><spring:message code="app.model.transmission"/></h2>
        <div class="char">
            <p><spring:message code="app.model.transmission.type"/> <c:out value="${car.typeOfTransmission}"/></p>
            <p><spring:message code="app.model.transmission.numb"/> <c:out value="${car.transmission}"/></p>
            <p><spring:message code="app.model.transmission.drType"/> <c:out value="${car.driveType}"/></p>
        </div>
    </div>
</section>
<hr>
<section class="manuf-sec">
    <div class="container">
        <h2 class="title"><spring:message code="app.model.manufacture"/></h2>
        <div class="char">
            <p><spring:message code="app.model.manufacture.year"/> <c:out value="${car.yearOfManufacture}"/></p>
        </div>
    </div>
</section>
<hr>
<section class="order-sec">
    <div class="container-links">
        <a href="/form/<c:out value="${car.model}"/>" class="order-btn"><spring:message code="app.model.order"/></a>
    </div>
</section>
<section class="links-sec">
    <div class="container-links">
        <a href="/cars" class="links"><spring:message code="app.model.link.car"/></a>
        <br>
        <a href="/main" class="links"><spring:message code="app.link.main.page"/></a>
    </div>
</section>
<footer class="footer">
    <div class="footer-info">
        <p><spring:message code="app.footer"/></p>
    </div>
</footer>
<script src="https://cdn.jsdelivr.net/npm/jquery@3.4.1/dist/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/gh/fancyapps/fancybox@3.5.7/dist/jquery.fancybox.min.js"></script>
</body>
</html>
