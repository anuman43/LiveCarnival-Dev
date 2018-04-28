<!-- Button Section -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<section class="body-bottom">
                <div class="container">
                    <div class="row">
                        <div class="col-sm-3 text-center">
                            <a href="<c:out value="${hotelSearchURL}"/>"><span class="ico"><i class="fa fa-2x fa-cutlery"></i></span></a>
                            <h4>Accommodations</h4>

                            <p>Carnival accommodation needs to fit your style and budget.&nbsp;</p></div>
                        <div class="col-sm-3 text-center">
                            <a href="<c:out value="${travelSearchURL}"/>"><span class="ico"><i class="fa fa-2x fa-plane"></i></span></a>
                            <h4>Travel</h4>

                            <p>Airfare booking to all Caribbean and Latin America Carnivals. </p></div>
                        <div class="col-sm-3 text-center">
                            <a href="<c:out value="${eventsSearchURL}"/>"><span class="ico"><i class="fa fa-2x fa-camera"></i></span></a>
                            <h4>Events</h4>

                            <p>Manage all your carnival events.&nbsp;</p></div>
                        <div class="col-sm-3 text-center">
                            <a href="<c:out value="${sponsorshipURL}"/>"><span class="ico"><i class="fa fa-2x fa-dashboard"></i></span></a>
                            <h4>Sponsorship</h4>
                            <p>Maximize your investment in Caribbean Carnivals.&nbsp;</p></div>
                    </div>
                    <p>&nbsp;</p>


                </div>
            </section>

<!-- Footer -->
<section id="footer">
    <div class="footer-top">
        <div class="container">
            <div class="row">
                <div class="col-sm-6 text-right">
                    <img src="${baseURL}/resources/images/logo-footer.png" align="logo">
                </div>
                <div class="col-sm-6 text-left">
                    Contact us:
                    <p>Email: <a target="_blank" href="mailto:info@live4carnival.com">info@live4carnival.com</a></p>
                </div>
            </div>
        </div>
    </div>
    <div class="footer-bottom">
        <div class="container">
            <h5>
            <span class="scroll-wrapper">
                <a id="back-to-top" href="#" style="display: none;"><i class="icon-arrow-up"></i></a>
                <small>Copyright © Live4Carnival. By <a target="_blank" href="http://glacegrafix.com/">GlaceGrafix Inc.</a></small>
            </span>
            </h5>
        </div>
    </div>
</section>
 </div>
</body>



</html>