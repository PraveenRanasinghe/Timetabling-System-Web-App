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

<div class="row justify-content-center mt-5">

    <div class="card"
         style="width: 25rem; border-style: double; border-color: black; box-shadow: 15px 15px 30px black; border-radius: 20px;">
        <div class="card-body cbcb" style="border-radius: 20px;">
            <div class="row justify-content-center">
                <h2 class="card-title" style="color: #f3da07">User Operations</h2>
            </div>
            <div class="row justify-content-center">
                <a class="btn btn-primary"
                   style="color: black; background-color: #61e728; width:250px; border-color: black; border-style: double"
                   href="${pageContext.request.contextPath}/viewAddUsers">Add Students </a>
            </div>
            <div class="row justify-content-center mt-2">
                <a class="btn btn-primary"
                   style="color: black; background-color: #61e728; width:250px; border-color: black; border-style: double"
                   href="${pageContext.request.contextPath}/viewAddLecturers">Add Lecturers </a>
            </div>
            <div class="row justify-content-center mt-2">
                <a class="btn btn-warning" style="color: black; background-color: #3d67e3; width:250px;
                  border-color: black; border-style: double" href="${pageContext.request.contextPath}/viewStudents">Student
                    Operations</a>
            </div>
            <div class="row justify-content-center mt-2">
                <a class="btn btn-warning" style="color: black; background-color: #3d67e3; width:250px;
                  border-color: black; border-style: double" href="${pageContext.request.contextPath}/viewLecturers">Lecturer
                    Operations</a>
            </div>
        </div>
    </div>

    <div class="card ml-5"
         style="width: 25rem;border-style: double; border-color: black; box-shadow: 15px 15px 30px black; border-radius: 20px;">
        <div class="card-body cbcb" style="border-radius: 20px;">
            <div class="row justify-content-center">
                <h2 class="card-title" style="color: #f3da07">Batch Operations</h2>
            </div>

            <div class="row justify-content-center mt-3">
                <a class="btn btn-primary" style="border-color: black; width:250px; border-style: double"
                   href="${pageContext.request.contextPath}/viewCreateBatch">Create Batch</a>
            </div>
            <div class="row justify-content-center mt-4">
                <a class="btn btn-warning" style="border-color: black;  width:250px; border-style: double"
                   href="${pageContext.request.contextPath}/viewRemoveBatch">View Update & Remove Batches</a>
            </div>

        </div>
    </div>
</div>

<div class="row justify-content-center mt-5 mb-5">
    <div class="card"
         style="width: 25rem; border-style: double; border-color: black; box-shadow: 15px 15px 30px black; border-radius: 20px;">
        <div class="card-body cbcb" style="border-radius: 20px;">
            <div class="row justify-content-center ">
                <h2 class="card-title" style="color: #f3da07">Module Operations</h2>
            </div>
            <div class="row justify-content-center mt-3">
                <a class="btn btn-primary" style="width: 250px;
                  border-color: black; border-style: double;" href="${pageContext.request.contextPath}/viewAddModules">Add
                    Modules</a>
            </div>

            <div class="row justify-content-center mt-3">
                <a class="btn btn-warning" style="width: 250px; background-color: #ea8232;
                  border-color: black; border-style: double; color: white"
                   href="${pageContext.request.contextPath}/viewRemoveModules">View Update & Remove Modules & Schedule
                    Lectures</a>
            </div>
            <div class="row justify-content-center mt-3">
                <a class="btn btn-success" style="width: 250px;
                  border-color: black; border-style: double "
                   href="${pageContext.request.contextPath}/viewAdminCancelClasses">View Cancel & Re-Scheduling
                    Lectures</a>
            </div>
        </div>
    </div>

    <div class="card ml-5"
         style="width: 25rem; border-style: double; border-color: black; box-shadow: 15px 15px 30px black; border-radius: 20px;">

        <div class="card-body cbcb" style="border-radius: 20px;">
            <div class="row justify-content-center ">
                <h2 class="card-title" style="color: #f3da07">Class-Room Operations</h2>
            </div>

            <div class="row justify-content-center mt-3">
                <a class="btn btn-primary" style="width: 250px;
                  border-color: black; border-style: double" href="${pageContext.request.contextPath}/viewAddClassRoom">Add
                    New Class-Room</a>
            </div>

            <div class="row justify-content-center mt-4">
                <a class="btn btn-danger" style="width: 250px;
                  border-color: black; border-style: double; background-color: #f12121; "
                   href="${pageContext.request.contextPath}/viewClassRooms">View Update & Remove Class-Rooms</a>
            </div>
        </div>
    </div>
</div>


</body>
</html>
