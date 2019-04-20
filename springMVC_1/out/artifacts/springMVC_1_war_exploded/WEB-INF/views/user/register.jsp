<%--
  Created by IntelliJ IDEA.
  User: gyf
  Date: 2018/5/23
  Time: 16:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/user/register3.do" method="post">
    用户名:<input type="text" name="user.username"><br>
    密码:<input type="text" name="user.password"><br>
    性别:<input type="text" name="user.gender"><br>
    年龄:<input type="text" name="user.age"><br>
    生日:<input type="text" name="user.birthday"><br>
    爱好:<input type="checkbox" name="user.hobbyIds" value="1">打球
    <input type="checkbox" name="user.hobbyIds" value="2">打人
    <input type="checkbox" name="user.hobbyIds" value="3">打假<br>
    <input type="submit">
</form>

<br>
接收集合类型参数<br>
<form action="${pageContext.request.contextPath}/user/register4.do" method="post">
    用户名1:<input type="text" name="users[0].username"><br>
    密码1:<input type="text" name="users[0].password"><br>
    <hr>
    用户名2:<input type="text" name="users[1].username"><br>
    密码2:<input type="text" name="users[1].password"><br>

    <input type="submit" value="保存">
</form>

<br>表单使用Map来接收<br>
<form action="${pageContext.request.contextPath}/user/register5.do" method="post">
    用户名:<input type="text" name="infos['username']"><br>
    密码:<input type="text" name="infos['password']"><br>
    性别:<input type="text" name="infos['gender']"><br>
    年龄:<input type="text" name="infos['age']"><br>
    <input type="submit">
</form>
</body>
</html>
