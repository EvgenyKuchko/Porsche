<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Таблица сделок</title>
</head>
<body>
<header>

</header>
<section>
<div>
    <table>
        <caption>Сделки</caption>
        <th>Дата</th>
        <th>Имя</th>
        <th>Фамилия</th>
        <th>Страна</th>
        <th>Город</th>
        <th>Телефон</th>
        <th>Модель</th>
        <th>Цена</th>
        <th>Статус</th>

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
                <td><a href="${updateLink}">Изменить сделку</a> </td>
            </tr>
        </c:forEach>

    </table>
</div>
</section>
<footer>

</footer>
<a href="/main">На главную страницу</a>
</body>
</html>
