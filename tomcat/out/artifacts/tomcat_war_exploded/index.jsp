<%--
  Created by IntelliJ IDEA.
  User: 10640
  Date: 2019/3/9
  Time: 11:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <%
    System.out.println("hello.jsp");
    String contextPath = request.getContextPath();
    out.print(contextPath);
  %>
  <%
    response.getWriter().write("response");
  %>


  </body>
</html>
