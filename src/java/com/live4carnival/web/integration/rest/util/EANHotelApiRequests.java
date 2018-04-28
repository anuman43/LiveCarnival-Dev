package com.live4carnival.web.integration.rest.util;

import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.live4carnival.accomodation.ean.configuration.EANRequestConfigurator;
import com.live4carnival.accomodation.ean.hotelList.po.EANRestHotelListResponse;
import com.live4carnival.accomodation.ean.roomAvail.to.EANHotelRoomAvailabilityResponse;
import com.live4carnival.accomodation.ean.roomAvail.to.EANHotelRoomAvailabilityTO;
import com.live4carnival.accomodation.search.to.AcommodationRequestTO;
import com.live4carnival.accomodation.search.to.RoomAvailabilityRequestTO;
import com.netreality.vertie.search.util.SearchResultUtils;

public class EANHotelApiRequests {
	
	
	private final String EAN_API_PING_REQUEST_URL = "http://api.ean.com/ean-services/rs/hotel/v3/ping?";
	private final String EAN_API_PING_ECHO_PARAM_NAME = "echo";
	private final String EAN_API_PING_ECHO_PARAM_VALUE = "EchoTest";
	private Logger _log;
	//EAN API URLS 
	private final String EAN_API_HOTEL_LISTING_URL = "https://book.api.ean.com/ean-services/rs/hotel/v3/list?";
	private final String EAN_API_HOTEL_ROOM_AVAILABILITY_URL = "api.ean.com/ean-services/rs/hotel/v3/avail?";
	//Hotel List Parameters
	private final String EAN_API_HOTEL_LISTING_REQUEST_CITY_PARAM = "city";
	private final String EAN_API_HOTEL_LISTING_REQUEST_STATEPROVINCECODE_PARAM = "stateProvinceCode";
	private final String EAN_API_HOTEL_LISTING_REQUEST_COUNTRY_CODE_PARAM = "countryCode";
	private final String QUERY_PARAM_SEPERATOR = "&";
	private final String QUERY_PARAM_VALUE_OPERATOR = "=";
	//New EAN RAPID API URL
	private final String EAN_RAPID_TEST_URL = "https://test.ean.com/2/";
	//Geography uris
	private final String EAN_RAPID_LIST_REGIONS = "regions/";
	private final String EAN_RAPID_LIST_REGIONS_DESCENDANTS = "/descendants";
	
	//Request Configuration Helper class
	private EANRequestConfigurator reqConfig;
	
	//Hotel List Parameters
	private final String EAN_API_HOTEL_LIST_ARRIVAL_DATE_QUERY_PARAM = "arrivalDate";
	private final String EAN_API_HOTEL_LIST_DEPATURE_DATE_QUERY_PARAM = "depatureDate";
	private final String EAN_API_HOTEL_LIST_ROOM_NUMBER_OF_ADULTS = "Room.numberOfAdults";
	private final String EAN_API_HOTEL_LIST_ROOM_NUMBER_OF_CHILDREN = "Room.numberOfChildren";
	public EANHotelApiRequests()
	{
		 _log = LogManager.getLogger(EANHotelApiRequests.class);

		 reqConfig = new EANRequestConfigurator();
	}
	
	
	public Boolean hasEANAPIAccess()
	{
		Boolean canMakeEANRequests = false;
		
		return canMakeEANRequests;
	}
	
	
	
	
	private Map<String,String> buildPingParaMap()
	{
		Map<String,String> paramMap = null;
		
		return paramMap;
	}
	
	private String buildEchoParam()
	{
		String echoParmStr = null;
		echoParmStr =  "&" + this.EAN_API_PING_ECHO_PARAM_NAME +"=" + this.EAN_API_PING_ECHO_PARAM_VALUE;
		return echoParmStr;
	}
	
	public String createRestEchoRequest()
	{
					
		return buildBaseRestUri();
		
	}
	
	private String buildBaseRestUri()
	{
		String echoRestReqStr = null;
		
		EANRequestConfigurator eCon = new EANRequestConfigurator();
		
		echoRestReqStr = eCon.buildBaseEANRequestParams(buildEchoParam());
		
		//echoRestReqStr += buildEchoParam();
		
		_log.debug(echoRestReqStr);
				
		return echoRestReqStr;
		
	}
	
