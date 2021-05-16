<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Praveen
  Date: 5/13/2021
  Time: 1:18 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Class-Room</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="/css/Home.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <link href="/webjars/bootstrap/4.5.0/css/bootstrap.min.css" rel="stylesheet"/>
    <script src="/webjars/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</head>
<body>

<div class="row alert-success justify-content-center">
    <div style="font-family:sans-serif; color: black; font-size: x-large;">${success}${error}</div>
</div>

<form:form action="/adminUpdateClassRoom" modelAttribute="getClassRoom" method="post" cssClass="mt-5">
    <div class="row justify-content-center mt-5">
        <div style="width: 500px; height: 550px; background-color: #fdf102; border-radius: 20px; border-color: black; border-style:double;
box-shadow: 15px 15px 30px black; border-radius: 20px;">
            <div class="ml-2 mt-5 mr-2">
                <div class="row justify-content-center">
                    <img src="https://img.icons8.com/ios/452/google-classroom.png"
                         style="width: 150px; height: 150px; background-size: cover;"/>

                    </img>
                </div>
                <div class="row justify-content-center">
                    <h1>${findClassRoom.classRoomID}</h1>
                </div>
                <div class="row mt-3">
                    <div class="col">
                        <label class="control-label col"><b>Class-Room ID</b></label>
                        <form:input path="classRoomID" value="${findClassRoom.classRoomID}" type="text" style="border-color: black"
                                    cssClass="form-control" readonly="true"/>
                    </div>

                    <form:input path="timetable" value="${findClassRoom.timetable}" type="hidden"/>

                     <div class="col">
                        <label class="control-label col"><b>Capacity of the Class</b></label>
                        <form:input path="capacity" value="${findClassRoom.capacity}" type="text" style="border-color: black"
                                    cssClass="form-control" placeholder="" readonly="false"/>
                    </div>
                </div>
                <div class="row">
                    <div class="col">
                        <label class="control-label col"><b>Air-Conditioned</b></label>
                        <form:select path="ac" value="${findClassRoom.ac}" type="text" style="border-color: black"
                                    cssClass="form-control" placeholder="" readonly="false">
                            <option>Yes</option>
                            <option>No</option>
                        </form:select>
                    </div>
                    <div class="col">
                        <label class="control-label col"><b>Smart Board</b></label>
                        <b><form:select path="smartBoard" value="${findClassRoom.smartBoard}" type="text"
                                       style="border-color: black"
                                        cssClass="form-control" placeholder="" readonly="false">
                            <option>Yes</option>
                            <option>No</option>
                        </form:select></b>
                    </div>
                </div>

                <div class="row justify-content-center mt-4">
                    <button type="submit" class="btn btn-success">Update User Info</button>
                </div>
            </div>
        </div>
    </div>
</form:form>
</body>
</html>
