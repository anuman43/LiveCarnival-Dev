/**
 * 
 */
package com.live4carnival.web.integration.rest.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.live4carnival.tickets.events.helper.EventDateHelper;
import com.live4carnival.tickets.events.helper.EventDisplayDateComparator;
import com.livecarnival.tickets.to.EventDetailsTo;
import com.livecarnival.tickets.to.EventDisplayObj;
import com.livecarnival.tickets.to.EventTo;
import com.livecarnival.tickets.to.GenericTicketRespTo;
import com.netreality.live4carnival.enums.TicketAPIActionsEnum;
import com.netreality.livecarnival.tickets.data.EventsTestDisplayData;
import com.netreality.vertie.alpha.to.SearchResultTO;

import static com.netreality.live4carnival.tickets.api.TicketAPIConstants.LIVECARNIVAL_TICKETTING_REST_API_BASE_URL;
import static com.netreality.live4carnival.tickets.api.TicketAPIConstants.LIVECARNIVAL_TICKETTING_GET_EVENTS_URI;
import static com.netreality.live4carnival.tickets.api.TicketAPIConstants.LIVECARNIVAL_TICKETTING_DEVELOPER_API_KEY;
import static com.netreality.live4carnival.tickets.api.TicketAPIConstants.LIVECARNIVAL_TICKETTING_EVENT_SEARCH_FILTER;

import static com.netreality.live4carnival.tickets.api.TicketAPIConstants.LIVECARNIVAL_TICKETTING_GET_EVENT_DETAILS_URI;
import static com.netreality.live4carnival.tickets.api.TicketAPIConstants.LIVECARNIVAL_TICKETTING_AFFILATE_LIST_URI;
import static com.netreality.live4carnival.tickets.api.TicketAPIConstants.LIVECARNIVAL_TICKETTING_EVENT_DISPLAY_DATA_TITLE;
import static com.netreality.live4carnival.tickets.api.TicketAPIConstants.LIVECARNIVAL_TICKETTING_EVENT_DISPLAY_DATA_STARTDATE;
import static com.netreality.live4carnival.tickets.api.TicketAPIConstants.LIVECARNIVAL_TICKETTING_EVENT_DISPLAY_DATA_ENDDATE;
import static com.netreality.live4carnival.tickets.api.TicketAPIConstants.LIVECARNIVAL_TICKETTING_EVENT_DISPLAY_DATA_VENUE;
import static com.netreality.live4carnival.tickets.api.TicketAPIConstants.LIVECARNIVAL_TICKETTING_EVENT_DISPLAY_DATA_SMALL_IMAGE;



/**
 * @author JahLion
 *
 */


	


public class TicketAPIUtil {
	
	private static HashMap<Integer,String> eventsURIMap;
	private static Logger _log;
	private static List<String> eventKeys;
	
	static{
		eventsURIMap = new HashMap<Integer,String>();
		eventsURIMap.put(0, LIVECARNIVAL_TICKETTING_REST_API_BASE_URL + LIVECARNIVAL_TICKETTING_GET_EVENTS_URI);
		eventsURIMap.put(1,  LIVECARNIVAL_TICKETTING_REST_API_BASE_URL + LIVECARNIVAL_TICKETTING_GET_EVENTS_URI);
		eventsURIMap.put(2, LIVECARNIVAL_TICKETTING_REST_API_BASE_URL + LIVECARNIVAL_TICKETTING_GET_EVENT_DETAILS_URI);
		eventsURIMap.put(3, LIVECARNIVAL_TICKETTING_REST_API_BASE_URL + LIVECARNIVAL_TICKETTING_AFFILATE_LIST_URI);
		_log = Logger.getLogger(TicketAPIUtil.class);
		eventKeys = new ArrayList<String>();
		eventKeys.add(LIVECARNIVAL_TICKETTING_EVENT_DISPLAY_DATA_TITLE);
		eventKeys.add(LIVECARNIVAL_TICKETTING_EVENT_DISPLAY_DATA_VENUE);
		eventKeys.add(LIVECARNIVAL_TICKETTING_EVENT_DISPLAY_DATA_ENDDATE);
		eventKeys.add(LIVECARNIVAL_TICKETTING_EVENT_DISPLAY_DATA_STARTDATE);
		eventKeys.add(LIVECARNIVAL_TICKETTING_EVENT_DISPLAY_DATA_SMALL_IMAGE);
		
	}
	
