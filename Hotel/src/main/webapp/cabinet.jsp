<%@ include file="header.jsp" %>


<!-- Header -->

<header class="masthead cabinet-header">
    <div class="container">
        <div class="intro-text">
            <div class="intro-lead-in">Welcome,
                <c:if test="${sessionScope.User != null}">
                    ${sessionScope.User.firstName}!
                </c:if>
                <c:if test="${sessionScope.Customer != null}">
                    ${sessionScope.Customer.firstName}!
                </c:if>
            </div>
            <div class="intro-heading text-uppercase">It's Nice To Meet You</div>

        </div>
    </div>
</header>

<div class="cabinet-main-section">
    <div class="container">
        <section class="cabinet-info-section d-flex justify-content-between pt-5 pb-5">
            <c:if test="${sessionScope.Customer != null}">
                <div class="bg-light border rounded border-secondary p-4 my-info-block col-md-5">
                    <h3 class="mb-4">My info</h3>
                    <p>First Name: <span class="my-info-block-val">${sessionScope.Customer.firstName}</span></p>
                    <p>Last Name: <span class="my-info-block-val">${sessionScope.Customer.lastName}</span></p>
                    <p>Contact Number: <span class="my-info-block-val">${sessionScope.Customer.contactNumber}</span></p>
                    <p>Email: <span class="my-info-block-val">${sessionScope.Customer.email}</span></p>
                </div>
                <div class="bg-light border rounded border-secondary p-4 user-info-block col-md-5">
                    <h3 class="mb-4">
                        Connected User
                    </h3>
                    <p>First Name: <span class="my-info-block-val">${User.firstName}</span></p>
                    <p>Last Name: <span class="my-info-block-val">${User.lastName}</span></p>
                    <p>Email: <span class="my-info-block-val">${User.email}</span></p>
                </div>
            </c:if>

            <c:if test="${sessionScope.User != null}">
                <div class="bg-light border rounded border-secondary p-4 user-info-block col-md-5">
                    <h3 class="mb-4">
                        User
                    </h3>
                    <p>First Name: <span class="my-info-block-val">${sessionScope.User.firstName}</span></p>
                    <p>Last Name: <span class="my-info-block-val">${sessionScope.User.lastName}</span></p>
                    <p>Email: <span class="my-info-block-val">${sessionScope.User.email}</span></p>
                </div>
            </c:if>
        </section>


        <section class="cabinet-table-section pt-5 pb-5 mb-3">

            <c:if test="${sessionScope.Customer != null}">

                <!-- DataTables -->
                <div class="card mb-5">
                    <div class="card-header">
                        <i class="fas fa-bookmark mr-1"></i>
                        Bookings
                    </div>
                    <div class="card-body">
                        <div class="table-responsive">
                            <table class="table dataTable table-bordered" id="bookingsDataTable" width="100%"
                                   cellspacing="0">
                                <thead>
                                <tr>
                                    <th>Booking ID</th>
                                    <th>Country</th>
                                    <th>City</th>
                                    <th>Hotel</th>
                                    <th>Room Number</th>
                                    <th>Room Type</th>
                                    <th>No. of people</th>
                                    <th>Price</th>
                                    <th>Start Date</th>
                                    <th>End Date</th>
                                </tr>
                                </thead>
                                <tfoot>
                                <tr>
                                    <th>Booking ID</th>
                                    <th>Country</th>
                                    <th>City</th>
                                    <th>Hotel</th>
                                    <th>Room Number</th>
                                    <th>Room Type</th>
                                    <th>No. of people</th>
                                    <th>Price</th>
                                    <th>Start Date</th>
                                    <th>End Date</th>
                                </tr>
                                </tfoot>
                                <tbody>
                                <c:forEach items="${BookingList}" var="booking">
                                    <tr>
                                        <td>${booking.id}</td>
                                        <td>${booking.room.hotel.country}</td>
                                        <td>${booking.room.hotel.city}</td>
                                        <td>${booking.room.hotel.name}</td>
                                        <td>${booking.room.roomNumber}</td>
                                        <td>${booking.room.roomType}</td>
                                        <td>${booking.room.numberOfPeople}</td>
                                        <td>${booking.totalPriceInDollars}</td>
                                        <td>${booking.startDate}</td>
                                        <td>${booking.endDate}</td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </c:if>

            <c:if test="${sessionScope.User != null}">

                <!-- DataTables -->
                <div class="card mb-5">
                    <div class="card-header">
                        <i class="fas fa-bookmark mr-1"></i>
                        Bookings
                    </div>
                    <div class="card-body">
                        <div class="table-responsive">
                            <table class="table dataTable table-bordered" width="100%"
                                   cellspacing="0">
                                <thead>
                                <tr>
                                    <th>Customer Email</th>
                                    <th>Booking ID</th>
                                    <th>Country</th>
                                    <th>City</th>
                                    <th>Hotel</th>
                                    <th>Room Number</th>
                                    <th>Room Type</th>
                                    <th>No. of people</th>
                                    <th>Price</th>
                                    <th>Start Date</th>
                                    <th>End Date</th>
                                </tr>
                                </thead>
                                <tfoot>
                                <tr>
                                    <th>Customer Email</th>
                                    <th>Booking ID</th>
                                    <th>Country</th>
                                    <th>City</th>
                                    <th>Hotel</th>
                                    <th>Room Number</th>
                                    <th>Room Type</th>
                                    <th>No. of people</th>
                                    <th>Price</th>
                                    <th>Start Date</th>
                                    <th>End Date</th>
                                </tr>
                                </tfoot>
                                <tbody>
                                <c:forEach items="${BookingList}" var="booking">
                                    <tr>
                                        <td>${booking.customer_email}</td>
                                        <td>${booking.id}</td>
                                        <td>${booking.room.hotel.country}</td>
                                        <td>${booking.room.hotel.city}</td>
                                        <td>${booking.room.hotel.name}</td>
                                        <td>${booking.room.roomNumber}</td>
                                        <td>${booking.room.roomType}</td>
                                        <td>${booking.room.numberOfPeople}</td>
                                        <td>${booking.totalPriceInDollars}</td>
                                        <td>${booking.startDate}</td>
                                        <td>${booking.endDate}</td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>

                <!-- DataTables -->
                <div class="card mb-3">
                    <div class="card-header">
                        <i class="fas fa-user mr-1"></i>
                        Customers
                    </div>
                    <div class="card-body">
                        <div class="table-responsive">
                            <table class="table dataTable table-bordered" id="customerDataTable" width="100%"
                                   cellspacing="0">
                                <thead>
                                <tr>
                                    <th>First Name</th>
                                    <th>Last Name</th>
                                    <th>Contact Number</th>
                                    <th>Email</th>
                                    <th>Visas</th>
                                </tr>
                                </thead>
                                <tfoot>
                                <tr>
                                    <th>First Name</th>
                                    <th>Last Name</th>
                                    <th>Contact Number</th>
                                    <th>Email</th>
                                    <th>Visas</th>
                                </tr>
                                </tfoot>
                                <tbody>
                                <c:forEach items="${CustomerList}" var="customer">
                                    <tr>
                                        <td>${customer.firstName}</td>
                                        <td>${customer.lastName}</td>
                                        <td>${customer.contactNumber}</td>
                                        <td>${customer.email}</td>
                                        <td>
                                            <table class="table table-bordered" id="" width="100%"
                                                   cellspacing="0">
                                                <thead>
                                                <tr>
                                                    <th>Country</th>
                                                    <th>Start Date</th>
                                                    <th>End Date</th>
                                                    <th>Visa Number</th>
                                                </tr>
                                                </thead>
                                                <tbody>

                                                <c:forEach items="${customer.visaList}" var="visa">
                                                    <tr>
                                                        <td> ${visa.country} </td>
                                                        <td> ${visa.startDate} </td>
                                                        <td> ${visa.endDate} </td>
                                                        <td> ${visa.visaNumber} </td>
                                                    </tr>
                                                </c:forEach>
                                                </tbody>

                                            </table>
                                        </td>
                                    </tr>
                                </c:forEach>

                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>

                <div class="user-management-btns d-flex justify-content-between pt-5">
                    <a class="btn btn-success btn-xl text-uppercase js-scroll-trigger" href="add-customer.jsp">
                        Add customer</a>
                    <a class="btn btn-primary btn-xl text-uppercase js-scroll-trigger" href="update-customer.jsp">
                        Update customer</a>
                    <a class="btn btn-danger btn-xl text-uppercase js-scroll-trigger" href="delete-customer.jsp">
                        Delete customer</a>

                </div>
            </c:if>
        </section>
    </div>
</div>

<%@ include file="footer.jsp" %>

