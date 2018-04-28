/**
 * 
 */
package com.live4carnival.accomodation.ean.hotelList.po;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author JahLion
 *
 */
public class EANRestHotelListResponse {
	
	private EANHotelListResponse HotelListResponse;

	@JsonProperty("HotelListResponse")
	public EANHotelListResponse getHotelListResponse() {
		return HotelListResponse;
	}
	
	@JsonProperty("HotelListResponse")
	public void setHotelListResponse(EANHotelListResponse hotelListResponse) {
		HotelListResponse = hotelListResponse;
	}

	

	

	

}
