<%--
  Created by IntelliJ IDEA.
  User: Миша
  Date: 22.04.2018
  Time: 16:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; UTF-8">
    <script src="http://code.jquery.com/jquery-2.2.4.js" type="text/javascript"></script>
    <script src="Show_Rigisters_Value.js" type="text/javascript"></script>

    <title>Progress bar</title>
</head>

<h1>Result</h1>

<body onload="show_Value()">

<div id="MyFuckingMap" style="color: #46f; font-size: 150%;
	                                  font-weight: bold;"></div>
<div id = "names" hidden></div>
<div id = "values" hidden></div>


<div style = "width:40%;">
 <canvas id = "myChart" width="400" height = "400"></canvas>
 <script src=https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.2/Chart.js></script>
 <script src = "My_chart.js"></script>
<input type = "button" id = "elem" onclick="func()" value="Build Chart">
</div>
</body>
</html>
