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
public class EANHotelRoomRateDetailsList {
	
	private EANHotelListRoomRateDetails RoomRateDetails;
	
	@JsonProperty("RoomRateDetails")
	public EANHotelListRoomRateDetails getRoomRateDetails() {
		return RoomRateDetails;
	}
	@JsonProperty("RoomRateDetails")
	public void setRoomRateDetails(EANHotelListRoomRateDetails roomRateDetails) {
		RoomRateDetails = roomRateDetails;
	}

	

}
