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
    <link rel="stylesheet" type="text/css" href="/css/Home.css">
</head>
<body>

<nav class="navbar navbar-expand-lg" style="padding: 10px; background: rgb(18,123,131);
background: linear-gradient(0deg, rgba(18,123,131,1) 0%, rgba(115,150,173,1) 100%); font-size:large; height: 85px;">


        <div class="row float-right mt-1">
        <ul>
            <img src="${pageContext.request.contextPath}/images/My%20Post.jpg"
                 style="height: 65px; width: 250px;margin-left: 100px; background-size: cover; border-radius: 10px;">
        </ul>
        </div>
    <div class="container">
        <div class="row ml-1">
            <ul id="dropdown-animated" class="navbar-nav">
                <li class="nav-item" style="cursor: pointer;">
                    <a class="nav-link active" style="color: black" href="${pageContext.request.contextPath}/viewStudentHome"><b>Home</b></a>
                </li>
                <li class="nav-item" style="cursor: pointer;">
                    <a class="nav-link" style="color: black" href="${pageContext.request.contextPath}/getStudent/"><b>Update Account</b></a>
                </li>
                <li class="nav-item" style="cursor: pointer;">
                    <a class="nav-link" style="color: black" href="${pageContext.request.contextPath}/learningModules"><b>My Modules</b></a>
                </li>
                <li class="nav-item" style="cursor: pointer;">
                    <a class="nav-link" style="color: black" href="${pageContext.request.contextPath}/allTimetables"><b>All Lectures</b></a>
                </li>
            </ul>
        </div>
        <ul class="navbar-nav ml-auto mr-5">
            <li class="nav-item" style="cursor: pointer;">
                <a class="nav-link" style="color: black" href="/logout"><b>Sign Out</b></a>
            </li>
        </ul>
    </div>

</nav>
<div class="container">
    <div class="row justify-content-center mt-4">
        <h1 style="color: #292929"><b> Find Your Batch Time Table Here! </b></h1>

    </div>
    <h2 style="color: #292929"><b> Today's Lectures </b></h2>
    <hr style="background-color: black">

    <div class="row justify-content-center mt-5">

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
