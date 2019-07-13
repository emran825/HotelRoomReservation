
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="icon" href="resources/image/favicon.png" type="image/png">
        <title>Royal Hotel</title>
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="resources/css/bootstrap.css">
        <link rel="stylesheet" href="resources/vendors/linericon/style.css">
        <link rel="stylesheet" href="resources/css/font-awesome.min.css">
        <link rel="stylesheet" href="resources/vendors/owl-carousel/owl.carousel.min.css">
        <link rel="stylesheet" href="resources/vendors/bootstrap-datepicker/bootstrap-datetimepicker.min.css">
        <link rel="stylesheet" href="resources/vendors/nice-select/css/nice-select.css">
        <link rel="stylesheet" href="resources/vendors/owl-carousel/owl.carousel.min.css">
        <link rel="stylesheet" href="resources/vendors/owl-carousel/owl.carousel.min.css">
        

        <!-- main css -->
        <link rel="stylesheet" href="resources/css/style.css">
        <link rel="stylesheet" href="resources/css/responsive.css">
          <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/core.js">

        <style>
            .login{
                top:20px;
            }
        </style>
        <script src="resources/js/angular.js"></script>
         <script src="resources/js/main.js" type="text/javascript"></script>

        <script>

            var categorylist = ${categoryList};

            angular.module('organocartpackage', []).controller('ProductController',
                    function ($scope) {

                        $scope.categoryname = categorylist;
                        console.log($scope.categoryname);
                    });
        </script>
    </head>
    <body  ng-app="organocartpackage" ng-controller="ProductController">
        <!--================Header Area =================-->
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
                            <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/about">About us</a></li>
                            <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/accomodation">Accomodation</a></li>
                            <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/login">Admin Login</a></li>
                            <li class="nav-item"><a class="nav-link" href="gallery.html">Gallery</a></li>
                            <li class="nav-item submenu dropdown">
                                <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Blog</a>
                                <ul class="dropdown-menu">
                                    <li class="nav-item"><a class="nav-link" href="blog.html">Blog</a></li>
                                    <li class="nav-item"><a class="nav-link" href="blog-single.html">Blog Details</a></li>
                                </ul>
                            </li> 
                            <li class="nav-item"><a class="nav-link" href="elements.html">Elemests</a></li>
                            <li class="nav-item"><a class="nav-link" href="contact.html">Contact</a></li>
                            <li class="nav-item"><a class="btn theme_btn button_hover login" href="#">Customer Login</a></li>
                        </ul>
                    </div> 
                </nav>
            </div>
        </header>
        <!--================Header Area =================-->

        <!--================Banner Area =================-->
 
        <!--================Banner Area =================-->

             <div class="formcontainer ">

                            <form:form commandName="newProductObject" action="addingbooking" >


                                <c:if test="${check}">
                                    <div class="form-group">
                                        <form:input class="form-control" Placeholder="id"
                                                    type="text" path="bookingid" required="true"></form:input>
                                        </div>
                                </c:if>

                                <c:if test="${!check}">
                                    <div class="form-group">
                                        <form:input class="form-control" Placeholder="Product Id"
                                                    type="text" path="bookingid" readonly="true" required="true"></form:input>
                                        </div>
                                </c:if>



<!--                                  =================================================-->
                                        
                                <div class="form-row">
                                    <div class="col-md-6">
                                        <div class="form-group">

                                            <select class="form-control" ng-model="s" ng-options="x.roomid as x.catid for x in roomallname" required="true">
                                                <option value="">-- Room Number --</option>
                                            </select>
                                            <div class="form-label-group">
                                                <form:hidden  class="form-control" value="{{s}}" path="roomid"></form:hidden>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                                
