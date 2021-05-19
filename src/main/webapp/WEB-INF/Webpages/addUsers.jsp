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
        <div class="container contact">
            <div class="row" style="box-shadow: 15px 15px 30px black; border-radius: 20px;">
                <div class="col-md-3">
                    <div class="contact-info">
                        <h2>ADD NEW <b>STUDENTS</b></h2>

                    </div>
                </div>
                <div class="col-md-9">
                    <form:form action="/adminAddUsers" modelAttribute="AddUser" method="POST">
                        <div class="contact-form">
                            <div class="form-group">
                                <div class="row">
                                    <div class="col">
                                        <label class="control-label col">User Type:</label>
                                        <form:select path="userRole" name="userRole" id="userRole"
                                                     class="form-control" style="color: black; border-color: black" readonly="true">
                                            <option value="student">Student</option>
                                        </form:select>
                                    </div>
                                    <div class="col">
                                        <label class="control-label col">Email Address:</label>
                                        <form:input type="text" path="email" style="border-color: black"
                                                    cssClass="form-control" placeholder="johnDoe@yahoo.com"/>
                                    </div>
                                </div>
                            </div>

                            <div class="form-group">
                                <div class="row">
                                    <div class="col">
                                        <label class="control-label col">First Name:</label>
                                        <form:input path="fName" type="text" style="border-color: black"
                                                    class="form-control" placeholder="John"/>
                                    </div>
                                    <div class="col">
                                        <label class="control-label col">Last Name:</label>
                                        <form:input path="lName" type="text" style="border-color: black"
                                                    class="form-control" placeholder="Doe"/>
                                    </div>
                                </div>
                            </div>

                            <div class="form-group">
                                <div class="row">
                                    <div class="col">
                                        <label class="control-label col" id="batchLable">Batch ID:</label>
                                        <form:select path="batchId" type="text"  style="border-color: black" cssClass="form-control">
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
                                                    class="form-control" placeholder="+94715385574"/>
                                    </div>
                                </div>
                            </div>

                            <div class="form-group mt-4" style="margin-left: 30%; width: 800px;">
                                <div class="col-sm-offset-2 col-sm-10">
                                    <button type="submit" class="btn btn-warning">Create Account</button>
                                </div>
                            </div>
                        </div>
                    </form:form>
                </div>
            </div>
        </div>

    </div>
</div>

<%--<script>--%>
<%--    document.getElementById("userRole").addEventListener("change", function () {--%>
<%--        hideItems(this.form)--%>
<%--    });--%>

<%--    function getSelectedValue(selectList) {--%>
<%--        return selectList[selectList.selectedIndex].value;--%>
<%--    }--%>

<%--    function hideItems(formRef) {--%>
<%--        var test = getSelectedValue(formRef.userRole)--%>
<%--        if (test === 'lecturer') {--%>
<%--            document.getElementById("batchLable").style.display = 'none';--%>
<%--            document.getElementById("batchId").style.display = 'none';--%>
<%--        } else {--%>
<%--            document.getElementById("batchLable").style.display = 'block';--%>
<%--            document.getElementById("batchId").style.display = 'block';--%>
<%--        }--%>
<%--    }--%>
<%--</script>--%>

</body>
</html>
