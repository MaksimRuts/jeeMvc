<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="by.gsu.epamlab.controller.Constants" %>
<%@ page import="by.gsu.epamlab.logic.MathOperations" %>
<html>
<head>
    <title>mvc project start page</title>
    <script type="text/javascript" src="script.js"></script>
</head>
<body>
    <h3>Numbers:</h3> <br/>
    <form method="post" action="/start" name="result">
        <c:forEach var="number" items="${numbers}" varStatus="loop">
            <input type="checkbox"
                   name="${Constants.CHECKBOX_NAME}"
                   value="${Constants.CHECKBOX_NAME}${loop.index}"
                   id="${Constants.CHECKBOX_NAME}${loop.index}"></label>
            <c:choose>
                <c:when test="${control eq Constants.VAL_TEXT}">
                    <input type="text"
                           name="${Constants.CHECKBOX_NAME}${loop.index}"
                           value="${number}"
                           size="6" readonly>
                    <br/>
                </c:when>
                <c:otherwise>
                    <label for="${Constants.CHECKBOX_NAME}${loop.index}">${number}
                        <input type="hidden"
                               name="${Constants.CHECKBOX_NAME}${loop.index}"
                               value="${number}">
                    <br/>
                </c:otherwise>
            </c:choose>
        </c:forEach>
        <input type=hidden name="action" value="">
        <a href="JavaScript:sendForm('<%= MathOperations.SUM %>')">Sum</a>&nbsp;
        <a href="JavaScript:sendForm('<%= MathOperations.MAX %>')">Max</a>&nbsp;
        <a href="JavaScript:sendForm('<%= MathOperations.MIN %>')">Min</a>&nbsp;
        <a href="JavaScript:sendForm('<%= MathOperations.AVG %>')">Avg</a>
    </form>
</body>
</html>
