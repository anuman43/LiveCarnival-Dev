/**
 * @date Jun 3, 2015
 */
package com.live4carnival.web.integration.rest.util;

import java.io.IOException;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.live4carnival.accomodation.ean.hotelList.po.EANRestHotelListResponse;
import com.live4carnival.accomodation.ean.ping.json.po.EANPingResponsePO;
import com.netreality.live4carnival.enums.HttpActionEnum;
import com.netreality.live4carnival.httpresponse.RestResponseHandler;
import com.netreality.live4carnival.integration.to.QPXAirfareRequestTO;
import com.netreality.live4carnival.integration.to.QPXAirfareResponseTO;
import com.netreality.vertie.search.GoogleCSESearchResponse;

/**
 * @author ldurh516
 *
 * @date Jun 3, 2015
 *	
 */
public class Live4CarnivalRestUtil {
	
	
	private static String CARNAVATTE_GOGGLE_CLIENT_ID = "AIzaSyA8jOrZiOuo5xWBS-gpNbrrmhPc1q1yDj8";
	public static String QPX_AIRFARE_URL = "https://www.googleapis.com/qpxExpress/v1/trips/search?key=";
	private static RestTemplate restRequestTemplate;
	private static RestResponseHandler respHandler;
	private static Logger _log = Logger.getLogger(Live4CarnivalRestUtil.class);
	private static List<HttpMessageConverter<?>> converters;
	private static StringHttpMessageConverter stConv;
	private static MappingJackson2HttpMessageConverter mjsonConv;
	private static MappingJackson2HttpMessageConverter mjsonConv1;
	
	//Google Custom Search Engine URL
	public static String CSE_SEARCH_URL = "https://www.googleapis.com/customsearch/v1";
	
	
	//LiveCarnival Ticketing Rest API
	private static String LIVECARNIVAL_TICKET_SCOKET_API_KEY = "8740d134a1dda91d878b764eed9f00f5-997863";
	//EAN Rapid Test Headers
	private static String TEST_EAN_STANDARD_HEADER_NAME = "Test";
	private static String TEST_EAN_STANDARD_HEADER_VALUE = "STANDARD";
	//EAN Authorization Header
	private static String EAN_AUTHORIZATION_HEADER_NAME = "Authorization";
	private static String EAN_AUTHORIZATION_HEADER_VALUE = "EAN APIKey=6d6abr6799s9qibqpnd8mu8uq7,signature=98376178a9885c158258bcf1a74679954d9d3b7bd5a455a4b15a5cc3fe34ca8c9a006fe9c210eba2e0a03cb16205bdbbb698f340dddfda2b9fd3b1aa2a31b208,timestamp=1515899117";
	//EAN Accept Header
	private static String EAN_ACCEPT_HEADER_NAME = "Accept";
	private static String EAN_ACCEPT_HEADER_VALUE = "application/json";
	//EAN Accept-Encoding Header
	private static String EAN_ACCEPT_ENCODING_HEADER_NAME = "Accept-Encoding";
	private static String EAN_ACCEPT_ENCODING_HEADER_VALUE = "gzip";
	//Customer IP Header
	private static String EAN_CUSTOMER_IP_HEADER_NAME = "Customer-Ip";
	private static String EAN_CUSTOMER_IP_HEADER_VALUE = "192.168.1.1";
	
