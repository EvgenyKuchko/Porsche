<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Новости</title>
    <link rel="stylesheet" href="/static/css/news.css" type="text/css"/>
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
<hr>
<section class="news-one">
    <div class="wrapper">
        <div class="pic">
            <img class="pics" src="/static/img/news-one.jpg" alt="brilliant car">
        </div>
        <div class="info">
            <div class="news-title">
                <h2 class="ttl">Бриллиантовый porsche</h2>
            </div>
            <p class="infos">
                Стоимость знаменитого спорткара Porsche GT3 всегда вызывала вопрос: он что, бриллиантовый?
                Наконец-то производитель может честно ответить: да. По-настоящему ослепительный экспонат попал
                на выставку в Китае. Porsche GT3 сияет в ювелирном павильоне на China International Import Expo.
                Кузов суперкара украшает 400 тыс. драгоценных камней, передает телеканал «Известия». China International
                Import Expo проходит в Китае с 5 по 10 ноября. Участие в выставке должны принять и российские
                автомобили.
            </p>
        </div>
    </div>
</section>
<hr>
<section class="news-two">
    <div class="wrapper">
        <div class="pic">
            <img class="pics" src="/static/img/news-two.jpg" alt="updated cayenne">
        </div>
        <div class="info">
            <div class="news-title">
                <h2 class="ttl">Обновленный Cayenne</h2>
            </div>
            <p class="infos">
                Немецкая компания Porsche представит обновленный кроссовер Cayenne в 2022 году, сейчас автомобиль
                проходит
                серию тестов на дорогах Европы. Об этом 26 октября сообщает Motor1.
                </br>
                По данным издания, обновленный Porsche Cayenne получит узкие линзованные фары, измененный передний
                бампер,
                а также доработанную решетку радиатора. Сзади у автомобиля появятся новые фонари, соединенные между
                собой
                светодиодной полосой. Кроме того, крепление номерного знака будет перенесено с задней двери на бампер.
                </br>
                В салоне появятся видоизмененные центральная консоль и селектор выбора передач, а также новый
                информационно-развлекательный комплекс. Количество физических переключателей сведут к минимуму,
                заменив их сенсорными.
            </p>
        </div>
    </div>
</section>
<hr>
<section class="news-three">
    <div class="wrapper">
        <div class="pic">
            <img class="pics" src="/static/img/news-three.jpg" alt="tom's cruz porsche">
        </div>
        <div class="info">
            <div class="news-title">
                <h2 class="ttl">Том Круз продаёт свой porsche</h2>
            </div>
            <p class="infos">
                Аукционный дом Bring a Trailer выставил 10 августа на торги Porsche 911 Carrera Targa,
                ранее принадлежавший актеру Тому Крузу. Автомобиль 1986 года выпуска находится в Иллинойсе (США).
                Актер владел машиной год, после чего ее продал.
                </br>
                Автомобиль оснащен 3,2-литровым бензиновым мотором мощностью 230 л.с. Двигатель работает совместно с
                пятиступенчатой механической коробкой передач.

                За время эксплуатации данный Porsche 911 Carrera Targa проехал всего 14 162 км. Текущая ставка на
                автомобиль составляет $51 500 (3,8 млн рублей).
                </br>
                7 июня сообщалось, что в Москве выставили на продажу ВАЗ-2101 1973 года выпуска, который переоборудован
                в автомобиль для Госавтоинспекции.
                </br>
                Машина оборудована проблесковыми маячками и устройством громкой связи. Как утверждает продавец, седан
                подойдет для «участия в киносъемках, реконструкциях и корпоративах».
            </p>
        </div>
    </div>
</section>
<hr>
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
