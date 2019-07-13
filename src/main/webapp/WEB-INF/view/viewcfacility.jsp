<%-- 
    Document   : prodescription
    Created on : Dec 3, 2018, 4:08:28 PM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">
        <title>Product details-Organic Shopping</title>
        <!-- Bootstrap core CSS -->
        <link href="resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <!--<link rel="stylesheet" href="resources/css/bootstrap.min.css">-->
        <!-- Custom styles for this template -->
        <link href="resources/cssnew/shop-homepage.css" rel="stylesheet">
        <link rel="stylesheet" href="resources/css/animate.css">
        <link href="resources/img/logo.ico" rel="shortcut icon" />
        <script src="resources/js/angular.js"></script>
        <script>
            var productdetails = ${pro};
            angular.module('organocartpackage', []).controller(
                    'ProductDetailsController', function ($scope) {
                        $scope.pdo = productdetails;
                        console.log(productdetails.productquantity);
                    });
        </script>
    </head>
    <body>
        <!-- Navigation -->
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
            <div class="container">
                <a class="navbar-brand" href="#">Organic Shopping</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarResponsive">
                    <ul class="navbar-nav ml-auto">
                        <li class="nav-item active">
                            <a class="nav-link" href="#">Home
                                <span class="sr-only">(current)</span>
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">About</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">Services</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">Contact</a>
                        </li>
                        <c:if test="${sessionScope.UserLoggedIn ==null}">
                        <li class="nav-item">
                            <a class="nav-link" href="login">Login</a>
                        </li>
                        </c:if>
                        <c:if test="${sessionScope.UserLoggedIn !=null}">
                            <li class="nav-item">
                            <a class="nav-link" href="logout">Logout</a>
                        </li>
                            <li><a href="showcartpage" style="color: #9ccc65; font-size: 19px"> 
                                    <span class="glyphicon glyphicon-shopping-cart"></span> 
                                    <span class="badge">${sessionScope.grandquantity}</span>
                            </a></li>
                        </c:if>
                    </ul>
                </div>
            </div>
        </nav>
        <!-- Page Content -->
        <div class="container">

            <div class="row">

                <div class="col-lg-3">

                    <h1 class="my-4">Organic Shopping</h1>
                    <div class="list-group">
                        <a href="#" class="list-group-item">Category 1</a>
                        <a href="#" class="list-group-item">Category 2</a>
                        <a href="#" class="list-group-item">Category 3</a>
                    </div>

                </div>
                <!-- /.col-lg-3 -->
                <div class="col-lg-9">

                    <div class="card mt-4" ng-app="organocartpackage" ng-controller="ProductDetailsController">
                        <img class="card-img-top img-fluid" src="resources/pimage/{{pdo.productid}}.jpg" width="600" height="100" alt="">
                        <div class="card-body">
                            <h3 class="card-title">{{pdo.productname}}</h3>
                            <h4>Tk.{{pdo.productprice}}</h4>
                            {{pdo.productquantity>0 ? 'In Stock' : 'Out of Stock'}} ({{pdo.productquantity}})
                            <p class="card-text">{{pdo.productdescription}}</p>
                            <span class="text-warning">&#9733; &#9733; &#9733; &#9733; &#9734;</span>
                            4.0 stars
                        </div>
                        <div class="btn-group cart">
                            <c:if test="${sessionScope.UserLoggedIn !=null}">
                                <a href="addtocart?getProductId={{pdo.productid}}" 
                                   class="{{pdo.productquantity>0 ? 'btn btn-primary' : 'btn disabled'}}" id="cartbutton"> Add to cart  </a>
                                <a href="buyproductpage" class="btn btn-primary" id="viewproductsbutton"> View More Products </a>
                            </c:if>
                            <c:if test="${sessionScope.UserLoggedIn == null}">
                                <a href="perlogcheck?getProductId={{pdo.productid}}"
                                   class="btn btn-primary" id="loginproductsbutton"
                                   >Add to Cart</a>
                                <a href="buyproductpage" class="btn btn-primary" id="viewproductsbutton">  View More Products </a>
                            </c:if>
                        </div>
                    </div>
                    <!-- /.card -->
                </div>
                <!-- /.col-lg-9 -->

            </div>

        </div>
        <!-- /.container -->
        <!-- Footer -->
        <footer class="py-5 bg-dark">
            <div class="container">
                <p class="m-0 text-center text-white">Copyright &copy; Your Website 2017</p>
            </div>
            <!-- /.container -->
        </footer>

        <!-- Bootstrap core JavaScript -->
        <script src="resources/jquery/jquery.min.js"></script>
        <script src="resources/bootstrap/js/bootstrap.bundle.min.js"></script>





    </body>
</html>
