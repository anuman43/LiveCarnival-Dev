package com.live4carnival.accomodation.ean.hotelList.po;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EANHotelSummary {
	
	private String order;
	private String ubsScore;
	@JsonProperty("@ubsScore")
	public String getUbsScore() {
		return ubsScore;
	}
	@JsonProperty("@ubsScore")
	public void setUbsScore(String ubsScore) {
		this.ubsScore = ubsScore;
	}
	private Integer hotelId;
	private String name;
	private String address1;
	private String address2;
	private String city;
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	private String stateProvinceCode;
	private String postalCode;
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	private String countryCode;
	private String airportCode;
	private String supplierType;
	private Integer propertyCategory;
	private Integer hotelRating;
	private String hotelRatingDisplay;
	private Integer confidenceRating;
	private Integer amenityMask;
	private Integer tripAdvisorRating;
	private Integer tripAdvisorReviewCount;
	private String tripAdvisorRatingUrl;
	private String locationDescription;
	private String shortDescription;
	private Integer highRate;
	private Integer lowRate;
	private String rateCurrencyCode;
	private Integer latitude;
	private Integer longitude;
	private Integer proximityDistance;
	private String proximityUnit;
	private Boolean hotelInDestination;
	private String thumbNailUrl;
	private String deepLink;
	private EANHotelRoomRateDetailsList RoomRateDetailsList;
	
	
	
	
	@JsonProperty("RoomRateDetailsList")
	public EANHotelRoomRateDetailsList getRoomRateDetailsList() {
		return RoomRateDetailsList;
	}
	@JsonProperty("RoomRateDetailsList")
	public void setRoomRateDetailsList(EANHotelRoomRateDetailsList roomRateDetailsList) {
		RoomRateDetailsList = roomRateDetailsList;
	}
	public Boolean getHotelInDestination() {
		return hotelInDestination;
	}
	public void setHotelInDestination(Boolean hotelInDestination) {
		this.hotelInDestination = hotelInDestination;
	}
	
	@JsonProperty("@order")
	public String getOrder() {
		return order;
	}
	@JsonProperty("@order")
	public void setOrder(String order) {
		this.order = order;
	}
	
	public Integer getHotelId() {
		return hotelId;
	}
	public void setHotelId(Integer hotelId) {
		this.hotelId = hotelId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getStateProvinceCode() {
		return stateProvinceCode;
	}
	public void setStateProvinceCode(String stateProvinceCode) {
		this.stateProvinceCode = stateProvinceCode;
	}
	/*public Integer getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(Integer postalCode) {
		this.postalCode = postalCode;
	}
	*/
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public String getAirportCode() {
		return airportCode;
	}
	public void setAirportCode(String airportCode) {
		this.airportCode = airportCode;
	}
	public String getSupplierType() {
		return supplierType;
	}
	public void setSupplierType(String supplierType) {
		this.supplierType = supplierType;
	}
	public Integer getPropertyCategory() {
		return propertyCategory;
	}
	public void setPropertyCategory(Integer propertyCategory) {
		this.propertyCategory = propertyCategory;
	}
	public Integer getHotelRating() {
		return hotelRating;
	}
	public void setHotelRating(Integer hotelRating) {
		this.hotelRating = hotelRating;
	}
	public String getHotelRatingDisplay() {
		return hotelRatingDisplay;
	}
	public void setHotelRatingDisplay(String hotelRatingDisplay) {
		this.hotelRatingDisplay = hotelRatingDisplay;
	}
	public Integer getConfidenceRating() {
		return confidenceRating;
	}
	public void setConfidenceRating(Integer confidenceRating) {
		this.confidenceRating = confidenceRating;
	}
	public Integer getAmenityMask() {
		return amenityMask;
	}
	public void setAmenityMask(Integer amenityMask) {
		this.amenityMask = amenityMask;
	}
	public Integer getTripAdvisorRating() {
		return tripAdvisorRating;
	}
	public void setTripAdvisorRating(Integer tripAdvisorRating) {
		this.tripAdvisorRating = tripAdvisorRating;
	}
	public Integer getTripAdvisorReviewCount() {
		return tripAdvisorReviewCount;
	}
	public void setTripAdvisorReviewCount(Integer tripAdvisorReviewCount) {
		this.tripAdvisorReviewCount = tripAdvisorReviewCount;
	}
	public String getTripAdvisorRatingUrl() {
		return tripAdvisorRatingUrl;
	}
	public void setTripAdvisorRatingUrl(String tripAdvisorRatingUrl) {
		this.tripAdvisorRatingUrl = tripAdvisorRatingUrl;
	}
	public String getLocationDescription() {
		return locationDescription;
	}
	public void setLocationDescription(String locationDescription) {
		this.locationDescription = locationDescription;
	}
	public String getShortDescription() {
		return shortDescription;
	}
	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}
	public Integer getHighRate() {
		return highRate;
	}
	public void setHighRate(Integer highRate) {
		this.highRate = highRate;
	}
	public Integer getLowRate() {
		return lowRate;
	}
	public void setLowRate(Integer lowRate) {
		this.lowRate = lowRate;
	}
	public String getRateCurrencyCode() {
		return rateCurrencyCode;
	}
	public void setRateCurrencyCode(String rateCurrencyCode) {
		this.rateCurrencyCode = rateCurrencyCode;
	}
	public Integer getLatitude() {
		return latitude;
	}
	public void setLatitude(Integer latitude) {
		this.latitude = latitude;
	}
	
	public Integer getLongitude() {
		return longitude;
	}
	public void setLongitude(Integer longitude) {
		this.longitude = longitude;
	}
	public Integer getProximityDistance() {
		return proximityDistance;
	}
	public void setProximityDistance(Integer proximityDistance) {
		this.proximityDistance = proximityDistance;
	}
	public String getProximityUnit() {
		return proximityUnit;
	}
	public void setProximityUnit(String proximityUnit) {
		this.proximityUnit = proximityUnit;
	}
	@JsonProperty("hotelInDestination")
	public Boolean getHotelDestination() {
		return hotelInDestination;
	}
	@JsonProperty("hotelInDestination")
	public void setHotelDestination(Boolean hotelDestination) {
		this.hotelInDestination = hotelDestination;
	}
	public String getThumbNailUrl() {
		return thumbNailUrl;
	}
	public void setThumbNailUrl(String thumbNailUrl) {
		this.thumbNailUrl = thumbNailUrl;
	}
	public String getDeepLink() {
		return deepLink;
	}
	public void setDeepLink(String deepLink) {
		this.deepLink = deepLink;
	}
	
	

}
