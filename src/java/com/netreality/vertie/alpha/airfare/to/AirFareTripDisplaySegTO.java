package com.netreality.vertie.alpha.airfare.to;

import java.util.List;

public class AirFareTripDisplaySegTO {
	
	private String bookingCode;
	public String getBookingCode() {
		return bookingCode;
	}
	public void setBookingCode(String bookingCode) {
		this.bookingCode = bookingCode;
	}
	public List<AirFareTripDisplaySegLegTO> getSegLegList() {
		return segLegList;
	}
	public void setSegLegList(List<AirFareTripDisplaySegLegTO> segLegList) {
		this.segLegList = segLegList;
	}
	List<AirFareTripDisplaySegLegTO> segLegList;
	private String airCarrier;
	public String getAirCarrier() {
		return airCarrier;
	}
	public void setAirCarrier(String airCarrier) {
		this.airCarrier = airCarrier;
	}
}
