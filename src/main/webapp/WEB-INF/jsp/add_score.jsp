<%--
  Created by IntelliJ IDEA.
  User: Jerry
  Date: 2019/7/18
  Time: 15:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加学生成绩</title>
    <link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.css" rel="stylesheet">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.4.1.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.js"></script>

    <script type="text/javascript">
        var flag = true;
        function checkScoure1() {
            var score1 = document.getElementById("score1").value;
            var reg =/^100$|^(\d|[1-9]\d)$/;
            if(!reg.test(score1)){
                document.getElementById("wscoureError1").innerHTML="分数必须是0-100的整数";
                document.getElementById("score1").focus();
                flag=false;
            }else{
                flag=true;
                document.getElementById("wscoureError1").innerHTML="";
            }
        }

        function checkScoure2() {
            var score2 = document.getElementById("score2").value;
            var reg =/^100$|^(\d|[1-9]\d)$/;
            if(!reg.test(score2)){
                document.getElementById("wscoureError2").innerHTML="分数必须是0-100的整数";
                document.getElementById("score2").focus();
                flag=false;
            }else{
                flag=true;
                document.getElementById("wscoureError2").innerHTML="";
            }
        }

        function checkScoure3() {
            var score3 = document.getElementById("score3").value;
            var reg =/^100$|^(\d|[1-9]\d)$/;
            if(!reg.test(score3)){
                document.getElementById("wscoureError3").innerHTML="分数必须是0-100的整数";
                document.getElementById("score3").focus();
                flag=false;
            }else{
                flag=true;
                document.getElementById("wscoureError3").innerHTML="";
            }
        }

        function checkScoure4() {
            var score4 = document.getElementById("score4").value;
            var reg =/^100$|^(\d|[1-9]\d)$/;
            if(!reg.test(score4)){
                document.getElementById("wscoureError4").innerHTML="分数必须是0-100的整数";
                document.getElementById("score4").focus();
                flag=false;
            }else{
                flag=true;
                document.getElementById("wscoureError4").innerHTML="";
            }
        }

        function subForm(){
            if(flag){
                document.getElementById("form1").submit();
            }
        }
    </script>
</head>
<body>
    <nav class="navbar navbar-expand-lg navbar-light bg-primary">
        <a class="navbar-brand">添加学生成绩</a>|
        <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
            <div class="navbar-nav">
                <a class="btn btn-primary" href="/toScore?uid=${sessionScope.user.id}">返回</a>
            </div>
        </div>
    </nav>

    <form action="" method="post" id="form1">
        <table cellpadding="30" align="center">
            <tr><td>学生姓名：</td><td><input type="text" name="name"></td></tr>
            <tr><td>第一阶段成绩：</td><td><input type="text" name="score1" id="score1" onblur="checkScoure1()"></td><td width="40%"><span id="wscoureError1" style="color:red;"></span></td></tr>
            <tr><td>第二阶段成绩：</td><td><input type="text" name="score2" id="score2" onblur="checkScoure2()"></td><td><span id="wscoureError2" style="color:red;"></span></td></tr>
            <tr><td>第三阶段成绩：</td><td><input type="text" name="score3" id="score3" onblur="checkScoure3()"></td><td><span id="wscoureError3" style="color:red;"></span></td></tr>
            <tr><td>第四阶段成绩：</td><td><input type="text" name="score4" id="score4" onblur="checkScoure4()"></td><td><span id="wscoureError4" style="color:red;"></span></td></tr>
            <tr><td colspan="2" align="center"><input type="button" value="提交" class="btn btn-primary" onclick="subForm()"></td></tr>
        </table>
    </form>
</body>
</html>
