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
public class EANHotelListHotelFees {

	private EANHotelListHotelFee HotelFee;
	private String size;

	@JsonProperty("@size")
	public String getSize() {
		return size;
	}
	@JsonProperty("@size")
	public void setSize(String size) {
		this.size = size;
	}
	@JsonProperty("HotelFee")
	public EANHotelListHotelFee getHotelFee() {
		return HotelFee;
	}
	@JsonProperty("HotelFee")
	public void setHotelFee(EANHotelListHotelFee hotelFee) {
		HotelFee = hotelFee;
	}
	
}
