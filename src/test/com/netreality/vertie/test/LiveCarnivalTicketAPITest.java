/**
 * 
 */
package com.netreality.vertie.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.live4carnival.web.integration.rest.util.Live4CarnivalRestUtil;
import com.live4carnival.web.integration.rest.util.TicketAPIUtil;
import com.livecarnival.tickets.to.EventDetailsTo;
import com.livecarnival.tickets.to.EventDisplayObj;
import com.livecarnival.tickets.to.EventTo;
import com.livecarnival.tickets.to.GenericTicketRespTo;



/**
 * @author JahLion
 *
 */
public class LiveCarnivalTicketAPITest extends BaseUnitTest {
	
	private static String LIVE_CARNIVAL_TICKETS_BASE_URL = "http://tickets.livecarnival.com";
	private static Map<String,String> qryMap;
	private static String LIVE_CARNIVAL_TICKETS_API_KEY = "8740d134a1dda91d878b764eed9f00f5-997863";
	private static String LIVE_CARNIVAL_TICKETS_GET_EVENTS_URL = "/api/v1/events";
	private static String LIVE_CARNIVAL_TICKETS_GET_EVENTS_DETAILS_URL = "/api/v1/events/";
	private static String TEST_TARGET_URL = "";
	private static String TEST_TARGET_EVENTS_DETAILS_URL = "";
	private static String LIVE_CARNIVAL_TICKETS_GET_EVENTS_SEARCH_PARAM_KEY_NAME = "";
	
	//Events Parameters
	private static String GET_EVENTS_SEARCH_PARAM = "search";
	private static String GET_EVENTS_CATEGORY_PARAM = "categoryId";
	private static String GET_EVENTS_LIMIT_PARAM = "limit";
	private static String GET_EVENTS_OFFSET_PARAM = "offset";
	private static String TEST_EVENT_ID = "13";
	
	//
	private static String TEST_SEARCH_FILTER = "testing";
	
	private static String TEST_EVENT_SEARCH_TERM = "Bliss";
	
	
	@BeforeClass
	public static void setUp()
	{
		setLogger(Logger.getLogger(LiveCarnivalTicketAPITest.class));
		getLog().info("Before Class setup");
		qryMap = new HashMap<String,String>();
		//qryMap.put(GET_EVENTS_SEARCH_PARAM, TEST_SEARCH_FILTER);
		TEST_TARGET_URL = LIVE_CARNIVAL_TICKETS_BASE_URL + LIVE_CARNIVAL_TICKETS_GET_EVENTS_URL;
		/*qryMap.put(GET_EVENTS_SEARCH_PARAM, "test");
		qryMap.put(GET_EVENTS_CATEGORY_PARAM, "test");
		qryMap.put(GET_EVENTS_LIMIT_PARAM, "test");
		qryMap.put(GET_EVENTS_OFFSET_PARAM, "test");*/
		TEST_TARGET_EVENTS_DETAILS_URL = LIVE_CARNIVAL_TICKETS_BASE_URL + LIVE_CARNIVAL_TICKETS_GET_EVENTS_DETAILS_URL;
	}
	
	
	@AfterClass
	public static void tearDown()
	{
		TEST_TARGET_URL = null;
		qryMap.clear();
		qryMap = null;
		
	}
	
	@Ignore
	public void testBuildURL()
	{
		String targetUrl = null;
		targetUrl = Live4CarnivalRestUtil.buildRestReq(TEST_TARGET_URL, LIVE_CARNIVAL_TICKETS_API_KEY, qryMap);
		Assert.assertNotNull(ASSERT_NOT_NULL_MESSAGE, targetUrl);
		getLog().info(targetUrl);
	}
	
	@Ignore
	public void testGetAllEvents()
	{
		List<EventDisplayObj> eventList = null;
		String targetUrl = null;
		targetUrl = Live4CarnivalRestUtil.buildRestReq(TEST_TARGET_URL, LIVE_CARNIVAL_TICKETS_API_KEY, qryMap);
		Assert.assertNotNull(ASSERT_NOT_NULL_MESSAGE, targetUrl);
		getLog().info(targetUrl);
		eventList = TicketAPIUtil.getAllEvents();
		Assert.assertNotNull(ASSERT_NOT_NULL_MESSAGE, eventList);
		Assert.assertTrue(ASSERT_CONDITION_TRUE, !eventList.isEmpty());
			
	}
	
	
	@Ignore
	public void testgetEventsBySearchTitle()
	{
		String targetUrl = null;
		List<EventDisplayObj> eventList = null;
		targetUrl = Live4CarnivalRestUtil.buildRestReq(TEST_TARGET_URL, LIVE_CARNIVAL_TICKETS_API_KEY, qryMap);
		Assert.assertNotNull(ASSERT_NOT_NULL_MESSAGE, targetUrl);
		getLog().info(targetUrl);
		eventList = TicketAPIUtil.getAllEvents();
		Assert.assertNotNull(ASSERT_NOT_NULL_MESSAGE, eventList);
		
		
	}
	
	
	@Ignore
	public void testGetEventDetails()
	{
		
		EventDetailsTo detailInfo = null;
		Assert.assertNull(ASSERT_NULL_MESSAGE, detailInfo);
		detailInfo = TicketAPIUtil.getEventDetails(TEST_EVENT_ID);
		Assert.assertNotNull(ASSERT_NOT_NULL_MESSAGE, detailInfo);
		Object objData = detailInfo.getData();
		Assert.assertNotNull(ASSERT_NOT_NULL_MESSAGE, objData);
		
		
	}
	
	@Ignore
	public void testGetAffiliates()
	{
		
		GenericTicketRespTo affData = null;
		Assert.assertNull(ASSERT_NULL_MESSAGE, affData);
		affData = TicketAPIUtil.getAllAffiliates();
		Assert.assertNotNull(ASSERT_NOT_NULL_MESSAGE, affData);
		getLog().info(affData);
		
	}
	
	
	@Test
	public void testSearchingEvents()
	{
		List<EventDisplayObj> resultList = null;
		Assert.assertNull(ASSERT_NULL_MESSAGE, resultList);
		resultList = TicketAPIUtil.getEventDataForMainSearch(TEST_EVENT_SEARCH_TERM);
		Assert.assertNotNull(ASSERT_NOT_NULL_MESSAGE, resultList);
	}
	

}
