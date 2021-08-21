<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Praveen
  Date: 4/29/2021
  Time: 9:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Users</title>
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

        </ul>
        <ul class="navbar-nav ml-auto">
            <li class="nav-item" style="cursor: pointer;">
                <a class="nav-link" href="/logout">Sign Out</a>
            </li>
        </ul>
    </div>
</nav>
<div class="row justify-content-center mt-4">

    <div class="col-lg-4">
        <div>
            <img src="${pageContext.request.contextPath}/images/stud.png"
                 style="background-size: cover; border-radius: 30px;">
        </div>
    </div>

    <div class="col-lg-6">
        <div class="contact">
            <div class="row header" style="box-shadow: 15px 15px 30px black; border-radius: 20px;">
                <div class="col contact-info">
                    <hr style="background-color: black">
                    <h2 class="justify-content-center">ADD NEW <b>STUDENTS</b></h2>
                    <hr style="background-color: black">
                </div>
                <div class="col">
                    <h3>Enroll new Students to the university here!</h3>
                </div>
            </div>
            <div class="row footer" style="box-shadow: 15px 15px 30px black; border-radius: 20px;">
                <form:form action="/adminAddUsers" modelAttribute="AddUser" method="POST">
                    <div class="contact-form">
                        <div class="form-group">
                            <div class="row">
                                <div class="col">
                                    <label class="control-label col">User Type:</label>
                                    <form:select path="userRole" name="userRole" id="userRole"
                                                 class="form-control" style="color: black; border-color: black"
                                                 readonly="true">
                                        <option value="student">Student</option>
                                    </form:select>
                                </div>
                                <div class="col">
                                    <label class="control-label col">Email Address:</label>
                                    <form:input type="text" path="email" style="border-color: black"
                                                cssClass="form-control" placeholder="any@gmail.com" required="required"
                                                pattern=".+@gmail.com"
                                                title="The email should be in the given pattern"/>

                                </div>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="row">
                                <div class="col">
                                    <label class="control-label col">First Name:</label>
                                    <form:input path="fName" type="text" style="border-color: black"
                                                class="form-control" placeholder="John" required="required"/>
                                </div>
                                <div class="col">
                                    <label class="control-label col">Last Name:</label>
                                    <form:input path="lName" type="text" style="border-color: black"
                                                class="form-control" placeholder="Doe" required="required"/>

                                </div>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="row">
                                <div class="col">
                                    <label class="control-label col" id="batchLable">Batch ID:</label>
                                    <form:select path="batchId" type="text" style="border-color: black"
                                                 cssClass="form-control" required="required">
                                        <c:forEach var="batchList" items="${batchList}" varStatus="item">
                                            <form:option value="${batchList.batchID}">
                                                ${batchList.batchID} ${batchList.batchName}
                                            </form:option>
                                        </c:forEach>
                                    </form:select>
                                </div>


                                <div class="col">
                                    <label class="control-label col">Contact Number:</label>
                                    <form:input path="contactNumber" type="text" style="border-color: black"
                                                class="form-control" placeholder="+94715385574" required="required"
                                                maxlength="15" minlength="10"/>
                                </div>
                            </div>
                        </div>

                        <div class="form-group mt-4" style="margin-left: 40%; width: 800px;">
                            <div class="col-sm-offset-2 col-sm-10">
                                <button type="submit" class="btn btn-warning">Create Account</button>
                            </div>
                        </div>
                    </div>
                </form:form>

            </div>
        </div>
        <div class="col-lg-2">

        </div>

    </div>
</div>

</body>
</html>
