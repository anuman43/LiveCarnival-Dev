/**
 * 
 */
package com.live4carnival.tickets.events.helper;

import java.util.Comparator;
import java.util.Date;

import com.livecarnival.tickets.to.EventDisplayObj;

/**
 * @author JahLion
 *
 */
public class EventDisplayDateComparator implements Comparator<com.livecarnival.tickets.to.EventDisplayObj> {

	@Override
	public int compare(EventDisplayObj event, EventDisplayObj event1) {

		Date eventDate = event.getEventStartDate();
		Date eventDate1 = event1.getEventStartDate();
		
		return eventDate.compareTo(eventDate1);
	}

}
