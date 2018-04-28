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
public class EANHotelListNightlyRatesPerRoom {
	
	private String size;
	private List<EANHotelListNightlyRate> NightlyRate;

	@JsonProperty("@size")
	public String getSize() {
		return size;
	}
	@JsonProperty("@size")
	public void setSize(String size) {
		this.size = size;
	}
	@JsonProperty("NightlyRate")
	public List<EANHotelListNightlyRate> getNightlyRate() {
		return NightlyRate;
	}
	@JsonProperty("NightlyRate")
	public void setNightlyRate(List<EANHotelListNightlyRate> nightlyRate) {
		NightlyRate = nightlyRate;
	}
}
