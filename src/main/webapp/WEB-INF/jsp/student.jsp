<%--
  Created by IntelliJ IDEA.
  User: 啦妈西
  Date: 2019/7/15
  Time: 18:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生页面</title>
</head>
<body>
    欢迎你！${student.cname}的${student.sname}！

    您可以：<a href="/student_change?sid=${student.sid}">个人信息修改</a> <a href="/student_change?sid=${student.sid}">查看周报</a>
    <a href="/student_change?sid=${student.sid}">请假详情</a>
</body>
</html>
