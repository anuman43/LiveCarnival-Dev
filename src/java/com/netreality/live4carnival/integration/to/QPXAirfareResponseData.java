/**
 * @date Jul 1, 2015
 */
package com.netreality.live4carnival.integration.to;

import java.util.List;

import com.netreality.live4carnival.enums.QPXAirfareResponseEnum;

/**
 * @author ldurh516
 *
 * @date Jul 1, 2015
 *	
 */
public class QPXAirfareResponseData {
	
	public List<QPXAirfareResponseAirport> getAirport() {
		return airport;
	}

	public void setAirport(List<QPXAirfareResponseAirport> airport) {
		this.airport = airport;
	}

	public List<QPXAirfareResponseCity> getCity() {
		return city;
	}

	public void setCity(List<QPXAirfareResponseCity> city) {
		this.city = city;
	}

	public List<QPXAirfareResponseAircraftTO> getAircraft() {
		return aircraft;
	}

	public void setAircraft(List<QPXAirfareResponseAircraftTO> aircraft) {
		this.aircraft = aircraft;
	}

	
	public List<QPXAirfareResponseDataTax> getTax() {
		return tax;
	}

	public void setTax(List<QPXAirfareResponseDataTax> tax) {
		this.tax = tax;
	}

	public List<QPXAirfareResponseCarrier> getCarrier() {
		return carrier;
	}

	public void setCarrier(List<QPXAirfareResponseCarrier> carrier) {
		this.carrier = carrier;
	}

	private String kind;
	private List<QPXAirfareResponseAirport> airport;
	private List<QPXAirfareResponseCity> city;
	private List<QPXAirfareResponseAircraftTO> aircraft;
	private List<QPXAirfareResponseDataTax> tax;
	private List<QPXAirfareResponseCarrier> carrier;

	/**
	 * @return the kind
	 */
	public String getKind() {
		return QPXAirfareResponseEnum.tripData.getQpxTypeVal();
	}

	/**
	 * @param kind the kind to set
	 */
	public void setKind(String kind) {
		this.kind = kind;
	}

}
