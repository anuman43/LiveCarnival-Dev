/**
 * 
 */
package com.live4carnival.accomodation.ean.hotelList.po;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author JahLion
 *
 */
public class EANHotelListSurcharge {
	
	@JsonProperty("@type")
	public String getType() {
		return type;
	}
	@JsonProperty("@type")
	public void setType(String type) {
		this.type = type;
	}
	@JsonProperty("@amount")
	public String getAmount() {
		return amount;
	}
	@JsonProperty("@amount")
	public void setAmount(String amount) {
		this.amount = amount;
	}
	private String type;
	private String amount;

}