	public String getPingUrl()
	{
		return this.EAN_API_PING_REQUEST_URL;
	}
	//EANRestHotelListResponse
	public String getHotelListByLocation(String country,String city,String state)
	{
		EANRestHotelListResponse hotelList = null;
		
		String hotelListParams = getHotelListByLocationParams(country,city,state);
		
		String hotelListBaseURL = getHotelListingTargetURL();
		
		String listOfHotels = Live4CarnivalRestUtil.execGetHotelListingRequest(hotelListBaseURL, hotelListParams);
		
		return listOfHotels;
	}
	
	
	public EANHotelRoomAvailabilityResponse performHotelRoomAvailRequest(RoomAvailabilityRequestTO checkForRooms)
	{
		EANHotelRoomAvailabilityResponse roomAvail = null;
		
		String roomAvailURL = null;
		
		roomAvailURL = getHotelRoomAvailURL();
		
		_log.debug(roomAvailURL);
		
		if(checkForRooms != null)
		{
			Long hotelId = checkForRooms.getHotelId();
			String roomArrivalDate = checkForRooms.getArrivalDate();
			String departDate = checkForRooms.getDepartureDate();
			
		}
		
		return roomAvail;
	}
	
	
	public EANRestHotelListResponse performBaseHotelListSearch(AcommodationRequestTO accReq)
	{
		EANRestHotelListResponse hotelList = null;
		String baseUrl = null;
		String isoCtryCode = null;
		
		String hotelListingParams = null;
		if(accReq != null)
		{
			
			String destinationCtry = accReq.getDestinationCountry();
			isoCtryCode = SearchResultUtils.getISOTwoCountryCode(destinationCtry);
			String destinationStProv = accReq.getDestinationState();
			String destinationCity = accReq.getDestinationCity();
			String dateIn = accReq.getStayFromDate();
			String dateOut = accReq.getStayToDate();
			String adultCount = accReq.getGuestsAdults();
			String kidsCount = accReq.getGuestKids();
			baseUrl = getHotelListingTargetURL();
			_log.debug("The target url for EAN Hotel listing is: " + "baseUri");
			hotelListingParams = buildEANV3HotelListingRequest(isoCtryCode, destinationStProv, destinationCity, adultCount, kidsCount, dateIn, dateOut);
			_log.debug("Parameter list is:" + hotelListingParams);
			hotelList = Live4CarnivalRestUtil.execGetHotelListing(baseUrl, hotelListingParams);
		}
		
		
		
		return hotelList;
	}
	
	public EANHotelRoomAvailabilityResponse getHotelRoomInfo()
	{
		EANHotelRoomAvailabilityResponse availRooms = null;
		
		
		return availRooms;
	}
	
	private String getHotelRoomAvailURL()
	{
		return EAN_API_HOTEL_ROOM_AVAILABILITY_URL;
	}
	
	private String getHotelListingTargetURL()
	{
		return EAN_API_HOTEL_LISTING_URL;
	}
	
	public String getHotelListByLocationParams(String country,String city,String state)
	{
		String hotelListReqParams = "";
		
		EANRequestConfigurator config = new EANRequestConfigurator();
		
		hotelListReqParams = config.createBaseEANRequestParams();
		
		_log.debug("Base parameters= " +hotelListReqParams);
		
		hotelListReqParams += QUERY_PARAM_SEPERATOR + EAN_API_HOTEL_LISTING_REQUEST_CITY_PARAM + QUERY_PARAM_VALUE_OPERATOR + city + QUERY_PARAM_SEPERATOR + EAN_API_HOTEL_LISTING_REQUEST_STATEPROVINCECODE_PARAM + QUERY_PARAM_VALUE_OPERATOR + state + QUERY_PARAM_SEPERATOR +EAN_API_HOTEL_LISTING_REQUEST_COUNTRY_CODE_PARAM +QUERY_PARAM_VALUE_OPERATOR + country;
		
		//return hotelList;
		return hotelListReqParams;
		
	}
	
	
	private String buildRoomAvailListingRequest(Long hotelId,String arrivalDate,String departureDate,String RoomGroup)
	{
		String roomAvailReq = null;
		
		return roomAvailReq;
	}
	
	
	
