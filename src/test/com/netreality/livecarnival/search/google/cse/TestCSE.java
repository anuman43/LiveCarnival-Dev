/**
 * 
 */
package com.netreality.livecarnival.search.google.cse;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.web.client.RestClientException;

import com.live4carnival.web.integration.rest.util.Live4CarnivalRestUtil;
import com.netreality.live4carnival.integration.to.CSESearchResultItems;
import com.netreality.live4carnival.integration.to.CseResultsMetaTag;
import com.netreality.live4carnival.integration.to.CseSearchResultThumbNail;
import com.netreality.vertie.search.GoogleCSESearchResponse;
import com.netreality.vertie.test.BaseUnitTest;



/**
 * @author JahLion
 *
 */
public class TestCSE extends BaseUnitTest {
	
	private static String CSE_GOOGLE_LIVECARNIVALBETA_ENGINE_ID = "003115069608776384649:rrhitb9ek_0";
	private static String CSE_GOOGLE_DEVELOPER_API_KEY = "AIzaSyAmuWfqdXhmD1HarV1v6RPA1CIS_jZ4rzY";
	private static String API_KEY_PARAM ="key=";
	private static String CSE_REST_TARGET_URL ="https://www.googleapis.com/customsearch/v1";
	private static String CSE_CLIENT_PARAM_KEY ="client=";
	private static String CSE_CLIENT_PARAM_VALUE = "google-csbe";
	private static String CSE_ID_PARAM_KEY = "cx=";
	private static String CSE_OUTPUT_PARAM_KEY = "output=";
	private static String CSE_OUTPUT_PARAM_VALUE = "xml";
	private static String CSE_SEARCH_QRY_WORDS_PARAM = "q=";
	private Document resultDoc;
	private static String TEST_SEARCH_QRY_STRING  = "";
	private static String PARAM_ARG_SEPERATOR ="&";
	
	
	@BeforeClass
	public static void setUp()
	{
		setLogger(Logger.getLogger(TestCSE.class));
		TEST_SEARCH_QRY_STRING = "When is Miami Carnival";
	}
	
