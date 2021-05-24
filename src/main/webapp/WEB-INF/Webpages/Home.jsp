<%--
  Created by IntelliJ IDEA.
  User: Praveen
  Date: 4/20/2021
  Time: 2:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
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
            <li class="nav-item" style="cursor: pointer">
                <a class="nav-link" href="${pageContext.request.contextPath}/viewStudentHome">Student Home</a>
            </li>
        </ul>


        <ul class="navbar-nav ml-auto">
            <li class="nav-item" style="cursor: pointer;">
                <a class="nav-link nl" href="${pageContext.request.contextPath}/viewAdminHome">Admin Home</a>
            </li>
        </ul>
        <ul class="navbar-nav ml-auto">
            <li class="nav-item" style="cursor: pointer;">
                <a class="nav-link nl" href="${pageContext.request.contextPath}/viewLecturerHome">Lecturer Home</a>
            </li>
        </ul>
    </div>
</nav>


<div class="container">
    <div class="row">
        <div class="col-sm-12">
            <div class="mt-4">
                <img src="${pageContext.request.contextPath}/images/My%20Post.jpg"
                     style="height: 250px; width: 900px;margin-left: 100px; background-size: cover; border-radius: 30px;">
            </div>



            <div class="d-flex justify-content-center mt-3">
                <div class="card card1" style="border-radius: 25px;">
                    <div class="row justify-content-center card-header">
                        <h3 style="color:#ffffff;">Sign In</h3>
                    </div>
                    <div class="card-body">
                        <form method="post" action="${pageContext.request.contextPath}/authenticate">
                            <label  class="form-label" style="color: #ffffff">Email address</label>
                            <div class="input-group form-group">

                                <input style="background-color: #cdc3c3" name="email" type="text" class="form-control" placeholder="johndoe@yahoo.com">

                            </div>

                            <label  class="form-label mt-2" style="color: #ffffff">Password</label>
                            <div class="input-group form-group">

                                <input style="background-color: #cdc3c3" name="password" type="password" class="form-control" placeholder="Password">
                            </div>
                            <div class="row align-items-center remember">
                                <input type="checkbox">Remember Me
                            </div>
                            <div class="row justify-content-center">
                                <button type="submit" class="btn btn-warning" style="width: 150px;
                            border-color: black; border-style: double">Login
                                </button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>

</div>
</body>

</html>
