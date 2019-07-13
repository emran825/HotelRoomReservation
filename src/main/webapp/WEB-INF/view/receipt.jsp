<%-- 
    Document   : receipt
    Created on : Jul 11, 2019, 8:11:48 PM
    Author     : SARK
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

        <style>
            .text-danger strong {
                color: #9f181c;
            }
            .receipt-main {
                background: #ffffff none repeat scroll 0 0;
                border-bottom: 12px solid #333333;
                border-top: 12px solid #9f181c;
                margin-top: 50px;
                margin-bottom: 50px;
                padding: 40px 30px !important;
                position: relative;
                box-shadow: 0 1px 21px #acacac;
                color: #333333;
                font-family: open sans;
            }
            .receipt-main p {
                color: #333333;
                font-family: open sans;
                line-height: 1.42857;
            }
            .receipt-footer h1 {
                font-size: 15px;
                font-weight: 400 !important;
                margin: 0 !important;
            }
            .receipt-main::after {
                background: #414143 none repeat scroll 0 0;
                content: "";
                height: 5px;
                left: 0;
                position: absolute;
                right: 0;
                top: -13px;
            }
            .receipt-main thead {
                background: #414143 none repeat scroll 0 0;
            }
            .receipt-main thead th {
                color:#fff;
            }
            .receipt-right h5 {
                font-size: 16px;
                font-weight: bold;
                margin: 0 0 7px 0;
            }
            .receipt-right p {
                font-size: 12px;
                margin: 0px;
            }
            .receipt-right p i {
                text-align: center;
                width: 18px;
            }
            .receipt-main td {
                padding: 9px 20px !important;
            }
            .receipt-main th {
                padding: 13px 20px !important;
            }
            .receipt-main td {
                font-size: 13px;
                font-weight: initial !important;
            }
            .receipt-main td p:last-child {
                margin: 0;
                padding: 0;
            }	
            .receipt-main td h2 {
                font-size: 20px;
                font-weight: 900;
                margin: 0;
                text-transform: uppercase;
            }
            .receipt-header-mid .receipt-left h1 {
                font-weight: 100;
                margin: 34px 0 0;
                text-align: right;
                text-transform: uppercase;
            }
            .receipt-header-mid {
                margin: 24px 0;
                overflow: hidden;
            }

            #container {
                background-color: #dcdcdc;
            }



        </style>
        <script src="resources/js/angular.js"></script>
        <script>
            angular.module('organocartpackage', []).controller('ProductController',
                    function ($scope) {
                    });
        </script>


        <link href="resources/receiptp/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <script src="resources/receiptp/bootstrap.min.js" type="text/javascript"></script>

        <script src="resources/receiptp/jquery-1.11.1.min.js" type="text/javascript"></script>
    </head>
    <body  onload="GetDateTime()"ng-app="organocartpackage" ng-controller="ProductController">

        <div class="container">
            <div class="row">

                <div class="receipt-main col-xs-10 col-sm-10 col-md-6 col-xs-offset-1 col-sm-offset-1 col-md-offset-2">
                    <div class="row">
                        <div class="receipt-header">
                            <div class="col-xs-6 col-sm-6 col-md-6">
                                <!--						<div class="receipt-left">
                                                                                        <img class="img-responsive" alt="iamgurdeeposahan" src="http://bootsnipp.com/img/avatars/bcf1c0d13e5500875fdd5a7e8ad9752ee16e7462.jpg" style="width: 71px; border-radius: 43px;">
                                                                                </div>-->
                            </div>
                            <div class="col-xs-6 col-sm-6 col-md-6 text-right">
                                <div class="receipt-right">
                                    <h5>ROYAL HOTEL.</h5>
                                    <p>+91 12345-6789 <i class="fa fa-phone"></i></p>
                                    <p>info@gmail.com <i class="fa fa-envelope-o"></i></p>
                                    <p>Bangladesh <i class="fa fa-location-arrow"></i></p>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="receipt-header receipt-header-mid">
                            <div class="col-xs-8 col-sm-8 col-md-8 text-left">
                                <div class="receipt-right">
                                    <h5>${sessionScope.UserLoggedIn} <small>  |   Booking ID : ${sessionScope.bookid}</small></h5>
                                    <p><b>Mobile :</b>${sessionScope.UserphoneIn}</p>
                                    <p><b>Email :</b> ${sessionScope.UserId}</p>
                                    <p><b>Address :</b>  ${sessionScope.customerinfo.nationality}</p>
                                </div>
                            </div>
                            <div class="col-xs-4 col-sm-4 col-md-4">
                                <div class="receipt-left">
                                    <h1>Receipt</h1>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div>
                        <table class="table table-bordered">
                            <thead>
                                <tr>
                                    <th colspan="2">
                                        Details
                                    </th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td class="col-md-9"> Room ID</td>
                                    <td class="col-md-3"><i class="fa fa-inr"></i> ${sessionScope.roomid}</td>
                                </tr>
                                <tr>
                                    <td class="col-md-9"> Room Type</td>
                                    <td class="col-md-3"><i class="fa fa-inr"></i> ${sessionScope.roomt}</td>
                                </tr>
                                <tr>
                                    <td class="col-md-9"> Room Category</td>
                                    <td class="col-md-3"><i class="fa fa-inr"></i> ${sessionScope.roomcat}</td>
                                </tr>
                                <tr>
                                    <td class="col-md-9"> Room Rent</td>
                                    <td class="col-md-3"><i class="fa fa-inr"></i> ${sessionScope.roomrent}</td>
                                </tr>
                                <tr>
                                    <td class="col-md-9"> Check-In Date</td>
                                    <td class="col-md-3"><i class="fa fa-inr"></i>  ${sessionScope.startdate}</td>
                                </tr>
                                <tr>
                                    <td class="col-md-9"> Check-Out Date</td>
                                    <td class="col-md-3"><i class="fa fa-inr"></i> ${sessionScope.enddate}</td>
                                </tr>
                                <tr>

                                    <td class="col-md-9"> Total Days</td>
                                    <td class="col-md-3"><i class="fa fa-inr"></i>${sessionScope.difference}</td>
                                </tr>

                            </tbody>
                        </table>
                    </div>

                    <div>
                        <table class="table table-bordered">
                            <thead>
                                <tr>
                                    <th>Description</th>
                                    <th>Amount</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td class="col-md-9">${sessionScope.difference} day room rent</td>
                                    <td class="col-md-3"><i class="fa fa-inr"></i> {{${sessionScope.roomrent} *${sessionScope.difference}}}/-</td>
                                </tr>
                                <tr>
                                    <td class="col-md-9">${sessionScope.difference} day facility cost</td>
                                    <td class="col-md-3"><i class="fa fa-inr"></i>{{ ${sessionScope.grandtotal} *${sessionScope.difference}}}/-</td>
                                </tr>


                                <tr>

                                    <td class="text-right"><h2><strong>Total: </strong></h2></td>
                                    <td class="text-left text-danger"><h2><strong><i class="fa fa-inr"></i> {{ ${sessionScope.grandtotal} *${sessionScope.difference} + ${sessionScope.roomrent} * ${sessionScope.difference}}}/-</strong></h2></td>
                                </tr>
                                <tr>
                                    <td class="text-right">
                                        <p>
                                            <strong>Payment Date: </strong>
                                        </p>
                                    </td>
                                    <td>
                                        <p>
                                            <strong><i class="fa fa-inr"></i> ${sessionScope.d}</strong>
                                        </p>
                                    </td>
                                </tr>
                                
                                   <tr>
                                    <td class="text-right">
                                        <p>
                                            <strong>Payment Type: </strong>
                                        </p>
                                    </td>
                                    <td>
                                        <p>
                                            <strong><i class="fa fa-inr"></i> ${sessionScope.paytype}</strong>
                                        </p>
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                    </div>

                    <div class="row">
                        <div class="receipt-header receipt-header-mid receipt-footer">
                            <div class="col-xs-8 col-sm-8 col-md-8 text-left">
                                <div class="receipt-right">
                                    <p><b>Date :</b> <p id="demo"></p></p>

                                    <h5 style="color: rgb(140, 140, 140);">Thank you for your business!</h5>
                                </div>
                            </div>
                            <div class="col-xs-4 col-sm-4 col-md-4">
                                <div class="receipt-left">
                                    <h1>Signature</h1>
                                </div>
                            </div>
                        </div>
                    </div>

                </div>  
                <div class="col-md-3" style="margin-top: 50px;">
                    <ul class="list-unstyled">
                        <li><a class="btn btn-primary" href="">Print Receipt</a></li>
                        <li><br></li>
                        <li><a class="btn btn-default" href="${pageContext.request.contextPath}/">Go Home</a></li>
                    </ul>
                </div>
            </div>
        </div>
        <div>
            <script type="text/javascript" language="javascript">
                function GetDateTime() {

                var param1 = new Date();
                document.getElementById('demo').innerHTML = param1;
                }
            </script>
        </div>

    </body>
</html>
