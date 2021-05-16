<%--
  Created by IntelliJ IDEA.
  User: Praveen
  Date: 4/26/2021
  Time: 2:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Re-Schedule Classes</title>
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
                <a class="nav-link" href="${pageContext.request.contextPath}/home">Home</a>
            </li>
            <li class="nav-item" style="cursor: pointer">
                <a class="nav-link active" href="${pageContext.request.contextPath}/viewReScheduling">Re-Schedule Classes</a>
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
    <form class="mt-5">
    <div style="width: 900px; background-color: #3f9658; margin-left: 10%; border-color: #ee823b; border-style: dashed; border-radius: 10px;">

        <div class="row justify-content-center mt-2">
            <h3>Re-Scheduling Form</h3>
        </div>
        <hr style="background-color: black">
        <div class="row">
            <div class="col ml-4">
                <label  class="form-label"><b>Module Name:</b></label>
                <select name="module" class="form-control"  style="background-color: #e3e1e1; color: black; border-color: black">
                    <option value="ABC001">ISEI</option>
                    <option value="ABC002">EEA</option>
                    <option value="ABC003">EIRLS</option>
                    <option value="ABC004">FYP</option>
                </select>
            </div>
            <div class="col">
                <label  class="form-label"><b>Select the Batch: </b></label>
                <select name="batch" id="batch" class="form-control"  style="background-color: #e3e1e1; color: black; border-color: black">
                    <option value="ABC001">ABC001</option>
                    <option value="ABC002">ABC002</option>
                    <option value="ABC003">ABC003</option>
                    <option value="ABC004">ABC004</option>
                </select>
            </div>
        </div>


        <div class="row justify-content-center mt-3">
            <div style="width: 400px;">
                <label  class="form-label"><b>New Scheduling Date:</b></label>
                <input  style="background-color: #e3e1e1; color: black; border-color: black" type="date" class="form-control">
            </div>
        </div>

        <div class="row justify-content-center mt-4">
            <button type="submit" class="btn btn-warning mb-4" style="border-color: black; border-style: double">Re-Schedule the Class</button>
        </div>

    </div>
    </form>
</div>
</body>
</html>
