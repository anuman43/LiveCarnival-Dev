/**
 * 
 */
package com.netreality.vertie.test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.live4carnival.accomodation.ean.hotelList.po.EANHotelListResponse;
import com.live4carnival.accomodation.ean.hotelList.po.EANRestHotelListResponse;
import com.live4carnival.accomodation.ean.rest.helper.EANRestUtility;
import com.live4carnival.accomodation.search.to.AcommodationRequestTO;
import com.live4carnival.accomodation.search.to.RoomRequestChildInfo;
import com.live4carnival.accomodation.search.to.RoomRequestDetailsTO;
import com.live4carnival.web.integration.rest.util.EANHotelApiRequests;
import com.live4carnival.web.integration.rest.util.Live4CarnivalRestUtil;



/**
 * @author JahLion
 *
 */
public class TestEANHtoleList extends BaseUnitTest {

	private static File TEST_EAN_HOTEL_LIST_RESPONSE_FILE;
	private static String TEST_EAN_HOTEL_LIST_RESPONSE_FILE_NAME = "C:\\LiveCarnivalBeta\\resources\\accomodation\\hotelList2.json";
	private static String TEST_HOTEL_LIST_REQUEST_CITY_PARAM_VALUE = "Frederick";
	private static String TEST_HOTEL_LIST_REQUEST_STATE_PARAM_VALUE = "MD";
	private static String TEST_HOTEL_LIST_REQUEST_COUNTRYCODE_PARAM_VALUE ="en-US";
	private static String TEST_HOTEL_LIST_REQUEST_ARRIVAL_DATE = "03/02/2018";
	private static String TEST_HOTEL_LIST_REQUEST_DEPATRURE_DATE = "03/12/2018";
	private static String TEST_HOTEL_LISTING_NUMBER_OF_KIDS = "2";
	private static String TEST_HOTEL_LISTING_NUMBER_OF_ADULTS = "2";
	//Accomodation Room Format for Rest
	private static RoomRequestDetailsTO TEST_ROOM_RESERVATION_REQUEST = null;
	private static String TEST_ROOM_RESERVATION_SEQ_1 = "1";
	private static String TEST_ROOM_RESERVATION_SEQ_8 = "8";
	
	
	@BeforeClass
	public static void setUp()
	{
		TEST_EAN_HOTEL_LIST_RESPONSE_FILE = new File(TEST_EAN_HOTEL_LIST_RESPONSE_FILE_NAME);
		setLogger(Logger.getLogger(TestEANHtoleList.class));
		TEST_ROOM_RESERVATION_REQUEST = new RoomRequestDetailsTO();
	}
	
	@AfterClass
	public static void tearDown()
	{
		TEST_EAN_HOTEL_LIST_RESPONSE_FILE = null;
		TEST_ROOM_RESERVATION_REQUEST = null;
		
	}
	
	
	@Ignore
	public void testConvertHotelJsonToPojo()
	{
		Assert.assertNotNull(ASSERT_NOT_NULL_MESSAGE, TEST_EAN_HOTEL_LIST_RESPONSE_FILE);
		Assert.assertTrue(ASSERT_CONDITION_TRUE, TEST_EAN_HOTEL_LIST_RESPONSE_FILE.exists());
		ObjectMapper objMapper = null;
		Assert.assertNull(ASSERT_NULL_MESSAGE, objMapper);
		objMapper = new ObjectMapper();
		//objMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		EANRestHotelListResponse respPojo = null;
		//JsonNode objNode = null;
		Assert.assertNull(ASSERT_NULL_MESSAGE, respPojo);
		try {
			respPojo = objMapper.readValue(TEST_EAN_HOTEL_LIST_RESPONSE_FILE, EANRestHotelListResponse.class);
			//objNode = objMapper.readTree(TEST_EAN_HOTEL_LIST_RESPONSE_FILE);
			//getLog().debug(objNode.get("customerSessionId").asText());
			Assert.assertNotNull(ASSERT_NOT_NULL_MESSAGE, respPojo);
		} catch (IOException mte) {
			getLog().error(mte);
			Assert.fail(mte.getCause().getMessage());
		}
		getLog().debug(respPojo.getHotelListResponse().getCacheKey());
		getLog().debug(respPojo.getHotelListResponse().getCachedSupplierResponse().getTpidUsed());
		// objNode.get("HotelListResponse");
	}
	