	public static List<EventDisplayObj> getTestEvents()
	{
		
		return EventsTestDisplayData.getEventData();
	}
	
	
	public static List<EventDisplayObj> getAllEvents()
	{
		GenericTicketRespTo allEvents = null;
		
		Map<String,String> reqParams = new HashMap<String,String>();
		
		String actionUrl = null;
		
		String restResult = null;
		
		String restTarget = null;
		
		actionUrl = getAPIUrl(TicketAPIActionsEnum.AllEvents);
		
		restTarget = Live4CarnivalRestUtil.buildRestReq(actionUrl,LIVECARNIVAL_TICKETTING_DEVELOPER_API_KEY, reqParams);
		
		restResult = executeRestAPI(restTarget);
		
		_log.debug(restResult);
		
		allEvents = convertRespToPojo(restResult);
		
		List<EventDisplayObj> eventDisList = null;
		
		 eventDisList = convertToDisplayableEvents(allEvents);
		
		return  eventDisList;
	}
	
	
	public static List<EventDisplayObj> convertToDisplayableEvents(GenericTicketRespTo ticketEvents)
	{
		List<EventDisplayObj> displayList = null;
		
		List<Object> dataList = null;
		
		if(ticketEvents.getData() != null)
		{
			dataList = (List<Object>) ticketEvents.getData();
			Map<String,String> eventDataMap = null;
			EventDisplayObj	displayedEvent = null;
			displayList = new ArrayList<EventDisplayObj>();
			for(Object obj: dataList)
			{
				eventDataMap = (Map<String, String>) obj;
				displayedEvent = convertMapToDisplayObj(eventDataMap);
					if(displayedEvent != null)
					{
						displayList.add(displayedEvent);
					}
			}
		}
		
		
		
		return displayList;
	}
	
	
	
	public static GenericTicketRespTo getEventsByFilter(String searchFilter)
	{
		GenericTicketRespTo events = null;
		
		Map<String,String> reqParams = new HashMap<String,String>();
		
		if(searchFilter != null)
		{
			reqParams.put(LIVECARNIVAL_TICKETTING_EVENT_SEARCH_FILTER, searchFilter);
		}
		
		String actionUrl = getAPIUrl(TicketAPIActionsEnum.AllEvents);
		
		_log.debug("LiveCarnival Tickets Url-" + actionUrl);
		
		String restTarget = Live4CarnivalRestUtil.buildRestReq(actionUrl, LIVECARNIVAL_TICKETTING_DEVELOPER_API_KEY, reqParams);
		
		String restResult = executeRestAPI(restTarget);
		events = convertRespToPojo(restResult);
		
		_log.debug("Rest result of all events filtered search-"+restResult);
		
		
		return events;
	}
	
	private static String executeRestAPI(String requestPacket)
	{
		String jsonResult = null;
		
		jsonResult = Live4CarnivalRestUtil.executeTicketRestCall(requestPacket);
		
		_log.info("Ticket API REST result:"+ jsonResult);
		
		return jsonResult;
	}
	
	
	private static String getAPIUrl(TicketAPIActionsEnum action)
	{
		String apiURL = null;
		
				
		apiURL = eventsURIMap.get(action.getActionValue());
		
		_log.debug(apiURL);
		
		return apiURL;
	}
	
	
	private static Object convertJsonToPojo(String jsonStr,Object pojo)
	{
		ObjectMapper objMap = new ObjectMapper();
		Object convPojo = null;
		
		try {
			convPojo = objMap.readValue(jsonStr, pojo.getClass());
		} catch (IOException ioe) {
			_log.error(ioe);
		}
		
		return convPojo;
	}
	
	
	private static EventTo convertJsonToEvents(String jsonResp)
	{
		EventTo allEvents = null;
		ObjectMapper objMap = new ObjectMapper();
		objMap.enable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		try {
			allEvents = objMap.readValue(jsonResp, EventTo.class);
		} catch (IOException ioe) {
			_log.error(ioe);
		}
		
		
		return allEvents;
		
	}
	
	private static GenericTicketRespTo convertRespToPojo(String jsonRes)
	{
		GenericTicketRespTo ticketObj = null;
		ObjectMapper objMap = new ObjectMapper();
		objMap.enable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		
		
		try {
			ticketObj = objMap.readValue(jsonRes, GenericTicketRespTo.class);
		} catch (IOException mte) {
			_log.error(mte);
		}
		
		return ticketObj;
	}
	
	
	
	private static EventDetailsTo convertJsonToEventDetails(String jsonResp)
	{
		EventDetailsTo eveDetails = null;
		ObjectMapper objMap = new ObjectMapper();
		objMap.enable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		try {
			eveDetails = objMap.readValue(jsonResp, EventDetailsTo.class);
		} catch (IOException ioe) {
			_log.error(ioe);
		}
		
		
		return eveDetails;
		
	}
	
