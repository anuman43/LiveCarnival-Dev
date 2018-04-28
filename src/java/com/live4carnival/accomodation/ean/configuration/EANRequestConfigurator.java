/**
 * 
 */
package com.live4carnival.accomodation.ean.configuration;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * @author JahLion
 *
 */
public class EANRequestConfigurator {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3267006051432494027L;
	private final String EAN_COMMON_REQUIRED_REQUEST_API_REFERENCE_REQ_PARAM = "apiExperience";
	private List<String> EAN_COMMON_REQUIRED_REQUEST_PARAM_LIST;
	private final String EAN_COMMON_REQUIRED_REQUEST_CID = "cid";
	private static final String EAN_COMMON_REQUIRED_REQUEST_API_KEY = "apiKey";
	private final String EAN_COMMON_REQUIRED_REQUEST_MINOR_REV = "minorRev";
	private final String EAN_COMMON_REQUIRED_PARAMETER_LOCALE_KEY = "locale";
	private final String EAN_COMMON_REQUIRED_PARAMETER_CUSTOMER_SESSION_ID = "customerSessionId";
	private final static String EAN_COMMON_REQUIRED_PARAMETER_SIGNATURE_KEY = "sig";
	private final String EAN_COMMON_REQUIRED_PARAMETER_CUSTOMER_IP_VALUE = "172.29.45.145";
	private final String EAN_COMMON_REQUIRED_PARAMETER_CUSTOMER_IP = "customerIpAddress";
	private final String EAN_COMMON_REQUIRED_PARAMETER_CUSTOMER_SESSIONID_VALUE = "3267006051432494027L";
	
	//default values
	private final String EAN_API_KEY_VALUE = "6d6abr6799s9qibqpnd8mu8uq7";
	private final String EAN_SECRET_KEY_VALUE = "8vrb0agj85f98";
	private final Long EAN_CID_VALUE = 490695L;
	private final String EAN_API_EXPERIENCE_VALUE = "PARTNER_AFFILIATE";
	private final String EAN_SIG = "1399f350cbdb73f20f3c963360c279a6";
	private final Integer EAN_MINOR_REV_VALUE = 24;
	
	private final String DEFAULT_LOCALE = "en-US";
	private final String DEFAULT_CURRENCY = "USD";
	
	private final String EAN_CUSTOMER_USER_AGENT_KEY = "customerUserAgent";
	private final String TEST_EAN_CUSTOMER_USER_AGENT_VALUE = "LiveCarnival/1.0beta(Windows 10)";
	 
	
	//optional request parameters
	private final String EAN_OPTIONAL_CURRENCY_CODE_KEY = "currencyCode";
	
	private final String EAN_GENERAL_REQUEST_ENDPOINT = "http://api.ean.com";
	private final String EAN_HOTEL_BOOKING_ENDPOINT = "https://book.api.ean.com";
	
	//request query operator 
	private final String REQUEST_QUERY_OP ="?";
	private final String REQUEST_QUERY_PARAM_STR = "&";
	
	private Logger _log = LogManager.getLogger(EANRequestConfigurator.class);
	
	
	//EAN RAPID API
	private final String EAN_RAPID_LANGAUGE_PARAM_NAME = "language";
	private final String EAN_RAPID_REGION_RESPONSE_INCLUDE_PARAM = "include";
	
	
	public static String getSigNatureParamKey()
	{
		return EAN_COMMON_REQUIRED_PARAMETER_SIGNATURE_KEY;
	}
	
	
	public EANRequestConfigurator()
	{
		EAN_COMMON_REQUIRED_REQUEST_PARAM_LIST = new ArrayList<String>();
	} 
	
	public List<String> getCommnRequestParamList()
	{
		this.EAN_COMMON_REQUIRED_REQUEST_PARAM_LIST.add(EAN_COMMON_REQUIRED_REQUEST_API_KEY);
		this.EAN_COMMON_REQUIRED_REQUEST_PARAM_LIST.add(EAN_COMMON_REQUIRED_REQUEST_API_REFERENCE_REQ_PARAM);
		this.EAN_COMMON_REQUIRED_REQUEST_PARAM_LIST.add(EAN_COMMON_REQUIRED_REQUEST_CID);
		this.EAN_COMMON_REQUIRED_REQUEST_PARAM_LIST.add(EAN_COMMON_REQUIRED_REQUEST_MINOR_REV);
		this.EAN_COMMON_REQUIRED_REQUEST_PARAM_LIST.add(EAN_COMMON_REQUIRED_PARAMETER_SIGNATURE_KEY);
		
		
		return this.EAN_COMMON_REQUIRED_REQUEST_PARAM_LIST;
	}
	
