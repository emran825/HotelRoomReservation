<%-- 
    Document   : login
    Created on : Nov 20, 2018, 3:44:20 PM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Shop - Login</title>

        <!-- Bootstrap core CSS-->
        <link href="resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom fonts for this template-->
        <link href="resources/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">

        <!-- Custom styles for this template-->
        <link href="resources/cssnew/sb-admin.css" rel="stylesheet">
        <link href="resources/img/logo.ico" rel="shortcut icon" />

    </head>
    <body class="bg-dark">
        <%--<jsp:include page="header.jsp" />--%>
        <!--        <div class="container">
                    <div class="wrapper animated fadeInUp delay-05s">
                        <form action="perform_login" method="post" class="form-signin">
                            <h3 class="form-signin-heading" style="color: #9ccc65">Welcome Back !!</h3>
                            <br> <input type="text" class="form-control" id="useridcontrol"
                                        placeholder="Email Id" id="usename" name="usename" required="true"> <input
                                        type="password" class="form-control" id="passwordcontrol"
                                        placeholder="Password" id="userpassword" name="userpassword" required="true">
        
                            <button class="btn btn-lg" name="Submit" id="loginbutton"
                                    value="Login" type="Submit">Login</button>
        
                            <a href="signup" class="btn" id="loginbutton">New Users Sign Up Here </a>
        
                        </form>
                    </div>
                </div>-->



        <div class="container">
            <div class="card card-login mx-auto mt-5">
                <div class="card-header">Login</div>
                <div class="card-body">
                    <form action="perform_login" method="post">
                        <div class="form-group">
                            <div class="form-label-group">
                                <input type="email" id="inputEmail" class="form-control" placeholder="Email address" required="required" autofocus="autofocus" name="usename">
                                <label for="inputEmail">Email address</label>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="form-label-group">
                                <input type="password" id="inputPassword" class="form-control" placeholder="Password" required="required" name="userpassword">
                                <label for="inputPassword">Password</label>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="checkbox">
                                <label>
                                    <input type="checkbox" value="remember-me">
                                    Remember Password
                                </label>
                            </div>
                        </div>
                        <input type="submit" class="btn btn-primary btn-block" value="Login"></input>
                        <a class="btn btn-primary btn-block" href="<%=request.getContextPath() %>">Home</a>
                    </form>
                    <div class="text-center">
                        <a class="d-block small mt-3" href="signup">Register an Account</a>
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
