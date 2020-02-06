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

<body id="page-top" class="make-container-wider">

<!-- Navigation -->
<nav class="navbar navbar-expand-lg navbar-dark fixed-top" id="mainNav">
    <div class="container">
        <a class="navbar-brand js-scroll-trigger" href="index.jsp">Travel Agency</a>
        <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse"
                data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false"
                aria-label="Toggle navigation">
            Menu
            <i class="fa fa-bars"></i>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav text-uppercase ml-auto">
                <li class="nav-item">
                    <a class="nav-link" href="index.jsp">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="hotels.jsp">Hotels</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="cabinet">Personal Cabinet</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="contact-us.jsp">Contact us</a>
                </li>
                <c:if test="${sessionScope.User != null and sessionScope.User.userRole == 'ROLE_ADMIN'}">
                    <li class="nav-item">
                        <a class="nav-link" href="admin/index.jsp">Admin</a>
                    </li>
                </c:if>

            </ul>

            <c:choose>
                <c:when test="${sessionScope.User != null or sessionScope.Customer != null}">
                    <div class="nav-item d-flex align-items-center">
                        <a class="btn btn-primary btn-md text-uppercase js-scroll-trigger ml-xl-3 ml-lg-3 mt-lg-0 mt-md-2 mt-sm-2"
                           href="logout">Logout</a>
                    </div>
                </c:when>
                <c:otherwise>
                    <div class="nav-item d-flex align-items-center">
                        <a class="btn btn-primary btn-md text-uppercase js-scroll-trigger ml-xl-3 ml-lg-3 mt-lg-0 mt-md-2 mt-sm-2"
                           href="login.jsp">Login</a>
                    </div>
                </c:otherwise>
            </c:choose>
            <c:if test="">

            </c:if>

        </div>

    </div>
</nav>

