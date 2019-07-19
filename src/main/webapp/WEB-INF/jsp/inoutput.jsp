<%--
  Created by IntelliJ IDEA.
  User: LM
  Date: 2019/7/17
  Time: 23:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>批量导入导出</title>
</head>
<body>
    <form action="/file/in" method="post" enctype="multipart/form-data">
        选择文件：<input type="file" name="infile">
        <input type="submit" value="导入">
    </form>

    <span>
        <c:forEach items="${studentss}" varStatus="i" var="student">
            <tr>
                <td>${student.sname}</td>
                <td>${student.age}</td>
                <td>${student.sex}</td>
                <td>${student.cname}</td>
            </tr><br>
        </c:forEach>
    </span>
</body>
</html>
