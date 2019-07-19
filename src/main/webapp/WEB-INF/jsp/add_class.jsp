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
</head>
<body>
    <form action="/addClass">
        班级名:<input type="text" name="cName">
        课程：
        <select name="courseId">
            <c:forEach items="${course}" var="c">
                <option value="${c.courseId}">${c.courseName}</option>
            </c:forEach>
        </select>
        <input type="submit" value="添加">
    </form>
</body>
</html>
