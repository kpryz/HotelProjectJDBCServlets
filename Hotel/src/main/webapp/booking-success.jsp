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

<div class="portfolio-modal d-flex justify-content-center align-items-center modal fade" id="bookingModal" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-dialog d-flex mw-25">
        <div class="modal-content d-flex align-items-center bg-light pl-5 pr-5" >
            <div class="close close-modal" data-dismiss="modal">
                <div class="lr">
                    <div class="rl"></div>
                </div>
            </div>
            <div class="container">
                <div class="row">
                    <div class="col mx-auto">
                        <div class="modal-body ">
                            <!-- Project Details Go Here -->
                            <c:if test="${requestScope.BookingStatus == 'success'}">
                                <h1 class="text-uppercase text-success ">Success</h1>
                                <p class="item-intro text-muted">Booking is added successfully.</p>
                            </c:if>
                            <c:if test="${requestScope.BookingStatus == 'failed'}">
                                <h1 class="text-uppercase text-danger ">FAILED</h1>
                                <p class="item-intro text-muted">Booking is failed</p>
                            </c:if>
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
