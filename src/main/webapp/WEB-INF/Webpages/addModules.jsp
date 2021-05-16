<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Praveen
  Date: 5/1/2021
  Time: 12:22 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Modules</title>
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
    <div class="row justify-content-center">
        <form:form action="/adminAddModules" modelAttribute="AddModules" method="post" class="mt-5">
            <div class="container contact">
                <div class="row" style="box-shadow: 15px 15px 30px black; border-radius: 20px;">
                    <div class="col-md-3">
                        <div class="contact-info">
                            <h2>ADD NEW <b>MODULES</b></h2>

                        </div>
                    </div>
                    <div class="col-md-9">
                        <div class="contact-form">
                            <div class="form-group">
                                <div class="row">
                                    <div class="col">
                                        <label class="control-label col">Module ID</label>
                                        <form:input path="moduleID" type="text" style="border-color: black" cssClass="form-control" placeholder="Enter the Module ID"/>
                                    </div>
                                    <div class="col">
                                        <label class="control-label col">Module Name</label>
                                        <form:input path="moduleName" type="text" style="border-color: black" cssClass="form-control" placeholder="Enter the Module Name"/>
                                    </div>
                                </div>
                            </div>

                            <div class="form-group">
                                <div class="row">
                                    <div class="col">
                                        <label class="control-label col">Lecturer Name</label>
                                        <form:select path="user.email"  style="border-color: black" cssClass="form-control">
                                            <c:forEach var="lecList" items="${lecList}" varStatus="item">
                                                <form:option value="${lecList.email}">
                                                    ${lecList.fName} ${lecList.lName}
                                                </form:option>
                                            </c:forEach>
                                        </form:select>
                                    </div>
                                    <div class="col">
                                        <label class="control-label col">Assign the batch</label>
                                        <form:select path="batch.batchID"  style="border-color: black" cssClass="form-control">
                                            <c:forEach var="batchList" items="${batchList}" varStatus="item">
                                                <form:option value="${batchList.batchID}">
                                                    ${batchList.batchID} - ${batchList.batchName}
                                                </form:option>
                                            </c:forEach>
                                        </form:select>
                                    </div>
                                </div>
                            </div>

                            <div class="form-group mt-4" style="margin-left: 30%; width: 800px;">
                                <div class="col-sm-offset-2 col-sm-10">
                                    <button type="submit" class="btn btn-warning ">Add Module</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </form:form>
    </div>
</div>
</body>
</html>
