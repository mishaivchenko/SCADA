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
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" type="text/css" href="../../libs/bootstrap-4.1.3/css/bootstrap.min.css">
<script type="text/javascript" src="libs/jquery-3.3.1/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="libs/propper-1.11.0/popper.min.js"></script>
<script type="text/javascript" src="libs/bootstrap-4.1.3/js/bootstrap.min.js"></script>

<script src="http://code.jquery.com/jquery-2.2.4.js" type="text/javascript"></script>
<script src="Show_Rigisters_Words.js" defer type="text/javascript"></script>
<script src="Show_Rigisters_Value.js" defer type="text/javascript"></script>
<script src="Show_Rigisters_Info.js" defer type="text/javascript"></script>
<html>
<head>


</head>

<title>Progress bar</title>
<body onload="show_Words();show_Value();show_Info()">
<jsp:include page="header.jsp"/>
<div class="row col-md-12 justify-content-end">
    <div id="MyFuckingMap3"></div>
</div>
<div class="form-row justify-content-md-center">
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
<div id="end" class="row justify-content-md-center">
    <p><a href="${pageContext.request.contextPath}/saveResults.jsp">Завершить</a></p>
</div>



</body>
<script src="https://code.highcharts.com/highcharts.js"></script>
<script src="https://code.highcharts.com/modules/exporting.js"></script>
<script src="https://code.highcharts.com/modules/export-data.js"></script>
</html>
