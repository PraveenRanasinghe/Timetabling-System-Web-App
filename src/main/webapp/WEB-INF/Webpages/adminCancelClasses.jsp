<%--
  Created by IntelliJ IDEA.
  User: Praveen
  Date: 4/30/2021
  Time: 11:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>View,Cancel & Re-Scheduling Classes</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/Home.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <link href="webjars/bootstrap/4.5.0/css/bootstrap.min.css" rel="stylesheet"/>
    <script src="webjars/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</head>

<body>
<nav class="navbar navbar-expand-lg"
     style="padding: 10px; background-color: #011801; border-color: black; border-style:outset; font-size:large ">
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

<div class="container">
    <div class="row justify-content-center mt-5">
        <table class="table table-success table-striped"
               style="border-color: black; border-radius: 15px; width: 1200px;">
            <thead style="background-color: #ffeb69; font-size: large; border-color: black; border-style: double;">
            <tr>
                <th scope="col">#</th>
                <th scope="col">Batch</th>
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
                    <td>
                        <c:forEach items="${timetables.batches}" var="batch">
                            ${batch.batchID}
                        </c:forEach>
                    </td>
                    <td>${timetables.module.moduleName}</td>
                    <td>${timetables.module.user.fName} ${timetables.module.user.lName}</td>
                    <td>${timetables.scheduledDate}</td>
                    <td>${timetables.startTime}</td>
                    <td>${timetables.endTime}</td>
                    <td>${timetables.classRoom.classRoomID}</td>
                    <td><a class="btn btn-outline-danger" style=" width:150px;"
                           href="/cancelTimetable/${timetables.timetableId}">Cancel Lecture</a></td>
                    <td><a class="btn btn-outline-dark" style="width:200px;"
                           href="/getTimetable/${timetables.timetableId}">Re-Schedule Lecture</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>
