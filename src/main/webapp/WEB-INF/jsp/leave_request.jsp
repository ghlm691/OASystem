<%--
  Created by IntelliJ IDEA.
  User: LM
  Date: 2019/7/17
  Time: 22:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>请假申请</title>
    <link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.css" rel="stylesheet">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.4.1.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.js"></script>
</head>
<body>
    <nav class="navbar navbar-expand-lg navbar-light bg-primary">
        <a class="navbar-brand" >请假申请</a>|
        <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
            <div class="navbar-nav">
                <a class="btn btn-primary" href="/Staff">返回</a>
            </div>
        </div>
    </nav>

    <form action="/leave/empLeave" method="post">
        <table cellpadding="30" align="center">
            <tr><td>开始时间：</td><td><input type="date" name="startdate"></td></tr>
            <tr><td>结束时间：</td><td><input type="date" name="enddate"></td></tr>
            <tr><td>请假理由：</td><td><input type="text" name="reason"></td></tr>
            <tr><td colspan="2" align="center"><input type="submit" value="提交" class="btn btn-primary" onclick="subForm()"></td></tr>
        </table>
    </form>
</body>
</html>
