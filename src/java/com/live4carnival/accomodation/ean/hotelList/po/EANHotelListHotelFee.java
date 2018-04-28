package com.live4carnival.accomodation.ean.hotelList.po;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EANHotelListHotelFee {
	
	private String amount;
	private String description;
	
	@JsonProperty("@amount")
	public String getAmount() {
		return amount;
	}
	@JsonProperty("@amount")
	public void setAmount(String amount) {
		this.amount = amount;
	}
	@JsonProperty("@description")
	public String getDescription() {
		return description;
	}
	@JsonProperty("@description")
	public void setDescription(String description) {
		this.description = description;
	}

}