	//EAN API KEY HEADER
	private static String EAN_API_KEY_HEADER_NAME = "apiKey";
	private static String EAN_API_KEY_HEADER_VALUE = "6d6abr6799s9qibqpnd8mu8uq7";
	//EAN Timestamp Header
	private static String EAN_TIMESTAMP_HEADER_NAME = "timestamp";
	private static String EAN_TIMESTAMP_HEADER_VALUE = "";
	//Server Timestamp
	private static String EAN_SERVER_TIMESTAMP_HEADER_NAME = "servertimestamp";
	private static String EAN_SERVER_TIMESTAMP_HEADER_VALUE = "";
	//Signature Header
	private static String EAN_SERVER_SIGNATURE_HEADER_NAME = "signature";
	private static String EAN_SERVER_SIGNATURE_HEADER_VALUE = "171eed97f9b7c79486e4bbb4b584857c";
	
	
	static
	{
		restRequestTemplate = new RestTemplate();
		respHandler = new RestResponseHandler();
		restRequestTemplate.setErrorHandler(respHandler);
		stConv = new StringHttpMessageConverter();
		converters = new ArrayList<HttpMessageConverter<?>>();
		converters.add(stConv);
		mjsonConv = new MappingJackson2HttpMessageConverter();
		
		ObjectMapper objMap = mjsonConv.getObjectMapper();
		objMap.setSerializationInclusion(Include.NON_DEFAULT);
		
		/*
		objMap.configure(Feature.AUTO_CLOSE_SOURCE, true);
		
		try {
			objMap.writeValue(new StringWriter(), QPXAirfareRequestTO.class);
			//objMap.writeValue(new StringWriter(), QPXAirfareResponseTO.class);
			
		} catch (JsonGenerationException jge) {
			_log.error(jge);
		} catch (JsonMappingException jme) {
			_log.error(jme);
		} catch (IOException ioe) {
			_log.error(ioe);
		}*/
		converters.add(mjsonConv);
		
		restRequestTemplate.setMessageConverters(converters);
	}
	
	
	public static String executeEANPingRestRequest(String pingReqUrl,String pingQryParams)
	{
		String pingResult = null;
		
		HttpEntity<String> reqEnt = null;
		
		reqEnt = new HttpEntity<String>(pingQryParams);
		
		pingResult = invokeRestRequest(pingReqUrl,HttpActionEnum.Get.getAction(),reqEnt,null);
		
		_log.debug("EAN Ping response "+ pingResult);
		
		return pingResult;
	}
	
	
	public static EANPingResponsePO executeEANPingRequest(String pingReqUrl,String pingQryParams)
	{
		EANPingResponsePO pingResp = null;
		
		String restResponse = null;
		
		restResponse = executeEANPingRestRequest(pingReqUrl, pingQryParams);
		
		ObjectMapper mapper = null;
		
		if(restResponse != null)
		{
			mapper = new ObjectMapper();
			
			try {
				pingResp = mapper.readValue(restResponse, EANPingResponsePO.class);
			} catch (IOException ioe) {
				_log.error(ioe);
			}
			
		}
		
		
		return pingResp;
	}
	
	
	
	
	public String createQPXAPIRequest(String qpxUrl,QPXAirfareRequestTO airfareInquiry)
	{
		String airFareResponse = null;
		HttpEntity<QPXAirfareRequestTO> reqEnt = null;
		
		if(qpxUrl != null && airfareInquiry != null)
		{
			reqEnt = new HttpEntity<QPXAirfareRequestTO>(airfareInquiry);
		}
		
		
		airFareResponse = invokeRestRequest(QPX_AIRFARE_URL + CARNAVATTE_GOGGLE_CLIENT_ID,HttpActionEnum.RestPost.getAction(),reqEnt,null);
		
		return airFareResponse;
	}
	
	public static QPXAirfareResponseTO executeQPXAPIRequest(String qpxUrl,QPXAirfareRequestTO airfareInquiry)
	{
		String airFareResponse = null;
		HttpEntity<QPXAirfareRequestTO> reqEnt = null;
		QPXAirfareResponseTO solutions = null;
		
		if(qpxUrl != null && airfareInquiry != null)
		{
			printQPXRequest(airfareInquiry);
			reqEnt = new HttpEntity<QPXAirfareRequestTO>(airfareInquiry);
		}
		
		
		airFareResponse = invokeRestRequest(QPX_AIRFARE_URL + CARNAVATTE_GOGGLE_CLIENT_ID,HttpActionEnum.RestPost.getAction(),reqEnt,null);
		
		if(airFareResponse != null)
		{
			_log.debug(airFareResponse);
			ObjectMapper objMap = new ObjectMapper();
			try {
				solutions = objMap.readValue(airFareResponse, QPXAirfareResponseTO.class);
			} catch (JsonGenerationException jge) {
				_log.error(jge);
			} catch (JsonMappingException jme) {
				_log.error(jme);
			} catch (IOException ioe) {
				_log.error(ioe);
			}
			_log.debug(solutions);
		}
		
		return solutions;
	}
	
