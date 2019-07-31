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
        <link href="resources/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
        <link href="resources/datatables/dataTablesbootstrap4.css" rel="stylesheet">
        <link href="resources/cssnew/sb-admin.css" rel="stylesheet">
        <script src="resources/js/angular.js"></script>
        <script>
            angular.module('organocartpackage', []).controller('ProductController',
                    function ($scope) {
                    });
        </script>
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

          <div class="content-wrapper" style="width: 1200px;">
                    
                      <div class="container card" style="margin-left: 150px;width:1035px;margin-top: 50px;padding-right:80px;">

                <div class="col-md-12" style="margin-left: 30px;">

                    <div class="container-fluid">


                        <ol class="breadcrumb" style="margin-top: 30px;">

                            <li class="breadcrumb-item active">Payment Inforation</li>
                        </ol>
                        <!-- end panel heading -->
                        <div class="panel-body">
                            <!--                        Start-->
                            <div class="formcontainer ">

                            <form:form commandName="newProductObject" action="addpayment" >

                                <div class="form-group">
                                    <div class="form-label-group">
                                        <form:input class="form-control" Placeholder="Payment Type" type="text" path="bookingid" required="true" id="bookingid" read-only="true" style="display:none"></form:input>
                                            <label for="bookingid">Booking ID</label>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <div class="form-label-group">
                                        <form:input class="form-control" Placeholder="Payment Type" type="text" path="paymenttype" required="true" id="paymenttype"></form:input>
                                            <label for="paymenttype">Payment Type</label>
                                        </div>
                                    </div>



                                    <div class="form-group">
                                        <div class="form-label-group">
                                        <form:input class="form-control" Placeholder="Payment Type" type="text" readonly="true" path="bookingamount" value="{{ ${sessionScope.roomrent} * ${sessionScope.difference} }}" id="bookingamount"></form:input>
                                            <label for="bookingamount">Booking Amount</label>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <div class="form-label-group">
                                        <form:input class="form-control" Placeholder="Payment Type" value="{{ ${sessionScope.grandtotal}*${sessionScope.difference}+ ${sessionScope.roomrent} * ${sessionScope.difference} }}" type="text" path="totalamount" readonly="true" id="totalamount"></form:input>
                                            <label for="totalamount">Total Amount</label>
                                        </div>
                                    </div>

                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <div class="form-label-group">
                                            <form:input type="text" class="form-control"  path="paymentdate" placeholder="Payment Date" value="${sessionScope.da}" required="true" id="date" ></form:input>
                                                <label for="date">Payment Date</label>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                    <form:button id="editbuttons" type="submit" name="Add" class="btn btn-success">Payment</form:button>

                                        <a href="showproductpage"><button id="show" type="button" class="btn">Cancel</button></a> 
                                    </div>
                            </form:form> 
                        </div>
                    </div>
                    </div>

                  
                       
                            <div class="copyright text-center my-auto">
                                <span>Copyright © Your Website 2018</span>
                            </div>
                       
                   

                </div>

            </div>

            <a class="scroll-to-top rounded" href="#page-top">
                <i class="fas fa-angle-up"></i>
            </a>


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

            <script src="resources/jqueryUI/jquery-2.2.4.js" type="text/javascript"></script>
            <link href="resources/jqueryUI/jquery-ui.css" rel="stylesheet" type="text/css"/>
            <script src="resources/jqueryUI/jquery-ui.js" type="text/javascript"></script>

            <script>
                            $(document).ready(function () {
                                var minDate = new Date();
                                $("#date").datepicker({
                                    showAmi: 'drop',
                                    numberOfMonth: 1,
                                    minDate: minDate,
                                    dateFormat: 'yy/mm/dd',
                                    onClose: function (selectedDate) {
                                        $('#date1').datepicker("option", "minDate", selectedDate);
                                    }
                                });


                                $("#date1").datepicker({
                                    showAmi: 'drop',
                                    numberOfMonth: 1,
                                    minDate: minDate,
                                    dateFormat: 'yy/mm/dd',
            //            onClose:function(selectedDate){
            //              $('#date').datepicker("option","minDate",selectedDate);  
            //            }
                                });

                            })
            </script>

    </body>
</html>
