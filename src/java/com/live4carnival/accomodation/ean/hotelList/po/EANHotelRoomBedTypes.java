/**
 * 
 */
package com.live4carnival.accomodation.ean.hotelList.po;

import com.live4carnival.accomodation.ean.roomAvail.to.EANHotelRoomBedType;

/**
 * @author JahLion
 *
 */
public class EANHotelRoomBedTypes {

		private String size;
		public String getSize() {
			return size;
		}
		public void setSize(String size) {
			this.size = size;
		}
		
		private EANHotelRoomBedType BedType;
		public EANHotelRoomBedType getBedType() {
			return BedType;
		}
		public void setBedType(EANHotelRoomBedType bedType) {
			BedType = bedType;
		}
}
