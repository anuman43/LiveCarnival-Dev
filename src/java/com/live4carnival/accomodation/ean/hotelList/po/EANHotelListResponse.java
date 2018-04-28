package com.live4carnival.accomodation.ean.hotelList.po;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class EANHotelListResponse {
	
	private String customerSessionId;
	private Integer numberOfRoomsRequested;
	private Boolean moreResultsAvailable;
	
	
	@JsonProperty("customerSessionId")
	public String getCustomerSessionId() {
		return customerSessionId;
	}
	@JsonProperty("numberOfRoomsRequested")
	public Integer getNumberOfRoomsRequested() {
		return numberOfRoomsRequested;
	}
	@JsonProperty("moreResultsAvailable")
	public Boolean getMoreResultsAvailable() {
		return moreResultsAvailable;
	}
	@JsonProperty("cacheKey")
	public String getCacheKey() {
		return cacheKey;
	}
	@JsonProperty("cacheLocation")
	public String getCacheLocation() {
		return cacheLocation;
	}
	
	
	

	public EANCachedSupplierResponse getCachedSupplierResponse() {
		return cachedSupplierResponse;
	}




	private String cacheKey;
	private String cacheLocation;
	public EANCachedSupplierResponse cachedSupplierResponse;
	private EANHotelList HotelList;


	@JsonProperty("HotelList")
	public EANHotelList getHotelList() {
		return HotelList;
	}
	public void setCustomerSessionId(String customerSessionId) {
		this.customerSessionId = customerSessionId;
	}
	public void setNumberOfRoomsRequested(Integer numberOfRoomsRequested) {
		this.numberOfRoomsRequested = numberOfRoomsRequested;
	}
	public void setMoreResultsAvailable(Boolean moreResultsAvailable) {
		this.moreResultsAvailable = moreResultsAvailable;
	}
	public void setCacheKey(String cacheKey) {
		this.cacheKey = cacheKey;
	}
	public void setCacheLocation(String cacheLocation) {
		this.cacheLocation = cacheLocation;
	}
	public void setCachedSupplierResponse(EANCachedSupplierResponse cachedSupplierResponse) {
		this.cachedSupplierResponse = cachedSupplierResponse;
	}
	public void setHotelList(EANHotelList hotelList) {
		HotelList = hotelList;
	}
	

}
