<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<body>
<h1><c:out value="${person.first_name}"/> <c:out value="${person.last_name}"/></h1>
<h3>License Number: <c:out value="${person.license.number}"/></h3>
<h3>State: <c:out value="${person.license.state}"/></h3>
<h3>Expiration Date: <c:out value="${person.license.expiration_date}"/></h3>
</body>
</html>