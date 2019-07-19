<%--
  Created by IntelliJ IDEA.
  User: LM
  Date: 2019/7/19
  Time: 9:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>审批情况</title>
    <link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.css" rel="stylesheet">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.4.1.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.js"></script>
</head>
<body class="text-center">

    <nav class="navbar navbar-expand-lg navbar-light bg-primary">
        <a class="navbar-brand">请假详情</a>
        <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
        </div>
    </nav>

    <table class="table table-hover">
        <tr>
            <th>请假开始时间</th>
            <th>是否审批</th>
        </tr>
        <c:forEach items="${approved}" var="info" varStatus="i">
            <tr>
                <td>${info.startTime}</td>
                <td>
                    <c:if test="${info.endTime != null}">
                        已审批
                    </c:if>
                    <c:if test="${info.endTime == null}">
                        未审批
                    </c:if>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
