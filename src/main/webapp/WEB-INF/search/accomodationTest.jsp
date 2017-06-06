<%@taglib prefix="acc" tagdir="/WEB-INF/tags" %>

<acc:accomodationTemplate>
	<jsp:body>
	<div class="liveCarnival">
		<div class="search-widget size336x280B">
        <div class="search-widget-inner">
            <div class="predefined-destinations-block">
                <label for="predefined-destinations">Where would you like to go?:</label>
                <ul id="predefined-destinations">
                            <li>
                                <input type="radio" class="radio" id="AREA-c2575e89-8779-491c-866b-60a7957c9f93|cities|Port of Spain, Chaguanas, Trinidad and Tobago" name="predefined" value="Port of Spain, Chaguanas, Trinidad and Tobago"/>
                                <label for="AREA-c2575e89-8779-491c-866b-60a7957c9f93|cities|Port of Spain, Chaguanas, Trinidad and Tobago">Port of Spain</label>
                            </li>
                            <li>
                                <input type="radio" class="radio" id="AREA-af53dbe5-b7df-4960-9de3-d373dbb1da36|cities|Miami, FL, United States" name="predefined" value="Miami, FL, United States"/>
                                <label for="AREA-af53dbe5-b7df-4960-9de3-d373dbb1da36|cities|Miami, FL, United States">Miami</label>
                            </li>
                            <li>
                                <input type="radio" class="radio" id="AREA-863d6680-432b-4e66-a2ef-2ce2e1377b23|cities|Kingston, Jamaica, Jamaica" name="predefined" value="Kingston, Jamaica, Jamaica"/>
                                <label for="AREA-863d6680-432b-4e66-a2ef-2ce2e1377b23|cities|Kingston, Jamaica, Jamaica">Kingston</label>
                            </li>
                            <li>
                                <input type="radio" class="radio" id="AREA-23a5057d-7dd7-43af-8c8b-dfd60146a467|cities|Bridgetown (Barbados, Charnocks, Barbados)" name="predefined" value="Bridgetown (Barbados, Charnocks, Barbados)"/>
                                <label for="AREA-23a5057d-7dd7-43af-8c8b-dfd60146a467|cities|Bridgetown (Barbados, Charnocks, Barbados)">Bridgetown (Barbados</label>
                            </li>
                            <li>
                                <input type="radio" class="radio" id="AREA-8e339710-3a23-4cb4-8a0b-d3329495e236|cities|Castries, Dennery, Saint Lucia" name="predefined" value="Castries, Dennery, Saint Lucia"/>
                                <label for="AREA-8e339710-3a23-4cb4-8a0b-d3329495e236|cities|Castries, Dennery, Saint Lucia">Castries</label>
                            </li>
                            <li>
                                <input type="radio" class="radio" id="AREA-572b0850-4e3f-469b-87b2-c17ed3ea049b|cities|NYC (New York, NY, United States)" name="predefined" value="NYC (New York, NY, United States)"/>
                                <label for="AREA-572b0850-4e3f-469b-87b2-c17ed3ea049b|cities|NYC (New York, NY, United States)">NYC (New York</label>
                            </li>
                </ul>
            </div>
                <div class="destination-block">
                    <label for="destination">Where would you like to go?:</label>
                        <input type="text" class="textbox" id="destination"/>
                        <input type="hidden" id="targetId"/>
                </div>
            <div class="check-in-block">
                <label for="check-in">Check-in:</label>
                <span class="calendar-icon" id="checkinIcon">&nbsp;</span>
                <input type="text" class="textbox" id="check-in"/>
                <div id="check-inDialogContainer" class="yui-skin-sam">
                   
                </div>
            </div>
            <div class="check-out-block">
                <label for="check-out">Check-out:</label>
                <span class="calendar-icon" id="checkoutIcon">&nbsp;</span>
                <input type="text" class="textbox" id="check-out"/>
                <div id="check-outDialogContainer" class="yui-skin-sam">
                    
                </div>
            </div>
            <div class="reset-dates-block">
                <input type="checkbox" class="checkbox" id="reset-dates"/>
                <label for="reset-dates">I don't have specific dates yet</label>
            </div>
            <div class="rooms-block">
                <label for="rooms">Rooms:</label>
                <select id="rooms">
                    <option value="1" selected>1</option>
                        <option value="2">2</option>
                        <option value="3">3</option>
                        <option value="4">4</option>
                        <option value="5">5</option>
                        <option value="6">6</option>
                        <option value="7">7</option>
                        <option value="8">8</option>
                    
                </select>
            </div>
            <div class="adults-block">
                <label for="adults" id="adults_label">Adults (18+):</label>
                <select id="adults">
                        <option value="1"
                                
                                >1</option>
                        <option value="2"
                                selected="selected"
                                >2</option>
                        <option value="3"
                                
                                >3</option>
                        <option value="4"
                                
                                >4</option>
                </select>
            </div>
            <div class="children-block">
                <label for="children" id="children_label">Children (0-17):</label>
                <select id="children">
                        <option value="0"
                                selected="selected"
                                >0</option>
                        <option value="1"
                                
                                >1</option>
                        <option value="2"
                                
                                >2</option>
                        <option value="3"
                                
                                >3</option>
                </select>
            </div>
            <div class="hotel-chains-block">
                <label for="hotel-chains">Hotel Chain:</label>
                <select id="hotel-chains">
                    <option selected="selected">Select hotel chain</option>
                        <option value="Hilton">Hilton</option>
                        <option value="Holiday Inn">Holiday Inn</option>
                        <option value="Marriott">Marriott</option>
                        <option value="Travelodge">Travelodge</option>
                        <option value="Ramada">Ramada</option>
                        <option value="Sheraton">Sheraton</option>
                        <option value="Best Western">Best Western</option>
                        <option value="Renaissance">Renaissance</option>
                        <option value="Westin">Westin</option>
                        <option value="Wyndham">Wyndham</option>
                        <option value="Courtyard">Courtyard</option>
                        <option value="Fairfield">Fairfield</option>
                        <option value="Clarion">Clarion</option>
                        <option value="Comfort Inn">Comfort Inn</option>
                        <option value="Super 8">Super 8</option>
                        <option value="Days Inn">Days Inn</option>
                        <option value="Hyatt Regency">Hyatt Regency</option>
                        <option value="Country Inn">Country Inn</option>
                        <option value="Grand Hyatt">Grand Hyatt</option>
                        <option value="Doubletree">Doubletree</option>
                        <option value="Embassy Suites">Embassy Suites</option>
                        <option value="Quality Inn">Quality Inn</option>
                        <option value="Residence Inn">Residence Inn</option>
                        <option value="Fairfield Inn">Fairfield Inn</option>
                        <option value="Hampton Inn">Hampton Inn</option>
                        <option value="Howard Johnson">Howard Johnson</option>
                        <option value="Omni">Omni</option>
                        <option value="Homewood Suites">Homewood Suites</option>
                        <option value="Homestead">Homestead</option>
                        <option value="Red Roof Inn">Red Roof Inn</option>
                        <option value="AmeriSuites">AmeriSuites</option>
                        <option value="Comfort Suites">Comfort Suites</option>
                        <option value="Wingate Inn">Wingate Inn</option>
                        <option value="Sleep Inn">Sleep Inn</option>
                        <option value="Springhill Suites">Springhill Suites</option>
                        <option value="Econo Lodge">Econo Lodge</option>
                        <option value="Hawthorn Suites">Hawthorn Suites</option>
                        <option value="Microtel Inn">Microtel Inn</option>
                        <option value="Extended Stay">Extended Stay</option>
                        <option value="TownePlace Suites">TownePlace Suites</option>
                        <option value="La Quinta Inn">La Quinta Inn</option>
                        <option value="Drury Inn">Drury Inn</option>
                        <option value="Masters Inn">Masters Inn</option>
                        <option value="Sierra Suites">Sierra Suites</option>
                        <option value="AmeriHost">AmeriHost</option>
                        <option value="Baymont Inns & Suites">Baymont Inns & Suites</option>
                        <option value="Ritz-Carlton">Ritz-Carlton</option>
                        <option value="America’s Best Inns">America’s Best Inns</option>
                        <option value="W Hotel">W Hotel</option>
                        <option value="Wellesley Inn">Wellesley Inn</option>
                        <option value="Studio 6">Studio 6</option>
                </select>
            </div>
            <div class="star-rating-block">
                <label for="star-rating">Star Rating:</label>
                <select id="star-rating">
                        <option value="0"
                                    selected="selected"
                        >
                        Don't limit search results</option>
                        <option value="1"
                        >
                        1 star</option>
                        <option value="2"
                        >
                        2 stars</option>
                        <option value="3"
                        >
                        3 stars</option>
                        <option value="4"
                        >
                        4 stars</option>
                        <option value="5"
                        >
                        5 stars</option>
                </select>
            </div>
            <div class="button-block">
                <button type="button" id="search-btn">Search</button>
            </div>
        </div>
        
        
    </div>
    <input type="hidden" id="lang" value="en">
    <input type="hidden" id="currency" value="USD">
    
    <div class="content">
            <section class="">
                <br>
            </section>
   
   <section class="body-bottom">
                <div class="container">
                    <div class="row">
                        <div class="col-sm-3 text-center">
                            <a href=""><span class="ico"><i class="fa fa-2x fa-cutlery"></i></span></a>
                            <h4>Accommodations</h4>

                            <p>Carnival accommodation needs to fit your style and budget.&nbsp;</p></div>
                        <div class="col-sm-3 text-center">
                            <a href=""><span class="ico"><i class="fa fa-2x fa-plane"></i></span></a>
                            <h4>Travel</h4>

                            <p>Airfare booking to all Caribbean and Latin America Carnivals. </p></div>
                        <div class="col-sm-3 text-center">
                            <a href=""><span class="ico"><i class="fa fa-2x fa-camera"></i></span></a>
                            <h4>Events</h4>

                            <p>Manage all your carnival events.&nbsp;</p></div>
                        <div class="col-sm-3 text-center">
                            <a href=""><span class="ico"><i class="fa fa-2x fa-dashboard"></i></span></a>
                            <h4>Sponsorship</h4>

                            <p>Maximize your investment in Caribbean Carnivals.&nbsp;</p></div>
                    </div>
                    <p>&nbsp;</p>


                </div>
            </section>
			
</div>
	
	</div>
	
		
	
	
	</jsp:body>

</acc:accomodationTemplate>