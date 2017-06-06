<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>Live Carnival Hotel Search</title>

    <!-- Bootstrap -->
    <link href="../scripts/bootstrap/css/bootstrap.min.css" rel="stylesheet">
   </head>
  <body>
  	<div class="container">
  	
  		<!-- Hotel Search Form -->
		<form id="liveCarnivalHotelFrm">
			
				<div class="row"> 
				
					<div class="col-xs-4">
						<label id="destLbl" for="destinationTxt">Destination</label>
						<input type="search" class="form-control" id="destinationTxt">
				
					</div>
				</div>
				<div class="row">
					<div class="col-xs-4">
						<label id="checkInLbl" for="destinationTxt">Check In Date</label>
						<input class="form-control" type="date" >
					
					</div>
				</div>
				<div class="row">
						<div class="col-xs-4">
							<label id="checkOutLbl" for="destinationTxt">Check Out Date</label>
							<input class="form-control" type="date" >
						
						</div>
				</div>
				<div class="row">
					<div class="col-xs-4">
						<label id="guestsLbl" for="destinationTxt">Guests</label>
					</div>
				
				</div>
				
				<div class="row">
					
					<div class="form-inline">
						<div class="col-xs-8">
							<input class="form-control" type="number" placeholder="Adults">
						
							<input class="form-control" type="number" placeholder="Kids">
					</div>
						
					</div>
				
				</div>
				
				<div class="row">
					<div class="col-xs-4">
						<br>
						<input class="btn-default.active" type="button" value="search">
					</div>
					
				</div>
				
			
		
		</form>
  	
  	</div>
  
  
  
  </body>
  </html>