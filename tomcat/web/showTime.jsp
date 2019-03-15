<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    Cookie[] cookies = request.getCookies();
    boolean flag = false;
    if (cookies!=null&&cookies.length>0){
        for (Cookie cookie : cookies) {
            String name = cookie.getName();
            if ("lastTime".equals(name)){
                flag=true;
                Date date = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日HH时mm分ss秒");
                String format = sdf.format(date);

                cookie.setMaxAge(60*60*24*30);
                String value = cookie.getValue();
                response.getWriter().write("时间Time:"+value);
                cookie.setValue(format);
                response.addCookie(cookie);
                break;
            }
        }
    }
    if (cookies==null||cookies.length==0||flag==false){
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日HH时mm分ss秒");
        String format = sdf.format(date);
        Cookie cookie = new Cookie("lastTime", format);
        cookie.setMaxAge(60*60*24*30);
        response.addCookie(cookie);
        response.getWriter().write("first时间Time:"+format);
    }

%>
</body>
</html>
