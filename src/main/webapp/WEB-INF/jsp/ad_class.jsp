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
                $.get("/delClass",{cid:cid},function (d) {
                    alert(d.message);
                    $("tr"+d.cid).remove();
                },"json");
            });
        });
    </script>
</head>
<body>
    <a href="/addClass">添加班级</a>
    <table>
        <tr>
            <td>班级</td>
            <td>教师</td>
            <td>班主任</td>
            <td>课程</td>
            <td>操作</td>
        </tr>
        <c:forEach items="${cList}" var="c">
            <tr id="tr${c.cid}">
                <td>${c.cname}</td>
                <td>${c.tname}</td>
                <td>矫</td>
                <td>${course}</td>
                <td><button id="${c.cid}" class="delBtn">删除</button><a href="#">查看走势图</a></td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
