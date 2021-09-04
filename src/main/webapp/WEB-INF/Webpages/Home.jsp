<%--
  Created by IntelliJ IDEA.
  User: Praveen
  Date: 4/20/2021
  Time: 2:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="/css/Home.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <link href="webjars/bootstrap/4.5.0/css/bootstrap.min.css" rel="stylesheet"/>
    <script src="webjars/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
    <div class="row">
        <div class="col-sm-12">
            <div class="mt-4">
                <img src="${pageContext.request.contextPath}/images/My%20Post.jpg"
                     style="height: 250px; width: 900px;margin-left: 100px; background-size: cover; border-radius: 30px;">
            </div>

            <div class="row justify-content-center">
                <div style="font-family:sans-serif; background: #e0c67b; height: 50px; color: black; font-size: x-large;">${success}${error}</div>
            </div>

            <c:if test="${param.error != null}">
                <div class="justify-content-center" style="font-size: x-large; color: #fc430b; margin-left: 30%"> Invalid Credentials.Please Try again!</div>
            </c:if>

            <div class="d-flex justify-content-center mt-5">
                <div class="card card1" style="border-radius: 25px;">
                    <div class="row justify-content-center card-header">
                        <h1 style="color:#130505;">Login Here!</h1>
                    </div>
                    <div style="margin-left: 34%">
                        <img src="${pageContext.request.contextPath}/images/login.png" width="150px" height="120px">
                    </div>
                    <div class="card-body">
                        <form method="post" action="${pageContext.request.contextPath}/authenticate">
                            <label  class="form-label" style="color: #ffffff">Email address</label>

                            <div class="input-group form-group">
                                <input style="background-color: #f5eded" name="email" type="text" class="form-control" placeholder="johndoe@yahoo.com" required="required">
                            </div>

                            <label  class="form-label mt-2" style="color: #ffffff">Password</label>

                            <div class="input-group form-group">
                                <input style="background-color: #f5eded" name="password" type="password" class="form-control" placeholder="Password" required="required">
                            </div>

                            <div class="row justify-content-center">
                                <button type="submit" class="btn btn-warning" style="width: 150px;
                            border-color: black; border-style: double">Login
                                </button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>

</div>
</body>
</html>
