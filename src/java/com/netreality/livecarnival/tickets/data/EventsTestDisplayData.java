/**
 * 
 */
package com.netreality.livecarnival.tickets.data;
import java.util.ArrayList;
import java.util.List;

import com.live4carnival.tickets.events.helper.EventDateHelper;
import com.livecarnival.tickets.to.EventDisplayObj;

/**
 * @author JahLion
 *  This class is used to provide test event data
 */
public class EventsTestDisplayData {
	
	private static List<EventDisplayObj> testList;
	private static List<EventDisplayObj> testCarnivalEventList;
	
	private static EventDisplayObj TEST_EVENT_1;
	private static EventDisplayObj TEST_EVENT_2;
	private static EventDisplayObj TEST_EVENT_3;
	private static EventDisplayObj TEST_EVENT_4;
	private static EventDisplayObj TEST_EVENT_5;
	private static EventDisplayObj TEST_EVENT_6	;
	private static EventDisplayObj TEST_EVENT_7	;
	
	
	private static EventDisplayObj TEST_EVENT_8;
	private static EventDisplayObj TEST_EVENT_9;
	private static EventDisplayObj TEST_EVENT_10;
	private static EventDisplayObj TEST_EVENT_11;
	private static EventDisplayObj TEST_EVENT_12;
	private static EventDisplayObj TEST_EVENT_13;
	private static EventDisplayObj TEST_EVENT_14;
	private static EventDisplayObj TEST_EVENT_15;
	private static EventDisplayObj TEST_EVENT_16;
	private static EventDisplayObj TEST_EVENT_17;
	private static EventDisplayObj TEST_EVENT_18;
	
	
	
	
	
	private static String TEST_EVENT_TITLE = "Test LiveCarnival Event";
	private static String TEST_EVENT_TITLE_1 = "Test LiveCarnival Event 2";
	private static String TEST_EVENT_TITLE_2 = "Machel Monday";
	private static String TEST_EVENT_TITLE_3 = "Fantasies Jouvert 2k17";
	private static String TEST_EVENT_TITLE_4 = "Beach House Cooler Fete";
	private static String TEST_EVENT_TITLE_5 = "Watch Thing 2017";
	private static String TEST_EVENT_DATE = "November 23rd, 2017 2pm PST";
	private static String TEST_EVENT_DATE_1 = "January 23rd, 2017 2pm PST";
	private static String TEST_EVENT_DATE_2 = "February 14th, 2017 2pm PST";
	private static String TEST_EVENT_DATE_3 = "March 14th, 2017 2pm PST";
	private static String TEST_EVENT_DATE_4 = "March 14th, 2017 2pm PST";
	private static String TEST_EVENT_DATE_5 = "March 14th, 2016 2pm PST";
	private static String TEST_EVENT_DATE_6 = "August 1st, 2016 6am PST";
	
	private static String TEST_EVENT_DATE_7 = "January 11th, 2017 6pm EST";
	private static String TEST_EVENT_DATE_8 = "January 12th, 2017 5pm EST";
	private static String TEST_EVENT_DATE_9 = "February 11th, 2017 4pm EST";
	private static String TEST_EVENT_DATE_10 = "February 15th, 2017 12pm EST";
	private static String TEST_EVENT_DATE_11 = "February 18th, 2017 6am EST";
	private static String TEST_EVENT_DATE_12 = "February 5th, 2017 1pm EST";
	private static String TEST_EVENT_DATE_13 = "February 22nd, 2017 11am EST";
	private static String TEST_EVENT_DATE_14 = "February 24th, 2017 2pm EST";
	
	
	//Test events by Carnival
	private static String TEST_EVENT_BY_CARNIVAL_TITLE = "Panorama Preliminary";
	private static String TEST_EVENT_BY_CARNIVAL_TITLE_1 = "Kings And Queens Of The Band";
	private static String TEST_EVENT_BY_CARNIVAL_TITLE_2 = "Groovy Soca Monarch Contest";
	private static String TEST_EVENT_BY_CARNIVAL_TITLE_3 = "Chutney Soca Monarch Contest";
	private static String TEST_EVENT_BY_CARNIVAL_TITLE_4 = "Calypso Monarch SemiFinals";
	private static String TEST_EVENT_BY_CARNIVAL_TITLE_5 = "Army Fete";
	private static String TEST_EVENT_BY_CARNIVAL_TITLE_6 = "Kiddie's Carnival";
	private static String TEST_EVENT_BY_CARNIVAL_TITLE_7 = "Beach House";
	private static String TEST_EVENT_BY_CARNIVAL_TITLE_8 = "Outta De Blue";
	private static String TEST_EVENT_BY_CARNIVAL_TITLE_9 = "Panorama Finals";
	private static String TEST_EVENT_BY_CARNIVAL_TITLE_10 = "J'ouvert";
	
	
	
	
	
