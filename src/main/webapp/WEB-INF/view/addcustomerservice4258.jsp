<%-- 
    Document   : bootstarp
    Created on : May 25, 2019, 10:30:21 AM
    Author     : B2
--%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
    <head>
        
         <script src="resources/js/angular.js"></script>
<!--        <script>
            //facilitymodelobject is json data
            var cat = ${roomtypemodelobject};
            console.log(cat);
            angular.module('myapp', []).controller('CategoryController',
                    function ($scope) {
                        $scope.Catagory = cat;
                    });
        </script>-->
        
        
        
        
        
<script>
         var allcustomerserviceDaolist = ${customerserviceDaolist};
          var allfacilitylist = ${facilitylist};
          var allcustomerinfolist = ${customerinfolist};
           var roombooking = ${roombookinglist};
           
          
          
            angular.module('organocartpackage', []).controller('ProductController',
                    function ($scope) {
                        $scope.allcustser = allcustomerserviceDaolist;
                        $scope.allfaci = allfacilitylist;
                        $scope.allcinfo = allcustomerinfolist;
                         $scope.roombook = roombooking;
                        console.log($scope.roombook);
                    });
</script>
<!--        
          <script>
           
            var categorylist = ${categoryList};
            var roomtypename = ${roomtypeList};
            angular.module('organocartpackage', []).controller('ProductController',
                    function ($scope) {
                       
                        $scope.categoryname = categorylist;
                        $scope.roomtypeallname = roomtypename;
                        console.log($scope.categoryname);
                    });
        </script>-->
        
        
        
        
        
        
        
        
        
        

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">


       
           
            <title>Room Type Table</title>
            <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round|Open+Sans">
            <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
            <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
            <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
            <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
            <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
            <style type="text/css">
                body {
                    color: #404E67;
                    background: #F5F7FA;
                    font-family: 'Open Sans', sans-serif;
                }
                .table-wrapper {
                    width: 700px;
                    margin: 30px auto;
                    background: #fff;
                    padding: 20px;	
                    box-shadow: 0 1px 1px rgba(0,0,0,.05);
                }
                .table-title {
                    padding-bottom: 10px;
                    margin: 0 0 10px;
                }
                .table-title h2 {
                    margin: 6px 0 0;
                    font-size: 22px;
                }
                .table-title .add-new {
                    float: right;
                    height: 30px;
                    font-weight: bold;
                    font-size: 12px;
                    text-shadow: none;
                    min-width: 100px;
                    border-radius: 50px;
                    line-height: 13px;
                }
                .table-title .add-new i {
                    margin-right: 4px;
                }
                table.table {
                    table-layout: fixed;
                }
                table.table tr th, table.table tr td {
                    border-color: #e9e9e9;
                }
                table.table th i {
                    font-size: 13px;
                    margin: 0 5px;
                    cursor: pointer;
                }
                table.table th:last-child {
                    width: 100px;
                }
                table.table td a {
                    cursor: pointer;
                    display: inline-block;
                    margin: 0 5px;
                    min-width: 24px;
                }    
                table.table td a.add {
                    color: #27C46B;
                }
                table.table td a.edit {
                    color: #FFC107;
                }
                table.table td a.delete {
                    color: #E34724;
                }
                table.table td i {
                    font-size: 19px;
                }
                table.table td a.add i {
                    font-size: 24px;
                    margin-right: -1px;
                    position: relative;
                    top: 3px;
                }    
                table.table .form-control {
                    height: 32px;
                    line-height: 32px;
                    box-shadow: none;
                    border-radius: 2px;
                }
                table.table .form-control.error {
                    border-color: #f50000;
                }
                table.table td .add {
                    display: none;
                }
            </style>
           
        </head>
        <body>

            
 

          
           <!--                    Display All Facility in Database-->
            <div class="container">
                <div class="table-wrapper">
                    <div class="table-title">
                        <div class="row">
                            <div class="col-sm-8"><h2>Customer All Facility <b>Details</b></h2></div>
                            <div class="col-sm-4">
                                <button type="button" class="btn btn-info add-new"><i class="fa fa-plus"></i> Add New</button>
                            </div>
                        </div>
                    </div>


                    <div class="card mb-3" ng-app="organocartpackage" ng-controller="ProductController"> 
                        <table class="table table-bordered">
                            <thead>
                                <tr>
                                    <th>Payment ID</th>
                                    <th>Booking ID</th>
                                    <th>Payment Type</th>
                                    <th>Pay Amount</th>
                                    
                                    <th>Edit/Remove</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
<!--                                    paymentid, bookingid, paymenttype, payamount-->
<!--                                    bookingid, roomid, roomtypeid, custid, startdate, enddate, numberofguest, emailid-->
                                  
                                <tr ng-repeat="Cat in allcustser">
                                    <td>{{Cat.serid}}</td>
                                    <td>{{Cat.facilityid}}</td>
                                    <td>{{Cat.servicedate}}</td>
                                    <td>{{Cat.custid}}</td>
                                    <td>{{Cat.bookingid}}</td>
                                    <td>
                                        <a href="editcategorybutton?getcid={{Cat.serid}}"><button id="editbuttons" type="submit" class="btn">Edit</button></a> <a href="removecategory/{{Cat.serid}}"><button  id="removebuttons" type="button" class="btn btn-danger">Remove</button></a>

                                       
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>     
        </body>
    </html>    
