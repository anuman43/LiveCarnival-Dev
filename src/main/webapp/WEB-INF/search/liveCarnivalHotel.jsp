


	<div class="row"><br></div>
	<div class="row"><br></div>
	<div class="row"><br></div>	
    <div class="row">
   	 <!-- Middle row with 12 columns. Middle column holds form content -->
    	<div class="col-md-4"></div>
    	<div class="col-md-4">
		<form id="liveCarnivalHotelFrm" name="hotelData" action="${baseURL}/Carnivate/submitHotelSearch"
			method="post">

			<div class="row">



				<div class="col-md-8">

					<label>Destination: Country</label> <input type="text"
						class="form-control" name="destinationCountry" id="countryText" autocomplete="off">
					<label>Destination: State/Province</label> <input type="text"
						class="form-control" id="statesText" name="destinationState" autocomplete="off"> <label>Destination:
						City</label> <input type="text" name="destinationCity" class="form-control" id="citiesText"
						autocomplete="off">

					<!-- <label id="destLbl" for="destinationTxt">Destination</label>
						<input type="search" class="form-control" id="destinationTxt"> -->

				</div>
				<div class="col-md-4"></div>
			</div>
			<div class="row">
				<div class="col-md-8">
					<label id="checkInLbl" for="destinationTxt">Check In Date</label>
					<input class="form-control" type="date" name="stayFromDate">

				</div>
				<div class="col-md-4"></div>
			</div>
			<div class="row">
				<div class="col-md-8">
					<label id="checkOutLbl" for="destinationTxt">Check Out Date</label> <input class="form-control" type="date" name="stayToDate">

				</div>
				<div class="col-md-4"></div>
			</div>
			<div class="row">
				<div class="col-md-8">
					<label id="guestsLbl" for="destinationTxt">Guests</label>
				</div>

			</div>
			<div class="col-md-4"></div>
			<div class="row">

				<div class="form-inline">
					<div class="col-md-8">
						<input class="form-control" type="number" placeholder="Adults"
							name="guestsAdults"> <input class="form-control" type="number"
							placeholder="Kids" name="guestKids">
					</div>
					<div class="col-md-4"></div>
				</div>

			</div>

			<div class="row">
				<div class="col-md-8">
					<br> <input class="btn-default.active" type="submit"
						value="search">
				</div>
				<div class="col-md-4"></div>
			</div>



		</form>
	</div>
   
   		<div class="col-md-4"></div>
    </div>
    </div>
    
	
	