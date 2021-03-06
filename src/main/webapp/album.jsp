<%@ page import="pl.jnowacki.Album" %>
<%@ page import="java.util.List" %>
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

    .error {
        color: red;
    }

    .startsWithA {
        color: red;
    }

    .even {
        background-color: grey;
    }
</style>

<head>
    <title>Album</title>
</head>
<body>

<form method="post">

    <label for="name" class="label">Name:</label>
    <input type="text" id="name" name="name"><br/>

    <label for="author" class="label">Author:</label>
    <input type="text" id="author" name="author"><br/>

    <label for="year" class="label">Year:</label>
    <input type="text" id="year" name="year"><br/>

    <c:forEach items="${applicationScope.genres}" var="genre" varStatus="status">
        <label for="${genre}">${genre}</label>
        <input type="radio" id=${genre} name="genre" value="${genre}" ${status.last ? "checked": ""}><br/>
    </c:forEach>

    <input type="submit" value="OK">
</form>

<c:if test="${requestScope.hasError}">
    <h3 class="error">Dane niepoprawne!</h3>
</c:if>

<c:choose>
    <c:when test="${sessionScope.albums != null && sessionScope.albums.size() > 0}">
        <table>
            <tr>
                <th>Lp.</th>
                <th>Name</th>
                <th>Author</th>
                <th>Year</th>
                <th>Genre</th>
            </tr>

            <c:forEach items="${sessionScope.albums}" var="album" varStatus="status">
                <tr class="${album.name.startsWith("a") ? "startsWithA": ""} ${status.count % 2 == 0 ? "even": ""}">
                    <td>${status.count}</td>
                    <td>${album.name}</td>
                    <td>${album.author}</td>
                    <td>${album.year}</td>
                    <td>${album.genre}</td>
                </tr>
            </c:forEach>

        </table>
    </c:when>
    <c:otherwise>
        <h3>Dodaj swój pierwszy album!</h3>
    </c:otherwise>
</c:choose>
</body>
</html>
