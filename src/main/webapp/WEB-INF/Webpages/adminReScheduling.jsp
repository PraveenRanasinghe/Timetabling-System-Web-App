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
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark" style="padding: 10px;">
    <div class="container">
        <ul id="dropdown-animated" class="navbar-nav">
            <li class="nav-item" style="cursor: pointer">
                <a class="nav-link active" href="${pageContext.request.contextPath}/home">Home</a>
            </li>
        </ul>
        <ul class="navbar-nav ml-auto">
            <li class="nav-item" style="cursor: pointer;">
                <a class="nav-link nl">Sign Out</a>
            </li>
        </ul>
    </div>
</nav>

<div class="container">
    <form:form action="/adminAddModules" modelAttribute="getTimetable"  method="post" cssClass="mt-5">
        <div class="row justify-content-center mt-5">
            <div style="width: 700px; height: 450px; background-color: #ead85c; border-radius: 20px; border-color: black; border-style:double">
                <div class="ml-2 mt-5 mr-2">
                    <div class="row justify-content-center">
                        <h1>Re-Schedule Class</h1>
                    </div>
                    <div class="row mt-3">
                        <div class="col">
                            <label class="control-label col"><b>Batch ID</b></label>
                            <form:input path="batch.batchID" value="${findTimetable.batch.batchID}" type="text" style="border-color: black"
                                        cssClass="form-control"/>
                        </div>
                        <div class="col">
                            <label class="control-label col"><b>Batch Name</b></label>
                            <form:input path="batch.batchName" value="${findTimetable.batch.batchName}" type="text" style="border-color: black"
                                        cssClass="form-control" placeholder="" contenteditable="true"/>
                        </div>
                    </div>
                    <div class="row mt-3">
                        <div class="col">
                            <label class="control-label col"><b>Module Name</b></label>
                            <form:input path="moduleName" value="${findTimetable.moduleName}" type="text" style="border-color: black"
                                        cssClass="form-control" placeholder="" contenteditable="false"/>
                        </div>
                        <div class="col">
                            <label class="control-label col"><b>Lecturer</b></label>
                            <form:input path="user.email" value="${findTimetable.user.email}" type="text" style="border-color: black"
                                        cssClass="form-control" placeholder="" contenteditable="false"/>
                        </div>
                    </div>

                    <div class="row mt-3">
                        <div class="col-lg-4">
                            <label class="control-label col"><b>Start Time</b></label>
                            <form:input path="startTime" value="${findTimetable.startTime}" type="time" style="border-color: black"
                                        cssClass="form-control" placeholder="" contenteditable="true"/>
                        </div>
                        <div class="col-lg-4">
                            <label class="control-label col"><b>End Time</b></label>
                            <form:input path="endTime" value="${findTimetable.endTime}" type="time" style="border-color: black"
                                        cssClass="form-control" placeholder="" contenteditable="true"/>
                        </div>
                        <div class="col-lg-4">
                            <label class="control-label col"><b>Scheduled Date</b></label>
                            <form:input path="scheduledDate" value="${findTimetable.scheduledDate}" type="date" style="border-color: black"
                                        cssClass="form-control" placeholder="" contenteditable="true"/>
                        </div>
                    </div>

                    <div class="row justify-content-center mt-4">
                        <button type="submit" class="btn btn-success">Re-Schedule Class</button>
                    </div>
                </div>
            </div>
        </div>
    </form:form>
</div>
</body>
</html>
