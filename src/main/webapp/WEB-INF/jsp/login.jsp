<%--
  Created by IntelliJ IDEA.
  User: Jerry
  Date: 2019/7/3
  Time: 8:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录页面</title>
    <link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.css" rel="stylesheet">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.4.1.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.js"></script>
</head>
<body class="text-center">
<form action="/login" method="post" class="form-signin">
    <h1 class="h3 mb-3 font-weight-normal">滴答教学OA办公平台</h1>
    <table cellpadding="10" align="center">
        <tr>
            <td algin="right">用户id：</td>
            <td><input type="text" name="id" id="id" class="form-control" placeholder="Userid" required autofocus></td>
        </tr>
        <tr><td algin="right">密码：</td>
            <td><input type="password" name="password" id="password" class="form-control" placeholder="Password" required></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="登录" id="login" class="btn btn-lg btn-primary btn-block"></td>
        </tr>
    </table>
    <p class="mt-3 mb-3 text-muted">&copy; 王正涛&nbsp;&nbsp;&nbsp;&nbsp;刘铭&nbsp;&nbsp;&nbsp;&nbsp;赖文熙</p>
</form>

</body>
</html>
