<%--
  Created by IntelliJ IDEA.
  User: 啦妈西
  Date: 2019/7/18
  Time: 17:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>角色管理</title>
</head>
<body>
    <form action="/addRole">
        角色名：<input type="text" name="roleName">
        <input type="submit" value="提交">
    </form>
    <table>
        <tr>
            <td>角色</td>
            <td>操作</td>
        </tr>
        <c:forEach items="${rList}" var="r">
            <tr id="${r.rid}">
                <td>${r.rname}</td>
                <td><a href="/delRole?rid=${r.rid}">删除</a></td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