	@Ignore
	public void testHotelListRequest()
	{
		String hotelListReq = null;
		Assert.assertNull(ASSERT_NULL_MESSAGE, hotelListReq);
		EANHotelApiRequests hotelReq = null;
		Assert.assertNull(ASSERT_NULL_MESSAGE, hotelReq);
		hotelReq = new EANHotelApiRequests();
		hotelListReq = hotelReq.getHotelListByLocationParams(TEST_HOTEL_LIST_REQUEST_COUNTRYCODE_PARAM_VALUE, TEST_HOTEL_LIST_REQUEST_CITY_PARAM_VALUE, TEST_HOTEL_LIST_REQUEST_STATE_PARAM_VALUE);
		Assert.assertNotNull(ASSERT_NOT_NULL_MESSAGE, hotelListReq);
		getLog().debug(hotelListReq);
	}
	
	@Ignore
	public void testGetHotListingResponse()
	{
		String hotListingResponse = null;
		Assert.assertNull(ASSERT_NULL_MESSAGE, hotListingResponse);
		EANHotelApiRequests hotApi = null;
		hotApi = new EANHotelApiRequests();
		hotListingResponse = hotApi.getHotelListByLocation(TEST_HOTEL_LIST_REQUEST_COUNTRYCODE_PARAM_VALUE, TEST_HOTEL_LIST_REQUEST_CITY_PARAM_VALUE, TEST_HOTEL_LIST_REQUEST_STATE_PARAM_VALUE);
		Assert.assertNotNull(ASSERT_NOT_NULL_MESSAGE, hotListingResponse);
	}
	
	@Ignore
	public void testEANRegionDataAPI()
	{
		EANHotelApiRequests eanReq = null;
		Assert.assertNull(ASSERT_NULL_MESSAGE, eanReq);
		 eanReq = new EANHotelApiRequests();
		 String getEANRegionsUrlStr = null;
		 Assert.assertNull(ASSERT_NULL_MESSAGE, getEANRegionsUrlStr);
		 getEANRegionsUrlStr = eanReq.getAllEANTestRegionDescendantsURL();
		 getLog().debug(getEANRegionsUrlStr);
	}
	
	
	@Ignore
	public void testGetHotelsForRequest()
	{
		EANHotelApiRequests hotelRequest = null;
		AcommodationRequestTO requestForHotels = null;
		EANRestHotelListResponse hotelList = null;
		Assert.assertNull(ASSERT_NULL_MESSAGE, hotelList);
		Assert.assertNull(ASSERT_NULL_MESSAGE, requestForHotels);
		requestForHotels = new AcommodationRequestTO();
		requestForHotels.setDestinationCountry(TEST_HOTEL_LIST_REQUEST_COUNTRYCODE_PARAM_VALUE);
		requestForHotels.setDestinationState(TEST_HOTEL_LIST_REQUEST_STATE_PARAM_VALUE);
		requestForHotels.setDestinationCity(TEST_HOTEL_LIST_REQUEST_CITY_PARAM_VALUE);
		requestForHotels.setGuestKids(TEST_HOTEL_LISTING_NUMBER_OF_KIDS);
		requestForHotels.setGuestsAdults(TEST_HOTEL_LISTING_NUMBER_OF_ADULTS);
		requestForHotels.setStayFromDate(TEST_HOTEL_LIST_REQUEST_ARRIVAL_DATE);
		requestForHotels.setStayToDate(TEST_HOTEL_LIST_REQUEST_DEPATRURE_DATE);
		hotelRequest = new EANHotelApiRequests();
		hotelList = hotelRequest.performBaseHotelListSearch(requestForHotels);
		Assert.assertNotNull(ASSERT_NOT_NULL_MESSAGE, hotelList);
		
	}
	@Test
	public void testConvertRoomRequestToRestFormat()
	{
		Assert.assertNotNull(ASSERT_NOT_NULL_MESSAGE, TEST_ROOM_RESERVATION_REQUEST); 
		TEST_ROOM_RESERVATION_REQUEST.setNumOfAdults(2);
		TEST_ROOM_RESERVATION_REQUEST.setNumOfRooms(2);
		RoomRequestChildInfo childGuests1 = null;
		RoomRequestChildInfo childGuests2 = null;
		childGuests1 = new RoomRequestChildInfo();
		childGuests2 = new RoomRequestChildInfo();
		childGuests1.setChildAge(10);
		childGuests2.setChildAge(8);
		List<RoomRequestChildInfo> kidGuests = null;
		Assert.assertNull(ASSERT_NULL_MESSAGE, kidGuests);
		kidGuests = new ArrayList<RoomRequestChildInfo>();
		kidGuests.add(childGuests1);
		kidGuests.add(childGuests2);
		TEST_ROOM_RESERVATION_REQUEST.setKids(kidGuests);
		String roomResRequest = null;
		Assert.assertNull(ASSERT_NULL_MESSAGE, roomResRequest);
		roomResRequest = EANRestUtility.convertRoomPOToRest(TEST_ROOM_RESERVATION_REQUEST, TEST_ROOM_RESERVATION_SEQ_8);
		getLog().debug(roomResRequest);
	}
	
	
	
}
