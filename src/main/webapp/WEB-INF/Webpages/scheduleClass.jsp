<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Praveen
  Date: 5/24/2021
  Time: 2:52 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Schedule Classes</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="/css/Home.css">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    <link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/timepicker/1.3.5/jquery.timepicker.min.css">
</head>

<body>
<nav class="navbar navbar-expand-lg" style="padding: 10px; background-color: #011801; border-color: black; border-style:outset; font-size:large ">
    <div class="container">
        <ul id="dropdown-animated" class="navbar-nav">
            <li class="nav-item" style="cursor: pointer">
                <a class="nav-link active" href="${pageContext.request.contextPath}/viewAdminHome">Back to Home</a>
            </li>

        </ul>
        <ul class="navbar-nav ml-auto">
            <li class="nav-item" style="cursor: pointer;">
                <a class="nav-link" href="/logout">Sign Out</a>
            </li>
        </ul>
    </div>
</nav>

<div class="row alert-success justify-content-center">
    <div style="font-family:sans-serif; color: black; font-size: x-large;">${success}${error}</div>
</div>


<div class="row">
    <div class="col-lg-4">
        <div class="mt-4 ml-3">
            <img src="${pageContext.request.contextPath}/images/lec1.png"
                 style="height: 650px;   background-size: cover; border-radius: 30px;">
        </div>
    </div>
    <div class="col-lg-8">
        <form:form class="mt-5" action="/adminAddTimetable" modelAttribute="addTimetable" method="POST">
            <div style="box-shadow: 15px 15px 30px black; border-radius: 20px;
         width: 900px;background: rgb(75,130,154);
background: linear-gradient(90deg, rgba(75,130,154,1) 0%, rgba(161,232,147,1) 49%, rgba(139,177,232,1) 100%); margin-left: 10%; border-color: #130a04;
          border-style: inset; border-radius: 10px;">


                <div class="row justify-content-center mt-2">
                    <h1>Class Scheduling Form</h1>
                </div>
                <div class="row justify-content-center">

                    <h3>Currently Learning Batches  : </h3>
                    <div>
                        <h3><b><c:forEach items="${findModule.batches}" var="batch">
                            ${batch.batchID}
                        </c:forEach></b></h3>
                        <form:input path="batches" type="hidden"/>
                    </div>
                </div>
                <hr style="background-color: black">
                <div class="row mt-5 ml-4 mr-4">

                    <div class="col-lg-6">
                        <label class="form-label"><b>Name of the Module</b></label>
                        <form:input path="modules.moduleID" Class="form-control" type="text" value="${findModule.moduleID}"
                                    style="background-color: #e3e1e1; color: black; border-color: black" readonly="true"/>
                    </div>


                    <div class="col-lg-6">
                        <label class="form-label"><b>Select the Class</b></label>
                        <form:select path="classRoom" type="text" style="border-color: black"
                                     cssClass="form-control">

                            <c:forEach var="classRoomList" items="${classRoomList}" varStatus="item">
                                <form:option value="${classRoomList.classRoomID}">
                                    ${classRoomList.classRoomID}: ${classRoomList.capacity}
                                </form:option>
                            </c:forEach>
                        </form:select>

                    </div>
                </div>

                <div class="row mt-5 ml-4 mr-4">

                    <div class="col-lg-4">
                        <label class="form-label"><b>Select the Date</b></label>
                        <form:input path="scheduledDate" Class="form-control" id='datetimepicker1' type="date"
                                    style="background-color: #e3e1e1; color: black; border-color: black" />
                    </div>

                    <div class="col-lg-4">
                        <label class="form-label"><b>Starting Time</b></label>
                        <form:input path="startTime" Class="form-control"
                                    style="background-color: #e3e1e1; color: black; border-color: black" type="time" max="05:00pm" min="08:00am"
                        />
                    </div>

                    <div class="col-lg-4">
                        <label class="form-label"><b>Ending Time</b></label>
                        <form:input path="endTime" Class="form-control" type="time"  max="09:00am" min="06:00pm"
                                    style="background-color: #e3e1e1; color: black; border-color: black"/>
                    </div>

                </div>


                <div class="row justify-content-center mt-5">
                    <button type="submit" class="btn btn-warning mb-4" style="border-color: black; border-style: double">
                        Schedule The Class
                    </button>
                </div>

            </div>
        </form:form>
    </div>
</div>


<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>

<%--<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>--%>
<%--<link rel="stylesheet" href="jquery-timepicker/jquery.timepicker.min.css">--%>
<%--<script src="jquery-timepicker/jquery.timepicker.min.js"></script>--%>
<%--<script>--%>
<%--    $(document).ready(function (){--%>
<%--            var dtToday = new Date();--%>
<%--            var month = dtToday.getMonth()+1;--%>
<%--            var day = dtToday.getDate();--%>
<%--            var year = dtToday.getFullYear();--%>

<%--            if (month<10)--%>
<%--                day='0'+day.toString();--%>
<%--            var maxDate = year+'-'+month+'-'+day;--%>
<%--            $('#dateControl').attr('min',maxDate);--%>

<%--    });--%>

<script type="text/javascript">
    $(document).ready(function(){
        $('#timepicker').timepicker({
            timeFormat: 'h:mm p',
            interval: 60,
            minTime: '8',
            maxTime: '5:00pm',
            startTime: '08:00',
            dynamic: false,
            dropdown: true,
            scrollbar: true
        });
    });
</script>

<script type="text/javascript">
    $(document).ready(function(){
        $('#timepicker2').timepicker({
            timeFormat: 'h:mm p',
            interval: 60,
            minTime: '9',
            maxTime: '6:00pm',
            startTime: '09:00',
            dynamic: false,
            dropdown: true,
            scrollbar: true
        });
    });
</script>

<script src="//cdnjs.cloudflare.com/ajax/libs/timepicker/1.3.5/jquery.timepicker.min.js"></script>
</body>
</html>



