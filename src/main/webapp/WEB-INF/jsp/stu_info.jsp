<%--
  Created by IntelliJ IDEA.
  User: LM
  Date: 2019/7/18
  Time: 11:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>学生信息查看</title>
</head>
<body>
    <table>
        <tr>
            <th>学生姓名</th>
            <th>年龄</th>
            <th>性别</th>
            <th>所在班级</th>
        </tr>
        <c:forEach items="${students}" var="student" varStatus="i">
            <input type="hidden" name="list[${i.count - 1}].sname" value="${s.sname}">
            <tr>
                <td>${student.sname}</td>
                <td>${student.age}</td>
                <td>${student.age}</td>
                <td>${student.cname}</td>
            </tr>
        </c:forEach>
    </table>

    <a href="/file/out" type="button">导出</a>
</body>
</html>
