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

            <!-- DataTables -->
            <div class="card mb-3">
                <div class="card-header">
                    <i class="fas fa-table"></i>
                    Hotels Table
                </div>
                <div class="card-body">
                    <div class="table-responsive">
                        <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                            <thead>
                            <tr>
                                <th>Name</th>
                                <th>Stars</th>
                                <th>City</th>
                                <th>Country</th>
                                <th>Street</th>
                            </tr>
                            </thead>
                            <tfoot>
                            <tr>
                                <th>Name</th>
                                <th>Stars</th>
                                <th>City</th>
                                <th>Country</th>
                                <th>Street</th>
                            </tr>
                            </tfoot>
                            <tbody>
                            <c:forEach items="${list}" var="item">
                                <tr>
                                    <td>${item.name}</td>
                                    <td>${item.stars}</td>
                                    <td>${item.city}</td>
                                    <td>${item.country}</td>
                                    <td>${item.street}</td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>

            </div>
            <!-- /.container-fluid -->

            <!-- Sticky Footer -->
            <%@ include file="sticky-footer.jsp" %>

        </div>
        <!-- /.content-wrapper -->

    </div>
    <!-- /#wrapper -->
    <%@ include file="footer.jsp" %>
