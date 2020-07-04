<%@ page import="java.util.Arrays" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--Expression language jest włączony--%>
<%@ page isELIgnored="false" %>
<%--JSTL jest włączony--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<h2>Books</h2>

<%
    List<String> myList = Arrays.asList("jedrzej", "adam", "ewa");

    request.setAttribute("names", myList);
%>

<jsp:useBean id="myBook" class="pl.jnowacki.Book"/>
<jsp:setProperty name="myBook" property="*"/>

<div id="book" style="color: ${param.color}">
    Book title: ${myBook.title}, book author: ${myBook.author}
</div>

<p id="par"></p>

<%
    for(String name: myList) {
        out.print(name);
    }
%>

<ol>
    <c:forEach items="${requestScope.names}" var="name">
        <li>${name}</li>
    </c:forEach>
</ol>

<c:if test="${param.test}">
    jakas wartosc
</c:if>

<c:if test="${!param.test}">
    nie ma paramsa
</c:if>

<br/>

<c:choose>
    <c:when test="${'v1'.equals(param.p1)}">
        wartosc 1
    </c:when>
    <c:when test="${'v2'.equals(param.p1)}">
        wartosc 2
    </c:when>
    <c:otherwise>
        inna wartosc
    </c:otherwise>
</c:choose>

<script>
    // alert('this is alert');
    document.getElementById('par').innerHTML = 'this comes from js!'
</script>

</body>
</html>
