/**
 * 
 */
package com.netreality.live4carnival.tickets.api;

/**
 * @author JahLion
 *
 */
public class TicketAPIConstants {
	
	public static String LIVECARNIVAL_TICKETTING_REST_API_BASE_URL = "http://tickets.livecarnival.com";
	//Ticketting Events
	public static String LIVECARNIVAL_TICKETTING_GET_EVENTS_URI = "/api/v1/events";
	
	//Event Details
	
	public static String LIVECARNIVAL_TICKETTING_GET_EVENT_DETAILS_URI = "/api/v1/events/";
	
	public static String LIVECARNIVAL_TICKETTING_DEVELOPER_API_KEY = "8740d134a1dda91d878b764eed9f00f5-997863";
	
	//Events filter parameters
	
	public static String LIVECARNIVAL_TICKETTING_EVENT_SEARCH_FILTER = "search";
	
	//Affilates 
	public static String LIVECARNIVAL_TICKETTING_AFFILATE_LIST_URI = "/api/v1/affiliates";
	
	//Organizers 
	public static String LIVECARNIVAL_TICKETTING_ORGANIZERS_URI = "/api/v1/organizers";
	
	//event details for display
	public static String LIVECARNIVAL_TICKETTING_EVENT_DISPLAY_DATA_TITLE = "title";
	public static String LIVECARNIVAL_TICKETTING_EVENT_DISPLAY_DATA_STARTDATE = "displayStartDate";
	public static String LIVECARNIVAL_TICKETTING_EVENT_DISPLAY_DATA_ENDDATE = "displayEndDate";
	public static String LIVECARNIVAL_TICKETTING_EVENT_DISPLAY_DATA_VENUE = "venue";
	public static String LIVECARNIVAL_TICKETTING_EVENT_DISPLAY_DATA_SMALL_IMAGE = "smallPic";
	
	
	//Image base location uri
	public static String LIVECARNIVAL_TICKETTING_EVENT_IMAGE_BASE_URI = "https://tickets.livecarnival.com/tickets/pics/";
	public static String LIVECARNIVAL_TICKETTING_EVENT_BASE_URI = "https://tickets.livecarnival.com/event/";
}
