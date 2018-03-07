<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<body>
<form:form method="POST" action="/persons/create" modelAttribute="person">
    <fieldset>
        <legend>Create a Person</legend>
        <form:label path="first_name">First Name:
            <form:errors path="first_name"/>
            <form:input path="first_name"/>
        </form:label>

        <form:label path="last_name">Last Name:
            <form:errors path="last_name"/>
            <form:input path="last_name"/>
        </form:label>

        <input type="submit" value="Create new Person">
    </fieldset>
</form:form>
</body>
</html>