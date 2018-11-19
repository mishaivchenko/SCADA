<%--
  Created by IntelliJ IDEA.
  User: Миша
  Date: 21.04.2018
  Time: 11:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=utf-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta http-equiv='content-type' content='text/html; charset=utf-8'>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" type="text/css" href="libs/bootstrap-4.1.3/css/bootstrap.min.css">
    <title>Choose Parapms</title>

</head>
<body>
<jsp:include page="header.jsp"/>

<form>
    <div class="row justify-content-md-center">
        <div class="form-group col-md-6">
            <label for="inputAddress">Ip Address</label>
            <input type="text" class="form-control" id="inputAddress" placeholder="enter ip address">
        </div>
    </div>
    <div class="form-row justify-content-center">
        <div class="form-group col col-md-3">
            <div class="form-check">
                <input class="form-check-input" type="checkbox" name="gridRadios" id="gridRadios1" value="Motor_torque">
                <label class="form-check-label" for="gridRadios1">
                    Motor torque
                </label>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="checkbox" name="gridRadios" id="gridRadios2"
                       value="Motor_current">
                <label class="form-check-label" for="gridRadios2">
                    Motor current
                </label>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="checkbox" name="gridRadios" id="gridRadios3"
                       value="Motor_voltage">
                <label class="form-check-label" for="gridRadios3">
                    Motor voltage
                </label>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="checkbox" name="gridRadios" id="gridRadios4" value="Motor_power">
                <label class="form-check-label" for="gridRadios4">
                    Motor power
                </label>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="checkbox" name="gridRadios" id="gridRadios5"
                       value="Motor_thermal_state">
                <label class="form-check-label" for="gridRadios5">
                    Motor thermal state
                </label>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="checkbox" name="gridRadios" id="gridRadios6"
                       value="Fault_counter">
                <label class="form-check-label" for="gridRadios6">
                    Fault counter
                </label>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="checkbox" name="gridRadios" id="gridRadios7"
                       value="DC_bus_voltage">
                <label class="form-check-label" for="gridRadios7">
                    DC bus voltage
                </label>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="checkbox" name="gridRadios" id="gridRadios8"
                       value="Speed_setpoint">
                <label class="form-check-label" for="gridRadios8">
                    Speed setpoint
                </label>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="checkbox" name="gridRadios" id="gridRadios41"
                       value="Reference_frequency">
                <label class="form-check-label" for="gridRadios4">
                    Reference frequency
                </label>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="checkbox" name="gridRadios" id="gridRadios51"
                       value="PID_setpoint">
                <label class="form-check-label" for="gridRadios5">
                    PID setpoint
                </label>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="checkbox" name="gridRadios" id="gridRadios61" value="Drive_state">
                <label class="form-check-label" for="gridRadios6">
                    Drive state
                </label>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="checkbox" name="gridRadios" id="gridRadios71"
                       value="Active_command_channel">
                <label class="form-check-label" for="gridRadios7">
                    Active command channel
                </label>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="checkbox" name="gridRadios" id="gridRadios81"
                       value="Active_configuration">
                <label class="form-check-label" for="gridRadios8">
                    Active configuration
                </label>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="checkbox" name="gridRadios" id="gridRadios23" value="CMD word">
                <label class="form-check-label" for="gridRadios16">
                    CMD word
                </label>
            </div>
        </div>
        <div class="form-group col col-md-3">
            <div class="form-check">
                <input class="form-check-input" type="checkbox" name="gridRadios" id="gridRadios9"
                       value="Output_velocity">
                <label class="form-check-label" for="gridRadios9">
                    Output velocity
                </label>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="checkbox" name="gridRadios" id="gridRadios10"
                       value="Motor_frequency">
                <label class="form-check-label" for="gridRadios10">
                    Motor_frequency
                </label>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="checkbox" name="gridRadios" id="gridRadios11"
                       value="PID_reference">
                <label class="form-check-label" for="gridRadios11">
                    PID reference
                </label>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="checkbox" name="gridRadios" id="gridRadios12"
                       value="PID_feedback">
                <label class="form-check-label" for="gridRadios12">
                    PID feedback
                </label>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="checkbox" name="gridRadios" id="gridRadios13" value="PID_error">
                <label class="form-check-label" for="gridRadios13">
                    PID error
                </label>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="checkbox" name="gridRadios" id="gridRadios14" value="PID_output">
                <label class="form-check-label" for="gridRadios14">
                    PID output
                </label>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="checkbox" name="gridRadios" id="gridRadios15"
                       value="Drive_thermal_state">
                <label class="form-check-label" for="gridRadios15">
                    Drive thermal state
                </label>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="checkbox" name="gridRadios" id="gridRadios16"
                       value="Logic_input_states">
                <label class="form-check-label" for="gridRadios16">
                    Logic input states
                </label>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="checkbox" name="gridRadios" id="gridRadios17"
                       value="Logic_output_states">
                <label class="form-check-label" for="gridRadios12">
                    Logic output states
                </label>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="checkbox" name="gridRadios" id="gridRadios18"
                       value="Physical_value_AI1">
                <label class="form-check-label" for="gridRadios13">
                    Physical value AI1
                </label>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="checkbox" name="gridRadios" id="gridRadios19"
                       value="Physical_value_AI2">
                <label class="form-check-label" for="gridRadios14">
                    Physical value AI2
                </label>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="checkbox" name="gridRadios" id="gridRadios20"
                       value="Physical_value_AI3">
                <label class="form-check-label" for="gridRadios15">
                    Physical value AI3
                </label>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="checkbox" name="gridRadios" id="gridRadios21" value="State_word">
                <label class="form-check-label" for="gridRadios16">
                    State word
                </label>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="checkbox" name="gridRadios" id="gridRadios22"
                       value="ETI_state_word">
                <label class="form-check-label" for="gridRadios15">
                    ETI state word
                </label>
            </div>
        </div>
    </div>

    <div class="row justify-content-center">
        <button type="submit" class="btn btn-primary" formaction="/param" formmethod="get"><c:out
                value="do track"/></button>
    </div>
    <%--  <div class="row justify-content-md-center">
          <p><input type = "submit" value = "submit" formaction = "/param" formmethod = "GET" ></p>
      </div>--%>
</form>


</body>
<script type="text/javascript" src="libs/jquery-3.3.1/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="libs/propper-1.11.0/popper.min.js"></script>
<script type="text/javascript" src="libs/bootstrap-4.1.3/js/bootstrap.min.js"></script>
</html>
