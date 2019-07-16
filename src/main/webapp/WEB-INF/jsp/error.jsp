<%--
  Created by IntelliJ IDEA.
  User: Jerry
  Date: 2019/7/16
  Time: 14:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>没有权限</title>
    <link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.css" rel="stylesheet">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.4.1.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.js"></script>
</head>
<body style="background: url(${pageContext.request.contextPath}/image/1.jpg);background-size:100% 100%;">
<nav class="navbar navbar-expand-lg navbar-light bg-primary">
    <a class="navbar-brand">您没有此权限</a>|
    <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
        <div class="navbar-nav">
            <a class="btn btn-primary" href="/Staff">返回</a>
        </div>
    </div>
</nav>
</body>
</html>
