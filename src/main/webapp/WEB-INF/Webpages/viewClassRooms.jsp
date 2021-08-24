<%--
  Created by IntelliJ IDEA.
  User: Praveen
  Date: 5/12/2021
  Time: 11:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Class-Rooms</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="/css/Home.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <link href="webjars/bootstrap/4.5.0/css/bootstrap.min.css" rel="stylesheet"/>
    <script src="webjars/bootstrap/4.5.0/js/bootstrap.min.js"></script>
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

<div class="row justify-content-center">
    <div style="font-family:sans-serif; background: #e0c67b; height: 50px; color: black; font-size: x-large;">${success}${error}</div>
</div>

<div class="container">
    <h2 class="justify-content-center mt-5">Class Rooms in Academy:</h2>
    <div class="row justify-content-center mt-5">
        <table class="table table-secondary table-striped" style="border-color: black; border-radius: 15px;">
            <thead style="background-color: #ffeb69; font-size: large; border-color: black; border-style: double;">
            <tr>
                <th scope="col">#</th>
                <th scope="col">Class-Room ID</th>
                <th scope="col">Capacity</th>
                <th scope="col">Air-Conditioned</th>
                <th scope="col">Smart-Board</th>
                <th scope="col">|Remove|</th>
                <th scope="col">|Update|</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="ClassRooms" items="${ClassRooms}" varStatus="item">
                <tr>
                    <td scope="row"><b>${item.index + 1}</b></td>
                    <td>${ClassRooms.classRoomID}</td>
                    <td>${ClassRooms.capacity}</td>
                    <td>${ClassRooms.ac}</td>
                    <td>${ClassRooms.smartBoard}</td>
                    <td><a class="btn btn-danger" style="border-color: black;
                  width:200px; border-style: double" href="/deleteClassRoom/${ClassRooms.classRoomID}" id="demo" onclick="deleteClass()">Remove Class-Room</a>
                    </td>
                    <td><a class="btn btn-warning" style="border-color: black;
                  width:200px; border-style: double" href="/getClassRoom/${ClassRooms.classRoomID}">Update Class-Room</a>
                    </td>
                </tr>
            </c:forEach>

            </tbody>
        </table>
    </div>
</div>

<script>
    function deleteClass() {
        var txt;
        var r = confirm("Do You Really want to Remove the Class-Room From the Academy?");
        if (r == true) {
            txt = "Class-Room has been removed successfully!";
        } else {
            txt = "Cancelled";
        }
        document.getElementById("demo").innerHTML = txt;
    }
</script>

</body>
</html>
