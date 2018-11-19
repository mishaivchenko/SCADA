<%--@elvariable id="errorLoginPassMessage" type=""--%>
<%--
  Created by IntelliJ IDEA.
  User: Misha
  Date: 21.08.2018
  Time: 15:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=utf-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>
    <meta http-equiv='content-type' content='text/html; charset=utf-8'>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" type="text/css" href="libs/bootstrap-4.1.3/css/bootstrap.min.css">
    <title>Log in</title>
</head>
<html>
<body>
<jsp:include page="header.jsp"/>
<div class="container">
    <div class="row justify-content-md-center">

        <div class="col-md-auto">
            <%--   <h1>please fill out the fields and sign in</h1>--%>
            <c:if test="${User==null}">
                <c:out value="Log In Title"/>
            </c:if>
        </div>
    </div>

    <c:if test="${applicationScope.User!=null}">
        <c:redirect url="View_Result.jsp"/>
    </c:if>

    <div class="row justify-content-center">
        <c:choose>
            <c:when test="${User == null}">
                <form class="col-lg-6" action="${pageContext.request.contextPath}/Login" method="post">
                    <div class="form-group">
                        <label for="registrationUserName"><c:out value="username"/></label>
                        <input name="username" type="text" class="form-control" id="registrationUserName">
                    </div>
                    <div class="form-group">
                        <label for="exampleInputPassword1"><c:out value="password"/></label>
                        <input name="password" type="password" class="form-control" id="exampleInputPassword1">
                    </div>
                    <br/>
                        ${errorLoginPassMessage}
                    <br/>
                    <div class="row justify-content-center">
                        <button type="submit" class="btn btn-primary"><c:out value="Log In"/></button>
                    </div>
                </form>
            </c:when>
            <c:otherwise>
                <div class="row justify-content-md-center">

                    <div class="col-md-auto">
                        <h1><c:out value="You already Sign in"/></h1>
                    </div>
                </div>
            </c:otherwise>
        </c:choose>
    </div>
</div>

<script type="text/javascript" src="libs/jquery-3.3.1/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="libs/propper-1.11.0/popper.min.js"></script>
<script type="text/javascript" src="libs/bootstrap-4.1.3/js/bootstrap.min.js"></script>
</body>
</html>