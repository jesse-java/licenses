<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>

<html>

<body>
<form:form method="POST" action="/licenses/create" modelAttribute="license">
    <fieldset>
        <legend>New License</legend>
        <form:errors path="person"/>
        Person: <form:select path="person">
           <c:forEach items="${persons}" var="p" varStatus="status">
               <option value="${p.id}">${p.first_name} ${p.last_name}</option>
           </c:forEach>
        </form:select>

        <form:label path="state">State
            <form:errors path="state"/>
            <form:input path="state"/>
        </form:label>

        <form:errors path="expiration_date"/>
        <form:input type="date" path="expiration_date"/>

        <input type="submit" value="Create new license">
    </fieldset>
</form:form>
</body>
</html>

