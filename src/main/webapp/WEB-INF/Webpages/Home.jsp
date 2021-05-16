<%--
  Created by IntelliJ IDEA.
  User: Praveen
  Date: 4/20/2021
  Time: 2:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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

<nav class="navbar navbar-expand-lg navbar-dark bg-dark" style="padding: 10px;">
    <div class="container">

        <ul id="dropdown-animated" class="navbar-nav">
            <li class="nav-item" style="cursor: pointer">
                <a class="nav-link active" href="${pageContext.request.contextPath}/home">Home</a>
            </li>
            <li class="nav-item" style="cursor: pointer">
                <a class="nav-link" href="${pageContext.request.contextPath}/viewTimeTable">Student Home</a>
            </li>
        </ul>


        <ul class="navbar-nav ml-auto">
            <li class="nav-item" style="cursor: pointer;">
                <a class="nav-link nl" href="${pageContext.request.contextPath}/viewAdminHome">Admin Home</a>
            </li>
        </ul>
        <ul class="navbar-nav ml-auto">
            <li class="nav-item" style="cursor: pointer;">
                <a class="nav-link nl" href="${pageContext.request.contextPath}/viewLecturerHome">Lecturer Home</a>
            </li>
        </ul>
    </div>
</nav>


<div class="container">
     <div class="mt-4">
         <img src="${pageContext.request.contextPath}/images/My%20Post.jpg"
              style="height: 250px; width: 900px;margin-left: 100px; background-size: cover;">
     </div>

     <div style="margin-top: 100px; border-color: #0a0a0a; border-radius: 10px; border-style: double; background-color: #887cee;">
         <div class="row justify-content-center contact-image">
             <img src="https://mpng.subpng.com/20180404/ire/kisspng-computer-icons-physician-login-medicine-user-avatar-5ac45a4d44fe99.2456489015228176132826.jpg" style="height: 150px; width: 150px;">
         </div>
         <div class="row justify-content-center" >
             <h1 style="font-size: xx-large">Login Here!</h1>
         </div>
         <div class="row justify-content-center">
             <form method="post" action="${pageContext.request.contextPath}/authenticate">
                 <div class="row mb-3">
                     <label  class="form-label"><b>Email address</b></label>
                     <input name="email" class="form-control" style="background-color: #e3e1e1; color: black; border-color: black" placeholder="johndoe@yahoo.com"/>
                     <div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div>
                 </div>
                 <div class="row mb-3">
                     <label for="exampleInputPassword1" class="form-label"><b>Password</b></label>
                     <input name="password" type="password" class="form-control" id="exampleInputPassword1" style="background-color:#e3e1e1;border-color: black;
                      color: black;" placeholder="Your Password"/>
                 </div>
                 <button type="submit" class="btn btn-primary" style="margin-left: 43%; width: 150px;
                  border-color: black; border-style: double">Login</button>
             </form>

<%--             <form:form action="${pageContext.request.contextPath}/authenticateUser" method="post">--%>
<%--                 <div class="row mb-3">--%>
<%--                     <label  class="form-label"><b>Email address</b></label>--%>
<%--                     <form:input path="" type="email" class="form-control" style="background-color: #e3e1e1; color: black; border-color: black" placeholder="johndoe@yahoo.com"/>--%>
<%--                     <div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div>--%>
<%--                 </div>--%>
<%--                 <div class="row mb-3">--%>
<%--                     <label for="exampleInputPassword1" class="form-label"><b>Password</b></label>--%>
<%--                     <form:input path="password" type="password" class="form-control" id="exampleInputPassword1" style="background-color:#e3e1e1;border-color: black;--%>
<%--                      color: black;" placeholder="Your Password"/>--%>
<%--                 </div>--%>
<%--                 <button type="submit" class="btn btn-primary" style="margin-left: 43%; width: 150px;--%>
<%--                  border-color: black; border-style: double">Login</button>--%>
<%--             </form:form>--%>
         </div>
     </div>
