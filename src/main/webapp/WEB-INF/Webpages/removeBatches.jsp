<%--
  Created by IntelliJ IDEA.
  User: Praveen
  Date: 4/29/2021
  Time: 5:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Remove Batches</title>
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
                <a class="nav-link nl">Sign Out</a>
            </li>
        </ul>
    </div>
</nav>

<div class="container">
    <div class="row justify-content-center mt-5">
        <table class="table table-info table-striped" style="border-color: black; border-radius: 15px;">
            <thead style="background-color: #ffeb69; font-size: large; border-color: black; border-style: double;">
            <tr>
                <th scope="col">#</th>
                <th scope="col">Batch ID</th>
                <th scope="col">Batch Name</th>
                <th scope="col">Commencement Date</th>
                <th scope="col">Termination Date</th>
                <th scope="col">|Remove|</th>
                <th scope="col">|Update|</th>
            </tr>
            </thead>
            <tbody>
<c:forEach var="batches" items="${batches}" varStatus="item">
            <tr>
                <th scope="row">${item.index + 1}</th>
                <td>${batches.batchID}</td>
                <td>${batches.batchName}</td>
                <td><fmt:formatDate value="${batches.startDate}" pattern="yyyy-MM-dd"/></td>
                <td><fmt:formatDate value="${batches.endDate}" pattern="yyyy-MM-dd"/></td>
                <td> <a class="btn btn-danger" style="border-color: black;
                  width:150px; border-style: double">Remove Batch</a>
                </td>
                <td> <a class="btn btn-warning" style="border-color: black;
                  width:150px; border-style: double" href="/getBatch/${batches.batchID}">Update Batch</a>
                </td>
            </tr>
</c:forEach>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>
