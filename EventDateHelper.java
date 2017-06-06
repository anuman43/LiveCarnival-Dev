/**
 * 
 */
package com.live4carnival.tickets.events.helper;

import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;



/**
 * @author JahLion
 *
 */
public class EventDateHelper {
	
	private static String LIVE4CARNIVAL_EVENT_DISPLAY_PATTERN = "MMMM dd,yyyy ha z";
	private static String LIVE4CARNIVAL_EVENT_DISPLAY_PATTERN_1 = "MMMM dd,yyyy h:mma z";
	private static SimpleDateFormat sdf;
	private static Logger _log;
	private static String EVENT_TIME_CHARACTER_REPLACE_PATTERN = "(?<=\\d)(st|nd|rd|th|)";
	private final static String EMAIL_CHAR = "@";
	
	
	static
	{
		sdf = new SimpleDateFormat();
		_log = Logger.getLogger(EventDateHelper.class);
	}
	
	public static Date parseEventDate(String eventDate)
	{
		Date dateOfEvent = null;
		
		if(eventDate != null)
			
		{
			
			if(dateContainsEmailChar(eventDate))
			{
				sdf.applyPattern(LIVE4CARNIVAL_EVENT_DISPLAY_PATTERN_1);
			}
			else
			{
				sdf.applyPattern(LIVE4CARNIVAL_EVENT_DISPLAY_PATTERN);
			}
			
			
			_log.info(eventDate);
			eventDate = eventDate.replaceAll(EVENT_TIME_CHARACTER_REPLACE_PATTERN, "");
			eventDate = eventDate.replaceAll("@","");
			_log.info(eventDate);
			try {
				dateOfEvent = sdf.parse(eventDate);
			} catch (ParseException pse) {
				_log.error(pse);
				_log.error(pse.getErrorOffset());
			}
			_log.debug(dateOfEvent);
		}
		
		return dateOfEvent;
	}
	
	private static Boolean dateContainsEmailChar(String eventDate)
	{
		Boolean emailChar = false;
		
		
		if(eventDate != null)
		{
			emailChar = eventDate.contains(EMAIL_CHAR);
		}
		
		
		return emailChar;
	}
	
	
	
	
}
