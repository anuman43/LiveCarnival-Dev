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
public class EANHotelListValueAdds {
	
	private String size;
	private EANHotelListValueAdd ValueAdd;
	
	@JsonProperty("ValueAdd")
	public EANHotelListValueAdd getValueAdd() {
		return ValueAdd;
	}
	@JsonProperty("ValueAdd")
	public void setValueAdd(EANHotelListValueAdd valueAdd) {
		ValueAdd = valueAdd;
	}
	@JsonProperty("@size")
	public String getSize() {
		return size;
	}
	@JsonProperty("@size")
	public void setSize(String size) {
		this.size = size;
	}
	
	

}
