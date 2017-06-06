/**
 * 
 */
package com.livecarnival.tickets.to;

import static com.netreality.live4carnival.tickets.api.TicketAPIConstants.LIVECARNIVAL_TICKETTING_EVENT_IMAGE_BASE_URI;

import java.util.Date;

import static com.netreality.live4carnival.tickets.api.TicketAPIConstants.LIVECARNIVAL_TICKETTING_EVENT_BASE_URI;

/**
 * @author JahLion
 *
 */
public class EventDisplayObj {
	
	private String eventTitle;
	public String getEventTitle() {
		return  eventTitle;
	}
	public void setEventTitle(String eventTitle) {
		this.eventTitle = eventTitle;
	}
	
	
	public String getEventLocation() {
		return eventLocation;
	}
	public void setEventLocation(String eventLocation) {
		this.eventLocation = eventLocation;
	}
	public String getEventDescription() {
		return eventDescription;
	}
	public void setEventDescription(String eventDescription) {
		this.eventDescription = eventDescription;
	}
	public String getEventImageLocation() {
		return LIVECARNIVAL_TICKETTING_EVENT_IMAGE_BASE_URI + eventImageLocation;
	}
	public void setEventImageLocation(String eventImageLocation) {
		this.eventImageLocation = eventImageLocation;
	}
	private Date eventStartDate;
	public Date getEventStartDate() {
		return eventStartDate;
	}
	public void setEventStartDate(Date eventStartDate) {
		this.eventStartDate = eventStartDate;
	}
	private Date eventEndDate;
	public Date getEventEndDate() {
		return eventEndDate;
	}
	public void setEventEndDate(Date eventEndDate) {
		this.eventEndDate = eventEndDate;
	}
	private String eventLocation;
	private String eventDescription;
	private String eventImageLocation;
	private String eventUri = LIVECARNIVAL_TICKETTING_EVENT_BASE_URI ;
	public String getEventUri() {
		return eventUri;
	}

}
