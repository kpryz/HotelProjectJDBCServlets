<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Agency - Start Bootstrap Theme</title>

    <!-- Bootstrap core CSS -->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- jQuery -->
    <script src="vendor/jquery/jquery.min.js"></script>

    <!-- Custom fonts for this template -->
    <!-- Page level plugin CSS-->
    <link href="vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet">
    <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
    <link href='https://fonts.googleapis.com/css?family=Kaushan+Script' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Droid+Serif:400,700,400italic,700italic' rel='stylesheet'
          type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700' rel='stylesheet' type='text/css'>

    <!-- Custom styles for this template -->
    <link href="css/agency.min.css" rel="stylesheet">

</head>
<body>
<a class="btn btn-success btn-md  text-uppercase o-0" id="linkToShowModal" data-toggle="modal"
   href="#bookingModal">book</a>

<div class="portfolio-modal modal fade" id="bookingModal" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content d-flex align-items-center h-95vh">
            <div class="close close-modal" data-dismiss="modal">
                <div class="lr">
                    <div class="rl"></div>
                </div>
            </div>
            <div class="container">
                <div class="row">
                    <div class="col-lg-10 mx-auto">
                        <div class="modal-body">

                            <form action="${requestScope['javax.servlet.forward.query_string']}"
                                  method="post">

                                <!-- Project Details Go Here -->
                                <h2 class="text-uppercase">Booking</h2>
                                <p class="item-intro text-muted">Choose customer, for whom you are making booking.</p>
                                <div class="card mb-5  text-left">
                                    <div class="card-header">
                                        <i class="fas fa-bookmark mr-1"></i>
                                        Available customers (with appropriate visa)
                                    </div>
                                    <div class="card-body">
                                        <div class="table-responsive">
                                            <table class="dataTable table table-bordered" width="100%"
                                                   cellspacing="0">
                                                <thead>
                                                <tr>
                                                    <th>First Name</th>
                                                    <th>Last Name</th>
                                                    <th>Contact Number</th>
                                                    <th>Email</th>
                                                    <th></th>
                                                </tr>
                                                </thead>
                                                <tfoot>
                                                <tr>
                                                    <th>First Name</th>
                                                    <th>Last Name</th>
                                                    <th>Contact Number</th>
                                                    <th>Email</th>
                                                    <th></th>
                                                </tr>
                                                </tfoot>
                                                <tbody>

                                                <c:forEach items="${Customers}" var="customer">
                                                    <tr>
                                                        <td>${customer.firstName}</td>
                                                        <td>${customer.lastName}</td>
                                                        <td>${customer.contactNumber}</td>
                                                        <td>${customer.email}</td>
                                                        <td>
                                                            <input type="radio" name="selectedCustomer"
                                                                   value="${customer.email}"/>
                                                        </td>
                                                    </tr>
                                                </c:forEach>
                                                </tbody>
                                            </table>
                                        </div>
                                    </div>

                                </div>

                                <div class="clearfix"></div>
                                <div class="col-lg-12 text-center">
                                    <div id="success"></div>
                                    <button class="btn btn-success w-25 btn-xl text-uppercase"
                                            type="submit"> Book
                                    </button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>


<script src="js/booking-modal.js"></script>
<!-- Bootstrap core JavaScript -->
<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

<!-- Plugin JavaScript -->
<script src="vendor/jquery-easing/jquery.easing.min.js"></script>

<!-- Contact form JavaScript -->
<script src="js/jqBootstrapValidation.js"></script>


<!-- Datatables-->
<script src="vendor/datatables/jquery.dataTables.js"></script>
<script src="vendor/datatables/dataTables.bootstrap4.js"></script>
<script src="js/demo/datatables-demo.js"></script>

</body>

</html>
