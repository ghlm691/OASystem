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
</head>
<body>
    <table>
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
