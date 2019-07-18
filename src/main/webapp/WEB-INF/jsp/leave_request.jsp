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
    <title>Title</title>
</head>
<body>
    <form action="/leave/empLeave" method="post">
        开始时间：<input type="date" name="startdate">
        结束时间：<input type="date" name="enddate">
        理由：<input type="text" name="reason">
        <input type="submit" value="提交">
    </form>
</body>
</html>
