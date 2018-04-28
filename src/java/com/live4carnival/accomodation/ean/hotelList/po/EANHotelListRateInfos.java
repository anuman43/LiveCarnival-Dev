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
public class EANHotelListRateInfos {

	private String size;
	
	@JsonProperty("@size")
	public String getSize() {
		return size;
	}
	@JsonProperty("@size")
	public void setSize(String size) {
		this.size = size;
	}
	
	private EANHotelListRateInfo RateInfo;

	@JsonProperty("RateInfo")
	public EANHotelListRateInfo getRateInfo() {
		return RateInfo;
	}
	@JsonProperty("RateInfo")
	public void setRateInfo(EANHotelListRateInfo rateInfo) {
		RateInfo = rateInfo;
	}

	

	
	
}
