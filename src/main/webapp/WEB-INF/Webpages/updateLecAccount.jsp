<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Praveen
  Date: 4/30/2021
  Time: 9:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Account Details</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="/css/Home.css">
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark" style="padding: 10px;">
    <div class="container">
        <ul id="dropdown-animated" class="navbar-nav">
            <li class="nav-item" style="cursor: pointer">
                <a class="nav-link" href="${pageContext.request.contextPath}/viewLecturerHome">Home</a>
            </li>
        </ul>
        <ul class="navbar-nav ml-auto">
            <li class="nav-item" style="cursor: pointer;">
                <a class="nav-link nl" href="/logout">Sign Out</a>
            </li>
        </ul>
    </div>
</nav>

<div class="row alert-success justify-content-center">
    <div style="font-family:sans-serif; color: black; font-size: x-large;">${success}${error}</div>
</div>

 <div class="container">
     <div class="row justify-content-center">
         <form:form action="${pageContext.request.contextPath}/adminUpdateLecturer" modelAttribute="updateLec" method="post" cssClass="mt-5">
             <div class="row justify-content-center mt-5">
                 <div style="width: 500px; background-color: #d0ee94; border-radius: 20px; border-color: black; border-style:double;
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


                             <div class="col">
                                 <label class="control-label col"><b>Last Name</b></label>
                                 <form:input path="lName" value="${findUser.lName}" type="text" style="border-color: black"
                                             cssClass="form-control" placeholder="" readonly="false"/>
                             </div>
                         </div>
                         <div class="row mt-3">
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

                         <div class="row mt-3">
                             <div class="col">
                                 <label class="control-label col"><b>Enter new Password</b></label>
                                 <input  id="pass1" style="border-color: black" type="password"
                                         class="form-control" placeholder="Enter New Password"/>
                             </div>
                             <div class="col">
                                 <label class="control-label col"><b>Confirm Password</b></label>
                                 <form:input path="password" id="pass2" type="password" value="" style="border-color: black"
                                             cssClass="form-control" placeholder="Confirm Password" readonly="false"/>
                             </div>
                         </div>

                         <div class="row justify-content-center mt-4">
                             <button type="submit" class="btn btn-success mb-4">Update User Info</button>
                         </div>
                     </div>
                 </div>
             </div>
         </form:form>
     </div>
 </div>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>

<script type="text/javascript">
    var password = document.getElementById("pass1")
        , confirm_password = document.getElementById("pass2");

    function validatePassword(){
        if(password.value != confirm_password.value) {
            confirm_password.setCustomValidity("Passwords Do Not Match");
        } else {
            confirm_password.setCustomValidity('');
        }
    }

    password.onchange = validatePassword;
    confirm_password.onkeyup = validatePassword;
</script>
</body>
</html>
