<%@taglib prefix="acc" tagdir="/WEB-INF/tags" %>

	<div class="row"><br></div>
	<div class="row"><br></div>
	<div class="row"><br></div>	
    <div class="row">
    	<div class="col-md-3"></div>
    	<div class="col-md-6">
		<form action="${baseURL}/Carnivate/submitTravelSearch"
			name="travelData" method="post">

			<div class="form-inline">
				<div class="form-group">
					<label class="sr-only" for="exampleInputEmail3">From</label> <input
						type="text" class="form-control" id="departTxtInput"
						placeholder="From" name="fromAirport">
				</div>
				<div class="form-group">
					<label class="sr-only" for="exampleInputPassword3">To</label> <input
						type="text" class="form-control" id="destinationTxt"
						placeholder="To" name="toAirport">
				</div>
			</div>
			<div class="row">
				<br>
			</div>
			<div class="form-inline">
				<div class="form-group">
					<label class="sr-only" for="exampleInputEmail3">Date From</label> <input
						type="date" class="form-control" id="travelFromDate"
						placeholder="From Date" name="fromDate">
				</div>
				<div class="form-group">
					<label class="sr-only" for="exampleInputPassword3">Date To</label>
					<input type="date" class="form-control" id="exampleInputPassword3"
						placeholder="To Date" name="toDate">
				</div>
			</div>
			<div class="row">
				<br>
			</div>
			<div class="form-inline">
				<div class="form-group">
					<select class="form-control" name="adultPassengers">
						<option value="1">1 Adult</option>
						<option value="2">2 Adults</option>
						<option value="3">3 Adults</option>
						<option value="4">4 Adults</option>
						<option value="5">5 Adults</option>
						<option value="6">6 Adults</option>
					</select>
				</div>
			</div>
			<div class="form-group">
				<select class="form-control" name="kidPassengers">
					<option value="0">0 Kids(under 14)</option>
					<option value="1">1 Kid(under 14)</option>
					<option value="2">2 Kids(under 14)</option>
					<option value="3">3 Kids(under 14)</option>
					<option value="4">4 Kids(under 14)</option>
					<option value="5">5 Kids(under 14)</option>
					<option value="6">6 Kids(under 14)</option>
				</select>
			</div>
			<div class="form-group">
				<select class="form-control" name="infantPassengers">
					<option value="0">0 Lap Infants(under 2)</option>
					<option value="1">1 Lap Infants(under 2)</option>
				</select>
			</div>
			<div class="row">
				<br>
			</div>
			<div class="form-group">
				<input class="btn btn-default" type="submit" value="Submit">
			</div>

		</form>
	</div>
    
    <div class="col-md-3"></div>
    </div>
    </div>
    
	
	