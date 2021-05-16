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


<nav class="navbar navbar-expand-lg navbar-dark bg-dark" style="padding: 10px;">
    <div class="container">
        <ul id="dropdown-animated" class="navbar-nav">
            <li class="nav-item" style="cursor: pointer">
                <a class="nav-link active" href="${pageContext.request.contextPath}/home">Home</a>
            </li>
        </ul>
        <ul class="navbar-nav ml-auto">
            <li class="nav-item" style="cursor: pointer;">
                <a class="nav-link nl" href="${pageContext.request.contextPath}/logout">Sign Out</a>
            </li>
        </ul>
    </div>
</nav>

<div class="row alert-success justify-content-center">
    <div style="font-family:sans-serif; color: black; font-size: x-large;">${success}${error}</div>
</div>

<div class="row justify-content-center mt-5">

        <div class="card" style="width: 25rem; border-style: double; border-color: black; box-shadow: 15px 15px 30px black; border-radius: 20px;">
            <div style="background-image: url('https://adaptivesolutions.com/wp-content/uploads/2016/10/icon2.gif'); background-size: cover; height: 15rem;border-radius: 20px;">
            </div>
              <div class="card-body cbcb" style="border-radius: 20px;">
                  <div class="row justify-content-center">
                      <h3 class="card-title">User Operations</h3>
                  </div>
                      <div class="row justify-content-center">
                          <a class="btn btn-primary" style="color: black; background-color: #61e728; width:250px; border-color: black; border-style: double" href="${pageContext.request.contextPath}/viewAddUsers">Add Students </a>
                      </div>
                  <div class="row justify-content-center mt-2">
                      <a class="btn btn-primary" style="color: black; background-color: #61e728; width:250px; border-color: black; border-style: double" href="${pageContext.request.contextPath}/viewAddLecturers">Add Lecturers </a>
                  </div>
                      <div  class="row justify-content-center mt-2">
                          <a class="btn btn-warning" style="color: black; background-color: #3d67e3; width:250px;
                  border-color: black; border-style: double" href="${pageContext.request.contextPath}/viewStudents">Student Operations</a>
                      </div>
                  <div  class="row justify-content-center mt-2">
                      <a class="btn btn-warning" style="color: black; background-color: #3d67e3; width:250px;
                  border-color: black; border-style: double" href="${pageContext.request.contextPath}/viewLecturers">Lecturer Operations</a>
                  </div>
            </div>
        </div>

        <div class="card ml-5" style="width: 25rem;border-style: double; border-color: black; box-shadow: 15px 15px 30px black; border-radius: 20px;">
            <div style="background-image: url('https://cdn.dribbble.com/users/1162077/screenshots/5388344/gears-animation.gif'); background-size: cover; height: 15rem; border-radius: 20px;">
            </div>
             <div class="card-body cbcb" style="border-radius: 20px;">
                 <div class="row justify-content-center">
                     <h3 class="card-title">Batch Operations</h3>
                 </div>

                 <div  class="row justify-content-center">
                     <a class="btn btn-primary" style="border-color: black; width:250px; border-style: double" href="${pageContext.request.contextPath}/viewCreateBatch">Create Batch</a>
                 </div>
                 <div  class="row justify-content-center mt-2">
                     <a class="btn btn-warning" style="border-color: black;  width:250px; border-style: double" href="${pageContext.request.contextPath}/viewRemoveBatch">View Update & Remove Batches</a>
                 </div>
                 <div  class="row justify-content-center mt-2">
<%--                     <a class="btn btn-warning" style="border-color: black;  width:250px; border-style: double" href="${pageContext.request.contextPath}/viewUpdateBatch">Update Batches</a>--%>
                 </div>
            </div>
        </div>


        <div class="card ml-5" style="width: 25rem; border-color: black; box-shadow: 15px 15px 30px black; border-radius: 20px;">
            <div style="background-image: url('https://adaptivesolutions.com/wp-content/uploads/2016/10/icon2.gif'); background-size: cover; height: 15rem; border-radius: 20px;">
            </div>
              <div class="card-body cbcb" style="border-radius: 20px;">
                  <div class="row justify-content-center">
                      <h3 class="card-title">Time-Table Scheduling</h3>
                  </div>
                  <div class="row justify-content-center mt-2">
                      <a class="btn btn-primary" style="width: 250px;
                  border-color: black; border-style: double" href="${pageContext.request.contextPath}/viewClassScheduling">Schedule a Class</a>
                  </div>

                  <div class="row justify-content-center mt-2">
                      <a class="btn btn-dark" style="width: 250px;
                  border-color: black; border-style: double " href="${pageContext.request.contextPath}/viewAdminCancelClasses">View Cancel & Re-Scheduling Classes</a>
                  </div>
            </div>
        </div>

</div>

<div class="row justify-content-center mt-5 mb-5">
    <div class="card" style="width: 25rem; border-style: double; border-color: black; box-shadow: 15px 15px 30px black; border-radius: 20px;">
        <div style="background-image: url('https://cdn.dribbble.com/users/43718/screenshots/1137873/loadinganimation1.gif'); background-size: cover; height: 15rem; border-radius: 20px;">
        </div>
        <div class="card-body cbcb" style="border-radius: 20px;">
            <div class="row justify-content-center ">
                <h3 class="card-title">Module Operations</h3>
            </div>
            <div class="row justify-content-center mt-2">
                <a class="btn btn-primary" style="width: 250px;
                  border-color: black; border-style: double" href="${pageContext.request.contextPath}/viewAddModules">Add Modules</a>
            </div>

            <div class="row justify-content-center mt-2">
                <a class="btn btn-warning" style="width: 250px; background-color: #ff3300;
                  border-color: black; border-style: double " href="${pageContext.request.contextPath}/viewRemoveModules">View Update & Remove Modules</a>
            </div>
        </div>
    </div>

    <div class="card ml-5" style="width: 25rem; border-style: double; border-color: black; box-shadow: 15px 15px 30px black; border-radius: 20px;">
        <div style="background-image: url('https://cdn.dribbble.com/users/1162077/screenshots/5388344/gears-animation.gif'); background-size: cover; height: 15rem; border-radius: 20px;">
        </div>
        <div class="card-body cbcb" style="border-radius: 20px;">
            <div class="row justify-content-center ">
                <h3 class="card-title">Class-Room Operations</h3>
            </div>
            <div class="row justify-content-center mt-2">
                <a class="btn btn-primary" style="width: 250px;
                  border-color: black; border-style: double" href="${pageContext.request.contextPath}/viewAddClassRoom">Add New Class-Room</a>
            </div>

            <div class="row justify-content-center mt-2">
                <a class="btn btn-secondary" style="width: 250px;
                  border-color: black; border-style: double; background-color: #ff3300; " href="${pageContext.request.contextPath}/viewClassRooms">View Update & Remove Class-Rooms</a>
            </div>
        </div>
    </div>
</div>




</body>
</html>
