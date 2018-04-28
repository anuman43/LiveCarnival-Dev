/**
 * 
 */
package com.live4carnival.accomodation.search.to;

import java.util.List;

/**
 * @author JahLion
 *
 */
public class RoomRequestDetailsTO {
	
	private Integer numOfRooms;
	public Integer getNumOfRooms() {
		return numOfRooms;
	}
	public void setNumOfRooms(Integer numOfRooms) {
		this.numOfRooms = numOfRooms;
	}
	public Integer getNumOfAdults() {
		return numOfAdults;
	}
	public void setNumOfAdults(Integer numOfAdults) {
		this.numOfAdults = numOfAdults;
	}
	
	private Integer numOfAdults;
	private List<RoomRequestChildInfo> kids;
	public List<RoomRequestChildInfo> getKids() {
		return kids;
	}
	public void setKids(List<RoomRequestChildInfo> kids) {
		this.kids = kids;
	}

}
