package com.netreality.vertie.alpha.airfare.to;

/**
 * 
 * @author JahLion
 * Mirrors a trip option
 */

public class AirfareResultDisplayTO {
	
	private String airCarrier;
	public String getAirCarrier() {
		return airCarrier;
	}
	public void setAirCarrier(String airCarrier) {
		this.airCarrier = airCarrier;
	}
	public String getFlightCost() {
		return flightCost;
	}
	public void setFlightCost(String flightCost) {
		this.flightCost = flightCost;
	}
	
	public String getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}
	public String getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	public String getFlightDuration() {
		return flightDuration;
	}
	public void setFlightDuration(String flightDuration) {
		this.flightDuration = flightDuration;
	}
	private String flightCost;
	private Integer routeStops;
	public Integer getRouteStops() {
		return routeStops;
	}
	public void setRouteStops(Integer routeStops) {
		this.routeStops = routeStops;
	}
	private String departureTime;
	private String arrivalTime;
	private String flightDuration;
	private Boolean isRoundTrip;
	public Boolean getIsRoundTrip() {
		return isRoundTrip;
	}
	public void setIsRoundTrip(Boolean isRoundTrip) {
		this.isRoundTrip = isRoundTrip;
	}
	private AirfareResultDetailsTO flightDetails;
	public AirfareResultDetailsTO getFlightDetails() {
		return flightDetails;
	}
	public void setFlightDetails(AirfareResultDetailsTO flightDetails) {
		this.flightDetails = flightDetails;
	}
}
