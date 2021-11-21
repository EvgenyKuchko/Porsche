<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Форма для доставки</title>
</head>
<body>
<h1>Форма для доставки</h1>
<form:form action="/form/{model}" modelAttribute="form"  method="post">

    <div>
        <form:label path="city">City:</form:label>
        <form:input path="city" id="city"/>
        <form:errors path="city"></form:errors>
    </div>

    <div>
        <form:label path="country">Country:</form:label>
        <form:input path="country" id="country"/>
        <form:errors path="country"></form:errors>
    </div>

    <div>
        <form:label path="phoneNumber">Phone Number:</form:label>
        <form:input path="phoneNumber" id="phoneNumber"/>
        <form:errors path="phoneNumber"></form:errors>
    </div>

    <div>
        <form:input path=""
    </div>

    <div><input type="submit" value="Оформить заказ"/></div>
</form:form>
<br>
<h2><a href="/main">На главную страницу</a></h2>
</body>
</html>
