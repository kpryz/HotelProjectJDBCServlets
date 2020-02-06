<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="header.jsp" %>


<!-- Header -->
<header class="masthead">
    <!-- Contact -->
    <section id="contact" class="bgi-map header-contact header-100vh d-flex align-items-center">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <h2 class="section-heading text-uppercase">Login</h2>
                    <h3 class="section-subheading text-grey">If you are not registered, contact us and join =)</h3>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-12">
                    <form id="contactForm" name="sentMessage" method="POST" action="login">
                        <div class="row">
                            <div class="col justify-content-center d-flex">
                                <div class="col-md-6 d-flex flex-wrap">
                                    <div class="form-group w-100">
                                        <input class="form-control" id="email" type="tel" name="email"
                                               placeholder="Email *"
                                               required="required"
                                               data-validation-required-message="Please enter your phone number.">
                                        <p class="help-block text-danger"></p>
                                    </div>
                                    <div class="form-group w-100">
                                        <input class="form-control" id="password" type="password" name="password"
                                               placeholder="Password *"
                                               required="required"
                                               data-validation-required-message="Please enter your email address.">
                                        <p class="help-block text-danger"></p>
                                    </div>


                                </div>
                            </div>

                            <!-- Response from server -->
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
                                <input id="" class="btn btn-primary btn-xl text-uppercase"
                                       type="submit" value="Login">
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </section>
</header>

<%@ include file="footer.jsp" %>
