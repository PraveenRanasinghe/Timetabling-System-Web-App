<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Praveen
  Date: 4/30/2021
  Time: 12:58 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Schedule Classes</title>
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

<div class="row alert-success justify-content-center">
    <div style="font-family:sans-serif; color: black; font-size: x-large;">${success}${error}</div>
</div>


    <div class="row">
        <div class="col-lg-4">
            <div class="mt-4 ml-3">
                <img src="${pageContext.request.contextPath}/images/lec1.png"
                     style="height: 650px;   background-size: cover; border-radius: 30px;">
            </div>
        </div>
        <div class="col-lg-8">
            <form:form class="mt-5" action="/adminAddTimetable" modelAttribute="AddTimetable" method="POST">
                <div style="box-shadow: 15px 15px 30px black; border-radius: 20px;
         width: 900px; background: rgb(75,144,154);
background: linear-gradient(90deg, rgba(75,144,154,1) 0%, rgba(21,135,52,1) 35%, rgba(215,235,122,1) 100%); margin-left: 10%; border-color: #130a04;
          border-style: inset; border-radius: 10px;">


                    <div class="row justify-content-center mt-2">
                        <h1><u><i>Class Scheduling Form</i></u></h1>
                    </div>
                    <hr style="background-color: black">

                    <div class="row mt-5 ml-4 mr-4">

                        <div class="col-lg-4">
                            <label class="form-label"><b>Name of the Module</b></label>
                            <form:select path="modules.moduleID" type="text" style="border-color: black"
                                         cssClass="form-control">
                                <c:forEach var="moduleList" items="${moduleList}" varStatus="item">
                                    <form:option value="${moduleList.moduleID}">
                                        ${moduleList.moduleID} : ${moduleList.moduleName}
                                    </form:option>
                                </c:forEach>
                            </form:select>
                        </div>

                        <div class="col-lg-4">
                            <label class="form-label"><b>Batch ID</b></label>
                            <form:select path="batches" type="text" style="border-color: black" cssClass="form-control">
                                <c:forEach var="batchList" items="${batchList}" varStatus="item">
                                    <form:option value="${batchList.batchID}">
                                        ${batchList.batchID} ${batchList.batchName}
                                    </form:option>
                                </c:forEach>
                            </form:select>
                        </div>

                        <div class="col-lg-4">
                            <label class="form-label"><b>Select the Class</b></label>
                            <form:select path="classRoom.classRoomID" type="text" style="border-color: black"
                                         cssClass="form-control">

                                <c:forEach var="classRoomList" items="${classRoomList}" varStatus="item">
                                    <form:option value="${classRoomList.classRoomID}">
                                        ${classRoomList.classRoomID}: ${classRoomList.capacity}
                                    </form:option>
                                </c:forEach>
                            </form:select>

                        </div>
                    </div>

                    <div class="row mt-5 ml-4 mr-4">

                        <div class="col-lg-4">
                            <label class="form-label"><b>Select the Date</b></label>
                            <form:input path="scheduledDate" Class="form-control" type="date"
                                        style="background-color: #e3e1e1; color: black; border-color: black"/>
                        </div>

                        <div class="col-lg-4">
                            <label class="form-label"><b>Starting Time</b></label>
                            <form:input path="startTime" Class="form-control"
                                        style="background-color: #e3e1e1; color: black; border-color: black" type="time"
                                        placeholder="Dr.John Doe"/>
                        </div>

                        <div class="col-lg-4">
                            <label class="form-label"><b>Ending Time</b></label>
                            <form:input path="endTime" Class="form-control" type="time"
                                        style="background-color: #e3e1e1; color: black; border-color: black"/>
                        </div>

                    </div>


                    <div class="row justify-content-center mt-5">
                        <button type="submit" class="btn btn-primary mb-4" style="border-color: black; border-style: double">
                            Schedule The Class
                        </button>
                    </div>

                </div>
            </form:form>
        </div>
    </div>


</body>
</html>
