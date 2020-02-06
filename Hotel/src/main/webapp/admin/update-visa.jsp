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
                    <i class="fas fa-money-check mr-1"></i>
                    update visa
                </div>
                <section id="contact"
                         class="update-visa-section admin-crud-section header-contact d-flex align-items-center">
                    <div class="container">
                        <div class="row">
                            <div class="col-lg-12 text-center">
                                <h2 class="section-heading text-uppercase mb-md-5 mb-sm-4">Update visa</h2>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-lg-12">
                                <form id="contactForm" method="post" action="update-visa" novalidate="novalidate">
                                    <div class="row d-flex justify-content-center">
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <input class="form-control" type="text" name="country"
                                                       placeholder="Enter country *" required="required"
                                                       data-validation-required-message="Please enter country.">
                                                <p class="help-block text-danger"></p>
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <input class="form-control" type="text" name="ownerEmail"
                                                       list="datalist"
                                                       placeholder="Owner's email *" required="required"
                                                       data-validation-required-message="Please enter owner's email(customer).">
                                                <datalist id="datalist">

                                                </datalist>
                                                <p class="help-block text-danger"></p>
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <input class="form-control" type="text" onfocus="(this.type='date')"
                                                       name="startDate"
                                                       placeholder="Start Date *" required="required"
                                                       data-validation-required-message="Please enter start date.">
                                                <p class="help-block text-danger"></p>
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <input class="form-control" type="text" onfocus="(this.type='date')"
                                                       name="endDate"
                                                       placeholder="End Date *" required="required"
                                                       data-validation-required-message="Please enter end date.">
                                                <p class="help-block text-danger"></p>
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <input class="form-control" type="text" name="visaNumber"
                                                       placeholder="Visa Number *" required="required" list="datalist"
                                                       data-validation-required-message="Please enter Visa number.">
                                                <p class="help-block text-danger"></p>
                                                <datalist class="datalist">

                                                </datalist>
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <input class="form-control" type="text" name="newVisaNumber"
                                                       placeholder="New Visa Number">
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
                                                    type="submit">update Visa
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
