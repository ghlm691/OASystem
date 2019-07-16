<%--
  Created by IntelliJ IDEA.
  User: 啦妈西
  Date: 2019/7/16
  Time: 10:09
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生个人信息修改</title>
</head>
<body>
    <form action="/stu_update" method="post">
        <input type="hidden" name="sid" value="${student.sid}">
        账号：<input type="text" name="username">
        年龄：<input type="text" name="age">
        性别：
        <select name="sex">
            <option value="0">女</option>
            <option value="1">男</option>
        </select>
        <input type="submit" value="提交">
    </form>
</body>
</html>
