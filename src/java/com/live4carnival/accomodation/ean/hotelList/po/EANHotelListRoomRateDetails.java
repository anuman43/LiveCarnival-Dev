/**
 * 
 */
package com.live4carnival.accomodation.ean.hotelList.po;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author JahLion
 *
 */
public class EANHotelListRoomRateDetails {
	
	
	@JsonProperty("ValueAdds")
	public EANHotelListValueAdds getValueAdds() {
		return ValueAdds;
	}
	@JsonProperty("ValueAdds")
	public void setValueAdds(EANHotelListValueAdds valueAdds) {
		ValueAdds = valueAdds;
	}
	private Integer roomTypeCode;
	private Integer rateCode;
	private Integer maxRoomOccupancy;
	private Integer quotedRoomOccupancy;
	private Integer minGuestAge;
	private String roomDescription;
	
	@JsonProperty("quotedRoomOccupancy")
	public Integer getQuotedRoomOccupancy() {
		return quotedRoomOccupancy;
	}
	@JsonProperty("quotedRoomOccupancy")
	public void setQuotedRoomOccupancy(Integer quotedRoomOccupancy) {
		this.quotedRoomOccupancy = quotedRoomOccupancy;
	}
	
	public String getRoomDescription() {
		return roomDescription;
	}
	public void setRoomDescription(String roomDescription) {
		this.roomDescription = roomDescription;
	}
	private Boolean propertyAvailable;
	private Boolean propertyRestricted;
	private Integer expediaPropertyId;
	private EANHotelListRateInfos RateInfos;
	private EANHotelListValueAdds ValueAdds;
	
	@JsonProperty("RateInfos")
	public EANHotelListRateInfos getRateInfos() {
		return RateInfos;
	}
	@JsonProperty("RateInfos")
	public void setRateInfos(EANHotelListRateInfos rateInfos) {
		RateInfos = rateInfos;
	}
	@JsonProperty("roomTypeCode")
	public Integer getRoomTypeCode() {
		return roomTypeCode;
	}
	@JsonProperty("roomTypeCode")
	public void setRoomTypeCode(Integer roomTypeCode) {
		this.roomTypeCode = roomTypeCode;
	}
	@JsonProperty("rateCode")
	public Integer getRateCode() {
		return rateCode;
	}
	@JsonProperty("rateCode")
	public void setRateCode(Integer rateCode) {
		this.rateCode = rateCode;
	}
	@JsonProperty("maxRoomOccupancy")
	public Integer getMaxRoomOccupancy() {
		return maxRoomOccupancy;
	}
	@JsonProperty("maxRoomOccupancy")
	public void setMaxRoomOccupancy(Integer maxRoomOccupancy) {
		this.maxRoomOccupancy = maxRoomOccupancy;
	}
	
	@JsonProperty("minGuestAge")
	public Integer getMinGuestAge() {
		return minGuestAge;
	}
	@JsonProperty("minGuestAge")
	public void setMinGuestAge(Integer minGuestAge) {
		this.minGuestAge = minGuestAge;
	}
	
	@JsonProperty("propertyAvailable")
	public Boolean getPropertyAvailable() {
		return propertyAvailable;
	}
	@JsonProperty("propertyAvailable")
	public void setPropertyAvailable(Boolean propertyAvailable) {
		this.propertyAvailable = propertyAvailable;
	}
	@JsonProperty("propertyRestricted")
	public Boolean getPropertyRestricted() {
		return propertyRestricted;
	}
	@JsonProperty("propertyRestricted")
	public void setPropertyRestricted(Boolean propertyRestricted) {
		this.propertyRestricted = propertyRestricted;
	}
	@JsonProperty("expediaPropertyId")
	public Integer getExpediaPropertyId() {
		return expediaPropertyId;
	}
	@JsonProperty("expediaPropertyId")
	public void setExpediaPropertyId(Integer expediaPropertyId) {
		this.expediaPropertyId = expediaPropertyId;
	}
}
