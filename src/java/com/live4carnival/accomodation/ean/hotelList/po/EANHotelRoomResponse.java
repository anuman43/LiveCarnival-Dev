package com.live4carnival.accomodation.ean.hotelList.po;

public class EANHotelRoomResponse {
	
	private EANHotelRoomBedTypes []BedTypes;
	public EANHotelRoomBedTypes[] getBedTypes() {
		return BedTypes;
	}
	public void setBedTypes(EANHotelRoomBedTypes[] bedTypes) {
		BedTypes = bedTypes;
	}
	public Integer getRateCode() {
		return rateCode;
	}
	public void setRateCode(Integer rateCode) {
		this.rateCode = rateCode;
	}
	public Integer getRoomTypeCode() {
		return roomTypeCode;
	}
	public void setRoomTypeCode(Integer roomTypeCode) {
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
	public Integer getPropertyId() {
		return propertyId;
	}
	public void setPropertyId(Integer propertyId) {
		this.propertyId = propertyId;
	}
	private Integer rateCode;
	public EANHotelListRateInfo[] getRateInfos() {
		return RateInfos;
	}
	public void setRateInfos(EANHotelListRateInfo[] rateInfos) {
		RateInfos = rateInfos;
	}
	public EANHotelListValueAdd[] getValueAdds() {
		return ValueAdds;
	}
	public void setValueAdds(EANHotelListValueAdd[] valueAdds) {
		ValueAdds = valueAdds;
	}
	public String getDeepLink() {
		return deepLink;
	}
	public void setDeepLink(String deepLink) {
		this.deepLink = deepLink;
	}
	private Integer roomTypeCode;
	private String rateDescription;
	private String roomTypeDescription;
	private String supplierType;
	private Integer propertyId;
	private EANHotelListRateInfo []RateInfos;
	private EANHotelListValueAdd []ValueAdds;
	private String deepLink;

}
