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
                $.post("/addCourse",{role:role,name:name},function(d){
                    alert(d.message);
                    var tables = $("#table tr");
                    tables.remove();
                    var top = "<tr><td>课程名</td><td>讲师</td><td>操作</td></tr>";
                    $("#table").append(top);
                    for (var i = 0;i < d.cList.length;i++){
                        var list = "<tr><td>" + d.cList[i].courseName + "</td><td>" + d.cList[i].tname + "</td><td><button class='delBtn' id='${d.cList[i].id}'>删除</button></td></tr>";
                    }
                },"json");
            });
        });
    </script>
</head>
<body>
    <div>
        要添加的用户姓名:<input id="addUser" type="text">
        所属角色:<select id="role">
                <option value="2">校长</option>
                <option value="3">班主任</option>
                <option value="4">讲师</option>
                <option value="5">学生</option>
            </select>
            <button id="addBtn">添加</button>
    </div>
    <table>
        <tr>
            <td>姓名</td>
            <td>角色</td>
            <td>操作</td>
        </tr>
        <c:forEach items="${users}" var="u">
            <tr id="tr${u.name}">
                <td></td>
                <td></td>
                <td>
                    <button class="updateBtn" id="${}">重置密码</button>
                    <button class="delBtn" id="${}">重置密码</button>
                </td>
            </tr>
        </c:forEach>
    </table>
<a href="/backAdmin">点此返回</a>
</body>
</html>
