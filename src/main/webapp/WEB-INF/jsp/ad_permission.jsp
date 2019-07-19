<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 啦妈西
  Date: 2019/7/18
  Time: 20:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.css" rel="stylesheet">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.4.1.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.js"></script>
    <title>权限管理页面</title>
    <script>
        $(function () {
            //删除
            $("body").on("click",".delBtn",function () {
                var pid = $(this).attr("id");
                $.get("/delPermission",{pid:pid},function (d) {
                    alert(d.message);
                    $("tr"+d.pid).remove();
                },"json");
            });
            //添加
            $("body").on("click","#addBtn",function () {

            });
        });
    </script>
</head>
<body class="text-center">

    <nav class="navbar navbar-expand-lg navbar-light bg-primary">
        <a class="navbar-brand">权限管理</a>|
        <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
            <div class="navbar-nav">
                <a class="btn btn-primary" href="/backAdmin">返回</a>
            </div>
        </div>
    </nav>

    <form action="/getRole">
        <table class="table table-hover">
            <tr><td>用户姓名:<input type="text" name="name"></td></tr>
            <tr><td><input type="submit" value="提交" class="btn btn-primary"></td></tr>
        </table>
       <%-- 用户姓名:<input type="text" name="name">
        <input type="submit" value="提交">--%>
    </form>

    <table class="table table-hover">
        <tr>
            <th>权限</th>
            <th>操作</th>
            <th width="600px"></th>
        </tr>
            <c:forEach items="${pList}" var="p">
                <tr id="${p.pid}">
                    <td>${p.pname}</td>
                    <td><button id="${p.pid}" class="delBtn">删除</button></td>
                </tr>
            </c:forEach>
        <tr>
            <td><input type="text" id="permission"></td>
            <td><button id="addBtn" class="btn btn-primary">添加</button></td>
        </tr>
    </table>
</body>
</html>
