<%--
  Created by IntelliJ IDEA.
  User: 10640
  Date: 2019/4/20
  Time: 12:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/command.do" method="post">
    用户名:<input type="text" name="username"><br>
    密码:<input type="text" name="password"><br>
    性别:<input type="text" name="gender"><br>
    生日:<input type="text" name="birthday"><br>
    <input type="submit">
</form>
</body>
</html>
