<%-- 
    Document   : addproduct
    Created on : Nov 25, 2018, 5:18:28 PM
    Author     : User
--%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Admin - Add Product</title>
        <link href="resources/img/logo.ico" rel="shortcut icon" />
        <!-- Bootstrap core CSS-->
        <link href="resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom fonts for this template-->
        <link href="resources/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">

        <!-- Page level plugin CSS-->
        <link href="resources/datatables/dataTablesbootstrap4.css" rel="stylesheet">

        <!-- Custom styles for this template-->
        <link href="resources/cssnew/sb-admin.css" rel="stylesheet">
        <script src="resources/js/angular.js"></script>



        <script>

            var categorylist = ${categoryList};
            var roomtypename = ${roomtypeList};
            angular.module('organocartpackage', []).controller('ProductController',
                    function ($scope) {

                        $scope.categoryname = categorylist;
                        $scope.roomtypeallname = roomtypename;
                        console.log($scope.categoryname);
                    });
        </script>
        <style>
            .hsonuc {
    position:absolute;
    top:20px;
    right:50%; /* Positions 50% from right (right edge will be at center) */
    margin-right:200px; /* Positions 200px to the left of center */
}

li{
    text-decoration: none;
    list-style: none;
}
a{
    text-decoration: none;
}
        </style>
    </head>

    <body id="page-top" ng-app="organocartpackage" ng-controller="ProductController">
        <header class="header_area">
            <div class="container">
                <nav class="navbar navbar-expand-lg navbar-light">
                    <!-- Brand and toggle get grouped for better mobile display -->
                    <a class="navbar-brand logo_h" href="${pageContext.request.contextPath}"><img src="resources/image/Logo.png" alt=""></a>
                    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <!-- Collect the nav links, forms, and other content for toggling -->
                    <div class="collapse navbar-collapse offset" id="navbarSupportedContent">
                        <ul class="nav navbar-nav menu_nav ml-auto">
                       <li class="nav-item active"><a class="nav-link" href="${pageContext.request.contextPath}">Home</a></li> 
                            <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/gallery">Gallery</a></li> 
<!--                                       <li class="nav-item"><a class="nav-link" href="gallery.html">Gallery</a></li>-->
                            <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/accomodation">Accomodation</a></li>
                            <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/search">Book Room</a></li>
                            
                             <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/about">About us</a></li>
                 
                            <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/contact">Contact</a></li>
                             <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/logout">Logout</a></li>
                        </ul>
                    </div> 
                </nav>
            </div>
        </header>

         <div id="wrapper">
                            
        <div id="content-wrapper">

            <div class="row">
              
                <div class="col-md-3">
                    <div class="container-fluid">
                        <ul class="">
                            <li><a href="${pageContext.request.contextPath}/search">Search Rooms</a></li>
                        </ul>
                    </div>
                </div>
              
                <div class="col-md-7  grid-margin">

                    <div class="container-fluid">

                       
                        <ol class="breadcrumb">
                           
                            <li class="breadcrumb-item active">Customer Information</li>
                        </ol>
                        <!-- end panel heading -->
                        <div class="panel-body">
                            <!--                        Start-->
                            <div class="formcontainer ">
<!--                                custid, username, emailid, nationality, phone, nid-->

                                <form:form commandName="newProductObject" action="addingcustomer" >
                                    
                                    
                                    <label class="card-title">Customer Name : </label> ${sessionScope.UserLoggedIn}<br>
                                    
                                    <label class="card-title">Email Address : </label> ${sessionScope.UserId}<br>
                                    
                                    <label class="card-title">Phone Number : </label> ${sessionScope.UserphoneIn}<br>
                                    
                                    <label class="card-title"> Nationality : </label>  ${sessionScope.customerinfo.nationality}<br>
                                    
                                    <label class="card-title"> NID No. : </label> ${sessionScope.customerinfo.nid}<br>
                                    
