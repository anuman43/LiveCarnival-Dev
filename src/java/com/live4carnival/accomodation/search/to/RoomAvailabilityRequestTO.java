/**
 * 
 */
package com.live4carnival.accomodation.search.to;

import com.live4carnival.accomodation.ean.hotelList.po.EANHotelListRoomGroup;

/**
 * @author JahLion
 *
 */
public class RoomAvailabilityRequestTO {
	
	private Long hotelId;
	private String arrivalDate;
	private String departureDate;
	private Integer roomNumAdults;
	private Integer roomNumChil;
	private String roomChildAges;
	private String roomTypeCode;
	private EANHotelListRoomGroup roomGroup;
	private String rateCode;
	private Boolean includeRateDetails;
	private Boolean includeRoomImages;
	private Boolean includeHotelFeeBreakdown;
	private Boolean fullRefundable;
	private String options;
	private Integer numberOfBedrooms;
	private String supplierType;
	private String rateKey;
	public Long getHotelId() {
		return hotelId;
	}
	public void setHotelId(Long hotelId) {
		this.hotelId = hotelId;
	}
	public String getArrivalDate() {
		return arrivalDate;
	}
	public void setArrivalDate(String arrivalDate) {
		this.arrivalDate = arrivalDate;
	}
	public String getDepartureDate() {
		return departureDate;
	}
	public void setDepartureDate(String departureDate) {
		this.departureDate = departureDate;
	}
	public Integer getRoomNumAdults() {
		return roomNumAdults;
	}
	public void setRoomNumAdults(Integer roomNumAdults) {
		this.roomNumAdults = roomNumAdults;
	}
	public Integer getRoomNumChil() {
		return roomNumChil;
	}
	public void setRoomNumChil(Integer roomNumChil) {
		this.roomNumChil = roomNumChil;
	}
	public String getRoomChildAges() {
		return roomChildAges;
	}
	public void setRoomChildAges(String roomChildAges) {
		this.roomChildAges = roomChildAges;
	}
	public String getRoomTypeCode() {
		return roomTypeCode;
	}
	public void setRoomTypeCode(String roomTypeCode) {
		this.roomTypeCode = roomTypeCode;
	}
	public EANHotelListRoomGroup getRoomGroup() {
		return roomGroup;
	}
	public void setRoomGroup(EANHotelListRoomGroup roomGroup) {
		this.roomGroup = roomGroup;
	}
	public String getRateCode() {
		return rateCode;
	}
	public void setRateCode(String rateCode) {
		this.rateCode = rateCode;
	}
	public Boolean getIncludeRateDetails() {
		return includeRateDetails;
	}
	public void setIncludeRateDetails(Boolean includeRateDetails) {
		this.includeRateDetails = includeRateDetails;
	}
	public Boolean getIncludeRoomImages() {
		return includeRoomImages;
	}
	public void setIncludeRoomImages(Boolean includeRoomImages) {
		this.includeRoomImages = includeRoomImages;
	}
	public Boolean getIncludeHotelFeeBreakdown() {
		return includeHotelFeeBreakdown;
	}
	public void setIncludeHotelFeeBreakdown(Boolean includeHotelFeeBreakdown) {
		this.includeHotelFeeBreakdown = includeHotelFeeBreakdown;
	}
	public Boolean getFullRefundable() {
		return fullRefundable;
	}
	public void setFullRefundable(Boolean fullRefundable) {
		this.fullRefundable = fullRefundable;
	}
	public String getOptions() {
		return options;
	}
	public void setOptions(String options) {
		this.options = options;
	}
	public Integer getNumberOfBedrooms() {
		return numberOfBedrooms;
	}
	public void setNumberOfBedrooms(Integer numberOfBedrooms) {
		this.numberOfBedrooms = numberOfBedrooms;
	}
	public String getSupplierType() {
		return supplierType;
	}
	public void setSupplierType(String supplierType) {
		this.supplierType = supplierType;
	}
	public String getRateKey() {
		return rateKey;
	}
	public void setRateKey(String rateKey) {
		this.rateKey = rateKey;
	}

}
