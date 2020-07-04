<%@ page import="java.util.Arrays" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--Expression language jest włączony--%>
<%@ page isELIgnored="false" %>
<%--JSTL jest włączony--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<h2>Forms</h2>

<form action="${pageContext.request.contextPath}/book.jsp" method="post">
    <input type="text" name="title">
    <input type="text" name="author">
    <input type="submit" value="SEND">
</form>

</body>
</html>