	public static String executeTicketRestCall(String restReq)
	{
		String ticketResp = null;
		
		HttpEntity<String> requestEntity  = new HttpEntity<String> ("");
		
		if(restReq != null)
		{
			_log.debug("Invoke Rest call for uri-" + restReq);
			requestEntity  = new HttpEntity<String>("");
			ticketResp = invokeRestRequest(restReq, HttpActionEnum.Get.getAction(), requestEntity, null);
		}
		
		_log.debug(ticketResp);
		return ticketResp;
		
	}
	
	
	
	
	private static Document convertRestStringToXml(String responseBody)
	{
		org.dom4j.Document convertedToXml = null;
		
		if(responseBody != null)
		{
			try {
				convertedToXml = DocumentHelper.parseText(responseBody);
			} catch (DocumentException docE) {
				_log.error("Error converting returned string to xml document", docE);
			}
		}
		else
		{
			_log.debug("Response string is null");
		}
		
		return convertedToXml;
		
	}
	
	public static GoogleCSESearchResponse executeCSERequest(String searchReq) throws RestClientException, UnsupportedEncodingException
	{
		Document xmlSearchResults = null;
		
		GoogleCSESearchResponse searchResp = null;
		
		String restResponse = null;
		
		HttpEntity<String> cseSearchReq = null;
		
		if(searchReq != null)
		{
			cseSearchReq = new HttpEntity<String>(searchReq);
			
		}
		
		restResponse = invokeRestRequest(CSE_SEARCH_URL + "?" + searchReq, HttpActionEnum.Get.getAction(), null, null);
		
		if(restResponse != null)
		{
			//xmlSearchResults = convertRestStringToXml(restResponse);
			ObjectMapper objMap = new ObjectMapper();
			try {
				searchResp = objMap.readValue(restResponse,GoogleCSESearchResponse.class);
			} catch (IOException ioe) {
				_log.error(ioe);
			}
			
		}
		
		
		return searchResp;
	}
	
	private static void printQPXRequest(QPXAirfareRequestTO airfareInquiry)
	{
		StringWriter sw = null;
		ObjectMapper testMap = new ObjectMapper();
		if(airfareInquiry != null)
		{
			try {
				sw = new StringWriter();
				testMap.writeValue(sw, airfareInquiry);
				_log.info("Logging QPX JSON Flight Request" +sw.toString());
			} catch (JsonGenerationException jge) {
				_log.error(jge);
			} catch (JsonMappingException jme) {
				_log.error(jme);
			} catch (IOException ioe) {
				_log.error(ioe);
			}
			finally
			{
				try {
					sw.close();
				} catch (IOException ioe) {
					_log.error(ioe);
				}
			}
	}
	}
	
	/**
	public QPXAirfareResponseTO executeQPXAPIRequest(String qpxUrl,QPXAirfareRequestTO airfareInquiry)
	{
		String airFareResponse = null;
		HttpEntity<String> reqEnt = null;
		QPXAirfareResponseTO solutions = null;
		StringWriter sw = null;
		ObjectMapper testMap = new ObjectMapper();
		if(qpxUrl != null && airfareInquiry != null)
		{
			try {
				sw = new StringWriter();
				testMap.writeValue(sw, airfareInquiry);
			} catch (JsonGenerationException jge) {
				_log.error(jge);
			} catch (JsonMappingException jme) {
				_log.error(jme);
			} catch (IOException ioe) {
				_log.error(ioe);
			}
			finally
			{
				try {
					sw.close();
				} catch (IOException ioe) {
					_log.error(ioe);
				}
			}
			reqEnt = new HttpEntity<String>(sw.toString());
		}
		
		
		airFareResponse = performRcRESTOperation(QPX_AIRFARE_URL + CARNAVATTE_GOGGLE_CLIENT_ID,HttpActionEnum.RestPost.getAction(),reqEnt,null);
		
		if(airFareResponse != null)
		{
			_log.debug(airFareResponse);
			ObjectMapper objMap = new ObjectMapper();
			try {
				solutions = objMap.readValue(airFareResponse, QPXAirfareResponseTO.class);
			} catch (JsonGenerationException jge) {
				_log.error(jge);
			} catch (JsonMappingException jme) {
				_log.error(jme);
			} catch (IOException ioe) {
				_log.error(ioe);
			}
			_log.debug(solutions.getTrips().getData().getAircraft().size());
		}
		
		return solutions;
	}
	**/
	
	
	public String getLiveCarnivalEvents(String searchQry,Integer categoryId,Integer limit,Integer offSet)
	{
		String result = null;
		
		return result;
	}
	
	
	
