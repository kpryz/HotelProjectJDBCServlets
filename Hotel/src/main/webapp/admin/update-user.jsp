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
                    Update user
                </div>
                <section id="contact"
                         class="update-user-section admin-crud-section header-contact d-flex align-items-center">
                    <div class="container">
                        <div class="row">
                            <div class="col-lg-12 text-center">
                                <h2 class="section-heading text-uppercase mb-md-5 mb-sm-4">Update user</h2>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-lg-12">
                                <form id="contactForm" method="post" action="update-user" novalidate="novalidate">
                                    <div class="row d-flex justify-content-center">
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <input class="form-control" type="text" name="firstName"
                                                       placeholder="User's First Name *" required="required"
                                                       data-validation-required-message="Please enter user's first name.">
                                                <p class="help-block text-danger"></p>
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <input class="form-control" type="text" name="lastName"
                                                       placeholder="User's Last Name *" required="required"
                                                       data-validation-required-message="Please enter user's last name.">
                                                <p class="help-block text-danger"></p>
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <input class="form-control search-dropdown" type="email" name="email"
                                                       placeholder="User's Email *" required="required" list="datalist"
                                                       data-validation-required-message="Please enter user's email.">
                                                <datalist id="datalist" class="delete-user-search-datalist">
                                                    <option value="Something"></option>
                                                </datalist>
                                                <p class="help-block text-danger"></p>
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <input class="form-control search-dropdown" type="email"
                                                       placeholder="New User's Email" list="datalist" name="newEmail"
                                                      >
                                                <p class="help-block text-danger"></p>
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <input class="form-control" type="password" name="password"
                                                       placeholder="User's Password *" required="required"
                                                       data-validation-required-message="Please enter user's password.">
                                                <p class="help-block text-danger"></p>
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <select id="selectUser" class="form-control" name="userRole"
                                                        required="required"
                                                        data-validation-required-message="Please select user's role.">
                                                    <option value="ROLE_ADMIN">ADMIN</option>
                                                    <option value="ROLE_USER">USER</option>
                                                </select>
                                                <p class="help-block text-danger"></p>
                                            </div>
                                        </div>

                                        <!-- Response from server -->
                                        <c:if test="${not empty Msg}">
                                            <div class="form-group col-md-12 d-flex justify-content-center">
                                                <div class="error-validation success alert-success p-3 rounded rounded">
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
                                                    type="submit">update USER
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
