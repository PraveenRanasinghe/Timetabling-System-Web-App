<%--
  Created by IntelliJ IDEA.
  User: Praveen
  Date: 5/7/2021
  Time: 2:27 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>View & Delete Users</title>
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
            <li class="mr-5">
                <form action="${pageContext.request.contextPath}/searchUsers" method="get" class="d-flex">
                    <input class="form-control" style="width: 450px;" type="search"  name="searchByName" placeholder="Search Lecturers" aria-label="Search">
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
    <h2 class="justify-content-center mt-5">List of Lecturers:</h2>
    <div class="row justify-content-center mt-5">
        <table class="table table-secondary table-striped" style="border-color: black; border-radius: 15px;">
            <thead style="background-color: #ffeb69; font-size: large; border-color: black; border-style: double;">
            <tr>
                <th scope="col">#</th>
                <th scope="col">First Name</th>
                <th scope="col">Last Name</th>
                <th scope="col">Email</th>
                <th scope="col">Contact Number</th>
                <th scope="col">|Remove|</th>
                <th scope="col">|Update|</th>
                <th scope="col">Call User</th>
                <th scope="col">Email User</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="Lecturers" items="${Lecturers}" varStatus="item">
                <tr>
                    <td scope="row"><b>${item.index + 1}</b></td>
                    <td>${Lecturers.fName}</td>
                    <td>${Lecturers.lName}</td>
                    <td>${Lecturers.email}</td>
                    <td>${Lecturers.contactNumber}</td>
                    <td><a class="btn btn-danger" style="border-color: black;
                  width:150px; border-style: double" href="/deleteLec/${Lecturers.email}">Remove Lecturer</a>
                    </td>
                    <td><a class="btn btn-warning" style="border-color: black;
                  width:150px; border-style: double" href="/getUser/${Lecturers.email}">Update Lecturer</a>
                    </td>
                    <td>
                        <a href="tel:${Lecturers.contactNumber}">
                             <i class="fas fa-phone-alt"></i>
                        </a>
                    </td>
                    <td>
                        <a href="mailto:${Lecturers.email}">
                            <button class="btn btn-primary"></button>
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