	public static String buildRestReq(String targetURL,String apiKey,Map<String,String> qryMap)
	{
		
		
		String invokedUrl = targetURL + "?";
		Integer counter = 1;
		//qryMap.entrySet().size();
		
		if(!qryMap.isEmpty())
		{
		
			for(Map.Entry<String,String> qry:qryMap.entrySet())
			{
				invokedUrl += qry.getKey() + "=" + qry.getValue();
				if(counter < qryMap.entrySet().size())
					invokedUrl += "&";
				counter++;
				_log.debug(invokedUrl);
			}
			
			invokedUrl += "&key=" + apiKey;
		}
		
		else
		{
			invokedUrl += "key=" + apiKey;
		}
		
		
		_log.debug(invokedUrl);
		
		
		return invokedUrl;
	}
	
	
	
	private static String invokeRestRequest(String rcRESTUri,Integer action,HttpEntity<?> requestEntity,Object args) throws RestClientException 
	{
		String restActionResult = null;
		ResponseEntity<String> restResponse = null;
		switch(action)
		{
			
			case 0:
				restResponse = restRequestTemplate.exchange(rcRESTUri, HttpMethod.HEAD, requestEntity, String.class);
				if(restResponse != null && restResponse.getStatusCode().value() == 200)
				{
					//restActionResult = getSessionIdFromHeaders(restResponse.getHeaders());
				}
				else
				{
					//throw new RestClientException("Rest Operation failed due to " + restResponse.getStatusCode().toString());
				}
				break;
			case 1:
				if(args != null)
				{
					restResponse = restRequestTemplate.exchange(rcRESTUri, HttpMethod.GET, requestEntity, String.class,args);
				}
				else
				{
					restResponse = restRequestTemplate.exchange(rcRESTUri, HttpMethod.GET, requestEntity, String.class);
				}
					
				
				if(restResponse != null && restResponse.getStatusCode().value() == 200)
				{
					restActionResult = restResponse.getBody();
					_log.debug(restActionResult);
				}
				else
				{
					restActionResult = restResponse.getBody();
					_log.debug(restActionResult);
					if(restActionResult != null && restActionResult.trim().length() < 1)
						throw new RestClientException("Rest Operation failed due to " + restResponse.getStatusCode().toString());
				}
				break;
			case 2:
				restResponse = restRequestTemplate.exchange(rcRESTUri, HttpMethod.POST, requestEntity, String.class, args);
				//restResponse = restRequestTemplate.postForEntity(rcRESTUri, requestEntity, String.class, args);
				_log.debug("Invoking Post Operation");
				if(restResponse != null && restResponse.getStatusCode().value() == 200)
				{
					restActionResult = restResponse.getBody();
					_log.debug(restActionResult);
				}
				else
				{
					throw new RestClientException("Rest Operation failed due to " + restResponse.getStatusCode().toString());
				}
				break;
				
			case 3:
			URI targetUri = null;
			try {
				targetUri = new URI(rcRESTUri);
			} catch (URISyntaxException ure) {
				_log.equals(ure);
			}
				restActionResult = restRequestTemplate.getForObject(targetUri, String.class);
				if(restActionResult != null )
				{
					_log.debug(restActionResult);
				}
				
				else
				{
					
					throw new RestClientException("Rest Operation failed due to " + restActionResult);
				}
				break;
				
			case 4:
				restActionResult = restRequestTemplate.postForObject(rcRESTUri, requestEntity, String.class, args);
				_log.debug(requestEntity.toString());
				if(restActionResult != null )
				{
					_log.debug(restActionResult);
				}
				
				else
				{
					
					throw new RestClientException("Rest Operation failed due to " + restActionResult);
				}
				break;
				
			default:
				_log.debug("Unspecified action provided");
				break;
			
		}
		
		
		
		
		
		
		
		return restActionResult;
	}

	
	public static String execGetHotelListingRequest(String hotelReqUrl,String hotelReqParams)
	{
		String hotelListResp = null;
		
		HttpEntity<String> reqEnt = null;
		
		//reqEnt = new HttpEntity<String>();
		
		hotelListResp = invokeRestRequest(hotelReqUrl + hotelReqParams, HttpActionEnum.Get.getAction(), reqEnt, null);
		
		return hotelListResp;
	}
	
	
	public static EANRestHotelListResponse execGetHotelListing(String hotelReqUrl,String hotelReqParams)
	{
		String hotelListResp = null;
		
		EANRestHotelListResponse resp = null;
		
		ObjectMapper objMapper = null;
		
		HttpEntity<String> reqEnt = null;
		
		objMapper = new ObjectMapper();
		
		hotelListResp = invokeRestRequest(hotelReqUrl + hotelReqParams, HttpActionEnum.Get.getAction(), reqEnt, null);
		
		try {
			resp =objMapper.readValue(hotelListResp,EANRestHotelListResponse.class);
		} catch (IOException mce) {
			_log.error(mce);
		}
		
		return resp;
	}
	
	
	public static String execEANRapidRequest(String rapidEANUrl,String params)
	{
		String restResult = null;
		
		HttpEntity<String> reqEnt = null;
		
		HttpHeaders reqHeaders = getTestEANRapidHeaders();
		
		reqEnt = new HttpEntity<String>(params,reqHeaders);
		
		_log.debug("EAN Rapid Url is- " + rapidEANUrl);
		
		restResult = invokeRestRequest(rapidEANUrl ,HttpActionEnum.Get.getAction(),reqEnt,null);
				
		
		return restResult;
	}
	
	
	private static HttpHeaders createHeader(String headerName, String headerValue)
	{
		HttpHeaders header = new HttpHeaders();
		
		header.add(headerName, headerValue);
		
		return header;
	}
	
