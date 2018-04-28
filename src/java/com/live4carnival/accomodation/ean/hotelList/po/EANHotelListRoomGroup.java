/**
 * 
 */
package com.live4carnival.accomodation.ean.hotelList.po;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author JahLion
 *
 */
public class EANHotelListRoomGroup {

	

		private EANHotelListRoom Room;
		@JsonProperty("Room")
		public EANHotelListRoom getRoom() {
			return Room;
		}
		@JsonProperty("Room")
		public void setRoom(EANHotelListRoom room) {
			Room = room;
		}
	
	
}
