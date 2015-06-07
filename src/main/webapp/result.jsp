<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Result page</title>
</head>
<body>
    <h3>Result page</h3>
    <form name="result" action="/start" method="post">
        result = <c:out value="${result}"/>
        <br/>
        <%--<input type="submit" value="back">--%>
        <a href="JavaScript:document.result.submit()">back</a>&nbsp;
    </form>

</body>
</html>
