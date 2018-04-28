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
public class EANHotelListRateInfo {
	
	@JsonProperty("@priceBreakdown")
	public String getPriceBreakdown() {
		return priceBreakdown;
	}
	@JsonProperty("@priceBreakdown")
	public void setPriceBreakdown(String priceBreakdown) {
		this.priceBreakdown = priceBreakdown;
	}
	@JsonProperty("@promo")
	public String getPromo() {
		return promo;
	}
	@JsonProperty("@promo")
	public void setPromo(String promo) {
		this.promo = promo;
	}
	@JsonProperty("@rateChange")
	public String getRateChange() {
		return rateChange;
	}
	@JsonProperty("@rateChange")
	public void setRateChange(String rateChange) {
		this.rateChange = rateChange;
	}
	public Boolean getNonRefundable() {
		return nonRefundable;
	}
	public void setNonRefundable(Boolean nonRefundable) {
		this.nonRefundable = nonRefundable;
	}
	public String getRateType() {
		return rateType;
	}
	public void setRateType(String rateType) {
		this.rateType = rateType;
	}
	public Integer getCurrentAllotment() {
		return currentAllotment;
	}
	public void setCurrentAllotment(Integer currentAllotment) {
		this.currentAllotment = currentAllotment;
	}
	private String priceBreakdown;
	
	@JsonProperty("ChargeableRateInfo")
	public EANHotelListCharegeableRateInfo getChargeableRateInfo() {
		return ChargeableRateInfo;
	}
	@JsonProperty("ChargeableRateInfo")
	public void setChargeableRateInfo(EANHotelListCharegeableRateInfo chargeableRateInfo) {
		ChargeableRateInfo = chargeableRateInfo;
	}
	private String promo;
	
	private String rateChange;
	private Boolean nonRefundable;
	private String rateType;
	private Integer currentAllotment;
	private EANHotelListCharegeableRateInfo ChargeableRateInfo;
	private EANHotelListHotelFees HotelFees;
	private EANHotelListRoomGroup RoomGroup;
	
	@JsonProperty("RoomGroup")
	public EANHotelListRoomGroup getRoomGroup() {
		return RoomGroup;
	}
	@JsonProperty("RoomGroup")
	public void setRoomGroup(EANHotelListRoomGroup roomGroup) {
		RoomGroup = roomGroup;
	}
	@JsonProperty("HotelFees")
	public EANHotelListHotelFees getHotelFees() {
		return HotelFees;
	}
	@JsonProperty("HotelFees")
	public void setHotelFees(EANHotelListHotelFees hotelFees) {
		HotelFees = hotelFees;
	}

}