	private String buildEANV3HotelListingRequest(String country,String state,String city,String adults,String kids,String inDate,String outdate)
	{
		EANRequestConfigurator config = new EANRequestConfigurator();
		
		String hotelListReqParams = "";
		
		hotelListReqParams = config.createBaseEANRequestParams();
		
		hotelListReqParams = addSignatureParam(hotelListReqParams,config.getApiKey(),config.getSharedSecret());
		
		hotelListReqParams += QUERY_PARAM_SEPERATOR + EAN_API_HOTEL_LISTING_REQUEST_CITY_PARAM + QUERY_PARAM_VALUE_OPERATOR + city + QUERY_PARAM_SEPERATOR + EAN_API_HOTEL_LISTING_REQUEST_STATEPROVINCECODE_PARAM + QUERY_PARAM_VALUE_OPERATOR + state + QUERY_PARAM_SEPERATOR +EAN_API_HOTEL_LISTING_REQUEST_COUNTRY_CODE_PARAM + QUERY_PARAM_VALUE_OPERATOR + country
				+ QUERY_PARAM_SEPERATOR + EAN_API_HOTEL_LIST_ROOM_NUMBER_OF_ADULTS + QUERY_PARAM_VALUE_OPERATOR + adults + QUERY_PARAM_SEPERATOR + EAN_API_HOTEL_LIST_ROOM_NUMBER_OF_CHILDREN + QUERY_PARAM_VALUE_OPERATOR + kids + QUERY_PARAM_SEPERATOR + EAN_API_HOTEL_LIST_ARRIVAL_DATE_QUERY_PARAM + QUERY_PARAM_VALUE_OPERATOR + inDate + QUERY_PARAM_SEPERATOR + EAN_API_HOTEL_LIST_DEPATURE_DATE_QUERY_PARAM + QUERY_PARAM_VALUE_OPERATOR + outdate;
		
		return hotelListReqParams;
		
	}
	
	
	private String addSignatureParam(String baseParams,String eanApiKey,String eanSecretKey)
	{
		String params = null;
		
		String eanSigHashValue = SignatureHashGenUtil.genEANSigHash(eanApiKey, eanSecretKey);
		
		params = baseParams;
		
		params += QUERY_PARAM_SEPERATOR + EANRequestConfigurator.getSigNatureParamKey() + QUERY_PARAM_VALUE_OPERATOR +eanSigHashValue;
		
		return params;
	}
	
	
	public String getAllEANRegions()
	{
		String allRegions = null;
		
		
		
		
		return allRegions;
	}
	
	
	public String getAllEANTestRegionDescendantsURL()
	{
		String allRegions = null;
		String allRegions_ID = "0";
		String requiredParams = createEANRapidRequiredParams();
		
		String testBaseUrl = null;
		testBaseUrl = getEANRegionURL(EAN_RAPID_TEST_URL);
		
		testBaseUrl += getRegionIDPath(allRegions_ID) + "?";
		
		allRegions =  Live4CarnivalRestUtil.execEANRapidRequest(testBaseUrl, requiredParams);
		
		return allRegions;
	}
	
	private String getRegionIDPath(String regionId)
	{
		return  regionId ;
		//return  regionId + EAN_RAPID_LIST_REGIONS_DESCENDANTS
	}
	
	private String getEANRegionURL(String baseUrl)
	{
		
		return baseUrl + EAN_RAPID_LIST_REGIONS;
	}
	
	private String createEANRapidRequiredParams()
	{
		
		String reqParamsQryStr = "";
		
		reqParamsQryStr += reqConfig.getEANRapidDefaultLangParam() + QUERY_PARAM_SEPERATOR + reqConfig.getEANRapidIncludeParams();
		
		_log.debug(reqParamsQryStr);
		
		return reqParamsQryStr;
	}
	
	
	
	
	
	
}
