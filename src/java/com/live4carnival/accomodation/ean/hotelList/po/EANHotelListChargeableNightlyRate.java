/**
 * 
 */
package com.live4carnival.accomodation.ean.hotelList.po;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author JahLion
 *
 */
public class EANHotelListChargeableNightlyRate {
	
	
	private Boolean promo;
	private String rate;
	private String baseRate;
	private String fenced;
	
	@JsonProperty("@promo")
	public Boolean getPromo() {
		return promo;
	}
	@JsonProperty("@promo")
	public void setPromo(Boolean promo) {
		this.promo = promo;
	}
	@JsonProperty("rate")
	public String getRate() {
		return rate;
	}
	@JsonProperty("@rate")
	public void setRate(String rate) {
		this.rate = rate;
	}
	@JsonProperty("@baseRate")
	public String getBaseRate() {
		return baseRate;
	}
	@JsonProperty("@baseRate")
	public void setBaseRate(String baseRate) {
		this.baseRate = baseRate;
	}
	
	@JsonProperty("@fenced")
	public String getFenced() {
		return fenced;
	}
	@JsonProperty("@fenced")
	public void setFenced(String fenced) {
		this.fenced = fenced;
	}

}