	public HttpHeaders createTestEANRapidHeader()
	{
		HttpHeaders testHeader = null;
		
		testHeader = createHeader(TEST_EAN_STANDARD_HEADER_NAME, TEST_EAN_STANDARD_HEADER_VALUE);
		
		return testHeader;
	}
	
	
	public static HttpHeaders createEANAuthorizationHeader()
	{
		HttpHeaders authzHeader = null;
		
		authzHeader = createHeader(EAN_AUTHORIZATION_HEADER_NAME, EAN_AUTHORIZATION_HEADER_VALUE);
		
		
		return authzHeader;
	}
	
	
	public static HttpHeaders getTestEANRapidHeaders()
	{
		
		
		HttpHeaders testReqHeaders = null;
		
		Long timeStamp = System.currentTimeMillis();
		
		EAN_TIMESTAMP_HEADER_VALUE = timeStamp.toString();
		
		EAN_SERVER_TIMESTAMP_HEADER_VALUE = timeStamp.toString();
		
		testReqHeaders = new HttpHeaders();
		
		testReqHeaders.add(EAN_AUTHORIZATION_HEADER_NAME, EAN_AUTHORIZATION_HEADER_VALUE);
		
		//testReqHeaders.add(TEST_EAN_STANDARD_HEADER_NAME, TEST_EAN_STANDARD_HEADER_VALUE);
		
		testReqHeaders.add(EAN_ACCEPT_HEADER_NAME, EAN_ACCEPT_HEADER_VALUE);
		
		testReqHeaders.add(EAN_ACCEPT_ENCODING_HEADER_NAME, EAN_ACCEPT_ENCODING_HEADER_VALUE);
		
		testReqHeaders.add(EAN_CUSTOMER_IP_HEADER_NAME, EAN_AUTHORIZATION_HEADER_VALUE);
		
		testReqHeaders.add(EAN_API_KEY_HEADER_NAME, EAN_API_KEY_HEADER_VALUE);
		
		testReqHeaders.add(EAN_TIMESTAMP_HEADER_NAME, EAN_TIMESTAMP_HEADER_VALUE);
		testReqHeaders.add(EAN_SERVER_SIGNATURE_HEADER_NAME, EAN_SERVER_SIGNATURE_HEADER_VALUE);
		testReqHeaders.add(EAN_SERVER_TIMESTAMP_HEADER_NAME, EAN_SERVER_TIMESTAMP_HEADER_VALUE);
		
		return testReqHeaders;
	}
	
	
}
