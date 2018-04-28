/**
 * 
 */
package com.live4carnival.accomodation.ean.roomAvail.to;

import com.live4carnival.accomodation.ean.hotelList.po.EANHotelListValueAdds;

/**
 * @author JahLion
 *
 */
public class EANHotelRoom {

	private String policy;
	public String getPolicy() {
		return policy;
	}
	public void setPolicy(String policy) {
		this.policy = policy;
	}
	public String getRateCode() {
		return rateCode;
	}
	public void setRateCode(String rateCode) {
		this.rateCode = rateCode;
	}
	public String getRoomTypeCode() {
		return roomTypeCode;
	}
	public void setRoomTypeCode(String roomTypeCode) {
		this.roomTypeCode = roomTypeCode;
	}
	public String getRateDescription() {
		return rateDescription;
	}
	public void setRateDescription(String rateDescription) {
		this.rateDescription = rateDescription;
	}
	public String getRoomTypeDescription() {
		return roomTypeDescription;
	}
	public void setRoomTypeDescription(String roomTypeDescription) {
		this.roomTypeDescription = roomTypeDescription;
	}
	public String getSupplierType() {
		return supplierType;
	}
	public void setSupplierType(String supplierType) {
		this.supplierType = supplierType;
	}
	public String getOtherInformation() {
		return otherInformation;
	}
	public void setOtherInformation(String otherInformation) {
		this.otherInformation = otherInformation;
	}
	public String getPropertyId() {
		return propertyId;
	}
	public void setPropertyId(String propertyId) {
		this.propertyId = propertyId;
	}
	public String getSmokingPreferences() {
		return smokingPreferences;
	}
	public void setSmokingPreferences(String smokingPreferences) {
		this.smokingPreferences = smokingPreferences;
	}
	public Integer getMinGuestAge() {
		return minGuestAge;
	}
	public void setMinGuestAge(Integer minGuestAge) {
		this.minGuestAge = minGuestAge;
	}
	public Integer getQuotedOccupancy() {
		return quotedOccupancy;
	}
	public void setQuotedOccupancy(Integer quotedOccupancy) {
		this.quotedOccupancy = quotedOccupancy;
	}
	public Integer getRateOccupancyPerRoom() {
		return rateOccupancyPerRoom;
	}
	public void setRateOccupancyPerRoom(Integer rateOccupancyPerRoom) {
		this.rateOccupancyPerRoom = rateOccupancyPerRoom;
	}
	public EANHotelRoomBedType[] getBedTypes() {
		return bedTypes;
	}
	public void setBedTypes(EANHotelRoomBedType[] bedTypes) {
		this.bedTypes = bedTypes;
	}
	public EANHotelListValueAdds getValueAdds() {
		return valueAdds;
	}
	public void setValueAdds(EANHotelListValueAdds valueAdds) {
		this.valueAdds = valueAdds;
	}
	private String rateCode;
	private String roomTypeCode;
	private String rateDescription;
	private String roomTypeDescription;
	private String supplierType;
	private String otherInformation;
	private String propertyId;
	private String smokingPreferences;
	private Integer minGuestAge;
	private Integer quotedOccupancy;
	private Integer rateOccupancyPerRoom;
	private EANHotelRoomBedType [] bedTypes;
	private EANHotelListValueAdds  valueAdds;
}