<!--                                    <label class="card-title">Customer Name : </label>
                                    <form:input type="text" class="form-control" path="username" value="${sessionScope.UserLoggedIn}"></form:input>
                                        <label class="card-title">Email Address : </label>
                                    <form:input type="text" class="form-control" aria-describedby="basic-addon1"  path="emailid" value="${sessionScope.UserId}"></form:input>
                                        <label class="card-title">Phone Number : </label>
                                    <form:input type="text" class="form-control" path="phone" value="${sessionScope.UserphoneIn}"></form:input>


                                        <label for="productname">Customer Nationality</label>
                                        
                                        
                                   ${sessionScope.customerinfo.custid}
                                    
                                    <form:input type="text" class="form-control" path="nationality" value=" ${sessionScope.customerinfo.nationality}"></form:input>

                                        <label for="productname"> National ID</label>
                                    
                                     <form:input type="text" class="form-control" path="nid" value="${sessionScope.customerinfo.nid}"></form:input>

                                        <div class="form-group">

                                        <c:if test="${check}">
                                            <form:button id="editbuttons" type="submit" name="Add" class="btn btn-success">Add Details</form:button>
                                            <form:button id="removebuttons" type="reset" class="btn btn-danger">Reset Details</form:button>
                                        </c:if>
                                        <c:if test="${!check}">
                                            <form:button id="editbuttons" type="submit" name="Edit" class="btn btn-success">Edit Details</form:button>
                                            <form:button id="removebuttons" type="reset" class="btn btn-danger">Reset Details</form:button>
                                        </c:if>
                                        <a href="showproductpage"><button id="show" type="button" class="btn">Cancel</button></a> 
                                    </div>-->
                                </form:form>

                            </div>
                            

                        </div>
                        <!-- /.container-fluid -->

                        <!-- Sticky Footer -->
<!--                        <footer class="sticky-footer" style="margin-top: 70px;">
                            <div class="container my-auto">
                                <div class="copyright text-center my-auto">
                                    <span>Copyright © Your Website 2018</span>
                                </div>
                            </div>
                        </footer>-->

                    </div>

            </div>
                
            
            </div>
                
                
            </div>

            <!-- /.content-wrapper -->

        </div>
        <!-- /#wrapper -->

        <!-- Scroll to Top Button-->
        <a class="scroll-to-top rounded" href="#page-top">
            <i class="fas fa-angle-up"></i>
        </a>

        <!-- Logout Modal-->
        <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
                        <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">×</span>
                        </button>
                    </div>
                    <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
                    <div class="modal-footer">
                        <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                        <a class="btn btn-primary" href="logout">Logout</a>
                    </div>
                </div>
            </div>
        </div>

        <!-- Bootstrap core JavaScript-->
        <script src="resources/jquery/jquery.min.js"></script>
        <script src="resources/bootstrap/js/bootstrap.bundle.min.js"></script>

        <!-- Core plugin JavaScript-->
        <script src="resources/jquery-easing/jquery.easing.min.js"></script>

        <!-- Page level plugin JavaScript-->
        <script src="resources/chart/Chartmin.js"></script>
        <script src="resources/datatables/jquerydataTables.js"></script>
        <script src="resources/datatables/dataTablesbootstrap4.js"></script>

        <!-- Custom scripts for all pages-->
        <script src="resources/jsnew/sb-adminmin.js"></script>

        <!-- Demo scripts for this page-->
        <script src="resources/jsnew/demo/datatablesdemo.js"></script>
        <script src="resources/jsnew/demo/chartareademo.js"></script>


        <!--<script type="text/javascript" src="https://code.jquery.com/jquery-1.11.3.min.js"></script>-->

        <!-- Include Date Range Picker -->
        <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/js/bootstrap-datepicker.min.js"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/css/bootstrap-datepicker3.css"/>

        <script>
                                                        $(document).ready(function () {
                                                            var date_input = $('input[name="purchasedate"]'); //our date input has the name "date"
                                                            var container = $('.bootstrap-iso form').length > 0 ? $('.bootstrap-iso form').parent() : "body";
                                                            date_input.datepicker({
                                                                format: 'yyyy/mm/dd',
                                                                container: container,
                                                                todayHighlight: true,
                                                                autoclose: true,
                                                            })
                                                        })
        </script>

        <!--     Form code begins 
            <form method="post">
              <div class="form-group">  Date input 
                <label class="control-label" for="date">Date</label>
                <input class="form-control" id="date" name="date" placeholder="MM/DD/YYY" type="text"/>
              </div>
             </form>-->
    </body>
</html>
