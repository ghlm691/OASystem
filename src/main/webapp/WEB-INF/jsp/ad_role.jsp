<%--
  Created by IntelliJ IDEA.
  User: 啦妈西
  Date: 2019/7/18
  Time: 17:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>角色管理</title>
    <link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.css" rel="stylesheet">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.4.1.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.js"></script>
</head>
<body class="text-center">

    <nav class="navbar navbar-expand-lg navbar-light bg-primary">
        <a class="navbar-brand">角色管理</a>|
        <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
            <div class="navbar-nav">
                <a class="btn btn-primary" href="/backAdmin">返回</a>
            </div>
        </div>
    </nav>

    <form action="/addRole">
        <table class="table table-hover">
            <tr><td>角色名：<input type="text" name="roleName"></td></tr>
            <tr><td><input type="submit" value="提交" class="btn btn-primary"></td></tr>
        </table>
       <%-- 角色名：<input type="text" name="roleName">
        <input type="submit" value="提交">--%>
    </form>
    <table class="table table-hover">
        <tr>
            <th>角色</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${rList}" var="r">
            <tr id="${r.rid}">
                <td>${r.rname}</td>
                <td><a href="/delRole?rid=${r.rid}" class="btn btn-primary">删除</a></td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
