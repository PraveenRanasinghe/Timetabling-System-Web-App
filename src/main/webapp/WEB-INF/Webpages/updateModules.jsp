<%--
  Created by IntelliJ IDEA.
  User: Praveen
  Date: 5/1/2021
  Time: 1:29 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Update Module Details</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="/css/Home.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <link href="/webjars/bootstrap/4.5.0/css/bootstrap.min.css" rel="stylesheet"/>
    <script src="/webjars/bootstrap/4.5.0/js/bootstrap.min.js"></script>
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
<div class="row alert-success justify-content-center mt-4">
    <div style="font-family:sans-serif; color: black; font-size: x-large;">${success}${error}</div>
</div>
<div class="container">
    <div class="row justify-content-center mt-5">
        <form:form action="/adminUpdateModules" modelAttribute="getModule" method="post" cssClass="mt-5">
            <div class="row justify-content-center mt-5">
                <div style="width: 500px; height: 550px; background-color: #bfa597; border-radius: 20px; border-color: black; border-style:double;
                  box-shadow: 15px 15px 30px black; border-radius: 20px;">
                    <div class="ml-2 mt-5 mr-2">
                        <div class="row justify-content-center">
                            <img src="https://cdn1.iconfinder.com/data/icons/education-set-2-3/33/reader_2-512.png" style="width: 150px; height: 150px; background-size: cover;"/>

                            </img>
                        </div>
                        <div class="row justify-content-center">
                            <h1>${findModule.moduleName}</h1>
                        </div>
                        <div class="row mt-3">
                            <div class="col">
                                <label class="control-label col"><b>Module ID</b></label>
                                <form:input path="moduleID" value="${findModule.moduleID}" type="text" style="border-color: black"
                                            cssClass="form-control" readonly="true"/>
                            </div>
                            <div class="col">
                                <label class="control-label col"><b>Update Module Name</b></label>
                                <form:input path="moduleName" value="${findModule.moduleName}" type="text" style="border-color: black"
                                            cssClass="form-control" placeholder="" readonly="false"/>
                            </div>
                        </div>
                        <div class="row mt-4">
                            <div class="col">
                                <label class="control-label col"><b>Lecturer</b></label>
                                <form:input path="user.email" value="${findModule.user.email}" type="text" style="border-color: black"
                                            cssClass="form-control" placeholder="" readonly="true"/>
                            </div>
                            <div class="col">
                                <label class="control-label col"><b>Currently Learning Batches</b></label>
                                <form:input path="batches" value="${findModule.batches}" type="" style="border-color: black"
                                            cssClass="form-control" placeholder="" readonly="true"/>
                            </div>

                        </div>

                        <div class="row justify-content-center mt-4">
                            <button type="submit" class="btn btn-success">Save Changes</button>
                        </div>
                    </div>
                </div>
            </div>
        </form:form>
    </div>
</div>
</body>
</html>
