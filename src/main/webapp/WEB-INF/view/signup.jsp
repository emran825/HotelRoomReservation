<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Shop - Sign Up</title>

        <!-- Bootstrap core CSS-->
        <link href="resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom fonts for this template-->
        <link href="resources/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">

        <!-- Custom styles for this template-->
        <link href="resources/cssnew/sb-admin.css" rel="stylesheet">
        <link href="resources/img/logo.ico" rel="shortcut icon" />

    </head>
    <body class="bg-dark">
<!--        custid, username, emailid, nationality, phone, nid-->

<!--custid, cusname, emailid, nationality, phoneno, nid-->

        <div class="container">
            <div class="card card-register mx-auto mt-5">
                <div class="card-header">Register an Account</div>
                <div class="card-body">
                    <form:form modelAttribute="urm" action="reguser">

                        <div class="form-group">
                            <div class="form-label-group">
                                <form:input type="text" class="form-control" placeholder="Username" id="name" autofocus="autofocus" aria-describedby="basic-addon1" path="username" required="true"></form:input>
                                    <label for="name">User Name</label>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="form-label-group">
                                <form:input type="password" class="form-control" id="pass"
                                            placeholder="New Password" aria-describedby="basic-addon1" path="password" required="true"></form:input>
                                    <label for="pass">Password</label>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="form-label-group">
                                <form:input type="text" class="form-control" id="phone"
                                            placeholder="Phone Number" aria-describedby="basic-addon1" path="phone" value="+88" required="true"></form:input>
                                    <label for="phone">Phone</label>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="form-label-group">
                                <form:input type="email" class="form-control" placeholder="Email" id="inputEmail" aria-describedby="basic-addon1" path="emailid" required="true"></form:input>
                                    <label for="inputEmail">Email address</label>
                                </div>
                            </div>
                                    
                              <div class="form-group">
                                <div class="form-label-group">
                                <form:input type="text" class="form-control" placeholder="Nationality" id="nationality" aria-describedby="basic-addon1" path="nationality" required="true"></form:input>
                                    <label for="nationality">Nationality</label>
                                </div>
                            </div>
                                    
                              <div class="form-group">
                                <div class="form-label-group">
                                <form:input type="text" class="form-control" placeholder="National ID" id="nid" aria-describedby="basic-addon1" path="nid" required="true"></form:input>
                                    <label for="nid">National ID</label>
                                </div>
                            </div>
                            <button id="signupbutton" class="btn btn-primary btn-block" type="submit">Sign Up</button>
                            <button id="cancelbutton" class="btn btn-primary btn-block" type="Reset">Cancel</button>

                    </form:form>
                    <div class="text-center">
                        <a class="d-block small mt-3" href="login">Login Page</a>
                        <a class="d-block small" href="forgot-password.html">Forgot Password?</a>
                    </div>
                </div>
            </div>
        </div>
        <!-- Bootstrap core JavaScript-->
        <script src="resources/jquery/jquery.min.js"></script>
        <script src="resources/bootstrap/js/bootstrap.bundle.min.js"></script>

        <!-- Core plugin JavaScript-->
        <script src="resources/jquery-easing/jquery.easing.min.js"></script>
    </body>
</html>
