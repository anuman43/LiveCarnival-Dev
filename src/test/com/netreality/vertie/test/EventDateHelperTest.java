/**
 * 
 */
package com.netreality.vertie.test;


import java.util.Date;

import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.live4carnival.tickets.events.helper.EventDateHelper;

/**
 * @author JahLion
 *
 */
public class EventDateHelperTest extends BaseUnitTest {
	
	private static String TEST_EVENT_DATE = "November 23rd, 2016 2pm PST";
	private static String TEST_EVENT_DATE_1 = "December 5th, 2016 @ 6:00pm EST";
	
	
	
	@BeforeClass
	public static void setUp()
	{
		setLogger(Logger.getLogger(EventDateHelperTest.class));
	}
	
	@AfterClass
	public static void tearDown()
	{
		//TEST_EVENT_DATE = null;
	}
	
	
	@Test
	public void testParseEventDate()
	{
		Date eventDate = null;
		Assert.assertNull(ASSERT_NULL_MESSAGE, eventDate);
		eventDate = EventDateHelper.parseEventDate(TEST_EVENT_DATE);
		Assert.assertNotNull(ASSERT_NOT_NULL_MESSAGE, eventDate);
		
	}
	
	

}
