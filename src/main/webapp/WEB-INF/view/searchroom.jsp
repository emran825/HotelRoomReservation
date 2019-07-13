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


    var roomtableall = ${roomtableList};
    var roomtype = ${roomtype};
    var categoryall = ${categoryall};
    var searchonetype = ${s};

    angular.module('abc', []).controller('ProductController',
            function ($scope) {
                $scope.rt = roomtableall;
                $scope.rtype = roomtype;
                $scope.rc = categoryall;
                $scope.sro = searchonetype;
                console.log($scope.rt);
                console.log($scope.sro);
                //                        console.log( $scope.rtList);
            });
        </script>




    </head>

    <body id="page-top" ng-app="abc" ng-controller="ProductController" >
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
                          <li class="nav-item active"><a class="nav-link" href="${pageContext.request.contextPath}">Home</a></li>> 
                            <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/gallery">Gallery</a></li> 

                            <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/accomodation">Accomodation</a></li>
                            <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/search">Book Room</a></li>
                            
                             <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/about">About us</a></li>
                 
                            <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/contact">Contact</a></li>
                           
                            <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/logout">Logout</a></li>
                            <!--							<li class="nav-item"><a class="btn theme_btn button_hover login" href="#">Customer Login</a></li>-->
                        </ul>
                    </div> 
                </nav>
            </div>
        </header>

       <div class="container card" style="margin-left: 150px;width:1035px;margin-top: 50px;padding-right:80px;">
                <div class="col-md-12" style="margin-left: 30px;">
                    <div class="container-fluid">
                        <ol class="breadcrumb" style="margin-top: 30px;">
                            <li class="breadcrumb-item active">Room Search</li>
                        </ol>
                        <div class="panel-body">
                            <div class="formcontainer ">


                            <!--                                <form action="processBasicyear" method="post">-->
                            <form action="roomsearch" >

                                <div class="form-row">
                                    <div class="col-md-6">
                                        <div class="form-group">

                                            <select class="form-control" ng-model="s" ng-options="x.roomtypeid as x.roomtype for x in rtype" required="true">
                                                <option value="">-- Room Type --</option>
                                            </select>
                                            <div class="form-label-group">
                                                <input type="hidden" value="{{s}}" name="roomtypeid"> <br>

                                            </div>
                                        </div>
                                    </div>
                                </div>



                                <div class="form-row">
                                    <div class="col-md-6">
                                        <div class="form-group">

                                            <select class="form-control" ng-model="c" ng-options="x.catid as x.catname for x in rc" required="true">
                                                <option value="">-- Room Category --</option>
                                            </select>
                                            <div class="form-label-group">
                                                <input type="hidden" value="{{c}}" name="catid"> <br>

                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="form-group">
                                        <div class="form-label-group">
                                            <input type="text" class="form-control"  name="startdate" placeholder="End Date" id="date" ></input>

                                            <label for="date">Check-In Date</label>
                                        </div>
                                    </div>
                                </div>
                                <!--                                                End Date-->

                                <div class="col-md-6">
                                    <div class="form-group">
                                        <div class="form-label-group">
                                            <input type="text" class="form-control"  name="enddate" placeholder="End Date" id="date1" ></input>
                                            <label for="date1">Check-Out Date</label>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <input type="submit" class="btn btn-primary btn-fw" value="Search">

                                </div>
                            </form>

                        </div>










                        <!--                        End-->
                        <!-- DataTables Example -->
                        <div class="card mb-3">
                            <c:if test="${check}">
                                <div class="card-header">
                                    <i class="fas fa-table"></i>
                                    Room List</div>
                                <div class="card-body">
                                    <div class="table-responsive">
                                        <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                            <thead>
                                                <tr>
                                                    <th>Room Image</th>
                                                    <th>Room ID</th>
                                                    <th>Room Number</th>
                                                    <th>Room Type</th>
                                                    <th>Room Category</th>
                                                    <th>Room Rent</th>
                                                    <th>Edit/Remove</th>

                                                </tr>
                                            </thead>
                                            <tfoot>
                                                <tr>
                                                    <th>Room Image</th>
                                                    <th>Room ID</th>
                                                    <th>Room Number</th>
                                                    <th>Room Type</th>
                                                    <th>Room Category</th>
                                                    <th>Room Rent</th>
                                                    <th>Edit/Remove</th>

                                                </tr>
                                            </tfoot>
                                            <tbody>
                                                <tr ng-repeat="Cat in sro">
                                                    <td><img class="img-responsive" style="width:180px ;height:200px;border-radius: 0;" src="resources/imgr/{{Cat.roomid}}.jpg" /></td>
                                                    <td>{{Cat.roomid}}</td>
                                                    <td>{{Cat.roomnumber}}</td>
                                                    <td>{{Cat.roomtype}}</td>
                                                    <td>{{Cat.catname}}</td>

                                                    <td>{{Cat.roomrent}}</td>
                                                    <td><a href="roomprofilelink?getsid={{Cat.roomid}}"><button id="editbuttons" type="submit" class="btn btn-info">room details</button></a></td>
                                                </tr>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                                <div class="card-footer small text-muted">Updated yesterday at 11:59 PM</div>
                            </c:if>
                        </div>

                    </div>
                    <!-- /.container-fluid -->

                    <!-- Sticky Footer -->
                   
                            <div class="copyright text-center my-auto">
                                <span>Copyright © Your Website 2018</span>
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
            <!--            <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/js/bootstrap-datepicker.min.js"></script>
                        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/css/bootstrap-datepicker3.css"/>-->





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
