
<%@taglib prefix="mt" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="travelSearchURL" value="travelSearch" scope="application"/>
<c:set var="hotelSearchURL" value="hotelSearch" scope="application"/>
<c:set var="eventsSearchURL" value="events" scope="application"/>
<c:set var="sponsorshipURL" value="sponsorship" scope="application"/>

<mt:modifiedtemplate>
    <jsp:body>

        <div class="slider" data-ng-controller="SliderController" data-ng-init="init()">
            <div class="tp-banner-container">
                <style scoped>.tp-caption.largegbgblue,.largegbgblue{font-size:40px;line-height:40px;font-weight:800;font-family:"Open Sans";color:#ffffff;text-decoration:none;padding:10px 20px 15px 20px;background-color:rgba(0,153,255,1);border-width:0px;border-color:rgb(255,214,88);border-style:none}.tp-caption.mediumbgorange,.mediumbgorange{font-size:20px;line-height:20px;font-weight:800;font-family:"Open Sans";color:#ffffff;text-decoration:none;padding:10px 10px 10px 10px;background-color:rgba(255,116,0,1);border-width:0px;border-color:rgb(255,214,88);border-style:none}</style>
                <div class="tp-banner">
                    <ul>
                        <!-- SLIDE  -->
                        <li data-transition="fade" data-slotamount="7" data-masterspeed="1500">
                            <!-- MAIN IMAGE -->
                            <img src="${baseURL}/resources/images/slider/slider1.jpg" alt="slidebg1" data-bgfit="cover" data-bgposition="left top" data-bgrepeat="no-repeat">
                            <!-- LAYERS -->
                            <!-- LAYER NR. 1 -->
                            <div class="tp-caption lightgrey_divider skewfromrightshort fadeout"
                                 data-x="85"
                                 data-y="224"
                                 data-speed="500"
                                 data-start="1200"
                                 data-easing="Power4.easeOut">My Caption
                            </div>
                            ...

                        </li>
                        <!-- SLIDE  -->
                        <li data-transition="zoomout" data-slotamount="7" data-masterspeed="1000">
                            <!-- MAIN IMAGE -->
                            <img src="${baseURL}/resources/images/slider/slider2.jpg" alt="darkblurbg" data-bgfit="cover" data-bgposition="left top" data-bgrepeat="no-repeat">
                            <!-- LAYERS -->
                            <!-- LAYER NR. 1 -->
                            <div class="tp-caption lightgrey_divider skewfromrightshort fadeout"
                                 data-x="85"
                                 data-y="224"
                                 data-speed="500"
                                 data-start="1200"
                                 data-easing="Power4.easeOut">My Caption
                            </div>
                            ...
                        </li>
                        ....
                    </ul>
                </div>
            </div>
        </div>

        <div class="content">
            <section class="">
                <br>
            </section>

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
        </div>

    </jsp:body>
</mt:modifiedtemplate>