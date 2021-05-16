<%--
  Created by IntelliJ IDEA.
  User: Praveen
  Date: 4/30/2021
  Time: 4:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Lecturer Home</title>
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
                <a class="nav-link" href="${pageContext.request.contextPath}/viewReScheduling">Re-Schedule Classes</a>
            </li>
            <li class="nav-item" style="cursor: pointer">
                <a class="nav-link" href="${pageContext.request.contextPath}/viewLecCancelClasses">Cancel Classes</a>
            </li>
            <li class="nav-item" style="cursor: pointer">
                <a class="nav-link" href="${pageContext.request.contextPath}/viewUpdateLecAccount">Update Account</a>
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
    <div class="row justify-content-center mt-4">
        <h1 style="color: #292929"><b>Find Your Weekly Time Table Here!</b></h1>
    </div>


    <hr style="background-color: black">

    <div class="mt-5">
        <form>
            <div class="row justify-content-center">

                <div style="width: 600px">
                    <label style="color: #030303"><h4>Select the Date:</h4></label>
                    <input  style="background-color: grey; color: black" type="date" class="form-control">
                </div>
            </div>

            <div class="row mt-5 justify-content-center">
                <button type="submit" class="btn btn-primary" style="border-color: black; border-style: double">View Time Table</button>
            </div>

        </form>
        <hr style="background-color: black">
    </div>

</div>
</body>
</html>
