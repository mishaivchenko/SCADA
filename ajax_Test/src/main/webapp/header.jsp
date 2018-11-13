<%--
  Created by IntelliJ IDEA.
  User: Misha
  Date: 26.08.2018
  Time: 17:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>


<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <%--<fmt:setLocale value="en_En"/>
    <fmt:setBundle basename="i18n.messages" var="msg"/>--%>
<%--<ctg:locale message="${pageScope.lang}"/>--%>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <c:choose>
                    <c:when test="${sessionScope.User.getUserRole() eq 'ADMIN'}">
                        <form class="form-inline my-2 my-lg-0">

                            <button class="btn btn-link" type="submit" formaction="/getUsers" formmethod="get"><c:out value="Choose params"/></button>
                        </form>
                    </c:when>

                    <c:otherwise>
                        <a class="nav-link disabled" href="${pageContext.request.contextPath}/jsp/login.jsp"><c:out value="see status"/></a>
                    </c:otherwise>
                </c:choose>
            </li>

            <li class="nav-item active">
                        <form class="form-inline my-2 my-lg-0">
                            <button class="btn btn-link" type="submit" formaction="/getCars" formmethod="get"><c:out value="errors"/></button>
                        </form>
            </li>

            <li class="nav-item active">
                        <form class="form-inline my-2 my-lg-0">
                            <a class="nav-link " href="${pageContext.request.contextPath}/jsp/admin/createCar.jsp"><c:out value="Help"/></a>
                        </form>

            </li>

            <c:choose>
                <c:when test="${User==null}">
                    <a class="nav-link disabled" href="#"><c:out value="Hello User"/></a>
                </c:when>
                <c:otherwise>
                    <li class="nav-item">
                        <a class="nav-link disabled" href="#"><ctg:locale message="Hello"/> ${sessionScope.User.getLastName()} </a>
                    </li>
                </c:otherwise>
            </c:choose>


        <form class="form-inline my-2 my-lg-0">
                <select class="custom-select" name = "lang" required>
                    <option value="ru">Russian</option>
                    <option value="en">English</option>
                    <option selected ="selected"></option>
                </select>

            <button class="btn btn-link my-2 my-sm-0" type="submit" formaction="/changeLocal" formmethod="get"><c:out value="changeLang"/></button>
        </form>
        </ul>

        <c:if test="${User!=null}">
            <form class="form-inline my-2 my-lg-0">
                <button class="btn btn-outline-success my-2 my-sm-0" type="submit" formaction="/Logout"
                        formmethod="post"><c:out value="Logout"/></button>
            </form>
        </c:if>
    </div>
</nav>
<script type="text/javascript" src="libs/jquery-3.3.1/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="libs/propper-1.11.0/popper.min.js"></script>
<script type="text/javascript" src="libs/bootstrap-4.1.3/js/bootstrap.min.js"></script>
</html>