<!--                                  =========================================              -->

                                                    
                                   
                                 





                                    <div class="form-row">
                                        <div class="col-md-6">
                                            <div class="form-group">
                                            <form:select path="roomtypeid" cssClass="form-control" required="true" id="roomtypeid">
                                                <option value="">-- Room Type --</option>
                                                <form:option ng-repeat="c in rtList" value="{{c.roomtypeid}}">
                                                    {{c.roomtype}}
                                                </form:option>
                                            </form:select>
                                        </div>
                                    </div>
                                </div>




                                <div class="form-row">
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <form:select path="custid" cssClass="form-control" required="true" id="roomtypeid">
                                                <option value="">-- Customer Name --</option>
                                                <form:option ng-repeat="c in customerallname" value="{{c.custid}}">
                                                    {{c.fname}} {{c.lname}}
                                                </form:option>
                                            </form:select>
                                        </div>
                                    </div>
                                </div>




                                <!--                                    Start Date-->
                                <div class="col-md-6">
                                    <div class="form-group">
                                        <div class="form-label-group">
                                            <form:input type="text" class="form-control"  path="startdate" placeholder="Start Date" required="true" id="date" ></form:input>
                                                <label for="date">Start Date</label>
                                            </div>
                                        </div>
                                    </div>
                                    <!--                                                End Date-->

                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <div class="form-label-group">
                                            <form:input type="text" class="form-control"  path="enddate" placeholder="End Date" required="true" id="date1" ></form:input>
                                                <label for="date1">End Date</label>
                                            </div>
                                        </div>
                                    </div>




                                    <div class="form-group">
                                        <div class="form-label-group">
                                        <form:input class="form-control" Placeholder="First Name" type="text" path="numberofguest" required="true" id="Number of Guest"></form:input>
                                            <label for="productname">Number of Guest</label>
                                        </div>
                                    </div>



                                    <div class="form-row">
                                        <div class="col-md-6">
                                            <div class="form-group">
                                            <form:select path="emailid" cssClass="form-control" required="true" id="roomtypeid">
                                                <option value="">-- Email Address --</option>
                                                <form:option ng-repeat="c in userall" value="{{c.emailid}}">
                                                    {{c.emailid}} 
                                                </form:option>
                                            </form:select>
                                        </div>
                                    </div>
                                </div>


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
                                </div>






                            </form:form>

                        </div>










                        <!--                        End-->
                        <!-- DataTables Example -->
                        <div class="card mb-3">
                            <div class="card-header">
                                <i class="fas fa-table"></i>
                                Room Category List</div>
                            <div class="card-body">
                                <div class="table-responsive">
                                    <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                        <thead>
                                            <tr>
                                                <th>Booking ID</th>
                                                <th>Room ID</th>
                                                <th>Room Type ID</th>
                                                <th>Customer ID</th>
                                                <th>Start Date</th>
                                                <th>End Date</th>
                                                <th>Number of Guest</th>
                                                <th>Email Address</th>
                                                <th>Edit/Remove</th>

                                            </tr>
                                        </thead>
                                        <tfoot>
                                            <tr>
                                                <th>Booking ID</th>
                                                <th>Room ID</th>
                                                <th>Room Type ID</th>
                                                <th>Customer ID</th>
                                                <th>Start Date</th>
                                                <th>End Date</th>
                                                <th>Number of Guest</th>
                                                <th>Email Address</th>
                                                <th>Edit/Remove</th>

                                            </tr>
                                        </tfoot>
                                        <tbody>
                                            <tr ng-repeat="Cat in roombook">
                                                <td>{{Cat.bookingid}}</td>
                                                <td>{{Cat.roomid}}</td>
                                                <td>{{Cat.roomtypeid}}</td>
                                                <td>{{Cat.custid}}</td>
                                                <td>{{Cat.startdate}}</td>
                                                <td>{{Cat.enddate}}</td>
                                                <td>{{Cat.numberofguest}}</td>
                                                <td>{{Cat.emailid}}</td>
                                                <td><a href="editingbooking?getbookingidid={{Cat.bookingid}}"><button id="editbuttons" type="submit" class="btn">Edit</button></a> <a href="removingbooking/{{Cat.bookingid}}"><button id="removebuttons" type="button" class="btn btn-danger">Remove</button></a>
                                                </td>
                                            </tr>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                            <div class="card-footer small text-muted">Updated yesterday at 11:59 PM</div>
                        </div>

                   

        <!--================ start footer Area  =================-->	
      
        <!--================ End footer Area  =================-->


        <!-- Optional JavaScript -->
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="resources/js/jquery-3.2.1.min.js"></script>
        <script src="resources/js/popper.js"></script>
        <script src="resources/js/bootstrap.min.js"></script>
        <script src="resources/vendors/owl-carousel/owl.carousel.min.js"></script>
        <script src="resources/js/jquery.ajaxchimp.min.js"></script>
        <script src="resources/js/mail-script.js"></script>
        <script src="resources/vendors/bootstrap-datepicker/bootstrap-datetimepicker.min.js"></script>
        <script src="resources/vendors/nice-select/js/jquery.nice-select.js"></script>
        <script src="resources/js/mail-script.js"></script>
        <script src="resources/js/stellar.js"></script>
        <script src="resources/vendors/lightbox/simpleLightbox.min.js"></script>
        <script src="resources/js/custom.js"></script>
    </body>
</html>