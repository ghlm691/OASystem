<%--
  Created by IntelliJ IDEA.
  User: 啦妈西
  Date: 2019/7/16
  Time: 11:40
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加周报</title>
    <link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.css" rel="stylesheet">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.4.1.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.js"></script>
</head>
<body class="text-center">

    <nav class="navbar navbar-expand-lg navbar-light bg-primary">
        <a class="navbar-brand">添加周报</a>|
        <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
            <div class="navbar-nav">
                <a class="btn btn-primary" href="/student?sid=${sid}">返回</a>
            </div>
        </div>
    </nav>

    <form action="/addWeekly" method="post">
        <table class="table table-hover">
            <tr><td> <input type="hidden" name="uid" value="${sid}"></td></tr>
            <tr><td>周报题目：</td><td><input type="text" name="wtitle"></td></tr>
            <tr><td>周报内容：</td><td><textarea name="wcontent"></textarea></td></tr>
            <tr>
                <td>阶段：</td>
                <td>
                    <select name="stage">
                    <option value="1">第一阶段</option>
                    <option value="2">第二阶段</option>
                    <option value="3">第三阶段</option>
                    <option value="4">第四阶段</option>
                    </select>
                </td>
            </tr>
            <tr><td colspan="2" align="center"><input type="submit" value="提交" class="btn btn-primary"></td></tr>
        </table>
    </form>

    <%--<form action="/addWeekly" method="post">
        <input type="hidden" name="uid" value="${sid}">
        标题:<input type="text" name="wtitle">
        内容：<textarea name="wcontent"></textarea>
        阶段：
        <select name="stage">
            <option value="1">第一阶段</option>
            <option value="2">第二阶段</option>
            <option value="3">第三阶段</option>
            <option value="4">第四阶段</option>
        </select>
        <input type="submit" value="提交">
    </form>--%>
    </form>
   <%-- <a href="/student?sid=${sid}">点此返回</a>--%>
</body>
</html>
