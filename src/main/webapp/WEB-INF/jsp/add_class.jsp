<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 啦妈西
  Date: 2019/7/19
  Time: 9:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加班级</title>
    <link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.css" rel="stylesheet">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.4.1.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.js"></script>
</head>
<body>
    <nav class="navbar navbar-expand-lg navbar-light bg-primary">
        <a class="navbar-brand">添加班级</a>
    </nav>
    <form action="/addClass">
        <table class="table table-hover">
            <tr><td>班级名:</td><td><input type="text" name="cName"></td></tr>
            <tr>
                <td>课程：</td>
                <td>
                    <select name="courseId">
                        <c:forEach items="${course}" var="c">
                            <option value="${c.courseId}">${c.courseName}</option>
                        </c:forEach>
                    </select>
                </td></tr>
                <tr><td><input type="submit" value="添加" class="btn btn-primary"></td></tr>
        </table>
      <%--  班级名:<input type="text" name="cName">
        课程：
        <select name="courseId">
            <c:forEach items="${course}" var="c">
                <option value="${c.courseId}">${c.courseName}</option>
            </c:forEach>
        </select>
        <input type="submit" value="添加">--%>
    </form>
</body>
</html>