	private Map<String,String> createCommonMap()
	{
		Map<String,String> cRequestMap = new HashMap<String,String>();
		
		/*for(String s: this.EAN_COMMON_REQUIRED_REQUEST_PARAM_LIST)
		{
			cRequestMap.put(s, new String());
		}
		*/
		
		cRequestMap.put(EAN_COMMON_REQUIRED_REQUEST_CID, EAN_CID_VALUE.toString());
		cRequestMap.put(EAN_COMMON_REQUIRED_REQUEST_API_KEY, EAN_API_KEY_VALUE);
		cRequestMap.put(EAN_COMMON_REQUIRED_REQUEST_MINOR_REV, EAN_MINOR_REV_VALUE.toString());
		cRequestMap.put(EAN_COMMON_REQUIRED_PARAMETER_LOCALE_KEY, DEFAULT_LOCALE);
		cRequestMap.put(EAN_OPTIONAL_CURRENCY_CODE_KEY, DEFAULT_CURRENCY);
		//cRequestMap.put(EAN_COMMON_REQUIRED_PARAMETER_SIGNATURE_KEY, EAN_SIG);
		cRequestMap.put(EAN_COMMON_REQUIRED_REQUEST_API_REFERENCE_REQ_PARAM, EAN_API_EXPERIENCE_VALUE);
		cRequestMap.put(EAN_COMMON_REQUIRED_PARAMETER_CUSTOMER_SESSION_ID, EAN_COMMON_REQUIRED_PARAMETER_CUSTOMER_SESSIONID_VALUE);
		cRequestMap.put(EAN_COMMON_REQUIRED_PARAMETER_CUSTOMER_IP, EAN_COMMON_REQUIRED_PARAMETER_CUSTOMER_IP_VALUE);
		cRequestMap.put(EAN_CUSTOMER_USER_AGENT_KEY, TEST_EAN_CUSTOMER_USER_AGENT_VALUE);
		
		
		return cRequestMap;
	}
	
	public Map<String,String> createCommonRequestMapping(String reqMapValues)
	{
		Map<String,String> comReqMap = null;
		comReqMap = createCommonMap();
		
		
		
		
		return comReqMap;
	}
	
	
	public String getApiKey()
	{
		return EAN_API_KEY_VALUE;
	}
	
	public String getSharedSecret()
	{
		return  EAN_SECRET_KEY_VALUE;
	}
	
	
	
	private String getDefaultLocale()
	{
		return this.DEFAULT_LOCALE;
	}
	
	public String getCommonEANEndpoint()
	{
		return EANEndpointsEnum.EanGeneralEndPoint.getEndPointVal();
	}
	
	public String buildCommonEANReqStr()
	{
		String eanGeneralReq = null;
		eanGeneralReq = getCommonEANEndpoint();
		 
		eanGeneralReq = buildBaseEANRequest(eanGeneralReq);
		
		return eanGeneralReq;
		
	}
	
	public String buildBaseEANBookingRequest()
	{
		
		String bookingEndPoint = getBookingEndPoint();
		
		String bookReqStr = null;
		
		if(bookingEndPoint != null)
		{
			bookReqStr = buildBaseEANRequest(bookingEndPoint);
		}
				
		else
		{
			_log.error("No endpoint provided");
		}
		
		
		return bookReqStr;
	}
	
	private String buildBaseEANRequest(String endPointStr)
	{
		String reqStr = endPointStr;
		
		reqStr +=this.REQUEST_QUERY_OP;
			_log.debug(reqStr);
			
			for(Map.Entry<String, String> kv: createCommonMap().entrySet())
			{
				if(kv.getKey() != null && kv.getValue() != null)
				{
					reqStr += kv.getKey() + "="+  kv.getValue()+  this.REQUEST_QUERY_PARAM_STR;
				
				}
			}
			
			reqStr = reqStr.substring(0, reqStr.lastIndexOf(REQUEST_QUERY_PARAM_STR));
			_log.debug("Request String is " + reqStr);
		
		
		return reqStr;
		
	}
	
	
	public String buildBaseEANRequestParams(String apiReqParams)
	{
		String reqStr = new String();
		
		
			
			for(Map.Entry<String, String> kv: createCommonMap().entrySet())
			{
				if(kv.getKey() != null && kv.getValue() != null)
				{
					reqStr += kv.getKey() + "="+  kv.getValue()+  this.REQUEST_QUERY_PARAM_STR;
				
				}
			}
			
			reqStr = reqStr.substring(0, reqStr.lastIndexOf(REQUEST_QUERY_PARAM_STR));
			reqStr += apiReqParams;
			_log.debug("Request String is " + reqStr);
		
		
		return reqStr;
		
	}
	
	
	public String createBaseEANRequestParams()
	{
		String reqStr = new String();
		
		
			
			for(Map.Entry<String, String> kv: createCommonMap().entrySet())
			{
				if(kv.getKey() != null && kv.getValue() != null)
				{
					reqStr += kv.getKey() + "="+  kv.getValue()+  this.REQUEST_QUERY_PARAM_STR;
				
				}
			}
			
			reqStr = reqStr.substring(0, reqStr.lastIndexOf(REQUEST_QUERY_PARAM_STR));
			//reqStr += apiReqParams;
			_log.debug("Request String is " + reqStr);
		
		
		return reqStr;
		
	}
	
	
	public String buildRequest(String apiUri)
	{
		String eanRestQuery = null;
		
		if(apiUri != null)
		{
			eanRestQuery = buildBaseEANRequest(apiUri);
		}
		
		return eanRestQuery;
		
	}
	
	
	private String getBookingEndPoint()
	{
		return EANEndpointsEnum.EanBookingEndPoint.getEndPointVal();
	}
	
	public String getEANRapidDefaultLangParam()
	{
		String langReqParamStr = "";
		
		langReqParamStr += EAN_RAPID_LANGAUGE_PARAM_NAME + "=" + DEFAULT_LOCALE;
		
		return langReqParamStr;
	}
	
	
	public String getEANRapidIncludeParams()
	{
		return EAN_RAPID_REGION_RESPONSE_INCLUDE_PARAM + "=" + "property_ids";
	}
	

}
