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
    <link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.css" rel="stylesheet">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.4.1.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.js"></script>
</head>
<body>
    <nav class="navbar navbar-expand-lg navbar-light bg-primary">
        <a class="navbar-brand">批量导入导出</a>|
        <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
            <div class="navbar-nav">
                <a class="btn btn-primary" href="/Staff">返回</a>
            </div>
        </div>
    </nav>
    <form action="/file/in" method="post" enctype="multipart/form-data">
        <table class="table table-hover">
            <tr><td> 选择文件：<input type="file" name="infile"></td></tr>
            <tr><td><input type="submit" value="导入"></td></tr>
        </table>
       <%-- 选择文件：<input type="file" name="infile">
        <input type="submit" value="导入">--%>
    </form>
<table class="table table-hover">
        <c:forEach items="${studentss}" varStatus="i" var="student">
            <tr>
                <td>${student.sname}</td>
                <td>${student.age}</td>
                <td>${student.sex}</td>
                <td>${student.cname}</td>
            </tr><br>
        </c:forEach>
</table>

</body>
</html>
