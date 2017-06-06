/**
 * @date Jun 8, 2015
 */
package com.netreality.vertie.test;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.live4carnival.web.integration.rest.util.Live4CarnivalRestUtil;
import com.netreality.live4carnival.integration.to.QPXAirfareRequest;
import com.netreality.live4carnival.integration.to.QPXAirfareRequestTO;
import com.netreality.live4carnival.integration.to.QPXAirfareResponseTO;
import com.netreality.live4carnival.integration.to.QPXAirfareResponseTripOption;
import com.netreality.live4carnival.integration.to.QPXPassengersTO;
import com.netreality.live4carnival.integration.to.QPXSlice;

/**
 * @author ldurh516
 *
 * @date Jun 8, 2015
 *	
 */
public class AirfareSearchTest extends BaseUnitTest {
	
private static QPXAirfareRequestTO testRequest;
	
	private static QPXPassengersTO testPassengerList;
	private static QPXPassengersTO testPassengerList1;
	private static QPXSlice TEST_SLICE_OBJ;
	private static QPXSlice TEST_SLICE_OBJ_RT;
	private static QPXSlice TEST_SLICE_OBJ_RT_LEG_1;
	private static Integer TEST_AIRFARE_REQUEST_ADULT_COUNT;
	private static String TEST_FLIGHT_ORGINATION_CODE = "IAD";
	private static String TEST_FLIGHT_DESTINATION_CODE = "MIA";
	private static String TEST_FLIGHT_DATE = "2016-05-12";
	private String QPX_TARGET_URL = "";
	private static String TEST_MAX_TRIP_PRICE = "USD300.00";
	private static QPXAirfareRequest TEST_AIRFARE_REQUEST = null;
	private static QPXAirfareRequest TEST_AIRFARE_REQUEST_ROUNDTRIP = null;
	private static Integer TEST_FLIGHT_SOLUTIONS = 20;
	private static String TEST_SALE_COUNTRY = "US";
	private static List<QPXSlice> trips = null;
	private static List<QPXSlice> TEST_TRIPS = null;
	private Live4CarnivalRestUtil util = null;
	private static QPXAirfareRequestTO testRoundTrip;
	
	@BeforeClass
	public static void setUp()
	{
		testPassengerList = new QPXPassengersTO();
		TEST_SLICE_OBJ = new QPXSlice();
		TEST_SLICE_OBJ.setDate(TEST_FLIGHT_DATE);
		TEST_SLICE_OBJ.setOrigin(TEST_FLIGHT_ORGINATION_CODE);
		TEST_SLICE_OBJ.setDestination(TEST_FLIGHT_DESTINATION_CODE);
		TEST_AIRFARE_REQUEST_ADULT_COUNT = 1;
		testPassengerList.setAdultCount(TEST_AIRFARE_REQUEST_ADULT_COUNT);
		testRequest = new QPXAirfareRequestTO();
		TEST_AIRFARE_REQUEST = new QPXAirfareRequest();
		TEST_AIRFARE_REQUEST.setMaxPrice(TEST_MAX_TRIP_PRICE);
		TEST_AIRFARE_REQUEST.setSaleCountry(TEST_SALE_COUNTRY);
		TEST_AIRFARE_REQUEST.setPassengers(testPassengerList);
		trips = new ArrayList<QPXSlice>();
		//add various objects
		trips.add(TEST_SLICE_OBJ);
		TEST_AIRFARE_REQUEST.setSlice(trips);
		testRequest.setRequest(TEST_AIRFARE_REQUEST);
		
		//TRIP Origin
		TEST_SLICE_OBJ_RT = new QPXSlice();
		TEST_SLICE_OBJ_RT.setOrigin("IAD");
		TEST_SLICE_OBJ_RT.setDestination("MIA");
		TEST_SLICE_OBJ_RT.setDate("2016-12-10");
		TEST_SLICE_OBJ_RT.setPreferredCabin("COACH");
		
		TEST_SLICE_OBJ_RT_LEG_1 = new QPXSlice();
		TEST_SLICE_OBJ_RT_LEG_1.setOrigin("MIA");
		TEST_SLICE_OBJ_RT_LEG_1.setDestination("IAD");
		TEST_SLICE_OBJ_RT_LEG_1.setDate("2016-12-18");
		TEST_SLICE_OBJ_RT_LEG_1.setPreferredCabin("COACH");
		
		TEST_TRIPS = new ArrayList<QPXSlice>();
		TEST_TRIPS.add(TEST_SLICE_OBJ_RT);
		TEST_TRIPS.add(TEST_SLICE_OBJ_RT_LEG_1);
		
		 testPassengerList1 = new QPXPassengersTO();
		 testPassengerList1.setAdultCount(2);
		 
		 
		 TEST_AIRFARE_REQUEST_ROUNDTRIP = new QPXAirfareRequest();
		 TEST_AIRFARE_REQUEST_ROUNDTRIP.setMaxPrice(TEST_MAX_TRIP_PRICE);
		 TEST_AIRFARE_REQUEST_ROUNDTRIP.setSolutions(TEST_FLIGHT_SOLUTIONS);
		 TEST_AIRFARE_REQUEST_ROUNDTRIP.setSlice(TEST_TRIPS);
		 TEST_AIRFARE_REQUEST_ROUNDTRIP.setSaleCountry(TEST_SALE_COUNTRY);
		 TEST_AIRFARE_REQUEST_ROUNDTRIP.setPassengers(testPassengerList1);
		 TEST_AIRFARE_REQUEST_ROUNDTRIP.setRefundable(true);
		 
		 
		 
		 testRoundTrip = new QPXAirfareRequestTO();
		 testRoundTrip.setRequest(TEST_AIRFARE_REQUEST_ROUNDTRIP);
		 setLogger(Logger.getLogger(AirfareSearchTest.class));
		
	}
	
