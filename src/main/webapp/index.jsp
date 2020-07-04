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
%>

<%
    String myName = "name";
    int b = 1 + 3;

    if (true) {
        b = 5;
    }

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

</body>
</html>
