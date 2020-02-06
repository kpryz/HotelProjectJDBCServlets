<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="header.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<!-- Header -->
<header class="masthead hotels-header">
    <section class="<c:if test="${empty requestScope.SearchQuery}">header-100vh </c:if>
header-hotel-search  bg-light-map header d-flex align-items-center" id="contact">
        <div class="container">
            <form id="contactForm" method="GET" action="hotel-search" class="">
                <div class="row">

                    <div class="col-md-12 justify-content-center d-flex flex-wrap">
                        <div class="form-group col-md-10 d-flex w-100">
                            <div class="col d-flex">
                                <input type="text" class="d-none" name="searchType" value="hotels">
                                <input class="form-control rounded-0" id="password" type="search" name="searchQuery"
                                       placeholder="Enter country, city or hotel name" required="required"
                                       data-validation-required-message="You need to enter country, city or hotel name for productive search">
                                <p class="help-block text-danger"></p>
                                <input id="searchBtn" class="rounded-0 btn btn-primary w-25 btn-xl text-uppercase"
                                       type="submit" value="Search">
                                <p class="help-block text-danger"></p>
                            </div>
                        </div>
                        <div class="col-md-10 d-flex justify-content-between">
                            <div class="col-md-4 form-group">

                                <input class="form-control" id="startDate" type="date" name="startDate"
                                       placeholder="Start Date *"
                                       required="required"
                                       data-validation-required-message="Please enter start date of your booking.">
                                <p class="help-block text-danger"></p>
                            </div>
                            <div class="col-md-4 form-group">
                                <input class="form-control" id="endDate" type="date" name="endDate"
                                       placeholder="End Date *"
                                       required="required"
                                       data-validation-required-message="Please enter end date of your booking.">
                                <p class="help-block text-danger"></p>
                            </div>
                            <div class="col-md-4 form-group">
                                <input class="form-control" id="phone" type="number" min="1" max="12"
                                       name="numberOfPeople"
                                       placeholder="Number of people *"
                                       required="required"
                                       data-validation-required-message="Please enter No. of people.">
                                <p class="help-block text-danger"></p>
                            </div>
                        </div>

                        <div class="clearfix"></div>

                    </div>

                    <!-- Response from server -->
                    <!--  <c:if test="${not empty Msg}">
                            <div class="form-group col-md-12 d-flex justify-content-center">
                                <div class="error-validation alert alert-danger">
                                        ${Msg}
                                </div>
                            </div>
                        </c:if>-->


                </div>

            </form>
        </div>

    </section>
</header>