</div>
</body>
<div class="footer">
    <div class="row px-3"> <small class="ml-4 ml-sm-5 mb-2">Copyright &copy; 2021. All rights reserved.</small>
        <div class="social-contact ml-4 ml-sm-auto"> <span class="fa fa-facebook mr-4 text-sm"></span> <span class="fa fa-google-plus mr-4 text-sm"></span> <span class="fa fa-linkedin mr-4 text-sm"></span> <span class="fa fa-twitter mr-4 mr-sm-5 text-sm"></span> </div>
    </div>
</div>
</html>







                        <%--<div class="container">--%>
<%--     <div class="mt-4">--%>
<%--         <img src="${pageContext.request.contextPath}/images/My%20Post.jpg"--%>
<%--              style="height: 250px; width: 900px;margin-left: 100px; background-size: cover;">--%>
<%--     </div>--%>

<%--     <div style="margin-top: 100px; border-color: #0a0a0a; border-radius: 10px; border-style: double; background-color: #cbdda5;">--%>
<%--         <div class="row justify-content-center" >--%>
<%--             <h1 style="font-size: xx-large">Login Here!</h1>--%>
<%--         </div>--%>
<%--         <div class="row justify-content-center">--%>
<%--             <form method="post" action="${pageContext.request.contextPath}/authenticate">--%>
<%--                 <div class="row mb-3">--%>
<%--                     <label  class="form-label"><b>Email address</b></label>--%>
<%--                     <input name="email" class="form-control" style="background-color: #e3e1e1; color: black; border-color: black" placeholder="johndoe@yahoo.com"/>--%>
<%--                     <div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div>--%>
<%--                 </div>--%>
<%--                 <div class="row mb-3">--%>
<%--                     <label for="exampleInputPassword1" class="form-label"><b>Password</b></label>--%>
<%--                     <input name="password" type="password" class="form-control" id="exampleInputPassword1" style="background-color:#e3e1e1;border-color: black;--%>
<%--                      color: black;" placeholder="Your Password"/>--%>
<%--                 </div>--%>
<%--                 <button type="submit" class="btn btn-primary" style="margin-left: 43%; width: 150px;--%>
<%--                  border-color: black; border-style: double">Login</button>--%>
<%--             </form>--%>

<%--&lt;%&ndash;             <form:form action="${pageContext.request.contextPath}/authenticateUser" method="post">&ndash;%&gt;--%>
<%--&lt;%&ndash;                 <div class="row mb-3">&ndash;%&gt;--%>
<%--&lt;%&ndash;                     <label  class="form-label"><b>Email address</b></label>&ndash;%&gt;--%>
<%--&lt;%&ndash;                     <form:input path="" type="email" class="form-control" style="background-color: #e3e1e1; color: black; border-color: black" placeholder="johndoe@yahoo.com"/>&ndash;%&gt;--%>
<%--&lt;%&ndash;                     <div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div>&ndash;%&gt;--%>
<%--&lt;%&ndash;                 </div>&ndash;%&gt;--%>
<%--&lt;%&ndash;                 <div class="row mb-3">&ndash;%&gt;--%>
<%--&lt;%&ndash;                     <label for="exampleInputPassword1" class="form-label"><b>Password</b></label>&ndash;%&gt;--%>
<%--&lt;%&ndash;                     <form:input path="password" type="password" class="form-control" id="exampleInputPassword1" style="background-color:#e3e1e1;border-color: black;&ndash;%&gt;--%>
<%--&lt;%&ndash;                      color: black;" placeholder="Your Password"/>&ndash;%&gt;--%>
<%--&lt;%&ndash;                 </div>&ndash;%&gt;--%>
<%--&lt;%&ndash;                 <button type="submit" class="btn btn-primary" style="margin-left: 43%; width: 150px;&ndash;%&gt;--%>
<%--&lt;%&ndash;                  border-color: black; border-style: double">Login</button>&ndash;%&gt;--%>
<%--&lt;%&ndash;             </form:form>&ndash;%&gt;--%>
<%--         </div>--%>
<%--     </div>--%>
<%--</div>--%>