<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Praveen
  Date: 5/11/2021
  Time: 2:33 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add ClassRoom</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="/css/Home.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <link href="webjars/bootstrap/4.5.0/css/bootstrap.min.css" rel="stylesheet"/>
    <script src="webjars/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</head>
<body>
<nav class="navbar navbar-expand-lg"
     style="padding: 10px; background-color: #011801; border-color: black; border-style:outset; font-size:large ">
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
    <div style="font-family:sans-serif; background: #FFC312; height: 50px; color: black; font-size: x-large;">${success}${error}</div>
</div>


<div class="container">
    <div class="row justify-content-center mb-5 mt-1">

        <form:form action="/adminAddClassRooms" modelAttribute="AddClasses" method="post" class="mt-5">
            <div class="container contact">
                <div class="row" style="box-shadow: 15px 15px 30px black; border-radius: 20px;">
                    <div class="col-md-3">
                        <div class="contact-info">
                            <h2>ADD NEW <b>CLASS-ROOM</b></h2>

                        </div>
                    </div>
                    <div class="col-md-9">
                        <div class="contact-form">
                            <div class="form-group">
                                <div class="row">
                                    <div class="col">
                                        <label class="control-label col">ClassRoom ID</label>
                                        <form:input path="classRoomID" type="text" style="border-color: black"
                                                    cssClass="form-control"
                                                    placeholder="Enter the ClassRoom ID :(CLZ_any)" required="required"
                                                    pattern="CLZ_.+"
                                                    title="The Class-Room Id should be in the given pattern"/>
                                    </div>
                                    <div class="col">
                                        <label class="control-label col">Capacity of the Room</label>
                                        <form:input path="capacity" type="number" min="0" style="border-color: black"
                                                    cssClass="form-control"
                                                    placeholder="Enter the capacity of the Class" required="required"/>
                                        <form:errors path="capacity" cssStyle="align-content: center; color: red;">
                                        </form:errors>
                                    </div>
                                </div>
                            </div>

                            <div class="form-group">
                                <div class="row">
                                    <div class="col">
                                        <label class="control-label">Air Conditioned: </label>
                                        <div class="form-check">
                                            <form:select path="ac" style="border-color: black" class="form-control"
                                                         value="" id="flexCheckDefault">
                                                <option>Yes</option>
                                                <option>No</option>
                                            </form:select>

                                        </div>
                                    </div>
                                    <div class="col">
                                        <div class="form-check">
                                            <label class="control-label">Smart Board :</label>
                                            <form:select path="smartBoard" style="border-color: black"
                                                         class="form-control" value="" id="flexCheckDefault">
                                                <option>Yes</option>
                                                <option>No</option>
                                            </form:select>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="form-group mt-4" style="margin-left: 30%; width: 800px;">
                                <div class="col-sm-offset-2 col-sm-10">
                                    <button type="submit" class="btn btn-warning ">Add Class-Room</button>
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
