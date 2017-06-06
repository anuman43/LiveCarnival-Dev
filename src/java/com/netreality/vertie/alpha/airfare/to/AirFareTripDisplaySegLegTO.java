package com.netreality.vertie.alpha.airfare.to;

public class AirFareTripDisplaySegLegTO {
	
	
	public String getOriginAirport() {
		return originAirport;
	}
	public void setOriginAirport(String originAirport) {
		this.originAirport = originAirport;
	}
	public String getDestinationAirport() {
		return destinationAirport;
	}
	public void setDestinationAirport(String destinationAirport) {
		this.destinationAirport = destinationAirport;
	}
	public String getDepatureTime() {
		return depatureTime;
	}
	public void setDepatureTime(String depatureTime) {
		this.depatureTime = depatureTime;
	}
	public String getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	
	private String originAirport;
	private String destinationAirport;
	private String depatureTime;
	private String arrivalTime;
	private String tripDuration;
	
	
	public String getTripDuration() {
		return tripDuration;
		//return 10;
	}
	public void setTripDuration(Integer segTripDuration) {
		this.tripDuration = String.valueOf(segTripDuration);
	}

}
