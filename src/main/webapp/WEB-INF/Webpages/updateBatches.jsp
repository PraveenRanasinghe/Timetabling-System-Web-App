<%--
  Created by IntelliJ IDEA.
  User: Praveen
  Date: 4/29/2021
  Time: 5:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Update Batch Details</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="/css/Home.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <link href="/webjars/bootstrap/4.5.0/css/bootstrap.min.css" rel="stylesheet"/>
    <script src="/webjars/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</head>

<body>

<nav class="navbar navbar-expand-lg"
     style="padding: 10px; background-color: #011801; border-color: black; border-style:outset; font-size:large ">
    <div class="container">
        <ul id="dropdown-animated" class="navbar-nav">
            <li class="nav-item" style="cursor: pointer">
                <a class="nav-link active" href="${pageContext.request.contextPath}/viewAdminHome">Back to Home</a>
            </li>

            <li class="nav-item ml-5" style="cursor: pointer">
                <a class="nav-link active" href="${pageContext.request.contextPath}/viewRemoveBatch">Back to List</a>
            </li>

        </ul>
    </div>
</nav>

<div class="row justify-content-center">
    <div style="font-family:sans-serif; background: #e0c67b; height: 50px; color: black; font-size: x-large;">${success}${error}</div>
</div>
<div class="container">
    <form:form action="/adminUpdateBatches" modelAttribute="getBatch" method="post" cssClass="mt-5">
        <div class="row justify-content-center mt-5">
            <div style="width: 500px; height: 550px; background: rgb(170,179,228);
background: linear-gradient(90deg, rgba(170,179,228,1) 0%, rgba(167,171,100,1) 48%, rgba(191,232,139,0.8799894957983193) 100%); border-radius: 20px; border-color: black; border-style:double;
         box-shadow: 15px 15px 30px black; border-radius: 20px;">
                <div class="ml-2 mt-5 mr-2">
                    <div class="row justify-content-center">
                        <img src="https://www.freeiconspng.com/uploads/computer-user-icon-27.png"
                             style="width: 150px; height: 150px; background-size: cover;"/>

                        </img>
                    </div>
                    <div class="row justify-content-center">
                        <h1>${findBatch.batchID}</h1>
                    </div>
                    <div class="row mt-3">
                        <div class="col">
                            <label class="control-label col"><b>Batch ID</b></label>
                            <form:input path="batchID" value="${findBatch.batchID}" type="text"
                                        style="border-color: black"
                                        cssClass="form-control" readonly="true"/>
                        </div>
                        <div class="col">
                            <label class="control-label col"><b>Update Batch Name</b></label>
                            <form:input path="batchName" value="${findBatch.batchName}" type="text"
                                        style="border-color: black"
                                        cssClass="form-control" placeholder="" readonly="false"/>
                        </div>
                    </div>
                    <div class="row mt-4">
                        <div class="col">
                            <label class="control-label col"><b>Started Date</b></label>
                            <form:input path="startDate" value="${findBatch.startDate}" pattern="yyyy-MM-dd" type="text"
                                        style="border-color: black"
                                        cssClass="form-control" placeholder="" readonly="true"/>
                        </div>
                        <div class="col">
                            <label class="control-label col"><b>Ending date</b></label>
                            <form:input path="endDate" value="${findBatch.endDate}" pattern="yyyy-MM-dd" type="text"
                                        style="border-color: black"
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

</body>
</html>
