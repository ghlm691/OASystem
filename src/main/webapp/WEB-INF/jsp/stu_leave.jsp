<%--
  Created by IntelliJ IDEA.
  User: 啦妈西
  Date: 2019/7/16
  Time: 14:04
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.css" />
    <script type="text/javascript" src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/DatePicker.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.4.1.js"></script>
    <title>学生请假页面</title>
</head>
<body>
    <form action="" method="post">
        <input type="hidden" name="uid" value="${sid}">
        起始时间：<input type="text" readonly="readonly" class="form-control" onclick="setday(this)" name="startDate"/>
        结束时间：<input type="text" readonly="readonly" class="form-control" onclick="setday(this)" name="endDate"/><br>
        原因:<input type="text" name="reason"><br>
        <input type="submit" value="提交">
    </form>
</body>
</html>
