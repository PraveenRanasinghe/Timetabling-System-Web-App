<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Praveen
  Date: 5/29/2021
  Time: 12:15 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>My Modules</title>
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
                <a class="nav-link active" href="${pageContext.request.contextPath}/viewStudentHome">Back to Home</a>
            </li>

        </ul>
        <ul class="navbar-nav ml-auto">
            <li class="nav-item" style="cursor: pointer;">
                <a class="nav-link" href="/logout">Sign Out</a>
            </li>
        </ul>
    </div>
</nav>

<div class="row alert-success justify-content-center">
    <div style="font-family:sans-serif; color: black; font-size: x-large;">${success}${error}</div>
</div>


<div class="container">
    <div class="row justify-content-center mt-5">
        <table class="table table-info table-striped" style="border-color: black; border-radius: 15px;">
            <thead style="background-color: #ffeb69; font-size: large; border-color: black; border-style: double;">
            <tr>
                <th scope="col">#</th>
                <th scope="col">Module Name</th>
                <th scope="col">Lecturer Name</th>
                <th scope="col">Contact Lecturer</th>
                <th scope="col">Send Email</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="modules" items="${modules}" varStatus="item">
                <tr>
                    <th scope="row">${item.index + 1}</th>
                    <td>${modules.moduleName}</td>
                    <td>${modules.user.fName} ${modules.user.lName}</td>
                    <td>
                    <a href="tel:${modules.user.contactNumber}">
                        <button class="btn btn-success">Contact Lecturer</button>
                    </a>
                    </td>
                    <td>
                    <a href="mailto:${modules.user.email}">
                        <button class="btn btn-warning">Send Mail to Lecturer</button>
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
