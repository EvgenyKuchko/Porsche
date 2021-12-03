<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>О компании</title>
    <link rel="stylesheet" href="/static/css/about-company.css" type="text/css"/>
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
<section class="information">
    <div class="inf">
        <p class="info-one">
            Porsche AG - немецкий производитель автомобилей, основанный
            конструктором Фердинандом Порше в 1931 году. Штаб-квартира и основной
            завод находятся в Штутгарте, Германия.
            К моменту выпуска первого автомобиля под своим именем Фердинанд Порше успел накопить немалый опыт.
            Основанное им 25 апреля 1931 года предприятие Dr. Ing. h.c. F. Porsche GmbH под его началом уже успело
            поработать над такими проектами, как 6-цилиндровый гоночный Auto Union и Volkswagen Käfer, ставший одним
            из самых продаваемых автомобилей в истории. В 1939 году был разработан первый автомобиль компании — Porsche
            64, который стал прародителем всех будущих Porsche. Для постройки этого экземпляра Фердинанд Порше
            использовал
            многие компоненты от Volkswagen Käfer.

            В течение Второй Мировой компания занималась выпуском военной продукции — штабных автомобилей и амфибий.
            Фердинанд Порше принимал участие в разработке немецких тяжёлых танков «Тигр P», а также сверхтяжёлого танка
            «Маус».
        </p>
    </div>
    <div class="inf">
        <p class="info-two">
            Компания выпускает спортивные автомобили класса «люкс», а также внедорожники.
            Производство Porsche в значительной мере кооперируется с Volkswagen. Бок о бок
            с участием в автоспорте ведётся работа над совершенствованием конструкции автомобиля
            (и его узлов) как такового: в разные годы были разработаны синхронизаторы механической
            КПП, автоматические КПП с возможностью ручного переключения (впоследствии — с кнопками
            переключения на руле), турбонаддув для серийного автомобиля, турбонаддув с изменяемой
            геометрией крыльчатки турбины в бензиновом двигателе, электронно-управляемая подвеска
            и так далее.
        </p>
    </div>
    <div class="inf">
            <p class="info-three">
    Также компания уже в течение длительного времени ведёт активную деятельность по организации
    спортивных клубов (клубы Porsche есть во многих странах Европы и Америки) и соревнований среди
    различных классов своих машин, регулярно проводятся несколько кубковых соревнований. Этому
    направлению её деятельности посвящена компьютерная игра Need for Speed: Porsche Unleashed.
    </p>
    </div>
</section>
<section class="main-page">
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
