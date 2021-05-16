<%--
  Created by IntelliJ IDEA.
  User: Praveen
  Date: 4/30/2021
  Time: 11:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>View,Cancel & Re-Scheduling Classes</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="/css/contactAdmin.css">
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
    <div class="row justify-content-center mt-5">
        <table class="table table-success table-striped" style="border-color: black; border-radius: 15px; width: 1200px;">
            <thead style="background-color: #ffeb69; font-size: large; border-color: black; border-style: double;">
            <tr>
                <th scope="col">#</th>
                <th scope="col">Batch ID</th>
                <th scope="col">Batch Name</th>
                <th scope="col">Module Name</th>
                <th scope="col">Lecturer Name</th>
                <th scope="col">Scheduled Date</th>
                <th scope="col">Start Time</th>
                <th scope="col">End Time</th>
                <th scope="col">Venue</th>
                <th scope="col">|Cancel|</th>
                <th scope="col">|Re-Schedule Class|</th>
            </tr>
            </thead>
            <tbody>
<c:forEach var="timetables" items="${timetables}" varStatus="item">
            <tr>
                <th scope="row">${item.index + 1}</th>
                <td>${timetables.batch.batchID}</td>
                <td>${timetables.batch.batchName}</td>
                <td>${timetables.moduleName}</td>
                <td>${timetables.user.fName} ${timetables.user.lName}</td>
                <td>${timetables.scheduledDate}</td>
                <td>${timetables.startTime}</td>
                <td>${timetables.endTime}</td>
                <td>${timetables.classRoom.classRoomID}</td>
                <td><a class="btn btn-danger" style="border-color: black;
                  width:150px; border-style: double; color: white" >Cancel Lecture</a></td>
                <td><a class="btn btn-warning" style="border-color: black;
                  width:150px; border-style: double; color: black" href="/getTimetable/${timetables.timetableId}">Re-Schedule Lecture</a></td>
            </tr>
</c:forEach>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>
