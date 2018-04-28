/**
 * 
 */
package com.live4carnival.accomodation.search.to;

/**
 * @author JahLion
 *
 */
public class AcommodationRequestTO {
	
	private String destinationCountry;
	public String getDestinationCountry() {
		return destinationCountry;
	}
	public void setDestinationCountry(String destinationCountry) {
		this.destinationCountry = destinationCountry;
	}
	public String getDestinationState() {
		return destinationState;
	}
	public void setDestinationState(String destinationState) {
		this.destinationState = destinationState;
	}
	public String getDestinationCity() {
		return destinationCity;
	}
	public void setDestinationCity(String destinationCity) {
		this.destinationCity = destinationCity;
	}
	public String getStayFromDate() {
		return stayFromDate;
	}
	public void setStayFromDate(String stayFromDate) {
		this.stayFromDate = stayFromDate;
	}
	public String getStayToDate() {
		return stayToDate;
	}
	public void setStayToDate(String stayToDate) {
		this.stayToDate = stayToDate;
	}
	public String getGuestsAdults() {
		return guestsAdults;
	}
	public void setGuestsAdults(String guestsAdults) {
		this.guestsAdults = guestsAdults;
	}
	public String getGuestKids() {
		return guestKids;
	}
	public void setGuestKids(String guestKids) {
		this.guestKids = guestKids;
	}
	private String destinationState;
	private String destinationCity;
	private String stayFromDate;
	private String stayToDate;
	private String guestsAdults;
	private String guestKids;
	private RoomRequestDetailsTO roomGroup;
	public RoomRequestDetailsTO getRoomGroup() {
		return roomGroup;
	}
	public void setRoomGroup(RoomRequestDetailsTO roomGroup) {
		this.roomGroup = roomGroup;
	}
}
