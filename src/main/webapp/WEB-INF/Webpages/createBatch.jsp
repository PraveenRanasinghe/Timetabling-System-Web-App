<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Praveen
  Date: 4/28/2021
  Time: 11:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Batch</title>
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


<%--<div class="alert-secondary mt-3" style="background-color: #efdc7a; color: black; width: 800px; height: 70px; font-size: xx-large; ">--%>
<%--    ${successMessage}--%>
<%--    ${errorMessage}--%>
<%--</div>--%>
 <div class="row alert-success justify-content-center">
     <div style="font-family:sans-serif; color: black; font-size: x-large;">${success}${error}</div>
 </div>

<div class="container">

    <form:form  action="/adminAddBatches" modelAttribute="AddBatches" method="POST" class="mt-5">
            <div class="container contact">
                <div class="row" style="box-shadow: 15px 15px 30px black; border-radius: 20px;">
                    <div class="col-md-3">
                        <div class="contact-info">
                            <h2>CREATE NEW <b>BATCH</b></h2>
                        </div>
                    </div>
                    <div class="col-md-9">
                        <div class="contact-form">
                            <div class="form-group">
                                <label class="control-label">Batch ID:</label>
                                <div class="col-sm-10">
                                    <form:input type="text" path="batchID" style="border-color: black" cssClass="form-control" placeholder="Enter the Batch ID (EX:Computing_001)"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label">Batch Name:</label>
                                <div class="col-sm-10">
                                    <form:input path="batchName" type="text" style="border-color: black" cssClass="form-control" placeholder="Enter the Batch Name (EX:Software Engineering Batch)"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="row">
                                    <div class="col">
                                        <label class="control-label">Date of Commencement:</label>
                                        <form:input  path="startDate" style="color: black; border-color: black" type="date" pattern="yyyy-MM-dd" cssClass="form-control"/>
                                    </div>
                                    <div class="col">
                                        <label class="control-label">Date of Termination:</label>
                                        <form:input path="endDate" style="color: black; border-color: black" type="date" pattern="yyyy-MM-dd" cssClass="form-control"/>
                                    </div>
                                </div>
                            </div>

                            <div class="form-group mt-4" style="margin-left: 30%; width: 800px;">
                                <div class="col-sm-offset-2 col-sm-10">
                                    <button type="submit" class="btn btn-default ">Create Batch</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </form:form>
</div>
</body>
</html>
