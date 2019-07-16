<%--
  Created by IntelliJ IDEA.
  User: Jerry
  Date: 2019/7/15
  Time: 19:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改密码</title>
    <link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.css" rel="stylesheet">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.4.1.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.js"></script>

    <script type="text/javascript">
        var flag=true;
        function checkP1(){
            var password1 = document.getElementById("password1").value;
            if(password1.length < 6){
                document.getElementById("pwdError1").innerHTML="密码必须6位以上";
                document.getElementById("password1").focus();
                flag=false;
            }else{
                flag=true;
                document.getElementById("pwdError1").innerHTML="";
            }
        }

        function checkP2(){
            var password1 = document.getElementById("password1").value;
            var password2 = document.getElementById("password2").value;
            if(password2 != password1){
                document.getElementById("pwdError2").innerHTML="两次输入密码不一致";
                document.getElementById("password2").focus();
                flag=false;
            }else{
                flag=true;
                document.getElementById("pwdError2").innerHTML="";
            }
        }

        function subForm(){
            if(flag){
                document.getElementById("form1").submit();
            }
        }
    </script>
</head>
<body class="text-center">
    <nav class="navbar navbar-expand-lg navbar-light bg-primary">
        <a class="btn btn-primary" >修改密码</a>|
        <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
            <div class="navbar-nav">
                <a class="btn btn-primary" href="/Staff">返回</a>
            </div>
        </div>
    </nav>
    <form action="" method="post" id="form1">
        <table cellpadding="30" align="center">
            <tr><td>请输入原密码：</td><td><input type="password" name="oldPassword"></td><td></td></tr>
            <tr><td>请输入新密码：</td><td><input type="password" name="newPassword1" id="password1" onblur="checkP1()"></td><td><span id="pwdError1"></span></td></tr>
            <tr><td>请再次输入新密码：</td><td><input type="password" name="newPassword2" id="password2" onblur="checkP2()"></td><td><span id="pwdError2"></span></td></tr>
            <tr><td colspan="2" align="center"><input type="submit" value="提交" class="btn btn-primary"></td></tr>
        </table>
    </form>
</body>
</html>
