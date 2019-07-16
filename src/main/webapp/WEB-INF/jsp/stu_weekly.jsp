<%--
  Created by IntelliJ IDEA.
  User: 啦妈西
  Date: 2019/7/16
  Time: 14:44
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>你的周报</title>
</head>
<body>
    <a href="/student_addWeekly?sid=${sid}">点此添加周报</a>
    <table>
        <tr>
            <td>标题</td>
            <td>内容</td>
            <td>发布时间</td>
            <td>分数</td>
            <td>阶段</td>
        </tr>
        <c:forEach items="${weeklyList}" var="w" varStatus="i">
            <tr id="tr${w.wid}">
                <td>${w.wtitle}</td>
                <td>${w.wcontent}</td>
                <td>${w.wtime}</td>
                <c:if test="${w.wscore ne 0}">
                    <td>${w.wscore}</td>
                </c:if>
                <c:if test="${w.wscore eq 0}">
                    <td>暂未打分</td>
                </c:if>
                <td>${w.stageName}</td>
            </tr>
        </c:forEach>
    </table>
    <a href="/student?sid=${sid}">点此返回</a>
</body>
</html>
