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
public class EANHotelListCharegeableRateInfo {
	
	private String averageBaseRate;
	private String averageRate;
	private String commissionableUsdTotal;
	private String currencyCode;
	private String maxNightlyRate;
	
	


	private String nightlyRateTotal;
	private String surchargeTotal;
	private String total;
	
	private EANHotelListNightlyRatesPerRoom NightlyRatesPerRoom;
	
	@JsonProperty("NightlyRatesPerRoom")
	public EANHotelListNightlyRatesPerRoom getNightlyRatesPerRoom() {
		return NightlyRatesPerRoom;
	}
	@JsonProperty("NightlyRatesPerRoom")
	public void setNightlyRatesPerRoom(EANHotelListNightlyRatesPerRoom nightlyRatesPerRoom) {
		NightlyRatesPerRoom = nightlyRatesPerRoom;
	}
	
	@JsonProperty("@averageBaseRate")
	public String getAverageBaseRate() {
		return averageBaseRate;
	}
	@JsonProperty("@averageBaseRate")
	public void setAverageBaseRate(String averageBaseRate) {
		this.averageBaseRate = averageBaseRate;
	}
	@JsonProperty("@averageRate")
	public String getAverageRate() {
		return averageRate;
	}
	@JsonProperty("@averageRate")
	public void setAverageRate(String averageRate) {
		this.averageRate = averageRate;
	}
	@JsonProperty("@commissionableUsdTotal")
	public String getCommissionableUsdTotal() {
		return commissionableUsdTotal;
	}
	@JsonProperty("@commissionableUsdTotal")
	public void setCommissionableUsdTotal(String commissionableUsdTotal) {
		this.commissionableUsdTotal = commissionableUsdTotal;
	}
	@JsonProperty("@currencyCode")
	public String getCurrencyCode() {
		return currencyCode;
	}
	@JsonProperty("@currencyCode")
	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}
	@JsonProperty("@maxNightlyRate")
	public String getMaxNightlyRate() {
		return maxNightlyRate;
	}
	@JsonProperty("@maxNightlyRate")
	public void setMaxNightlyRate(String maxNightlyRate) {
		this.maxNightlyRate = maxNightlyRate;
	}
	@JsonProperty("@nightlyRateTotal")
	public String getNightlyRateTotal() {
		return nightlyRateTotal;
	}
	@JsonProperty("@nightlyRateTotal")
	public void setNightlyRateTotal(String nightlyRateTotal) {
		this.nightlyRateTotal = nightlyRateTotal;
	}
	@JsonProperty("@surchargeTotal")
	public String getSurchargeTotal() {
		return surchargeTotal;
	}
	@JsonProperty("@surchargeTotal")
	public void setSurchargeTotal(String surchargeTotal) {
		this.surchargeTotal = surchargeTotal;
	}
	@JsonProperty("@total")
	public String getTotal() {
		return total;
	}
	@JsonProperty("@total")
	public void setTotal(String total) {
		this.total = total;
	}
	

	@JsonProperty("Surcharges")
	public EANHotelListSurcharges getSurcharges() {
		return Surcharges;
	}
	@JsonProperty("Surcharges")
	public void setSurcharges(EANHotelListSurcharges surcharges) {
		Surcharges = surcharges;
	}




	private EANHotelListSurcharges Surcharges;
	
}
