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
</head>
<body>
    <form action="/addWeekly" method="post">
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
    </form>
    <a href="/student?sid=${sid}">点此返回</a>
</body>
</html>
