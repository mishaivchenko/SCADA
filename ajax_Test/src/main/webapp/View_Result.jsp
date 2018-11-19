<%--
  Created by IntelliJ IDEA.
  User: Миша
  Date: 22.04.2018
  Time: 16:27
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" type="text/css" href="../../libs/bootstrap-4.1.3/css/bootstrap.min.css">
    <script type="text/javascript" src="libs/jquery-3.3.1/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="libs/propper-1.11.0/popper.min.js"></script>
    <script type="text/javascript" src="libs/bootstrap-4.1.3/js/bootstrap.min.js"></script>

    <script src="http://code.jquery.com/jquery-2.2.4.js" type="text/javascript"></script>
    <script src="Show_Rigisters_Value.js" type="text/javascript"></script>
    <script src="Show_Rigisters_Words.js" type="text/javascript"></script>
    <title>Progress bar</title>
</head>

<h1>Result</h1>

<body onload="show_Words();show_Value()">
<div class="form-row justify-content-md-center ">
    <div class="form-group col col-md-5">
        <div id="MyFuckingMap"></div>
    </div>
    <div class="form-group col col-md-5">

        <div id="MyFuckingMap2"></div>
    </div>
</div>
<div id="container" class="row justify-content-md-center">
    <script src="container.js"></script>
    <button type="submit" class="btn btn-primary" onclick="highChart()" value="Build Chart"></button>
</div>


<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script src="https://code.highcharts.com/highcharts.js"></script>
<script src="https://code.highcharts.com/modules/exporting.js"></script>
<script src="https://code.highcharts.com/modules/export-data.js"></script>


</body>

</html>
