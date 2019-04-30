<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <title>Title</title>
</head>
<body>
    欢迎   ${loginname}


    <table border="1">
        <tr>
            <td>ID</td>
            <td>姓名</td>
            <td>性别</td>
        </tr>
        <#list stuList?sort_by("id")?reverse as stu>
            <tr>
                <td>${stu.id}</td>
                <td>${stu.username}</td>
                <td>${stu.gender}</td>
            </tr>
        </#list>



    </table>

</body>
</html>