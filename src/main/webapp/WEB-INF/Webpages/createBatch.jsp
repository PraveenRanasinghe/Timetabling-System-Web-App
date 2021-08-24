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

<nav class="navbar navbar-expand-lg" style="padding: 10px; background-color: #011801; border-color: black; border-style:outset; font-size:large ">
    <div class="container">
        <ul id="dropdown-animated" class="navbar-nav">
            <li class="nav-item" style="cursor: pointer">
                <a class="nav-link active" href="${pageContext.request.contextPath}/viewAdminHome">Back to Home</a>
            </li>

        </ul>
        <ul class="navbar-nav ml-auto">
            <li class="nav-item" style="cursor: pointer;">
                <a class="nav-link" href="/logout">Sign Out</a>
            </li>
        </ul>
    </div>
</nav>


<div class="row justify-content-center">
    <div style="font-family:sans-serif; background: #e0c67b; height: 50px; color: black; font-size: x-large;">${success}${error}</div>
</div>

<div class="row justify-content-center">
    <div>
        <img src="${pageContext.request.contextPath}/images/students.png"
             style="height: 350px;background-size: cover; border-radius: 30px;">
    </div>
</div>
<div class="row justify-content-center mb-5">
    <form:form action="/adminAddBatches" modelAttribute="AddBatches" method="POST">
    <div class="contact">
        <div class="row" style="box-shadow: 15px 15px 30px black; border-radius: 20px;">
            <div class="col-md-3">
                <div class="contact-info">
                    <h2>CREATE NEW <b>BATCH</b></h2>
                </div>
            </div>
            <div class="col-md-9">
                <div class="contact-form">
                    <div class="row">
                        <div class="col">
                            <div class="form-group">
                                <label class="control-label">Batch ID:</label>
                                <div class="col">
                                    <form:input type="text" path="batchID" style="border-color: black"
                                                cssClass="form-control"
                                                placeholder="Enter the Batch ID (EX:APIIT_any)" required="required"
                                                pattern="APIIT_.+" title="The Batch Id should be in the given pattern"/>
                                </div>
                            </div>
                        </div>
                        <div class="col">
                            <div class="form-group">
                                <label class="control-label">Batch Name:</label>
                                <div class="col">
                                    <form:input path="batchName" type="text" style="border-color: black"
                                                cssClass="form-control"
                                                placeholder="Enter the Batch Name (EX:Software Engineering Batch)" required="required"/>
                                </div>
                            </div>
                        </div>
                    </div>


                    <div class="row mt-4">
                        <div class="col">
                            <div class="form-group">
                                <label class="control-label">Date of Commencement:</label>
                                <form:input path="startDate"  id="dateControl"
                                            style="color: black; border-color: black" type="date"
                                            pattern="yyyy-MM-dd" cssClass="form-control" required="required"/>
                            </div>
                        </div>
                        <div class="col">
                            <div class="form-group">
                                <label class="control-label">Date of Termination:</label>
                                <form:input path="endDate" id="dateControl2"
                                            style="color: black; border-color: black" type="date"
                                            pattern="yyyy-MM-dd" cssClass="form-control" required="required"/>
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
        </form:form>
    </div>
</div>

<script>
    $(document).ready(function (){
        $(function (){
            var dtToday = new Date();
            var month = dtToday.getMonth()+1;
            var day = dtToday.getDay()+8;
            var year = dtToday.getFullYear();

            if(month<10){
                month='0'+month.toString();
            }
            if(day<10){
                day='0'+day.toString();
            }

            var maxDate = year +'-' +month+'-'+day;
            $('#dateControl').attr('min',maxDate);
            $('#dateControl2').attr('min',maxDate);
        });
    })
</script>
</body>
</html>
