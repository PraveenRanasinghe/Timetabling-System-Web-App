<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Praveen
  Date: 4/30/2021
  Time: 11:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Re-Schedule Classes</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="/css/contactAdmin.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <link href="/webjars/bootstrap/4.5.0/css/bootstrap.min.css" rel="stylesheet"/>
    <script src="/webjars/bootstrap/4.5.0/js/bootstrap.min.js"></script>

    <link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/timepicker/1.3.5/jquery.timepicker.min.css">
</head>
<body>

<nav class="navbar navbar-expand-lg" style="padding: 10px; background-color: #011801; border-color: black; border-style:outset; font-size:large ">
    <div class="container">
        <ul id="dropdown-animated" class="navbar-nav">
            <li class="nav-item" style="cursor: pointer">
                <a class="nav-link active" href="${pageContext.request.contextPath}/viewAdminHome">Back to Home</a>
            </li>

            <li class="nav-item ml-5" style="cursor: pointer">
                <a class="nav-link active" href="${pageContext.request.contextPath}/viewAdminCancelClasses">Back to List</a>
            </li>

        </ul>
    </div>
</nav>

<div class="row justify-content-center">
    <div style="font-family:sans-serif; background: #e0c67b; height: 50px; color: black; font-size: x-large;">${success}${error}</div>
</div>
<div class="container">
    <form:form action="/classRescheduling" modelAttribute="findTimetable"  method="post" cssClass="mt-5">
        <div class="row justify-content-center mt-5">
            <div style="width: 700px; height: 450px; background: rgb(203,212,128);
background: linear-gradient(90deg, rgba(203,212,128,1) 0%, rgba(103,189,85,1) 51%, rgba(179,218,198,1) 100%); border-radius: 20px; border-color: black; border-style:double">
                <div class="ml-2 mt-5 mr-2">
                    <div class="row justify-content-center">
                        <h1>Re-Schedule Class</h1>
                    </div>

                    <form:input path="timetableId" value="${findTimetable.timetableId}" type="hidden"/>

                        <div class="row justify-content-center mt-3">
                                <h3><b>Batch ID : <c:forEach items="${findTimetable.batches}" var="batch">
                                    ${batch.batchID}
                                </c:forEach>
                                </b></h3>
                        </div>

                    <div class="row mt-4">
                        <div class="col-lg-4">
                            <label class="control-label col"><b>Module Name</b></label>
                            <form:input path="modules.moduleName" value="${findTimetable.modules.moduleName}" type="text" style="border-color: black"
                                        cssClass="form-control" placeholder="" readonly="true"/>
                        </div>
                        <div class="col-lg-4">
                            <label class="control-label col"><b>Lecturer</b></label>
                            <form:input path="modules.user.email" value="${findTimetable.modules.user.fName} ${findTimetable.modules.user.lName}" type="text" style="border-color: black"
                                        cssClass="form-control" placeholder="" readonly="true"/>
                        </div>
                        <div class="col-lg-4">
                            <label class="control-label col"><b>Class-Room</b></label>
                            <form:input path="classRoom.classRoomID" value="${findTimetable.classRoom.classRoomID}" type="text" style="border-color: black"
                                        cssClass="form-control" placeholder="" readonly="true"/>
                        </div>
                    </div>

                    <div class="row mt-3">
                        <div class="col-lg-4">
                            <label class="control-label col"><b>Scheduled Date</b></label>
                            <form:input path="scheduledDate" value="${findTimetable.scheduledDate}" type="date" style="border-color: black"
                                        cssClass="form-control" required="required"/>
                        </div>
                        <div class="col-lg-4">
                            <label class="control-label col"><b>Start Time</b></label>
                            <form:input path="startTime" value="${findTimetable.startTime}" style="border-color: black"
                                        cssClass="form-control" type="time"
                                        required="required" min="08:00" max="17:00"/>
                        </div>
                        <div class="col-lg-4">
                            <label class="control-label col"><b>End Time</b></label>
                            <form:input path="endTime" value="${findTimetable.endTime}" type="time"
                                        style="border-color: black"
                                        cssClass="form-control" required="required" min="08:00" max="17:00"/>
                        </div>
                    </div>

                    <div class="row justify-content-center mt-4">
                        <button type="submit" class="btn btn-warning">Re-Schedule Class</button>
                    </div>
                </div>
            </div>
        </div>
    </form:form>
</div>

<script src="//cdnjs.cloudflare.com/ajax/libs/timepicker/1.3.5/jquery.timepicker.min.js"></script>
</body>
</html>
