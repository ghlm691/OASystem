<%--
  Created by IntelliJ IDEA.
  User: Jerry
  Date: 2019/7/16
  Time: 14:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>超级管理员界面</title>
    <link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.css" rel="stylesheet">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.4.1.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.js"></script>
</head>
<body class="text-center">
    <nav class="navbar navbar-expand-lg navbar-light bg-primary">
        <a class="btn btn-primary" href="">课程管理</a>|
        <a class="btn btn-primary" href="">用户管理</a>|
        <a class="btn btn-primary" href="">角色管理</a>|
        <a class="btn btn-primary" href="">员工管理</a>|
        <a class="btn btn-primary" href="">班级管理</a>|
        <a class="btn btn-primary" href="">权限管理</a>|
        <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
            <div class="navbar-nav">
                <a class="btn btn-primary" href="/index">退出</a>
            </div>
        </div>
    </nav>
    <table cellpadding="30" align="center">
        <tr><td><h2>欢迎使用滴答教学OA办公平台</h2></td></tr>
        <tr><td><h5>您好：</h5></td></tr>
        <tr><td><h5>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;您现在使用的是千锋公司开发的滴答教学OA办公平台，通过该系统，</h5></td></tr>
        <tr><td><h5>您可以在线完成课程，用户，角色，员工，班级以及权限等信息的管理和</h5></td></tr>
        <tr><td><h5>维护。</h5></td></tr>
    </table>
</body>
</html>