	@AfterClass
	public static void tearDown()
	{
		testPassengerList = null;
		TEST_SLICE_OBJ = null;
		TEST_AIRFARE_REQUEST = null;
		testRequest = null;
		
	}
	
	@Test
	public void testQPXRequest()
	{
		QPXAirfareResponseTO singleSolutionResponse = null;
		String fareSolution = null;
		Assert.assertNull(ASSERT_NULL_MESSAGE, fareSolution);
		Assert.assertNull(ASSERT_NULL_MESSAGE, util);
		util = new Live4CarnivalRestUtil();
		//fareSolution = util.createQPXAPIRequest(QPX_TARGET_URL, testRequest);
		singleSolutionResponse = util.executeQPXAPIRequest(QPX_TARGET_URL, testRequest);
		List<QPXAirfareResponseTripOption> trips = singleSolutionResponse.getTrips().getTripOption();
		Assert.assertTrue(ASSERT_CONDITION_TRUE, !trips.isEmpty());
		getLog().info(trips.size());
		Assert.assertNotNull(ASSERT_NOT_NULL_MESSAGE, singleSolutionResponse);
	}
	
	@Ignore
	public void testRoundTrip()
	{
		QPXAirfareResponseTO solutionResponse = null;
		Assert.assertNull(ASSERT_NULL_MESSAGE, solutionResponse);
		String jsonStr = null;
		util = new Live4CarnivalRestUtil();
		/*StringWriter sw = null;
		ObjectMapper testMap = new ObjectMapper();
		try {
			//jsonStr = testMap.writeValueAsString(testRoundTrip);
			sw = new StringWriter();
			testMap.writeValue(sw, testRoundTrip);
			
			//sw.flush();
		} catch (JsonGenerationException jge) {
			getLog().error(jge);
		} catch (JsonMappingException jme) {
			
			getLog().error(jme);
		} catch (IOException ioe) {
			
			getLog().error(ioe);
		}
		getLog().debug(sw);*/
		solutionResponse = util.executeQPXAPIRequest(QPX_TARGET_URL, testRoundTrip);
		Assert.assertNotNull(ASSERT_NOT_NULL_MESSAGE, solutionResponse);
		//getLog().debug(solutionResponse);
	}
}
