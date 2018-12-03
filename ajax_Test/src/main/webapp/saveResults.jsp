<%--
  Created by IntelliJ IDEA.
  User: Misha
  Date: 26.11.2018
  Time: 19:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=utf-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>
    <meta http-equiv='content-type' content='text/html; charset=utf-8'>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" type="text/css" href="libs/bootstrap-4.1.3/css/bootstrap.min.css">
    <title>save file</title>
</head>
<html>
<body>
<jsp:include page="header.jsp"/>

<div class="container">

    <div class="row justify-content-center">
        <c:if test="${requestScope.result==null}">
                <form class="col-lg-6" action="${pageContext.request.contextPath}/saveResult" method="get">

                   <p>Click on the button if you want to save results to file</p>
                    <div class="row justify-content-center">
                        <button type="submit" class="btn btn-primary"><c:out value="Save"/></button>
                    </div>
                </form>
        </c:if>
        ${requestScope.result}
    </div>

</div>

<script type="text/javascript" src="libs/jquery-3.3.1/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="libs/propper-1.11.0/popper.min.js"></script>
<script type="text/javascript" src="libs/bootstrap-4.1.3/js/bootstrap.min.js"></script>
</body>
</html>
