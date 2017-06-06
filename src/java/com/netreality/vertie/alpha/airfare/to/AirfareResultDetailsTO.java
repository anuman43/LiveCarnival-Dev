package com.netreality.vertie.alpha.airfare.to;

import com.netreality.live4carnival.enums.airfare.AirTravelLegEnum;

public class AirfareResultDetailsTO {
	
	private AirTravelLegEnum legDirection;
	public AirTravelLegEnum getLegDirection() {
		return legDirection;
	}
	public void setLegDirection(AirTravelLegEnum legDirection) {
		this.legDirection = legDirection;
	}
	public String getPlaneModelInfo() {
		return planeModelInfo;
	}
	public void setPlaneModelInfo(String planeModelInfo) {
		this.planeModelInfo = planeModelInfo;
	}
	public Boolean getInflightWiFi() {
		return inflightWiFi;
	}
	public void setInflightWiFi(Boolean inflightWiFi) {
		this.inflightWiFi = inflightWiFi;
	}
	public Boolean getSeatClassfication() {
		return seatClassfication;
	}
	public void setSeatClassfication(Boolean seatClassfication) {
		this.seatClassfication = seatClassfication;
	}
	public Boolean getFoodForPurchase() {
		return foodForPurchase;
	}
	public void setFoodForPurchase(Boolean foodForPurchase) {
		this.foodForPurchase = foodForPurchase;
	}
	private String planeModelInfo;
	private Boolean inflightWiFi;
	private Boolean seatClassfication;
	private Boolean foodForPurchase;

}
