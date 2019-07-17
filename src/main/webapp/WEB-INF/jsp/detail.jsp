<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Jerry
  Date: 2019/7/16
  Time: 8:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查看周报详情</title>
    <link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.css" rel="stylesheet">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.4.1.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.js"></script>
</head>
<body>
    <nav class="navbar navbar-expand-lg navbar-light bg-primary">
        <a class="navbar-brand">查看周报详情</a>|
        <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
            <div class="navbar-nav">
                <a class="btn btn-primary" href="/AllWeekly?method=All">返回</a>
            </div>
        </div>
    </nav>
    <form action="/UpdateWscore?wid=${weekly.wid}" method="post" id="form1">
        <table class="table table-hover">
            <tr><td>周报题目：</td><td>${weekly.wtitle}</td></tr>
            <tr><td>周报内容：</td><td><span>${weekly.wcontent}</span></td></tr>
            <tr><td>周报分数：</td><td>${weekly.wscore}</td></tr>
            <tr><td>发布人：${weekly.uname}</td><td>发布时间：${weekly.wtime}</td></tr>
            <shiro:lacksRole name="leader">
                <tr><td><input type="text" name="wscore" id="wscoure"></td><td><span id="wscoureError"></span></td></tr>
                <tr><td><input type="submit" value="打分" class="btn btn-primary" onblur="checkScoure()"></td><td></td></tr>
            </shiro:lacksRole>

        </table>
    </form>

    <script type="text/javascript">
        var flag = true;
        function checkScoure() {
            var wscoure = document.getElementById("wscoure").value;
            var reg =/^100$|^(\d|[1-9]\d)$/;
            if(!reg.test(wscoure)){
                document.getElementById("wscoureError").innerHTML="分数必须是0-100的整数";
                document.getElementById("wscoure").focus();
                flag=false;
            }else{
                flag=true;
                document.getElementById("wscoureError").innerHTML="";
            }
        }

        function subForm(){
            if(flag){
                document.getElementById("form1").submit();
            }
        }
    </script>
</body>
</html>
