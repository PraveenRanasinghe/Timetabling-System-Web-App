<%--
  Created by IntelliJ IDEA.
  User: Praveen
  Date: 4/30/2021
  Time: 12:25 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>View & Delete Users</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="/css/Home.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <link href="webjars/bootstrap/4.5.0/css/bootstrap.min.css" rel="stylesheet"/>
    <script src="webjars/bootstrap/4.5.0/js/bootstrap.min.js"></script>
    <link href="css/font-awesome-4.6.3/css/font-awesome.min.css" rel="stylesheet">
</head>

<body>
<nav class="navbar navbar-expand-lg"
     style="padding: 10px; background-color: #011801; border-color: black; border-style:outset; font-size:large ">
    <div class="container">
        <ul id="dropdown-animated" class="navbar-nav">
            <li class="nav-item" style="cursor: pointer">
                <a class="nav-link active" href="${pageContext.request.contextPath}/viewAdminHome">Back to Home</a>
            </li>

        </ul>
        <ul class="navbar-nav ml-auto mt-2">
            <li class="mr-5">
                <form action="${pageContext.request.contextPath}/searchUsers" method="get" class="d-flex">
                    <input class="form-control" style="width: 450px;" type="search" name="searchByName"
                           placeholder="Search Students" aria-label="Search">
                    <button class="btn btn-primary" type="submit">Search</button>
                </form>
            </li>

            <li class="nav-item ml-5" style="cursor: pointer;">
                <a class="nav-link" href="/logout">Sign Out</a>
            </li>
        </ul>
    </div>
</nav>

<div class="row justify-content-center">
    <div style="font-family:sans-serif; background: #e0c67b; height: 50px; color: black; font-size: x-large;">${success}${error}</div>
</div>

<div class="container">
    <h2 class="justify-content-center mt-5">List of Students:</h2>
    <div class="row justify-content-center mt-5">
        <table class="table table-striped table-success table-hover" style="border-color: black; border-radius: 15px;">
            <thead>
            <tr class="table-bordered"
                style="background-color: #ffeb69; font-size: large; border-color: black; border-style: double;">
                <th scope="col">#</th>
                <th scope="col">First Name</th>
                <th scope="col">Last Name</th>
                <th scope="col">Email</th>
                <th scope="col">Learning Batch</th>
                <th scope="col">Contact Number</th>
                <th scope="col"> Remove</th>
                <th scope="col"> Update</th>
                <th scope="col">Call User</th>
                <th scope="col">Email User</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="users" items="${users}" varStatus="item">
                <tr>
                    <td scope="row">${item.index + 1}</td>
                    <td>${users.fName}</td>
                    <td>${users.lName}</td>
                    <td>${users.email}</td>
                    <td>${users.batchId.batchID}</td>
                    <td>${users.contactNumber}</td>
                    <td><a class="btn btn-danger" style="border-color: black;
                  width:150px; border-style: double" href="/deleteStudent/${users.email}">Remove Student</a>
                    </td>
                    <td><a class="btn btn-warning" style="border-color: black;
                  width:150px; border-style: double" href="/getUser/${users.email}">Update Student</a>
                    </td>
                    <td>
                        <a href="tel:${users.contactNumber}">
                            <img src="${pageContext.request.contextPath}/images/call.png"
                                 style="height: 24px; width: 24px; margin-top: 5px">
                        </a>
                    </td>
                    <td>
                        <a href="mailto:${users.email}">
                            <img src="${pageContext.request.contextPath}/images/email.png"
                                 style="height: 24px; width: 24px; margin-top: 5px">
                        </a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>