<c:if test="${requestScope.SearchQuery != null}">

    <div class="cabinet-main-section">
        <div class="container">

            <section class="row cabinet-info-section row  pt-5 pb-5">
                <!-- if search -->
                <div class="d-flex justify-content-center text-center col">
                    <div class="bg-light border rounded border-secondary p-4 my-info-block col-md-5">
                        <h3 class="mb-4">Booking search</h3>
                        <p><span class="text-black-50">Key words: </span>
                            <span class=" search-info-block-val">${requestScope.SearchQuery}</span></p>
                        <p><span class="text-black-50">Start Date: </span>
                            <span class="search-info-block-val">${requestScope.StartDate}</span></p>
                        <p><span class="text-black-50">End Date: </span>
                            <span class="search-info-block-val">${requestScope.EndDate}</span></p>
                        <p><span class="text-black-50">No. of people: </span>
                            <span class="search-info-block-val">${requestScope.NumberOfPeople}</span></p>
                    </div>
                </div>
                <!-- endif -->
            </section>


            <section class="hotels-search-content-section pt-5 pb-5">
                <div class="row">
                    <div class="col-lg-12 text-center">
                        <h2 class="section-heading text-uppercase mb-5">Search results</h2>
                    </div>
                </div>

                <!-- if customer -->
                <!--  <div class="row">
                    <div class="col-md-4 col-sm-6 portfolio-item mb-4">
                        <a class="portfolio-link" data-toggle="modal" href="#portfolioModal1">
                            <div class="portfolio-hover opacity-on-hover transition-hover">
                                <div class="portfolio-hover-content position-relative">
                                    <img class="img-fluid" src="img/portfolio/05-thumbnail.jpg" alt="">
                                    <i class="fa fa-info-circle fa-3x abs-center"></i>
                                </div>
                            </div>
                        </a>
                        <div class="portfolio-caption">
                            <h4 class="mt-3">Hotel name</h4>
                            <p class="text-muted mt-3">
                                Hotel description Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ad esse
                                molestiae, nemo optio repellendus sunt!
                            </p>
                        </div>
                    </div>
                </div>-->
                <!-- endif -->

                <!-- if user/admin -->
                <div class="card mb-5">
                    <div class="card-header">
                        <i class="fas fa-bookmark mr-1"></i>
                        Available rooms
                    </div>
                    <div class="card-body">
                        <div class="table-responsive">
                            <table id="" class="dataTable table table-bordered" width="100%"
                                   cellspacing="0">
                                <thead>
                                <tr>
                                    <th>County</th>
                                    <th>City</th>
                                    <th>Hotel</th>
                                    <th>Stars</th>
                                    <th>Room Number</th>
                                    <th>Room Type</th>
                                    <th>Price</th>
                                    <th>Price per day</th>
                                    <th>Start Date</th>
                                    <th>End Date</th>
                                    <th>No. of people</th>
                                    <c:if test="${sessionScope.User != null}">
                                        <th></th>
                                    </c:if>
                                </tr>
                                </thead>

                                <tfoot>
                                <tr>
                                    <th>County</th>
                                    <th>City</th>
                                    <th>Hotel</th>
                                    <th>Stars</th>
                                    <th>Room Number</th>
                                    <th>Room Type</th>
                                    <th>Price</th>
                                    <th>Price per day</th>
                                    <th>Start Date</th>
                                    <th>End Date</th>
                                    <th>No. of people</th>
                                    <c:if test="${sessionScope.User != null}">
                                        <th></th>
                                    </c:if></tr>
                                </tfoot>
                                <tbody>
                                <c:forEach items="${RoomList}" var="room">
                                    <tr>
                                        <td>${room.hotel.country}</td>
                                        <td>${room.hotel.city}</td>
                                        <td>${room.hotel_name}</td>
                                        <td>
                                            <c:choose>
                                                <c:when test="${room.hotel.stars == 1}"> * </c:when>
                                                <c:when test="${room.hotel.stars == 2}"> ** </c:when>
                                                <c:when test="${room.hotel.stars == 3}"> *** </c:when>
                                                <c:when test="${room.hotel.stars == 4}"> **** </c:when>
                                                <c:otherwise> ***** </c:otherwise>
                                            </c:choose>
                                        </td>
                                        <td>${room.roomNumber}</td>
                                        <td>${room.roomType}</td>
                                        <c:set var="totalPrice"
                                               value="${requestScope.DaysNumber * room.priceInDollars}"/>
                                        <td>${totalPrice}</td>
                                        <td>${room.priceInDollars}</td>
                                        <td>${requestScope.StartDate}</td>
                                        <td>${requestScope.EndDate}</td>
                                        <td>${room.numberOfPeople}</td>
                                        <c:if test="${sessionScope.User != null}">
                                            <td class="d-flex justify-content-center">
                                                <!-- url is modified in js -->
                                                <a class="btn btn-success btn-md  text-uppercase"
                                                   href="booking?searchQuery=${requestScope.SearchQuery}&roomId=${room.id}&roomNumber=${room.roomNumber}&startDate=${requestScope.StartDate}&endDate=${requestScope.EndDate}&numberOfPeople=${requestScope.NumberOfPeople}">book</a>
                                            </td>
                                        </c:if>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
                <!-- endif -->

            </section>
        </div>
    </div>
</c:if>


<%@ include file="footer.jsp" %>

