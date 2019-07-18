<%--
  Created by IntelliJ IDEA.
  User: 啦妈西
  Date: 2019/7/16
  Time: 23:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>成绩管理页面</title>
    <link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.css" rel="stylesheet">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.4.1.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.js"></script>

    <script>
        $(function(){
            $(".firstSelect").change(function(){
                var cid =$('#firstSelect option:selected').val();
                $.post("/changeScore",{cid:cid},function(d){
                    var tables = $("#table tr");
                    tables.remove();
                    var top ="<tr><td>编号</td><td>学生姓名</td><td>第一阶段</td><td>第二阶段</td><td>第三阶段</td><td>第四阶段</td><td>操作</td></tr>";
                    $("#table").append(top);
                    for (var i = 0;i < d.sList.length;i++){
                        var list = "<tr>" +
                            "<td>" + d.sList[i].id + "</td>" +
                            "<td>" + d.sList[i].name + "</td>" +
                            "<td>" + d.sList[i].scoreList[0] + "</td>" +
                            "<td>" + d.sList[i].scoreList[1] + "</td>" +
                            "<td>" + d.sList[i].scoreList[2] + "</td>" +
                            "<td>" + d.sList[i].scoreList[3] + "</td>" +
                            "<td><a href='StudentScore?sid=" + d.sList[i].id + "' class=\"btn btn-primary\">查看走势图</a>" +
                            "</td>" +
                            "</tr>";
                        $("#table").append(list);
                    }
                },"json");
            });
        });
    </script>
</head>
<body class="text-center">

    <nav class="navbar navbar-expand-lg navbar-light bg-primary">
        <a class="navbar-brand">成绩管理页面</a>|
        <a class="btn btn-primary" href="/goAddScore">添加学生成绩</a>|
        <a class="btn btn-primary" >
            <select name="classes" class="firstSelect" id="firstSelect">
            <c:forEach items="${classList}" var="c">
                <option value="${c.cid}">${c.cname}</option>
            </c:forEach>
            </select>
        </a>|
        <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
            <div class="navbar-nav">
                <a class="btn btn-primary" href="/Staff">返回</a>
            </div>
        </div>
    </nav>

    <%--<a href="">添加学生成绩</a>--%>
    <form>
        <%--<select name="classes" class="firstSelect" id="firstSelect">
            <c:forEach items="${classList}" var="c">
                <option value="${c.cid}">${c.cname}</option>
            </c:forEach>
        </select>--%>
            <table id="table" class="table table-hover">
                <tr>
                    <td>编号</td>
                    <td>学生姓名</td>
                    <td>第一阶段</td>
                    <td>第二阶段</td>
                    <td>第三阶段</td>
                    <td>第四阶段</td>
                    <td>操作</td>
                </tr>
                <c:forEach items="${score}" var="s">
                    <tr>
                        <td>${s.id}</td>
                        <td>${s.name}</td>
                        <c:forEach items="${s.scoreList}" var="slist">
                            <td>${slist}</td>
                        </c:forEach>
                        <td>
                            <a href="StudentScore?sid=${s.id}" class="btn btn-primary">查看走势图</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
    </form>
</body>
</html>
