<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Praveen
  Date: 5/7/2021
  Time: 10:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update User</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="/css/Home.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <link href="/webjars/bootstrap/4.5.0/css/bootstrap.min.css" rel="stylesheet"/>
    <script src="/webjars/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</head>
<body>

<nav class="navbar navbar-expand-lg" style="padding: 10px; background-color: #011801; border-color: black; border-style:outset; font-size:large ">
    <div class="container">
        <ul id="dropdown-animated" class="navbar-nav">
            <li class="nav-item" style="cursor: pointer">
                <a class="nav-link active" href="${pageContext.request.contextPath}/viewAdminHome">Back to Home</a>
            </li>


        </ul>

    </div>
</nav>

<div class="row justify-content-center">
    <div style="font-family:sans-serif; background: #e0c67b; height: 50px; color: black; font-size: x-large;">${success}${error}</div>
</div>

<form:form action="/adminUpdateUsers" modelAttribute="upUser" method="post" cssClass="mt-5">
    <div class="row justify-content-center mt-5">
        <div style="width: 500px; height: 550px; background-color: #d0ee94; border-radius: 20px; border-color: black; border-style:double;
box-shadow: 15px 15px 30px black; border-radius: 20px;">
            <div class="ml-2 mt-5 mr-2">
                <div class="row justify-content-center">
                    <img src="https://blog.cpanel.com/wp-content/uploads/2019/08/user-01.png"
                         style="width: 150px; height: 150px; background-size: cover;"/>

                    </img>
                </div>
                <div class="row justify-content-center">
                    <h1>${findUser.fName} ${findUser.lName}</h1>
                </div>
                <div class="row mt-3">
                    <div class="col">
                        <label class="control-label col"><b>First Name</b></label>
                        <form:input path="fName" value="${findUser.fName}" type="text" style="border-color: black"
                                    cssClass="form-control" readonly="false"/>
                    </div>
                    <form:input path="userRole" value="${findUser.userRole}" type="hidden"/>
                    <form:input path="batch" value="${findUser.batch.batchID}" type="hidden" readonly="true"/>
<%--                                            <form:input path="email" value="${findUser.email}" type="hidden"/>--%>
                    <form:input path="password" value="${findUser.password}" type="hidden"/>
                    <div class="col">
                        <label class="control-label col"><b>Last Name</b></label>
                        <form:input path="lName" value="${findUser.lName}" type="text" style="border-color: black"
                                    cssClass="form-control" placeholder="" readonly="false"/>
                    </div>
                </div>
                <div class="row">
                    <div class="col">
                        <label class="control-label col"><b>Email</b></label>
                        <form:input path="email" value="${findUser.email}" type="text" style="border-color: black"
                                    cssClass="form-control" placeholder="" readonly="true"/>
                    </div>
                    <div class="col">
                        <label class="control-label col"><b>Contact Number</b></label>
                        <b><form:input path="contactNumber" value="${findUser.contactNumber}" type="text"
                                       style="border-color: black"
                                       cssClass="form-control" placeholder="" readonly="false"/></b>
                    </div>
                </div>
<%--                <div class="row">--%>
<%--                    <div class="col">--%>
<%--                        <label class="control-label col"><b>Select Batch</b></label>--%>

<%--                        <form:select path="batch" type="text" style="border-color: black"--%>
<%--                                     cssClass="form-control" required="required">--%>
<%--                            <c:forEach var="batchList" items="${batchList}" varStatus="item">--%>
<%--                                <form:option value="${batchList.batchID}">--%>
<%--                                    ${batchList.batchID} ${batchList.batchName}--%>
<%--                                </form:option>--%>
<%--                            </c:forEach>--%>
<%--                        </form:select>--%>

<%--                    </div>--%>
<%--                </div>--%>

                <div class="row justify-content-center mt-4">
                    <button type="submit" class="btn btn-success">Update User Info</button>
                </div>
            </div>
        </div>
    </div>
</form:form>
</body>
</html>
