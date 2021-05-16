<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Praveen
  Date: 4/30/2021
  Time: 12:58 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Schedule Classes</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="/css/Home.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <link href="webjars/bootstrap/4.5.0/css/bootstrap.min.css" rel="stylesheet"/>
    <script src="webjars/bootstrap/4.5.0/js/bootstrap.min.js"></script>
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
    <form:form class="mt-5" action="/adminAddTimetable" modelAttribute="AddTimetable" method="POST">
        <div style="box-shadow: 15px 15px 30px black; border-radius: 20px;
         width: 900px; background-color: #f3f3bf; margin-left: 10%; border-color: #130a04;
          border-style: inset; border-radius: 10px;">


            <div class="row justify-content-center mt-2">
                <h3>Class Scheduling Form</h3>
            </div>
            <hr style="background-color: black">

            <div class="row mt-5">
                <div class="col-lg-4">
                    <label  class="form-label"><b>Batch ID</b></label>
                    <form:input path="batch.batchID" Class="form-control" style="background-color: #e3e1e1; color: black; border-color: black" placeholder="Com001"/>
                </div>
                <div class="col-lg-4">
                    <label  class="form-label"><b>Name of the Module</b></label>
                    <form:input path="moduleName" Class="form-control" style="background-color: #e3e1e1; color: black; border-color: black" placeholder="Cloud Computing"/>
                </div>
                <div class="col-lg-4">
                    <label  class="form-label"><b>Select the Class Room</b></label>
                    <form:input path="classRoom.classRoomID" Class="form-control" style="background-color: #e3e1e1; color: black; border-color: black" placeholder="Lab01"/>
                </div>
            </div>

            <div class="row mt-5">
                <div class="col ml-4">
                    <label  class="form-label"><b>Lecturer Name</b></label>
                    <form:input path="user.email" Class="form-control" style="background-color: #e3e1e1; color: black; border-color: black" placeholder="Dr.John Doe"/>
                </div>
                <div class="col mr-4">
                    <label  class="form-label"><b>Select the Date</b></label>
                    <form:input path="scheduledDate" Class="form-control" type="date" style="background-color: #e3e1e1; color: black; border-color: black"/>
                </div>
            </div>

            <div class="row mt-5">
                <div class="col ml-4">
                    <label  class="form-label"><b>Starting Time</b></label>
                    <form:input path="startTime" Class="form-control" style="background-color: #e3e1e1; color: black; border-color: black" type="time" placeholder="Dr.John Doe"/>
                </div>
                <div class="col mr-4">
                    <label  class="form-label"><b>Ending Time</b></label>
                    <form:input path="endTime" Class="form-control" type="time" style="background-color: #e3e1e1; color: black; border-color: black"/>
                </div>
            </div>


            <div class="row justify-content-center mt-4">
                <button type="submit" class="btn btn-success mb-4" style="border-color: black; border-style: double">Schedule The Class</button>
            </div>

        </div>
    </form:form>
</div>

</body>
</html>
