<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title><c:out value="${car.model}"/></title>
    <%@ page isELIgnored="false" %>
</head>
<body>
<center>
<h1><c:out value="${car.model}"/></h1>
<p><c:out value="${car.price}"/></p>

<h2>Двигатель</h2>
<div>
    <p>Мощность: <c:out value="${car.power}"/></p>
    <p>Объем двигателя: <c:out value="${car.engineDisplacement}"/></p>
    <p>Тип топлива: <c:out value="${car.fuelType}"/></p>
</div>

<h2>Кузов</h2>
<div>
    <p>Тип кузова: <c:out value="${car.bodyType}"/></p>
    <p>Количество мест: <c:out value="${car.places}"/></p>
    <p>Длина: <c:out value="${car.length}"/></p>
    <p>Высота: <c:out value="${car.height}"/></p>
    <p>Вес: <c:out value="${car.weight}"/></p>
    <p>Полезная загрузка: <c:out value="${car.payload}"/></p>
    <p>Количетсво дверей: <c:out value="${car.numberOfDoors}"/></p>
    <p>Материал салона: <c:out value="${car.interior}"/></p>
</div>

<h2>Эксплуатационные характеристики</h2>
<div>
    <p>Максимальная скорость: <c:out value="${car.maxSpeed}"/></p>
    <p>Разгон от 0 до 100 км/ч: <c:out value="${car.acceleration}"/></p>
    <p>Расход топлива на 100 км в городе: <c:out value="${car.fuelConsInTheCity}"/></p>
    <p>Расход топлива на 100 км за городом: <c:out value="${car.fuelConsOutsideTheCity}"/></p>
    <p>Комбинированный расход топлива на 100 км: <c:out value="${car.combinedFuelCons}"/></p>
    <p>Объем топливного бака: <c:out value="${car.fuelTankVolume}"/></p>
</div>

<h2>Трансмиссия</h2>
<div>
    <p>Тип коробки передач: <c:out value="${car.typeOfTransmission}"/></p>
    <p>Количество передач: <c:out value="${car.transmission}"/></p>
    <p>Тип привода: <c:out value="${car.driveType}"/></p>
</div>

<h2>Производство</h2>
<div>
    <p>Год выпуска: <c:out value="${car.yearOfManufacture}"/></p>
</div>

<a href="/form/<c:out value="${car.model}"/>">Оформить заказ</a>

<a href="/cars">Автомобили</a>
<a href="/main">На главную страницу</a>
</center>
</body>
</html>
