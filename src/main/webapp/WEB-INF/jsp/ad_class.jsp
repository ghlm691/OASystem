<%--
  Created by IntelliJ IDEA.
  User: 啦妈西
  Date: 2019/7/18
  Time: 18:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.css" rel="stylesheet">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.4.1.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.js"></script>
    <title>班级管理</title>
    <script>
        $(function () {
            $(".delBtn").click(function () {
                var cid = $(this).attr("id");
                $.post("/delClass",{cid:cid},function (d) {
                    alert(d.message);
                    $("tr"+d.cid).remove();
                },"json");
            });
        });
    </script>
</head>
<body class="text-center">
<nav class="navbar navbar-expand-lg navbar-light bg-primary">
    <a class="navbar-brand">班级管理</a>|
    <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
        <div class="navbar-nav">
            <a class="btn btn-primary" href="/toAddClass">添加班级</a>
        </div>
    </div>
</nav>
   <%-- <a href="/toAddClass">添加班级</a>--%>
    <table class="table table-hover">
        <tr>
            <th>班级</th>
            <th>教师</th>
            <th>班主任</th>
            <th>课程</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${cList}" var="c">
            <tr id="tr${c.cid}">
                <td>${c.cname}</td>
                <td>${c.tname}</td>
                <td>矫</td>
                <td>${c.course}</td>
                <td><button id="${c.cid}" class="delBtn btn btn-primary">删除</button></td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