	@AfterClass
	public static void tearDown()
	{
		TEST_SEARCH_QRY_STRING = null;
	}
	
	
	private String buildSearchQryParams()
	{
		String cseSearchQry = "";
		cseSearchQry +=  API_KEY_PARAM + CSE_GOOGLE_DEVELOPER_API_KEY + PARAM_ARG_SEPERATOR;
		cseSearchQry += CSE_ID_PARAM_KEY + CSE_GOOGLE_LIVECARNIVALBETA_ENGINE_ID + PARAM_ARG_SEPERATOR;
		cseSearchQry += CSE_CLIENT_PARAM_KEY + CSE_CLIENT_PARAM_VALUE + PARAM_ARG_SEPERATOR;
		cseSearchQry += CSE_OUTPUT_PARAM_KEY + CSE_OUTPUT_PARAM_VALUE + PARAM_ARG_SEPERATOR;
		cseSearchQry += CSE_SEARCH_QRY_WORDS_PARAM + TEST_SEARCH_QRY_STRING;
		
		return cseSearchQry;
		
	}

	
	@Ignore
	public void testCSESearch()
	{
		//Document cseResultsXml = null;
		GoogleCSESearchResponse resp = null;
		String searchQry = null;
		Assert.assertNull(ASSERT_NULL_MESSAGE, resp);
		Assert.assertNull(ASSERT_NULL_MESSAGE, searchQry);
		searchQry = buildSearchQryParams();
		try {
			resp = Live4CarnivalRestUtil.executeCSERequest(searchQry);
		} catch (RestClientException | UnsupportedEncodingException mte) {
			getLog().error(mte);;
		}
		Assert.assertNotNull(ASSERT_NOT_NULL_MESSAGE, resp);
	}
	
	
	@Test
	public void testCSEResults()
	{
		GoogleCSESearchResponse respObj = null;
		respObj = getCSESearchResults();
		List <CSESearchResultItems> resultItemList = null;
		Assert.assertNull(ASSERT_NULL_MESSAGE, resultItemList);
		resultItemList = respObj.getItems();
		Assert.assertTrue(ASSERT_CONDITION_TRUE, !resultItemList.isEmpty());
		Map<Object,Object> pageMapObj = null;
		List<Object> resultItemsList = null;
		CseSearchResultThumbNail thumbs = null;
		ArrayList<CseSearchResultThumbNail> thumbList = new ArrayList<CseSearchResultThumbNail>();
		ArrayList<CseResultsMetaTag> metaTagList = new ArrayList<CseResultsMetaTag>();
		CseResultsMetaTag mTag = null;
		getLog().info("Starting-------------------------------->");
		for(CSESearchResultItems cseItem:resultItemList)
		{
			 pageMapObj = cseItem.getPagemap();
			 if(pageMapObj != null)
				 getLog().debug("Contains a page map object");
			 for(Map.Entry<Object, Object> ent : pageMapObj.entrySet())
			 {
				getLog().debug("Key name is:" + ent.getKey() + " Key value is: " + ent.getValue());
				resultItemsList = (List<Object>) ent.getValue();
				getLog().debug("PageMap Items " + resultItemsList.size() + resultItemsList);
				LinkedHashMap itemObj = (LinkedHashMap) resultItemsList.get(0);
				//getLog().debug(itemObj.size());
				//getLog().debug(itemObj.getClass().getName());
				Set<Map.Entry<Object, Object>> linkedObj = itemObj.entrySet();
				getLog().debug(linkedObj.getClass().getName());
				getLog().debug(itemObj.toString());
				String keyName = (String)ent.getKey();
				if(keyName.equalsIgnoreCase("cse_thumbnail"))
				{
					
					//linkedObj.stream().forEach( thumbs = new CseSearchResultThumbNail();});
					Iterator<Entry<Object, Object>> it = linkedObj.iterator();
					thumbs = new CseSearchResultThumbNail();
					while(it.hasNext())
					{
						
						Entry<Object, Object> stEnt = it.next();
						String key = (String)stEnt.getKey();
						getLog().debug("The key's name is " + key);
						if(key.trim().equals("width"))
						{
							getLog().debug("Adding the width");
							thumbs.setWidth(stEnt.getValue().toString());
						}
						else if(key.trim().equals("height"))
						{
							getLog().debug("Adding the height");
							thumbs.setHeight(stEnt.getValue().toString());
						}
						else
						{
							thumbs.setSrc(stEnt.getValue().toString());
						}
						
						//getLog().info("Key name is-"+stEnt.getKey());
						//getLog().info("Key value is-"+stEnt.getValue());
						
					}
					
					thumbList.add(thumbs);
				}
				else if(keyName.equalsIgnoreCase("metatags"))
				{
					Iterator<Entry<Object, Object>> it = linkedObj.iterator();
					while(it.hasNext())
					{
						mTag = new CseResultsMetaTag();
						Entry<Object, Object> stEnt = it.next();
						String key = (String)stEnt.getKey();
						//getLog().debug("The meta tags key's name is " + key);
						//getLog().debug("The meta tags key's value is " + stEnt.getValue());
						mTag.setName(key);
						mTag.setValue(stEnt.getValue().toString());
						metaTagList.add(mTag);
					}
					
				}
				
				
			 }
			 Assert.assertNotNull(ASSERT_NOT_NULL_MESSAGE, pageMapObj);
			
		}
		getLog().debug("Collected-"+thumbList.size() + " thumbnails");
		getLog().debug("Collected-"+metaTagList.size() + "meta tags");
		for(CseSearchResultThumbNail t: thumbList)
		{
			//getLog().debug("Thumbnail"+ "width="+ t.getWidth() +"height"+ t.getHeight()+"src=" + t.getSrc());
		}
		for(CseResultsMetaTag mt: metaTagList)
		{
			getLog().debug("Meta Tag-" +mt.getName()+ ":value-" + mt.getValue());
		}
		
		getLog().info("End<-------------------------------->");
	}
	
	private GoogleCSESearchResponse getCSESearchResults()
	{
		GoogleCSESearchResponse resp = null;
		
		String searchQry = null;
		Assert.assertNull(ASSERT_NULL_MESSAGE, resp);
		Assert.assertNull(ASSERT_NULL_MESSAGE, searchQry);
		searchQry = buildSearchQryParams();
		try {
			resp = Live4CarnivalRestUtil.executeCSERequest(searchQry);
		} catch (RestClientException | UnsupportedEncodingException mte) {
			getLog().error(mte);;
		}
		Assert.assertNotNull(ASSERT_NOT_NULL_MESSAGE, resp);
		return resp;
	}
	
	
}
