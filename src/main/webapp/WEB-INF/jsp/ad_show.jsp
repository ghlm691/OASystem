<%--
  Created by IntelliJ IDEA.
  User: 啦妈西
  Date: 2019/7/18
  Time: 17:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.css" rel="stylesheet">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.4.1.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.js"></script>
    <title>员工展示页面</title>
    <script>
        $(function () {
            $("#getBtn").click(function(){
                var name = $("#name").val();//需要搜索的姓名
                $.post("/getUser",{name:name},function(d){
                    var tables = $("#table tr");
                    tables.remove();
                    var top = "<tr><td>帐号</td><td>姓名</td><td>职务</td></tr>";
                    $("#table").append(top);
                    var list = "<tr id='tr" + d.user.id + "'><td>" + d.user.username + "</td><td>" + d.user.name + "</td><td>" + d.user.rname + "</td></tr>";
                    $("#table").append(list);
                },"json");
            });
        });
    </script>
</head>
<body>
    员工姓名：<input type="text" id="name"> <button id="getBtn">查询</button>
    <table id="table">
        <tr>
            <td></td>
            <td></td>
            <td></td>
        </tr>
    </table>
</body>
</html>
