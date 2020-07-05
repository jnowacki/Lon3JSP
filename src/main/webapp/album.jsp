<%@ page import="pl.jnowacki.Album" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--Expression language jest włączony--%>
<%@ page isELIgnored="false" %>
<%--JSTL jest włączony--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<style>
    table, td, th{
        border: solid 1px black;
    }

    .label {
        display: inline-block;
        width: 50px;
        margin-bottom: 10px;
    }
</style>

<head>
    <title>Album</title>
</head>
<body>

<%
    if (session.getAttribute("albums") == null) {
        session.setAttribute("albums", new ArrayList<Album>());
    }
%>

<form action="${pageContext.request.contextPath}/album.jsp" method="get">

    <label for="name" class="label">Name:</label>
    <input type="text" id="name" name="name"><br/>

    <label for="author" class="label">Author:</label>
    <input type="text" id="author" name="author"><br/>

    <label for="year" class="label">Year:</label>
    <input type="text" id="year" name="year"><br/>

    <input type="hidden" name="sent" value="true">

    <input type="submit" value="OK">
</form>

<jsp:useBean id="album" class="pl.jnowacki.Album"/>
<jsp:setProperty name="album" property="*"/>

<c:choose>
    <c:when test="${album.valid}">
        <%
            List<Album> albums = (List<Album>) session.getAttribute("albums");
            albums.add(album);
        %>
    </c:when>
    <c:otherwise>
        <h3>Dane niepoprawne!</h3>
    </c:otherwise>
</c:choose>

<table>
    <tr>
        <th>Lp.</th>
        <th>Name</th>
        <th>Author</th>
        <th>Year</th>
    </tr>

    <c:forEach items="${sessionScope.albums}" var="album" varStatus="status">
        <tr>
            <td>${status.count}</td>
            <td>${album.name}</td>
            <td>${album.author}</td>
            <td>${album.year}</td>
        </tr>
    </c:forEach>

</table>

</body>
</html>
