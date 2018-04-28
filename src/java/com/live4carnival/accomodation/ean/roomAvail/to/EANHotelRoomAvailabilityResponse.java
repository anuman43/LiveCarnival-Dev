/**
 * 
 */
package com.live4carnival.accomodation.ean.roomAvail.to;

import com.live4carnival.accomodation.ean.hotelList.po.EANHotelRoomResponse;

/**
 * @author JahLion
 *
 */
public class EANHotelRoomAvailabilityResponse {
	
	
	private String size;
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
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
	public String getDepatureDate() {
		return depatureDate;
	}
	public void setDepatureDate(String depatureDate) {
		this.depatureDate = depatureDate;
	}
	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	public String getHotelAddress() {
		return hotelAddress;
	}
	public void setHotelAddress(String hotelAddress) {
		this.hotelAddress = hotelAddress;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getHotelCity() {
		return hotelCity;
	}
	public void setHotelCity(String hotelCity) {
		this.hotelCity = hotelCity;
	}
	public String getHotelStateProvince() {
		return hotelStateProvince;
	}
	public void setHotelStateProvince(String hotelStateProvince) {
		this.hotelStateProvince = hotelStateProvince;
	}
	public String getHotelCountry() {
		return hotelCountry;
	}
	public void setHotelCountry(String hotelCountry) {
		this.hotelCountry = hotelCountry;
	}
	public Integer getNumberOfRoomsRequested() {
		return numberOfRoomsRequested;
	}
	public void setNumberOfRoomsRequested(Integer numberOfRoomsRequested) {
		this.numberOfRoomsRequested = numberOfRoomsRequested;
	}
	public String getCheckInInstructions() {
		return checkInInstructions;
	}
	public void setCheckInInstructions(String checkInInstructions) {
		this.checkInInstructions = checkInInstructions;
	}
	public String getSpecialCheckInInstructions() {
		return specialCheckInInstructions;
	}
	public void setSpecialCheckInInstructions(String specialCheckInInstructions) {
		this.specialCheckInInstructions = specialCheckInInstructions;
	}
	private Long hotelId;
	private String arrivalDate;
	private String depatureDate;
	private String hotelName;
	private String hotelAddress;
	private String address2;
	private String hotelCity;
	private String hotelStateProvince;
	private String hotelCountry;
	private Integer numberOfRoomsRequested;
	private String checkInInstructions;
	private String specialCheckInInstructions;
	private EANHotelRoomResponse []HotelRoomResponse;
	public EANHotelRoomResponse[] getHotelRoomResponse() {
		return HotelRoomResponse;
	}
	public void setHotelRoomResponse(EANHotelRoomResponse[] hotelRoomResponse) {
		HotelRoomResponse = hotelRoomResponse;
	}
	
	
}
