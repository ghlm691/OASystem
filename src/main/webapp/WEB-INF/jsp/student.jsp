<%--
  Created by IntelliJ IDEA.
  User: 啦妈西
  Date: 2019/7/15
  Time: 18:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生页面</title>
    <link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.css" rel="stylesheet">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.4.1.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.js"></script>
</head>
<body class="text-center">
   <%-- 欢迎你！${student.cname}的${student.sname}！

    您可以：<a href="/student_change?sid=${student.sid}">个人信息修改</a> <a href="/student_weekly?sid=${student.sid}">查看周报</a>
    <a href="/student_leave?sid=${student.sid}">请假详情</a> <a href="/stu_logout">退出</a>
--%>

    <nav class="navbar navbar-expand-lg navbar-light bg-primary">
        <a class="btn btn-primary" href="${pageContext.request.contextPath}/student_change?sid=${student.sid}">个人资料管理</a>|
        <a class="btn btn-primary" href="${pageContext.request.contextPath}/student_weekly?sid=${student.sid}">查看周报</a>|
        <a class="btn btn-primary" href="${pageContext.request.contextPath}/student_leave?sid=${student.sid}">请假详情</a>|
        <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
            <div class="navbar-nav">
                <a class="navbar-brand">欢迎你！${student.cname}的${student.sname}！</a>
                <a class="btn btn-primary" href="/stu_logout">退出</a>
            </div>
        </div>
    </nav>
    <table cellpadding="30" align="center">
        <tr><td><h2>欢迎使用滴答教学OA办公平台</h2></td></tr>
        <tr><td><h4>您好：</h4></td></tr>
        <tr><td><h4>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;您现在使用的是千锋公司开发的滴答教学OA办公平台，通过该系统，</h4></td></tr>
        <tr><td><h4>您可以在线完成个人资料管理，查看周报以及请假详情。</h4></td></tr>
    </table>
</body>
</html>
