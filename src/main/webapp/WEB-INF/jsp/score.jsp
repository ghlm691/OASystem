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
    <link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.css" rel="stylesheet">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.4.1.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.js"></script>
    <title>成绩管理页面</title>
    <script>
        $(function(){
            $(".firstSelect").change(function(){
                var cid =$('#firstSelect option:selected').val();
                //var please = "--请选择--";
                $.post("/changeScore",{cid:cid},function(d){
                    var tables = $("#table tr");
                    tables.remove();
                    var top ="<tr><td>编号</td><td>学生姓名</td><td>第一阶段</td><td>第二阶段</td><td>第三阶段</td><td>第四阶段</td><td>操作</td></tr>";
                    $("#table").append(top);
                    for (var i = 0;i < d.sList.length;i++){
                        var list = "<tr><td>" + d.sList[i].id + "</td><td>" + d.sList[i].name + "</td><td>" + d.sList[i].scoreList[0] + "</td><td>" + d.sList[i].scoreList[1] + "</td><td>" + d.sList[i].scoreList[2] + "</td><td>" + d.sList[i].scoreList[3] + "</td><td><a href=''>查看走势图</a></td></tr>";
                        $("#table").append(list);
                    }
                    // var options= $("#secondSelect option");
                    // options.remove();
                    // var o ="<option value='0'>" + please + "</option>";
                    // $("#secondSelect").append(o);
                    // for(var i = 0;i<d.second.length;i++){
                    //     var option = "<option value=" + d.second[i].id + ">" + d.second[i].name + "</option>";
                    //     $("#secondSelect").append(option);
                    //}
                },"json");
            });
        });
    </script>
</head>
<body>
    <a href="">添加学生成绩</a>
    <form>
        <select name="classes" class="firstSelect" id="firstSelect">
            <c:forEach items="${classList}" var="c">
                <option value="${c.cid}">${c.cname}</option>
            </c:forEach>
        </select>
        <div>
            <table id="table">
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
                            <a href="">查看走势图</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </form>
</body>
</html>
