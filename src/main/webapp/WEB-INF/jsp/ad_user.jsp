<%--
  Created by IntelliJ IDEA.
  User: 啦妈西
  Date: 2019/7/17
  Time: 17:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.css" rel="stylesheet">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.4.1.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.js"></script>
    <title>用户管理页面</title>
    <script>
        $(function(){
            $("#addBtn").click(function(){
                var name = $("#addUser").val();//需要添加的姓名
                var role = $("#role option:selected").val();
                $.post("/addUser",{role:role,name:name},function(d){
                    alert(d.message);
                    var tables = $("#table tr");
                    tables.remove();
                    var top = "<tr><td>姓名</td><td>角色</td><td>操作</td></tr>";
                    $("#table").append(top);
                    for (var i = 0;i < d.user.length;i++){
                        var list = "<tr id='tr" + d.user[i].id + "'><td>" + d.user[i].name + "</td><td>" + d.user[i].rname + "</td><td><button class='updateBtn' id='" + d.user[i].id + "'>重置密码</button> <button class='delBtn' id='" + d.user[i].id + "'>删除</button></td></tr>";
                        $("#table").append(list);
                    }
                },"json");
            });
            //删除用户
            $("body").on("click",".delBtn",function () {
                var uid = $(this).attr("id");
                $.get("/delUser",{uid:uid},function (d) {
                    alert(d.message);
                    $("#tr"+uid).remove();
                },"json");
            });
            //重置密码
            $("body").on("click",".updateBtn",function () {
                var uid = $(this).attr("id");
                $.post("/updatePwd",{uid:uid},function (d) {
                    alert(d.message);
                },"json");
            });
        });
    </script>
</head>
<body class="text-center">

    <nav class="navbar navbar-expand-lg navbar-light bg-primary">
        <a class="navbar-brand">用户管理</a>|
        <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
            <div class="navbar-nav">
                <a class="btn btn-primary" href="/backAdmin">返回</a>
            </div>
        </div>
    </nav>

    <table class="table table-hover">
        <tr><td>要添加的用户姓名:</td><td><input id="addUser" type="text"></td></tr>
        <tr>
            <td>所属角色:</td>
            <td>
                <select id="role">
                    <option value="2">校长</option>
                    <option value="3">班主任</option>
                    <option value="4">讲师</option>
                    <option value="5">学生</option>
                </select>
            </td>
        </tr>
        <tr><td><button id="addBtn" class="btn btn-primary">添加</button></td><td></td></tr>
    </table>

    <table id="table" class="table table-hover">
        <tr>
            <th>姓名</th>
            <th>角色</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${users}" var="u">
            <tr id="tr${u.id}">
                <td>${u.name}</td>
                <td>${u.rname}</td>
                <td>
                    <button class="updateBtn btn btn-primary" id="${u.id}">重置密码</button>
                    <button class="delBtn btn btn-primary" id="${u.id}">删除</button>
                </td>
            </tr>
        </c:forEach>
    </table>
   <%-- <div>
        要添加的用户姓名:<input id="addUser" type="text">
        所属角色:<select id="role">
                <option value="2">校长</option>
                <option value="3">班主任</option>
                <option value="4">讲师</option>
                <option value="5">学生</option>
            </select>
            <button id="addBtn">添加</button>
    </div>
    <table id="table">
        <tr>
            <td>姓名</td>
            <td>角色</td>
            <td>操作</td>
        </tr>
        <c:forEach items="${users}" var="u">
            <tr id="tr${u.id}">
                <td>${u.name}</td>
                <td>${u.rname}</td>
                <td>
                    <button class="updateBtn" id="${u.id}">重置密码</button>
                    <button class="delBtn" id="${u.id}">删除</button>
                </td>
            </tr>
        </c:forEach>
    </table>--%>
<%--<a href="/backAdmin">点此返回</a>--%>
</body>
</html>
