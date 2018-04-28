/**
 * 
 */
package com.live4carnival.accomodation.ean.hotelList.po;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author JahLion
 *
 */
public class EANHotelListSurcharges {
	
	private String size;
	private EANHotelListSurcharge Surcharge;
	
	@JsonProperty("@size")
	public String getSize() {
		return size;
	}
	@JsonProperty("@size")
	public void setSize(String size) {
		this.size = size;
	}
	@JsonProperty("Surcharge")
	public EANHotelListSurcharge getSurcharge() {
		return Surcharge;
	}
	@JsonProperty("Surcharge")
	public void setSurcharge(EANHotelListSurcharge surcharge) {
		Surcharge = surcharge;
	}

}
