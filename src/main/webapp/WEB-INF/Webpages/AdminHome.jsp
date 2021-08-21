<%--
  Created by IntelliJ IDEA.
  User: Praveen
  Date: 4/28/2021
  Time: 12:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin Home</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="/css/Home.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <link href="webjars/bootstrap/4.5.0/css/bootstrap.min.css" rel="stylesheet"/>
    <script src="webjars/bootstrap/4.5.0/js/bootstrap.min.js"></script>

</head>
<body>


<nav class="navbar navbar-expand-lg" style="padding: 10px; background: rgb(18,123,131);
background: linear-gradient(0deg, rgba(18,123,131,1) 0%, rgba(115,150,173,1) 100%); border-color: black; font-size:large; height: 85px;">
    <div class="row float-right mt-1">
        <ul>
            <img src="${pageContext.request.contextPath}/images/My%20Post.jpg"
                 style="height: 65px; width: 250px;margin-left: 100px; background-size: cover; border-radius: 10px;">
        </ul>
    </div>
    <div class="container">
        <ul id="dropdown-animated" class="navbar-nav">
            <li class="nav-item" style="cursor: pointer">
                <a class="nav-link active" style="color: black" href="${pageContext.request.contextPath}/viewAdminHome">Home</a>
            </li>
            <li class="nav-item" style="cursor: pointer">
                <a class="nav-link" style="color: black" href="${pageContext.request.contextPath}/getAdmin/">Update Account</a>
            </li>
        </ul>
        <ul class="navbar-nav ml-auto mt-2">
            <li class="nav-item ml-5" style="cursor: pointer;">
                <a class="nav-link" style="color: black" href="/logout">Sign Out</a>
            </li>
        </ul>
    </div>
</nav>



<div class="row alert-success justify-content-center">
    <div style="font-family:sans-serif; color: black; font-size: x-large;">${success}${error}</div>
</div>


<div class="row">

    <div class="card" style="width: 23rem; background: #dccdee; margin-left: 150px; margin-top: 100px;">
        <img class="card-img-top"  height="220px" src="${pageContext.request.contextPath}/images/batch.jpg">

        <div class="card-body" style="background: #548fec">
            <h1><b><u>Manage Batches</u></b></h1>
            <div class="row justify-content-center mt-3">
                <a class="btn btn-outline-primary" style="width: 250px; font-weight: bold; color: black;
                  border-color: black; border-style: double"  href="${pageContext.request.contextPath}/viewCreateBatch">Create
                    New Batch</a>
            </div>

            <div class="row justify-content-center mt-4">
                <a class="btn btn-outline-primary" style="width: 250px;
                  border-color: black; border-style: double; font-weight: bold; color: black"
                   href="${pageContext.request.contextPath}/viewRemoveBatch">View Update & Remove Batches</a>
            </div>
        </div>
    </div>


    <div class="card" style="width: 23rem; background: #c3e8c8; margin-left: 70px; margin-top: 100px;">
        <img class="card-img-top"  height="220px" src="${pageContext.request.contextPath}/images/users.jpg">

        <div class="card-body" style="background: #79f389">
            <h1><b><u>Manage Users</u></b></h1>
            <div class="row justify-content-center mt-3">
                <a class="btn btn-outline-success" style="width: 250px; font-weight: bold; color: black;
                  border-color: black; border-style: double"  href="${pageContext.request.contextPath}/viewAddUsers">Add Students </a>
            </div>

            <div class="row justify-content-center mt-3">
                <a class="btn btn-outline-success" style="width: 250px; font-weight: bold; color: black;
                  border-color: black; border-style: double" href="${pageContext.request.contextPath}/viewAddLecturers">Add Lecturers </a>
            </div>

            <div class="row justify-content-center mt-3">
                <a class="btn btn-outline-success" style="width: 250px; font-weight: bold; color: black;
                  border-color: black; border-style: double"   href="${pageContext.request.contextPath}/viewStudents">Student
                    Operations</a>
            </div>

            <div class="row justify-content-center mt-4">
                <a class="btn btn-outline-success" style="width: 250px;
                  border-color: black; border-style: double; font-weight: bold; color: black"
                   href="${pageContext.request.contextPath}/viewLecturers">Lecturer
                    Operations</a>
            </div>

        </div>


    </div>


    <div class="card" style="width: 23rem; background: #eceecd; margin-left: 70px; margin-top: 100px;">
        <img class="card-img-top"  height="220px" src="${pageContext.request.contextPath}/images/module.jpg">

        <div class="card-body" style="background: #f6e16a">
            <h1><b><u>Manage Modules</u></b></h1>

            <div class="row justify-content-center mt-3">
                <a class="btn btn-outline-warning" style="width: 250px; font-weight: bold; color: black;
                  border-color: black; border-style: double"  href="${pageContext.request.contextPath}/viewAddModules">Add
                    Modules</a>
            </div>

            <div class="row justify-content-center mt-4">
                <a class="btn btn-outline-warning" style="width: 250px;
                  border-color: black; border-style: double; font-weight: bold; color: black"
                   href="${pageContext.request.contextPath}/viewRemoveModules">View Update & Remove Modules & Schedule
                    Lectures</a>
            </div>

            <div class="row justify-content-center mt-4">
                <a class="btn btn-outline-warning" style="width: 250px;
                  border-color: black; border-style: double; font-weight: bold; color: black"
                   href="${pageContext.request.contextPath}/viewAdminCancelClasses">View Cancel & Re-Scheduling
                    Lectures</a>
            </div>

        </div>


    </div>

    <vr></vr>

    <div class="card" style="width: 23rem; background: #efccc4; margin-left: 70px; margin-top: 100px;">
        <img class="card-img-top"  height="220px" src="${pageContext.request.contextPath}/images/class.jpg">

        <div class="card-body" style="background: #a19c9c">
            <h1><b><u>Manage Classes</u></b></h1>
            <div class="row justify-content-center mt-3">
                <a class="btn btn-outline-secondary" style="width: 250px; font-weight: bold; color: black;
                  border-color: black; border-style: double" href="${pageContext.request.contextPath}/viewAddClassRoom">Add
                    New Class-Room</a>
            </div>

            <div class="row justify-content-center mt-4">
                <a class="btn btn-outline-secondary" style="width: 250px;
                  border-color: black; border-style: double; font-weight: bold; color: black"
                   href="${pageContext.request.contextPath}/viewClassRooms">View Update & Remove Class-Rooms</a>
            </div>

        </div>
    </div>
</div>


</body>
</html>
