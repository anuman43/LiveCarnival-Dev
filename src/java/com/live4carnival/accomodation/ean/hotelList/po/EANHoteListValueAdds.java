/**
 * 
 */
package com.live4carnival.accomodation.ean.hotelList.po;

import java.util.List;

/**
 * @author JahLion
 *
 */
public class EANHoteListValueAdds {

		private String size;
		public String getSize() {
			return size;
		}
		public void setSize(String size) {
			this.size = size;
		}
		
		public List<EANHotelListValueAdd> getValueAdd() {
			return ValueAdd;
		}
		public void setValueAdd(List<EANHotelListValueAdd> valueAdd) {
			ValueAdd = valueAdd;
		}

		private List<EANHotelListValueAdd> ValueAdd;
}
