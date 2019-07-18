<%--
  Created by IntelliJ IDEA.
  User: 啦妈西
  Date: 2019/7/17
  Time: 17:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.css" rel="stylesheet">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.4.1.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.js"></script>
    <title>课程管理页面</title>
    <script>
        $(function(){
            $("#addBtn").click(function(){
                var cname = $("#addCourse").val();//需要添加的课程名
                var tid = $("#teacher option:selected").val();
                $.post("/addCourse",{tid:tid,cname:cname},function(d){
                    alert(d.message);
                    var tables = $("#table tr");
                    tables.remove();
                    var top = "<tr><td>课程名</td><td>讲师</td><td>操作</td></tr>";
                    $("#table").append(top);
                    for (var i = 0;i < d.cList.length;i++){
                        var list = "<tr id='tr${d.cList[i].id}'><td>" + d.cList[i].courseName + "</td><td>" + d.cList[i].tname + "</td><td><button class='delBtn' id='" + d.cList[i].id + "'>删除</button></td></tr>";
                        $("#table").append(list);
                    }
                },"json");
            });
            $("body").on("click",".delBtn",function () {
                var id = $(this).attr("id");
                $.post("/delCourse",{id:id},function (d) {
                    alert(d.message);
                    $("#tr"+d.del).remove();
                },"json");
            });
        });
    </script>
</head>
<body>
    <div>
        添加课程:<input id="addCourse" type="text">
        讲师:<select id="teacher">
                <c:forEach items="${teachers}" var="t">
                    <option value="${t.uid}">${t.name}</option>
                </c:forEach>
            </select>
            <button id="addBtn">添加</button>
    </div>
    <table id="table">
        <tr>
            <td>课程名</td>
            <td>讲师</td>
            <td>操作</td>
        </tr>
        <c:forEach items="${courses}" var="c">
            <tr id="tr${c.id}">
                <td>${c.courseName}</td>
                <td>${c.tname}</td>
                <td><button class="delBtn" id="${c.id}">删除</button></td>
            </tr>
        </c:forEach>
    </table>
<a href="/backAdmin">点此返回</a>
</body>
</html>
