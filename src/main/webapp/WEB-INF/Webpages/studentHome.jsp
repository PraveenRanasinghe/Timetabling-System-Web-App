<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Praveen
  Date: 4/26/2021
  Time: 2:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student Time Table</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <link href="webjars/bootstrap/4.5.0/css/bootstrap.min.css" rel="stylesheet"/>
    <script src="webjars/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</head>
<body style="background-image: url('https://coolbackgrounds.io/images/backgrounds/index/ranger-4df6c1b6.png'); background-size: cover;">

<nav class="navbar navbar-expand-lg" style="padding: 10px; background-color: #011801; border-color: black; border-style:outset; font-size:large ">
    <div class="container">
        <ul id="dropdown-animated" class="navbar-nav">
            <li class="nav-item" style="cursor: pointer">
                <a class="nav-link active" href="${pageContext.request.contextPath}/home">Home</a>
            </li>
            <li class="nav-item" style="cursor: pointer">
                <a class="nav-link" href="${pageContext.request.contextPath}/getStudent/">Update Account</a>
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
    <div class="row justify-content-center mt-4">

        <h1 style="color: #292929"><b>Find Your Batch Time Table Here!</b></h1>
    </div>


    <hr style="background-color: black">


    <div class="row justify-content-center">

        <table class="table table-success table-striped table-hover" style="border-color: black; border-radius: 15px; width: 1200px;">
            <thead style="background-color: #ffeb69; font-size: large; border-color: black; border-style: double;">
            <tr>
                <th scope="col">#</th>
                <th scope="col">Module ID</th>
                <th scope="col">Module Name</th>
                <th scope="col">Lecturer Name</th>
                <th scope="col">Scheduled Date</th>
                <th scope="col">Start Time</th>
                <th scope="col">End Time</th>
                <th scope="col">Venue</th>

            </tr>
            </thead>
            <tbody>
            <c:forEach var="timetables" items="${timetables}" varStatus="item">
                <tr>
                    <th scope="row">${item.index + 1}</th>
                    <td>${timetables.module.moduleID}</td>
                    <td>${timetables.module.moduleName}</td>
                    <td>${timetables.module.user.fName} ${timetables.module.user.lName}</td>
                    <td>${timetables.scheduledDate}</td>
                    <td>${timetables.startTime}</td>
                    <td>${timetables.endTime}</td>
                    <td>${timetables.classRoom.classRoomID}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

</div>
</body>
</html>
