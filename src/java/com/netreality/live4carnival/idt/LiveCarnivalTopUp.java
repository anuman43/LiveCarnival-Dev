package com.netreality.live4carnival.idt;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.live4carnival.web.integration.rest.util.LiveCarnivalIDT;
import com.netreality.live4carnival.idt.Json.to.LocalTopUpProduct;
import com.netreality.live4carnival.idt.Json.to.TopUpProduct;

 import static com.live4carnival.web.integration.rest.util.LiveCarnivalIDT.IDT_GET_LOCAL_PRODUCTS_KEY;
 import static com.live4carnival.web.integration.rest.util.LiveCarnivalIDT.SANDBOX_LIVE_CARNIVAL_APP_ID;
import static com.live4carnival.web.integration.rest.util.LiveCarnivalIDT.SANDBOX_LIVE_CARNIVAL_APP_KEYS;
 

/**
 * @date Jul 11, 2015
 */

/**
 * @author ldurh516
 *
 * @date Jul 11, 2015
 *	
 */
public class LiveCarnivalTopUp {
	
	private Logger _log = Logger.getLogger(LiveCarnivalTopUp.class);
	private String IDT_COUNTRY_TOKEN = "country";
	public LiveCarnivalTopUp()
	{
		_log.debug("Live Carnival API integration to IDT");
	}
	
	public List<TopUpProduct> getAllProducts()
	{
		List<TopUpProduct> allIdtList = null;
		
		String allProdJsonStr = LiveCarnivalIDT.getAllIDTProducts();
		
		allIdtList = parseJSonContent(allProdJsonStr);
		
		
		
		return allIdtList;
	}
	
	public String getLocalProduct(LocalTopUpProduct localReq,String apiKey,String appProductKeys)
	{
		String localProduct = null;
		
		localProduct = LiveCarnivalIDT.getLocalIDTProducts(localReq,IDT_GET_LOCAL_PRODUCTS_KEY , SANDBOX_LIVE_CARNIVAL_APP_ID, SANDBOX_LIVE_CARNIVAL_APP_KEYS);
		
		return localProduct;
	}
	
	
	
	private List<TopUpProduct> parseJSonContent(String jsonContent)
	{
		List<TopUpProduct> productList = new ArrayList<TopUpProduct>();
		JsonParser jParse = null;
		JsonFactory jf = new JsonFactory();
		ObjectMapper objMap = new ObjectMapper();
		try {
			jParse = jf.createParser(jsonContent);
			jParse.nextToken();
			TopUpProduct prod = null;
			while(jParse.nextToken() == JsonToken.START_OBJECT)
			{
				 prod = objMap.readValue(jParse, TopUpProduct.class);
				 if(prod != null)
					 productList.add(prod);
				//_log.debug(jParse.getValueAsString());
			}
		} catch (JsonParseException jpe) {
			_log.error(jpe);
		} catch (IOException ioe) {
			_log.error(ioe);
		}
		
		return productList;
	}
	

}
