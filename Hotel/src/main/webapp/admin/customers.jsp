<%@ include file="header.jsp" %>


<div id="wrapper">

    <%@ include file="sidebar.jsp" %>


    <div id="content-wrapper">

        <div class="container-fluid">

            <!-- Breadcrumbs-->
            <ol class="breadcrumb">
                <li class="breadcrumb-item">
                    <a href="#">Statistick</a>
                </li>
                <li class="breadcrumb-item active">Tables</li>
            </ol>

            <!-- DataTables Example -->
            <div class="card mb-3">
                <div class="card-header">
                    <i class="fas fa-table"></i>
                    Customers Table
                </div>
                <div class="card-body">
                    <div class="table-responsive">
                        <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                            <thead>
                            <tr>
                                <th>First Name</th>
                                <th>Last Name</th>
                                <th>Contact Number</th>
                                <th>Email</th>
                                <th>Connected User Id</th>
                                <th>Visas</th>
                            </tr>
                            </thead>
                            <tfoot>
                            <tr>
                                <th>First Name</th>
                                <th>Last Name</th>
                                <th>Contact Number</th>
                                <th>Email</th>
                                <th>Connected User Id</th>
                                <th>Visas</th>
                            </tr>
                            </tfoot>
                            <tbody>
                            <c:forEach items="${Customers}" var="customer">
                                <tr>
                                    <td>${customer.firstName}</td>
                                    <td>${customer.lastName}</td>
                                    <td>${customer.contactNumber}</td>
                                    <td>${customer.email}</td>
                                    <td>${customer.user_email}</td>
                                    <td>
                                        <c:forEach items="${customer.visaList}" var="visa">
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
                                                <tr>
                                                    <td> ${visa.country} </td>
                                                    <td> ${visa.startDate} </td>
                                                    <td> ${visa.endDate} </td>
                                                    <td> ${visa.visaNumber} </td>
                                                </tr>
                                                </tbody>
                                            </table>
                                        </c:forEach>
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
                <div class="card-footer small text-muted">Updated yesterday at 11:59 PM</div>
            </div>

            <p class="small text-center text-muted my-5">
                <em>More table examples coming soon...</em>
            </p>

        </div>
        <!-- /.container-fluid -->

        <!-- Sticky Footer -->
        <%@ include file="sticky-footer.jsp" %>

    </div>
    <!-- /.content-wrapper -->

</div>
<!-- /#wrapper -->
<%@ include file="footer.jsp" %>
