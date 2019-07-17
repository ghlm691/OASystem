<%--
  Created by IntelliJ IDEA.
  User: LM
  Date: 2019/7/17
  Time: 11:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>请假审批</title>
</head>
<body>
    <table>
        <tr>
            <th>请假人</th>
            <th>开始时间</th>
            <th>结束时间</th>
            <th>原因</th>
        </tr>
        <c:forEach items="${leaves}" var="leave" varStatus="i">
            <td>${leave.user.name}</td>
            <td>${leave.startdate}</td>
            <td>${leave.enddate}</td>
            <td>${leave.reason}</td>
        </c:forEach>
    </table>
</body>
</html>
