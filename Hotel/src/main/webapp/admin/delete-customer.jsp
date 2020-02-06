<%@ include file="header.jsp" %>

<div id="wrapper">

    <%@ include file="sidebar.jsp" %>

    <div id="content-wrapper">

        <div class="container-fluid">

            <!-- Breadcrumbs-->
            <ol class="breadcrumb">
                <li class="breadcrumb-item">
                    <a href="#">Dashboard</a>
                </li>
                <li class="breadcrumb-item active">Overview</li>
            </ol>
            <!-- Area Chart Example-->
            <div class="card mb-3">
                <div class="card-header">
                    <i class="fas fa-chart-area"></i>
                    Area Chart Example
                </div>
                <section id="contact"
                         class="delete-customer-section admin-crud-section header-contact d-flex align-items-center">
                    <div class="container">
                        <div class="row">
                            <div class="col-lg-12 text-center">
                                <h2 class="section-heading text-uppercase mb-md-5 mb-sm-4">Delete customer</h2>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-lg-12">
                                <form id="contactForm" method="POST" action="delete-customer" novalidate="novalidate">
                                    <div class="row d-flex justify-content-center">
                                        <div class="col-md-8">
                                            <div class="form-group">

                                                <input class="form-control search-dropdown" name="email"
                                                       placeholder="Enter customer email ..." list="datalist"
                                                       required="required"
                                                       data-validation-required-message="Please enter customer's email.">
                                                <p class="help-block text-danger"></p>

                                                <datalist id="datalist" class="delete-customer-search-datalist">
                                                </datalist>

                                            </div>
                                        </div>

                                        <!-- Response from server -->
                                        <c:if test="${not empty Msg}">
                                            <div class="form-group col-md-12 d-flex justify-content-center">
                                                <div class="error-validation success alert-success p-3 rounded">
                                                        ${Msg}
                                                </div>
                                            </div>
                                        </c:if>
                                        <c:if test="${not empty Error}">
                                            <div class="form-group col-md-12 d-flex justify-content-center">
                                                <div class="error-validation alert alert-danger">
                                                        ${Error}
                                                </div>
                                            </div>
                                        </c:if>

                                        <div class="clearfix"></div>
                                        <div class="col-lg-12 text-center">
                                            <div id="success"></div>
                                            <button class="btn btn-danger btn-xl text-uppercase"
                                                    type="submit">Delete customer
                                            </button>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </section>
            </div>
        </div>


        <%@ include file="sticky-footer.jsp" %>

    </div>
    <!-- /.content-wrapper -->

</div>
<!-- /#wrapper -->
<%@ include file="footer.jsp" %>
