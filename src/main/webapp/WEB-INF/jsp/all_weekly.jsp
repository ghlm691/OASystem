<%--
  Created by IntelliJ IDEA.
  User: Jerry
  Date: 2019/7/15
  Time: 20:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>周报查看</title>
    <link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.css" rel="stylesheet">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.4.1.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.js"></script>


    <script>
        $(function(){
            $(".firstSelect").change(function(){
                var cid =$('#firstSelect option:selected').val();
                $.post("/changeWeekly",{cid:cid},function(d){
                    var tables = $("#table tr");
                    tables.remove();
                    var top ="<tr><td>序号</td><td>周报题目</td><td>周报内容</td><td>周报分数</td><td>周报阶段</td><td>发布人</td><td>发布时间</td><td>操作</td></tr>";
                    $("#table").append(top);
                    for (var i = 0;i < d.wList.length;i++){
                        var list = "<tr>" +
                            "<td>" + d.wList[i].wid + "</td>" +
                            "<td>" + d.wList[i].wtitle + "</td>" +
                            "<td>" + d.wList[i].wcontent + "</td>" +
                            "<td>" + d.wList[i].wscore + "</td>" +
                            "<td>" + d.wList[i].stageName + "</td>" +
                            "<td>" + d.wList[i].uname + "</td>" +
                            "<td>" + d.wList[i].wtime + "</td>" +
                            "<td>" +
                            "<a href='detail?wid=" + d.wList[i].wid + "' class=\"btn btn-primary\">详情</a>" +
                            " <a href='javascript:void(0) id=" + d.wList[i].wid  + "'class=\"delete btn btn-primary\">删除</a>" +
                            "</td>" +
                            "</tr>";
                        $("#table").append(list);
                    }
                },"json");
            });
        });
    </script>

    <script type="text/javascript">
        $(function () {
            $(".delete").click(function () {
                var wid=$(this).attr("id");
                $.ajax({
                    url:'/' + wid,
                    type:'DELETE',
                    success:function (){
                        alert("删除成功！！！");
                        $("#tr" + wid).remove();
                    }
                })
            })
        })

    </script>
</head>
<body class="text-center">
    <nav class="navbar navbar-expand-lg navbar-light bg-primary">
        <a class="navbar-brand" >周报查看</a>|
        <a class="btn btn-primary" >
            <select name="classes" class="firstSelect" id="firstSelect">
                <c:forEach items="${classList}" var="c">
                    <option value="${c.cid}">${c.cname}</option>
                </c:forEach>
            </select>
        </a>
        |<a class="btn btn-primary" href="/AllWeekly?pageNum=${pageInfo.pageNum}&uid=${sessionScope.user.id}&method=mark">查看已打分周报</a>|
        <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
            <div class="navbar-nav">
                <a class="btn btn-primary" href="/Staff">返回</a>
            </div>
        </div>
    </nav>

    <table id="table" class="table table-hover">
        <tr>
            <th>序号</th>
            <th>周报题目</th>
            <th>周报内容</th>
            <th>周报分数</th>
            <th>周报阶段</th>
            <th>发布人</th>
            <th>发布时间</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${pageInfo.list}" var="list" varStatus="i">
            <tr id="tr${list.wid}">
                <th>${i.count}</th>
                <td>${list.wtitle}</td>
                <td>${list.wcontent}</td>
                <td>${list.wscore}</td>
                <td>${list.stageName}</td>
                <td>${list.uname}</td>
                <td>${list.wtime}</td>
                <td>
                    <a href="/detail?wid=${list.wid}&pageNum=${pageInfo.pageNum}" class="btn btn-primary">详情</a>
                    <a href="javascript:void(0)" class="delete btn btn-primary" id="${list.wid}">删除</a>
                </td>
            </tr>
        </c:forEach>
    </table>

    <div align="center">
        共${pageInfo.pages}页|
        <c:if test="${pageInfo.hasPreviousPage eq false}">
            首页|上一页
        </c:if>
        <c:if test="${pageInfo.hasPreviousPage eq true}">
            <a href="/AllWeekly?method=All">首页</a>|<a href="/AllWeekly?pageNum=${pageInfo.prePage}&method=All">上一页</a>|
        </c:if>
        <c:forEach begin="1" end="${pageInfo.pages}" var="i">
            <c:if test="${i == pageInfo.pageNum }">
                ${i }
            </c:if>
            <c:if test="${i != pageInfo.pageNum }">
                <a href="/AllWeekly?pageNum=${i }&method=All">${i }</a>
            </c:if>
        </c:forEach>
        <c:if test="${pageInfo.hasNextPage eq true}">
            |<a href="AllWeekly?pageNum=${pageInfo.nextPage}&method=All">下一页</a>|<a href="AllWeekly?pageNum=${pageInfo.lastPage}&method=All">尾页</a>
        </c:if>
        <c:if test="${pageInfo.hasNextPage eq false}">
            |下一页|尾页
        </c:if>
    </div>
</body>
</html>
