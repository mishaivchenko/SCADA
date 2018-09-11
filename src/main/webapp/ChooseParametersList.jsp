<%--
  Created by IntelliJ IDEA.
  User: Миша
  Date: 21.04.2018
  Time: 11:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Parameters</title>
</head>
<body>
<form>
    <p><strong>enter the ip address of the device</strong></p>
    <p><input maxlength="25" size="40" name = "ip" ></p>


    <p>Choose parameters</p>
    <p><input type="checkbox" name="a" value="3205"> Motor torque</p>
    <p><input type="checkbox" name="a" value="3204" > Motor current</p>
    <p><input type="checkbox" name="a" value="3208">Motor voltage</p>
    <p><input type="checkbox" name="a" value="3211"> Motor power</p>
    <p><input type="checkbox" name="a" value="9630"> Motor thermal state</p>
    <p><input type="checkbox" name="a" value="7393"> Fault counter</p>
    <p><input type="checkbox" name="a" value="7270"> DC bus voltage</p>

    <p><input type = "submit" value = "submit" formaction = "/param" formmethod = "GET"></p>
</form>

</body>
</html>
