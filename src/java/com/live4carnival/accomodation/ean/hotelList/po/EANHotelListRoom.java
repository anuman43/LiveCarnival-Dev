/**
 * 
 */
package com.live4carnival.accomodation.ean.hotelList.po;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author JahLion
 *
 */
public class EANHotelListRoom {
	
	private Integer numberOfAdults;
	private Integer numberOfChildren;
	private String rateKey;
	public Integer getNumberOfAdults() {
		return numberOfAdults;
	}
	public void setNumberOfAdults(Integer numberOfAdults) {
		this.numberOfAdults = numberOfAdults;
	}
	public Integer getNumberOfChildren() {
		return numberOfChildren;
	}
	public void setNumberOfChildren(Integer numberOfChildren) {
		this.numberOfChildren = numberOfChildren;
	}
	public String getRateKey() {
		return rateKey;
	}
	@JsonProperty("ChargeableNightlyRates")
	public List<EANHotelListChargeableNightlyRate> getChargeableNightlyRates() {
		return ChargeableNightlyRates;
	}
	@JsonProperty("ChargeableNightlyRates")
	public void setChargeableNightlyRates(List<EANHotelListChargeableNightlyRate> chargeableNightlyRates) {
		ChargeableNightlyRates = chargeableNightlyRates;
	}
	public void setRateKey(String rateKey) {
		this.rateKey = rateKey;
	}
	
	private List<EANHotelListChargeableNightlyRate> ChargeableNightlyRates;

}
