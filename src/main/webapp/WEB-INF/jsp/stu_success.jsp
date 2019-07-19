<%--
  Created by IntelliJ IDEA.
  User: 啦妈西
  Date: 2019/7/16
  Time: 11:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改成功</title>
    <link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.css" rel="stylesheet">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.4.1.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.js"></script>
</head>
<body class="text-center">
    <nav class="navbar navbar-expand-lg navbar-light bg-primary">
        <a class="navbar-brand">个人信息修改结果</a>|
        <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
            <div class="navbar-nav">
                <a class="btn btn-primary" href="/student?sid=${student.sid}">返回</a>
            </div>
        </div>
    </nav>
    <table cellpadding="80" align="center">
        <tr><td><h2> ${message}！</h2></td></tr>
    </table>
    <a href="/student?sid=${student.sid}" class="btn btn-primary">点此回到学生页面</a>
</body>
</html>
