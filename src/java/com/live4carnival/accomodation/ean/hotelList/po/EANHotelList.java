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
public class EANHotelList {
	
	@JsonProperty("@size")
	public String getSize() {
		return size;
	}
	@JsonProperty("@size")
	public void setSize(String size) {
		this.size = size;
	}
	@JsonProperty("@activePropertyCount")
	public String getActivePropertyCount() {
		return activePropertyCount;
	}
	@JsonProperty("@activePropertyCount")
	public void setActivePropertyCount(String activePropertyCount) {
		this.activePropertyCount = activePropertyCount;
	}
	
	private String size;
	private String activePropertyCount;
	private EANHotelSummary []HotelSummary;
	
	@JsonProperty("HotelSummary")
	public EANHotelSummary[] getHotelSummary() {
		return HotelSummary;
	}
	@JsonProperty("HotelSummary")
	public void setHotelSummary(EANHotelSummary[] hotelSummary) {
		HotelSummary = hotelSummary;
	}
	
	
	

}
