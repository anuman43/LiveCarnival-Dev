/**
 * @date Jun 19, 2015
 */
package com.netreality.live4carnival.integration.to;

import java.util.List;

import com.netreality.live4carnival.enums.QPXAirfareResponseEnum;

/**
 * @author ldurh516
 *
 * @date Jun 19, 2015
 *	
 */
public class QPXAifareResponseTripData {
	
	private String kind;
	private List<QPXAirfareResponseTripOption> tripOption;
	private QPXAirfareResponseAirport airport;
	private QPXAirfareResponseCity city;
	private QPXAirfareResponseAircraftTO aircraft;
	private QPXAirfareResponseDataTax tax;
	private QPXAirfareResponseCarrier carrier;
	/**
	 * @return the airport
	 */
	public QPXAirfareResponseAirport getAirport() {
		return airport;
	}
	/**
	 * @param airport the airport to set
	 */
	public void setAirport(QPXAirfareResponseAirport airport) {
		this.airport = airport;
	}
	/**
	 * @return the city
	 */
	public QPXAirfareResponseCity getCity() {
		return city;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(QPXAirfareResponseCity city) {
		this.city = city;
	}
	/**
	 * @return the aircraft
	 */
	public QPXAirfareResponseAircraftTO getAircraft() {
		return aircraft;
	}
	/**
	 * @param aircraft the aircraft to set
	 */
	public void setAircraft(QPXAirfareResponseAircraftTO aircraft) {
		this.aircraft = aircraft;
	}
	
	/**
	 * @return the carrier
	 */
	public QPXAirfareResponseCarrier getCarrier() {
		return carrier;
	}
	/**
	 * @param carrier the carrier to set
	 */
	public void setCarrier(QPXAirfareResponseCarrier carrier) {
		this.carrier = carrier;
	}
	/**
	 * @return the kind
	 */
	public String getKind() {
		return QPXAirfareResponseEnum.tripAirportData.getQpxTypeVal();
	}
	/**
	 * @param kind the kind to set
	 */
	public void setKind(String kind) {
		this.kind = kind;
	}

}