	static {
		
			testList = new ArrayList<EventDisplayObj>();
			testCarnivalEventList = new ArrayList<EventDisplayObj>();
			TEST_EVENT_1 = new EventDisplayObj();
			TEST_EVENT_2 = new EventDisplayObj();
			TEST_EVENT_3 = new EventDisplayObj();
			TEST_EVENT_4 = new EventDisplayObj();
			TEST_EVENT_5 = new EventDisplayObj();
			TEST_EVENT_6 = new EventDisplayObj();
			TEST_EVENT_7 = new EventDisplayObj();
			
			TEST_EVENT_8 = new EventDisplayObj();
			TEST_EVENT_9 = new EventDisplayObj();
			TEST_EVENT_10 = new EventDisplayObj();
			TEST_EVENT_11 = new EventDisplayObj();
			TEST_EVENT_12 = new EventDisplayObj();
			TEST_EVENT_13 = new EventDisplayObj();
			TEST_EVENT_14 = new EventDisplayObj();
			
			TEST_EVENT_15 = new EventDisplayObj();
			TEST_EVENT_16 = new EventDisplayObj();
			TEST_EVENT_17 = new EventDisplayObj();
			TEST_EVENT_18 = new EventDisplayObj();
			
			
			//1 st event
			TEST_EVENT_1.setEventTitle(TEST_EVENT_TITLE);
			TEST_EVENT_1.setEventStartDate(EventDateHelper.parseEventDate(TEST_EVENT_DATE));
			TEST_EVENT_1.setEventEndDate(EventDateHelper.parseEventDate(TEST_EVENT_DATE));
			//2ndevent
			TEST_EVENT_2.setEventTitle(TEST_EVENT_TITLE_2);
			TEST_EVENT_2.setEventEndDate(EventDateHelper.parseEventDate(TEST_EVENT_DATE_1));
			TEST_EVENT_2.setEventStartDate(EventDateHelper.parseEventDate(TEST_EVENT_DATE_1));
			//3rd event
			TEST_EVENT_3.setEventStartDate(EventDateHelper.parseEventDate(TEST_EVENT_DATE_2));
			TEST_EVENT_3.setEventEndDate(EventDateHelper.parseEventDate(TEST_EVENT_DATE_2));
			//4th event
			TEST_EVENT_4.setEventTitle(TEST_EVENT_TITLE_1);
			TEST_EVENT_4.setEventStartDate(EventDateHelper.parseEventDate(TEST_EVENT_DATE_3));
			TEST_EVENT_4.setEventEndDate(EventDateHelper.parseEventDate(TEST_EVENT_DATE_3));
			//5th event
			TEST_EVENT_5.setEventTitle(TEST_EVENT_TITLE_4);
			TEST_EVENT_5.setEventStartDate(EventDateHelper.parseEventDate(TEST_EVENT_DATE_4));
			TEST_EVENT_5.setEventEndDate(EventDateHelper.parseEventDate(TEST_EVENT_DATE_4));
			
			//6th event
			TEST_EVENT_6.setEventTitle(TEST_EVENT_TITLE_3);
			TEST_EVENT_6.setEventStartDate(EventDateHelper.parseEventDate(TEST_EVENT_DATE_5));
			TEST_EVENT_6.setEventEndDate(EventDateHelper.parseEventDate(TEST_EVENT_DATE_5));
			
			//7th event
			TEST_EVENT_7.setEventTitle(TEST_EVENT_TITLE_5);
			TEST_EVENT_7.setEventStartDate(EventDateHelper.parseEventDate(TEST_EVENT_DATE_6));
			TEST_EVENT_7.setEventEndDate(EventDateHelper.parseEventDate(TEST_EVENT_DATE_6));
			
			TEST_EVENT_8.setEventTitle(TEST_EVENT_BY_CARNIVAL_TITLE_1);
			TEST_EVENT_8.setEventStartDate(EventDateHelper.parseEventDate(TEST_EVENT_DATE_6));
			
			
			
			//add items to the collection
			testList.add(TEST_EVENT_1);
			testList.add(TEST_EVENT_2);
			testList.add(TEST_EVENT_3);
			testList.add(TEST_EVENT_4);
			testList.add(TEST_EVENT_5);
			testList.add(TEST_EVENT_6);
			testList.add(TEST_EVENT_7);
			
			
			
	}
	
	
	public static List<EventDisplayObj> getEventData()
	{
		return testList;
	}
	
	
	public static List<EventDisplayObj> getCarnivalData()
	{
		
		return null;
	}

}
