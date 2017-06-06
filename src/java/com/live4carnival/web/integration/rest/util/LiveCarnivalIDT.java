/**
 * @date Jul 1, 2015
 */
package com.live4carnival.web.integration.rest.util;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.netreality.live4carnival.enums.HttpActionEnum;
import com.netreality.live4carnival.httpresponse.RestResponseHandler;
import com.netreality.live4carnival.idt.Json.to.LocalTopUpProduct;
import com.netreality.live4carnival.integration.to.QPXAirfareRequestTO;

/**
 * @author ldurh516
 *
 * @date Jul 1, 2015
 *	
 */
public class LiveCarnivalIDT {
	
	private static String IDT_PORTAL_URI = "https://api.idtbeyond.com/v1/iatu";
	private static String IDT_MEDIA_TYPE = "application/json";
	private static RestTemplate restRequestTemplate;
	private static RestResponseHandler respHandler;
	
	//IDT Information per Live4Carnival
	public static String SANDBOX_LIVE_CARNIVAL_APP_ID = "8a9ed7dd";
	public static String SANDBOX_LIVE_CARNIVAL_APP_KEYS = "8cd3da9ad987af88611e61b3fc063e5d";
	
	private static String IDT_APP_ID_HEADER = "x-idt-beyond-app-id";
	private static String IDT_APP_KEYS_HEADER = "x-idt-beyond-app-key";
	
	private static List<HttpMessageConverter<?>> converters;
	private static StringHttpMessageConverter stConv;
	private static MappingJackson2HttpMessageConverter mjsonConv;
	
	private static Map<String,String> IDT_GET_API_CALL_LIST_TO_ENDPOINT_MAP;
	
	//Logging
	private static Logger _log = Logger.getLogger(LiveCarnivalIDT.class);
	
	
	//API END Point Strings
	public static String IDT_GET_ALL_PRODUCTS_KEY = "Products";
	public static String IDT_GET_LOCAL_PRODUCTS_KEY = "LocalProducts";
	
	//APR End Points
	private static String IDT_GET_LOCAL_PRODUCTS_ENDPOINT = "https://api.idtbeyond.com/v1/iatu/products/reports/local_value";
	
	
	static
	{
		restRequestTemplate = new RestTemplate();
		respHandler = new RestResponseHandler();
		restRequestTemplate.setErrorHandler(respHandler);
		stConv = new StringHttpMessageConverter();
		converters = new ArrayList<HttpMessageConverter<?>>();
		converters.add(stConv);
		mjsonConv = new MappingJackson2HttpMessageConverter();
		//ObjectMapper objMap = mjsonConv.getObjectMapper();
		
		converters.add(mjsonConv);
		restRequestTemplate.setMessageConverters(converters);
		IDT_GET_API_CALL_LIST_TO_ENDPOINT_MAP = new HashMap<String,String>();
		IDT_GET_API_CALL_LIST_TO_ENDPOINT_MAP.put("Products", "https://api.idtbeyond.com/v1/iatu/products/reports/all");
		IDT_GET_API_CALL_LIST_TO_ENDPOINT_MAP.put(IDT_GET_LOCAL_PRODUCTS_KEY, "https://api.idtbeyond.com/v1/iatu/products/reports/local_value");
		
	}
	
	
	public static String getAllIDTProducts()
	{
		String getProductsEndPoint = null;
		
		String allProductJsonStr = null;
		
		getProductsEndPoint = IDT_GET_ALL_PRODUCTS_KEY;
		
		Object getArgs = null;
		
		allProductJsonStr = invokeIDTGetAPI(IDT_GET_API_CALL_LIST_TO_ENDPOINT_MAP.get(getProductsEndPoint), getArgs);
		
		return allProductJsonStr;
	}
	
	
	public static String getLocalIDTProducts(LocalTopUpProduct localReq,String idtEndpointKey,String apiKey,String productKeys)
	{
		String localProdResponse = null;
		
		Object getArgs = null;
		
		 localProdResponse = invokeIDTGetAPIWithBody(IDT_GET_API_CALL_LIST_TO_ENDPOINT_MAP.get(idtEndpointKey),getArgs,localReq,apiKey,productKeys);
		
		return localProdResponse;
		
	}
	
	
	public static String getIDTAPIStatus(String idTEndPoint)
	{
		String restResponse = null;
		
		HttpEntity<String> reqEntity = createIDTAppHeaders(SANDBOX_LIVE_CARNIVAL_APP_ID, SANDBOX_LIVE_CARNIVAL_APP_KEYS);
		
		restResponse = performRcRESTOperation(idTEndPoint,  HttpActionEnum.Get.getAction(),reqEntity, null);
		
		
		return restResponse;
	}
	
	
	public static String invokeIDTGetAPIWithBody(String idTEndPoint,Object apiArgs,LocalTopUpProduct bodyParams,String apiKey,String appKeys)
	{
		String restResponse = null;
		
		HttpEntity<LocalTopUpProduct> reqEntity = createIDTAppHeadersWithBody(bodyParams,apiKey, appKeys);
		
		restResponse = performRcRESTOperation(idTEndPoint,  HttpActionEnum.Get.getAction(),reqEntity, null);
		
		
		return restResponse;
	}
	
	
	
	
	
	private static String invokeIDTGetAPI(String apiEndpoint,Object apiArgs)
	{
		String restResponse = null;
		
		HttpEntity<String> reqEntity = createIDTAppHeaders(SANDBOX_LIVE_CARNIVAL_APP_ID, SANDBOX_LIVE_CARNIVAL_APP_KEYS);
		
		restResponse = performRcRESTOperation(apiEndpoint,  HttpActionEnum.Get.getAction(),reqEntity, null);
		
		
		return restResponse;
	}
	
	
	
	private static HttpEntity<String> createIDTAppHeaders(String appId,String appKeys)
	{
		HttpEntity<String> requestEnt = null;
		
				
		HttpHeaders idtrequestAppHeaders = null;
		
		idtrequestAppHeaders = createIDTHeader(appId,appKeys);
		
			
		requestEnt = new HttpEntity<String>(idtrequestAppHeaders);
		
		return requestEnt;
		
	}
	
	private static HttpHeaders createIDTHeader(String appId,String appKeys)
	{
		HttpHeaders requestAppHeaders = new HttpHeaders();
		
		requestAppHeaders.add(IDT_APP_ID_HEADER,appId );
		requestAppHeaders.add(IDT_APP_KEYS_HEADER,appKeys );
		
		requestAppHeaders.setContentType(MediaType.APPLICATION_JSON);
		
		return requestAppHeaders;
	}
	
	
	
	private static HttpEntity<LocalTopUpProduct> createIDTAppHeadersWithBody(LocalTopUpProduct bodyParams,String appId,String appKeys)
	{
		HttpEntity<LocalTopUpProduct> requestEnt = null;
		
		HttpHeaders idtHeaders = createIDTHeader(appId,appKeys);
		
		requestEnt = new HttpEntity<LocalTopUpProduct>(bodyParams,idtHeaders);
		
		return requestEnt;
		
	}
	
	
	private static String performRcRESTOperation(String rcRESTUri,Integer action,HttpEntity<?> requestEntity,Object args) throws RestClientException 
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


}
