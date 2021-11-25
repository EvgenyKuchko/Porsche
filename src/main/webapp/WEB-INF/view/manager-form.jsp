<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<header>

</header>
<section>
    <div>
        <form:form action="saveDeal" method="post" modelAttribute="deal">
            <input type="hidden" value="${deal.id}" name="dealId"/>
            <div>
                <div>
                    <label>Date</label>
                        <form:input path="creatingDate" />
                </div>
                <div>
                    <label>First Name</label>
                    <form:input path="user.firstName" />
                </div>
                <div>
                    <label>Last Name</label>
                    <form:input path="user.lastName" />
                </div>
                <div>
                    <label>Country</label>
                    <form:input path="country" />
                </div>
                <div>
                    <label>City</label>
                    <form:input path="city" />
                </div>
                <div>
                    <label>Phone number</label>
                    <form:input path="phoneNumber" />
                </div>
                <div>
                    <label>Car model</label>
                    <form:input path="car.model" />
                </div>
                <div>
                    <label>Car Price</label>
                    <form:input path="car.price" />
                </div>
            </div>
            <div>
                <form:select path="status">
                    <form:option value="Active"></form:option>
                    <form:option value="Complete"></form:option>
                    <form:option value="Failed"></form:option>
                </form:select>
            </div>
            <form:button>Подтвердить</form:button>
        </form:form>
    </div>
</section>
<footer>

</footer>
</body>
</html>
