<%@ page import="java.time.LocalDateTime" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--Expression language jest włączony--%>
<%@ page isELIgnored="false" %>
<%--JSTL jest włączony--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<h2>Hello World from JSP!</h2>

<%!
    private int c = 8;

    private int add(int a, int b) {
        return a + b;
    }

    private String sayHello(String name) {
        return String.format("Hello %s!", name);
    }
%>

<%
    String myName = "name";
    int b = 1 + 3;

    if (true) {
        b = 5;
    }

    LocalDateTime.now();

    for (int i = 0; i < 5; i++) {
%>
<b>
    <%=i%>
</b>
<%
    }
%>

<%=myName%>
<%=3 + 7%>
<b><%=b%>
</b>
<b><%=c%>
</b>
<i><%=add(4, 10)%>
</i>

<br/>
<%=sayHello("Jedrzej")%>
<br/>
<%=LocalDateTime.now()%>
<br/>

<%
    int start = Integer.parseInt(request.getParameter("start"));
    int end = Integer.parseInt(request.getParameter("end"));

    for (int i = start; i <= end; i++) {
        out.print(i);
    }

    Cookie cookie = new Cookie("myLon3Cookie", request.getParameter("name"));

    response.addCookie(cookie);
%>

<%--komentarz jsp--%>
<!--html komentarz-->

<br/>
<jsp:useBean id="myPerson" class="pl.jnowacki.Person"/>

<jsp:setProperty name="myPerson" property="*"/>

<%=myPerson.getMyName()%>
<%=myPerson.getPwd()%>
<br/>

${myPerson.myName}
${myPerson.pwd}

${param.end}
</body>
</html>
