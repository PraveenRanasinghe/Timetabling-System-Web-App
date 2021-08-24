<%--
  Created by IntelliJ IDEA.
  User: Praveen
  Date: 5/1/2021
  Time: 1:48 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Remove Modules</title>
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
        <ul class="navbar-nav ml-auto mt-2">
            <li class="mr-5 mt-1">
                <form action="${pageContext.request.contextPath}/searchModules" method="get" class="d-flex">
                    <input class="form-control" style="width: 450px;" type="search"  name="searchByName" placeholder="Search Modules" aria-label="Search">
                    <button class="btn btn-primary" type="submit">Search</button>
                </form>
            </li>
            <li class="nav-item" style="cursor: pointer;">
                <a class="nav-link" href="/logout">Sign Out</a>
            </li>
        </ul>
    </div>
</nav>

<div class="row justify-content-center">
    <div style="font-family:sans-serif; background: #e0c67b; height: 50px; color: black; font-size: x-large;">${success}${error}</div>
</div>

<div class="container">
    <div class="row justify-content-center mt-5">
        <table class="table table-secondary table-striped" style="border-color: black; border-radius: 15px;">
            <thead style="background-color: #ffeb69; font-size: large; border-color: black; border-style: double;">
            <tr>
                <th scope="col">#</th>
                <th scope="col">Module ID</th>
                <th scope="col">Module Name</th>
                <th scope="col">Lecturer Name</th>
                <th scope="col">Learning Batch</th>
                <th scope="col">|Remove|</th>
                <th scope="col">|Update|</th>
                <th scope="col">|Schedule|</th>
            </tr>
            </thead>
            <tbody>
<c:forEach var="modules" items="${modules}" varStatus="item">
            <tr>
                <th scope="row">${item.index + 1}</th>
                <td>${modules.moduleID}</td>
                <td>${modules.moduleName}</td>
                <td>${modules.user.fName} ${modules.user.lName}</td>
                <td>
                    <c:forEach items="${modules.batches}" var="batch">
                        ${batch.batchID}
                    </c:forEach>
                </td>
                <td> <a class="btn btn-outline-danger" style="
                  width:150px;"   href="/deleteModule/${modules.moduleID}" id="demo" onclick="deleteModules()">Remove Module</a>
                </td>
                <td> <a class="btn btn-outline-warning" style=" color: black;
                  width:150px;" href="/getModule/${modules.moduleID}">Update Module</a>
                </td>
                <td> <a class="btn btn-outline-success" style="color: black;
                  width:150px;" href="/getModuleToTimetable/${modules.moduleID}">Schedule Lecture</a>
                </td>
            </tr>
</c:forEach>
            </tbody>
        </table>
    </div>
</div>

<script>
    function deleteModules() {
        var txt;
        var r = confirm("Do You Really want to Remove this Module?");
        if (r == true) {
            txt = "Module has been removed successfully!";
        } else {
            txt = "Cancelled";
        }
        document.getElementById("demo").innerHTML = txt;
    }
</script>


</body>
</html>
