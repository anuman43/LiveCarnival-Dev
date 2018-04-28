/**
 * 
 */
package com.live4carnival.accomodation.ean.roomAvail.to;

/**
 * @author JahLion
 *
 */
public class EANHotelRoomBedType {

	private String smokingPreferences;
	public String getSmokingPreferences() {
		return smokingPreferences;
	}
	public void setSmokingPreferences(String smokingPreferences) {
		this.smokingPreferences = smokingPreferences;
	}
	public Integer getRateOccupancyPerRoom() {
		return rateOccupancyPerRoom;
	}
	public void setRateOccupancyPerRoom(Integer rateOccupancyPerRoom) {
		this.rateOccupancyPerRoom = rateOccupancyPerRoom;
	}
	public Integer getQuotedOccupancy() {
		return quotedOccupancy;
	}
	public void setQuotedOccupancy(Integer quotedOccupancy) {
		this.quotedOccupancy = quotedOccupancy;
	}
	public Integer getMinGuestAge() {
		return minGuestAge;
	}
	public void setMinGuestAge(Integer minGuestAge) {
		this.minGuestAge = minGuestAge;
	}
	private Integer rateOccupancyPerRoom;
	private Integer quotedOccupancy;
	private Integer minGuestAge;
}
