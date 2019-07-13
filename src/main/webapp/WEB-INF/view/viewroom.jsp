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

        <script src="resources/js/all.js" type="text/javascript"></script>
        <!--Custom Javascript-->
        <script>
            <c:if test="${!acartempty}">
            var acartgsonTemp = ${acartgson};
            </c:if>
            var student = ${singleStd};
            var facility = ${facility};
            console.log(student);
            angular.module('organocartpackage', []).controller('ProductController',
                    function ($scope) {

            <c:if test="${!acartempty}">
                    $scope.acartAddedItems = acartgsonTemp;
                    $scope.atoTakaPoisaKothayRakhi = function(){
                    var total = 0;
                    for (var i = 0; i < $scope.acartAddedItems.length; i++){
                    var item = $scope.acartAddedItems[i];
                    total += item.facilitycost;
                    }
                    return total;
                    };
            </c:if>

                    $scope.sStd = student;
                    $scope.fc = facility;
                    console.log($scope.sStd);
                    console.log($scope.fc);
                    });
        </script>
        
        <style>
            th{
                background: #005cbf;
                color:white;
                text-align: center;
            }
            td{
                text-align: center;
            }
            tr:nth-child(even){
                background: #e7e7e7;
                
            }
        </style>
    </head>

    <body id="page-top" ng-app="organocartpackage" ng-controller="ProductController" >
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
                            <li class="nav-item active"><a class="nav-link" href="${pageContext.request.contextPath}/">Home</a></li> 
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


            <div class="row">
                <div class="col-md-6  grid-margin">
                    <div class="card" style="margin-left: 150px;width: 450px;">
                        <div class="card-body">
                            <p class="card-title" style="font-size: 25px;font-weight: bold; text-align: center;">Room Details of: <span class="text-primary">{{sStd.roomnumber}}</p>
                            <div class=col-md-12>
                                <!--                                                <center><img class="img-responsive" style="width:320px ;height:300px;border-radius: 3; boder:none;" src="resources/stimage/{{sStd.stid}}.jpg" /></center>-->
                                <center><img class="img-responsive" style="width:400px ;height:270px;border-radius: 3; boder:none;"src="resources/imgr/{{sStd.roomid}}.jpg" /></center>
                            </div>

                        </div>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="card" style="margin-left: 10px;width:560px;height: 360px;">
                        <div class="card-body">
                            <p class="card-title"><span style="font-weight:bold;">Room Details of : </span><span class="text-primary">{{sStd.roomnumber}}</span></p>
                            <div class="text-gray">
                                <label class="card-title">Room Number: </label> {{sStd.roomnumber}}
                                <br>
                                <label class="card-title">Room Type:</label> {{sStd.roomtype}} 
                                <br>
                                <label class="card-title">Room Category:</label> {{sStd.catname}} 
                                <br>
                                <label class="card-title">Room Rent:</label> {{sStd.roomrent}}TK 
                                <br>

                            </div>                                        
                        </div>
                    </div>
                </div>
            </div>
            
            <div class="container card" style="margin-left: 150px;width:1035px;margin-top: 50px;padding-right:80px;">
                <div class="col-md-12" style="margin-left: 30px;">
                    <div class="container-fluid">
                        <ol class="breadcrumb" style="margin-top: 30px;">
                            <li class="breadcrumb-item active">Booking Information</li>
                        </ol>
                        <div class="panel-body">
                            <div class="formcontainer ">
                                
                                <form:form commandName="newProductObject" action="booking">
                                    <!--                                    ==========cart===================-->
                                    <div class="card mb-7" style="margin-bottom: 30px; padding: 50px;">
                                        <div class="card-title" style="background: #e7e7e7;margin-left: 5px;">
                                            <h2 style="color:red; padding-left: 5px; ">Added Facilities</h2>
                                        </div>
                                        
                                        <c:if test="${acartempty}">
                                            <p class="card-description text-small text-center">No item added :( </p>
                                        </c:if>
                                        <c:if test="${!acartempty}"> 

                                            <table class="table table-bordered">
                                                <tbody>
                                                    
<!--                                                    **************DAY AND FACILITY COST***********************-->
<!--                                                <b> total day: ${sessionScope.difference}</b>
                                                <b>One Day facility cost: {{ atoTakaPoisaKothayRakhi()}} Tk.</b>
                                                <b>${sessionScope.difference} Day facility cost: {{ ${sessionScope.difference} * atoTakaPoisaKothayRakhi()}} Tk.</b>
                                                Facility+Room Total: {{${sessionScope.difference} * atoTakaPoisaKothayRakhi() + ${sessionScope.roomrent} * ${sessionScope.difference}}}-->
                                                <thead>
                                                    <tr>
                                                        <th>Facility Id</th>
                                                        <th>Facility Name</th>
                                                        <th>Facility Cost</th>
                                                        <th>Manage Category</th>
                                                    </tr>
                                                </thead>

                                                <tr ng-repeat="addedallowance in acartAddedItems">
                                                    <td>{{addedallowance.facilityid}}</td>
                                                <input:hidden value="{{addedallowance.facilityid}}" path="facilityid"/>
                                                
                                                <input:hidden value="{{addedallowance.facilitycost}}" path="facilitycost"/>
                                                
                                                <input:hidden value="${sessionScope.customerinfo.custid}" path="custid"/>
                                                <input:hidden value="1" path="bookingid"/>
                                                <td>{{addedallowance.facilityname}}</td>
                                                <td>{{addedallowance.facilitycost}}</td>
                                                <td>
                                                    <a href="deleteallowance4rmcart?getallowanceid={{addedallowance.facilityid}}" class="btn btn-sm btn-danger">
                                                        remove
                                                    </a>
                                                </td>
                                                </tr>

                                                </tbody>

                                            </table>

                                        </c:if> 
                                    </div>
                                    <div class="card mb-7">
                                        <div class="card-header">
                                            <i class="fas fa-table"></i>
                                            Facility List</div>
                                        <div class="card-body">
                                            <div class="table-responsive">
                                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                                    <thead>
                                                        <tr>
                                                            <th>Facility Id</th>
                                                            <th>Facility Name</th>
                                                            <th>Facility Cost</th>
                                                            <th>Manage Category</th>
                                                        </tr>
                                                    </thead>
                                                    <tbody>
                                                        <tr ng-repeat="Cat in fc">
                                                            <td>{{Cat.facilityid}}</td>
                                                            <td>{{Cat.facilityname}}</td>
                                                            <td>{{Cat.facilitycost}}</td>
                                                            <td>
                                                                <a href="addcart?getallowanceid={{Cat.facilityid}}" class="btn btn-outline-success">
                                                                    <i class="mdi mdi-plus-circle">Add</i>
                                                                </a>
                                                            </td>
                                                        </tr>
                                                    </tbody>
                                                </table>
                                            </div>
                                        </div>
                                    </div>
                                    <!--                                    ==========cart===================-->
                                    <label class="card-title">Room ID : </label>
                                    <form:input type="text" class="form-control" path="roomid" value="${sessionScope.roomid}" readonly="true"></form:input>
                                        <label class="card-title">Room Type : </label>
                                    <form:input type="text" class="form-control" path="roomtypeid" value="${sessionScope.roomtypeid}" readonly="true"></form:input>
                                        <label class="card-title">Customer ID Number : </label>
    <!--                                            <h1>  Custid: ${sessionScope.customerinfo.custid}</h1>-->
                                    <form:input type="text" class="form-control" path="custid" value=" ${sessionScope.customerinfo.custid}" readonly="true"></form:input>

                                        <label class="card-title">Check-In Date : </label>
                                    <form:input type="text" class="form-control" path="startdate" value="${sessionScope.startdate}" readonly="true"></form:input>
                                        <label class="card-title">Check-Out Date : </label>
                                    <form:input type="text" class="form-control" path="enddate" value="${sessionScope.enddate}" readonly="true"></form:input>
                                        <label class="card-title">Email Address : </label>
                                    <form:input type="text" class="form-control"  path="emailid" value="${sessionScope.UserId}" readonly="true"></form:input>

                                        <div></div>


                                        <div class="form-group" style="margin-top: 20px;">
                                        <form:button id="editbuttons" class="btn btn-success" name="Add" value="Booking Room">submit</form:button>

                                        </div>
                                        <!--                        </div>-->
                                    </div>
                                </div>
                            </div>
<!--                            <h1  color="red">Total day: ${sessionScope.difference}</h1>  
                        <br>
                        <h1>Total Room Rent:  {{${sessionScope.roomrent} *${sessionScope.difference}}}</h1>-->
                        <!--                                =============*************============-->

                        <!--=====================*************************===========================-->
                    </form:form>
                    <div class="card-footer small text-muted">Updated yesterday at 11:59 PM</div>
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


        <!--<script type="text/javascript" src="https://code.jquery.com/jquery-1.11.3.min.js"></script>-->

        <!-- Include Date Range Picker -->
        <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/js/bootstrap-datepicker.min.js"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/css/bootstrap-datepicker3.css"/>

<!--       DATE CALENDER**************************************


<script>
                            $(document).ready(function () {
                            var date_input = $('input[name="startdate"]'); //our date input has the name "date"
                            var container = $('.bootstrap-iso form').length > 0 ? $('.bootstrap-iso form').parent() : "body";
                            date_input.datepicker({
                            format: 'yyyy/mm/dd',
                                    container: container,
                                    todayHighlight: true,
                                    autoclose: true,
                            })
                            })
        </script>


        <script>
                    $(document).ready(function () {
            var date_input = $('input[name="enddate"]'); //our date input has the name "date"
            var container = $('.bootstrap-iso form').length > 0 ? $('.bootstrap-iso form').parent() : "body";
            date_input.datepicker({
            format: 'yyyy/mm/dd',
                    container: container,
                    todayHighlight: true,
                    autoclose: true,
            })
            })
        </script>-->

        <!--     Form code begins 
            <form method="post">
              <div class="form-group">  Date input 
                <label class="control-label" for="date">Date</label>
                <input class="form-control" id="date" name="date" placeholder="MM/DD/YYY" type="text"/>
              </div>
             </form>-->
    </div>
</body>
</html>
