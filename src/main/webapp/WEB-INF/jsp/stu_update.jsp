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
    <title>学生个人信息管理</title>
    <link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.css" rel="stylesheet">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.4.1.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.js"></script>
</head>
<body class="text-center">
    <nav class="navbar navbar-expand-lg navbar-light bg-primary">
        <a class="navbar-brand">学生个人信息管理</a>|
        <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
            <div class="navbar-nav">
                <a class="btn btn-primary" href="">返回</a>
            </div>
        </div>
    </nav>

    <form action="/stu_update" method="post">
        <table class="table table-hover">
            <tr><td><input type="hidden" name="sid" value="${student.sid}"></td></tr>
            <tr><td>账号：<input type="text" name="username"></td></tr>
            <tr><td>年龄：<input type="text" name="age"></td></tr>
            <tr>
                <td>
                    性别：<select name="sex">
                <option value="0">女</option>
                <option value="1">男</option>
            </select>
                </td>
            </tr>
            <tr><td><input type="submit" value="提交" class="btn btn-primary"></td></tr>
        </table>
    </form>

    <%--<form action="/stu_update" method="post">
        <input type="hidden" name="sid" value="${student.sid}">
        账号：<input type="text" name="username">
        年龄：<input type="text" name="age">
        性别：
        <select name="sex">
            <option value="0">女</option>
            <option value="1">男</option>
        </select>
        <input type="submit" value="提交">
    </form>--%>
</body>
</html>
