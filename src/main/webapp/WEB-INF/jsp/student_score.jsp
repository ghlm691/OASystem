<%--
  Created by IntelliJ IDEA.
  User: Jerry
  Date: 2019/7/16
  Time: 20:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>学生成绩分析</title>
    <link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.css" rel="stylesheet">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.4.1.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.js"></script>
    <script src="${pageContext.request.contextPath}/js/echarts.js"></script>
    <script src="${pageContext.request.contextPath}/js/jquery-3.4.1.js"></script>
</head>
<body class="text-center">
    <nav class="navbar navbar-expand-lg navbar-light bg-primary">
        <a class="navbar-brand">学生成绩分析</a>|
        <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
            <div class="navbar-nav">
                <a class="btn btn-primary" href="/toScore?uid=${sessionScope.user.id}">返回</a>
            </div>
        </div>
    </nav>
    <!-- 为ECharts准备一个具备大小（宽高）的Dom -->
    <div id="main" style="width: 600px;height:400px;"></div>
    <script type="text/javascript">
        // 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(document.getElementById('main'));

        // 指定图表的配置项和数据
        var option = {
            title: {
                text: '学生各阶段成绩分析'
            },
            tooltip: {},
            legend: {
                data:['成绩']
            },
            xAxis: {
                data: ["第一阶段","第二阶段","第三阶段","第四阶段"]
            },
            yAxis: {},
            series: [{
                name: '成绩',
                type: 'line',
                data: [
                    <c:forEach items="${scoreList}" var="score">
                        ${score},
                    </c:forEach>
                ]
            }]
        };

        // 使用刚指定的配置项和数据显示图表。
        myChart.setOption(option);
    </script>
</body>
</html>
