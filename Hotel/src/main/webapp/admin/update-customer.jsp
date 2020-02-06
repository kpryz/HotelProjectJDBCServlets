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
                    <i class="fas fa-user mr-1"></i>
                    Update customer
                </div>
                <section id="contact"
                         class="update-customer-section admin-crud-section header-contact d-flex align-items-center">
                    <div class="container">
                        <div class="row">
                            <div class="col-lg-12 text-center">
                                <h2 class="section-heading text-uppercase mb-md-5 mb-sm-4">Update customer</h2>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-lg-12">
                                <form id="contactForm" method="post" action="update-customers"
                                      novalidate="novalidate">
                                    <div class="row d-flex justify-content-center">
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <input class="form-control" type="text" name="firstName"
                                                       placeholder="Customer's First Name *" required="required"
                                                       data-validation-required-message="Please enter Customer's first name.">
                                                <p class="help-block text-danger"></p>
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <input class="form-control" type="text" name="lastName"
                                                       placeholder="Customer's Last Name *" required="required"
                                                       data-validation-required-message="Please enter Customer's last name.">
                                                <p class="help-block text-danger"></p>
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <input class="form-control search-dropdown" type="email" name="email"
                                                       placeholder="Customer's Email *" required="required"
                                                       list="datalist"
                                                       data-validation-required-message="Please enter Customer's email.">
                                                <datalist id="datalist" class="delete-user-search-datalist">
                                                    <option value="Something"></option>
                                                </datalist>
                                                <p class="help-block text-danger"></p>
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <input class="form-control search-dropdown" type="email" name="newEmail"
                                                       placeholder="Customer's new Email"
                                                       list="datalist">
                                                <p class="help-block text-danger"></p>
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <input class="form-control" type="password" name="password"
                                                       placeholder="Customer's Password *" required="required"
                                                       data-validation-required-message="Please enter Customer's password.">
                                                <p class="help-block text-danger"></p>
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <div class="form-group">
                                                    <input class="form-control" type="password" name="phoneNumber"
                                                           placeholder="Customer's contact phone number"
                                                           required="required"
                                                           data-validation-required-message="Please enter customer's phone number.">
                                                    <p class="help-block text-danger"></p>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <input class="form-control search-dropdown" list="datalist2"
                                                       name="connectedUser" placeholder="Connected user (email) *"
                                                       required="required"
                                                       data-validation-required-message="Please enter customer's connected user.">
                                                <datalist id="datalist2">
                                                    <option value="value"></option>
                                                </datalist>
                                                <p class="help-block text-danger"></p>
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
                                            <button class="btn btn-primary btn-xl text-uppercase"
                                                    type="submit">update Customer
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
