<%--
  Created by IntelliJ IDEA.
  User: Jerry
  Date: 2019/7/15
  Time: 18:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>滴答教学OA办公平台</title>
    <link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.css" rel="stylesheet">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.4.1.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.js"></script>
</head>
<body class="text-center">
    <nav class="navbar navbar-expand-lg navbar-light bg-primary">
        <a class="btn btn-primary" href="/UpdatePassword">修改密码</a>|
        <a class="btn btn-primary" href="/AllWeekly?method=All">周报查看</a>|
        <a class="btn btn-primary" href="">请假审批</a>|
        <a class="btn btn-primary" href="">学生成绩管理</a>|
        <a class="btn btn-primary" href="">学生信息查看</a>|
        <a class="btn btn-primary" href="">个人请假</a>|
        <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
            <div class="navbar-nav">
                <a class="btn btn-primary" href="">退出</a>
            </div>
        </div>
    </nav>
    <table cellpadding="30" align="center">
        <tr><td><h2>欢迎使用滴答教学OA办公平台</h2></td></tr>
        <tr><td><h5>您好：</h5></td></tr>
        <tr><td><h5>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;您现在使用的是千锋公司开发的滴答教学OA办公平台，通过该系统，</h5></td></tr>
        <tr><td><h5>您可以在线完成个人资料管理；请假申请以及审批工作，同时还可以对学</h5></td></tr>
        <tr><td><h5>生信息还有学生成绩进行维护。</h5></td></tr>
    </table>
</body>
</html>
