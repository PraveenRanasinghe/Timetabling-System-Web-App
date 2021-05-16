<%--
  Created by IntelliJ IDEA.
  User: Praveen
  Date: 4/30/2021
  Time: 9:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Account Details</title>
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
                <a class="nav-link " href="${pageContext.request.contextPath}/home">Home</a>
            </li>
            <li class="nav-item" style="cursor: pointer">
                <a class="nav-link active" href="${pageContext.request.contextPath}/viewUpdateStudAccount">Update Account</a>
            </li>

        </ul>

        <ul class="navbar-nav ml-auto">
            <li class="nav-item" style="cursor: pointer;">
                <a class="nav-link nl">Sign Out</a>
            </li>
        </ul>
    </div>
</nav>

<div class="row alert-success justify-content-center mt-4">
    <div style="font-family:sans-serif; color: black; font-size: x-large;">${success}${error}</div>
</div>

<div class="container">
    <div class="row justify-content-center">
        <form class="mt-5">
            <div style="width: 900px; background-color: #3f9658; margin-left: 10%; border-color: #ee823b; border-style: dashed; border-radius: 10px;">

                <div class="row justify-content-center mt-2">
                    <h3>Update User Account</h3>
                </div>
                <hr style="background-color: black">

                <div class="row" style="width: 400px; margin-left: 28%">
                    <label  class="form-label"><b>Email Address</b></label>
                    <input  style="background-color: #e3e1e1; color: black; border-color: black" type="email" contenteditable="false" class="form-control">
                </div>

                <div class="row justify-content-center ml-2 mt-3 mr-2">
                    <div class="col">
                        <label  class="form-label"><b>First Name:</b></label>
                        <input  style="background-color: #e3e1e1; color: black; border-color: black" type="password" class="form-control" contenteditable="true">
                    </div>
                    <div class="col">
                        <label  class="form-label"><b>Last Name:</b></label>
                        <input  style="background-color: #e3e1e1; color: black; border-color: black" type="password" class="form-control" contenteditable="true">
                    </div>
                </div>

                <div class="row justify-content-center ml-2 mt-3 mr-2">
                    <div class="col">
                        <label  class="form-label"><b>Create New Password</b></label>
                        <input  style="background-color: #e3e1e1; color: black; border-color: black" type="password" class="form-control" placeholder="Create Your New Password Here">
                    </div>
                    <div class="col">
                        <label  class="form-label"><b>Re-Enter the Password</b></label>
                        <input  style="background-color: #e3e1e1; color: black; border-color: black" type="password" class="form-control" placeholder="Re-Enter Your Password Here">
                    </div>
                </div>

                <div class="row justify-content-center mt-4">
                    <button type="submit" class="btn btn-warning mb-4" style="border-color: black; border-style: double">Update Account</button>
                </div>

            </div>
        </form>
    </div>
</div>
</body>
</html>