	public static EventDetailsTo getEventDetails(String eventId)
	{
		EventDetailsTo eventInfo = null;
		
		Map<String,String> reqParams = new HashMap<String,String>();
		
		String actionUrl = null;
		
		String restResult = null;
		
		String restTarget = null;
		
		actionUrl = getAPIUrl(TicketAPIActionsEnum.EventDetails);
		
				
		restTarget = Live4CarnivalRestUtil.buildRestReq(actionUrl + eventId,LIVECARNIVAL_TICKETTING_DEVELOPER_API_KEY, reqParams);
		
		_log.debug(restTarget);
		
		restResult = executeRestAPI(restTarget);
		
		_log.debug(restResult);
		
		eventInfo = convertJsonToEventDetails(restResult);
		
		return eventInfo;
	}
	
	
	public static List<EventDisplayObj>  getEventDataForMainSearch(String searchedTerm)
	{
		//List<SearchResultTO> eventResultData = null;
		
		List<EventDisplayObj> dispEvents =  null;
		
		GenericTicketRespTo eventResp = null;
		eventResp = getEventsByFilter(searchedTerm);
		
		 dispEvents = convertToDisplayableEvents(eventResp);
		
		return dispEvents;
	}
	
	
	
	private List<SearchResultTO> copyEventDisplayObjToSearchResultTO(List<EventDisplayObj> eventList)
	{
		List<SearchResultTO> eventSearchResults = null;
		
		eventSearchResults = new ArrayList<SearchResultTO>(eventList.size());
		
		for(EventDisplayObj eObj: eventList)
		{
			if(eObj != null)
			{
				SearchResultTO result = new SearchResultTO();
				result.setResultUrl(eObj.getEventUri() + eObj.getEventTitle());
				result.setDomainTerm(eObj.getEventTitle());
				result.setResultPageTitle(eObj.getEventTitle());
				eventSearchResults.add(result);
			}
		}
		
		
		return eventSearchResults;
		
	}
	
	
	public static GenericTicketRespTo getAllAffiliates()
	{
		GenericTicketRespTo affData = null;
		
		Map<String,String> reqParams = new HashMap<String,String>();
		
		String actionUrl = null;
		
		String restResult = null;
		
		String restTarget = null;
		
		actionUrl = getAPIUrl(TicketAPIActionsEnum.Allaffilates);
		
		restTarget = Live4CarnivalRestUtil.buildRestReq(actionUrl,LIVECARNIVAL_TICKETTING_DEVELOPER_API_KEY, reqParams);
		
		restResult = executeRestAPI(restTarget);
		
		affData = convertRespToPojo(restResult);
		
		
		return affData;
		
		
	}
	
	public static List<EventDisplayObj> getAllEventsForDisplay(List<Object> jsonEvents)
	{
		List<EventDisplayObj> displayList  = null;
		
		if(!jsonEvents.isEmpty())
		{
			displayList  = new ArrayList<EventDisplayObj>();
			
			for(Object jsonObj: jsonEvents)
			{
				if(jsonObj != null)
				{
					Map<String,String> objMap = (Map<String,String>) jsonObj;
					
				}
				
			}
		}
		
		
		return displayList;
	}
	
	public static EventDisplayObj convertMapToDisplayObj(Map<String,String> jsonObjMap)
	{
		EventDisplayObj displayedEvent = null;
		Map<String,String> dspMap = new HashMap<String,String>();
		
		for(Map.Entry<String, String> entry:jsonObjMap.entrySet())
		{
			if(eventKeys.contains(entry.getKey()))
			{
				_log.debug("Found key " + entry.getKey());
				dspMap.put(entry.getKey(), entry.getValue());
			}
		}
		
		displayedEvent = copyEventDisplayData(dspMap);
		
		
		return displayedEvent;
	}
	
	private static EventDisplayObj copyEventDisplayData(Map<String,String> dspMap)
	{
		EventDisplayObj eventData = null;
		
		if(!dspMap.isEmpty())
		{
			eventData = new EventDisplayObj();
			eventData.setEventTitle(dspMap.get(LIVECARNIVAL_TICKETTING_EVENT_DISPLAY_DATA_TITLE));
			eventData.setEventEndDate(EventDateHelper.parseEventDate(dspMap.get(LIVECARNIVAL_TICKETTING_EVENT_DISPLAY_DATA_ENDDATE)));
			eventData.setEventLocation(dspMap.get(LIVECARNIVAL_TICKETTING_EVENT_DISPLAY_DATA_VENUE));
			eventData.setEventStartDate(EventDateHelper.parseEventDate((dspMap.get(LIVECARNIVAL_TICKETTING_EVENT_DISPLAY_DATA_STARTDATE))));
			eventData.setEventImageLocation(dspMap.get(LIVECARNIVAL_TICKETTING_EVENT_DISPLAY_DATA_SMALL_IMAGE));;
		}
		
		return eventData;
	}
	
	public static List<EventDisplayObj> sortAllEventsByStartDate(List<EventDisplayObj> allEventList)
	{
		return sortByStartDate(allEventList);
	}
	
	
	private static List<EventDisplayObj> sortByStartDate(List<EventDisplayObj> unsortCol)
	{
		List<EventDisplayObj> dispList = null;
		EventDisplayDateComparator comparator = new EventDisplayDateComparator();
		
		dispList =  unsortCol;
		Collections.sort(dispList, comparator);
		_log.debug("Inside the sorting by date method");
		
		
				
		return dispList;
	}
	
}
