/**
 * @date Oct 18, 2014
 */
package com.netreality.vertie.search.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.apache.log4j.Logger;
import org.jsoup.Connection;
import org.jsoup.Jsoup;

import com.netreality.live4carnival.integration.to.CSESearchResultItems;
import com.netreality.live4carnival.integration.to.CseResultsMetaTag;
import com.netreality.live4carnival.integration.to.CseSearchResultThumbNail;
import com.netreality.vertie.alpha.to.SearchResultTO;
import com.netreality.vertie.search.GoogleCSESearchResponse;

/**
 * @author ldurh516
 *
 * @date Oct 18, 2014
 *	
 */
public class SearchResultUtils {
	
	public static int CONNECTION_TIMEOUT = 30000;
	private static Logger _log = Logger.getLogger(SearchResultUtils.class);
	static HashMap<String,String> countryCodeMap = null;
	
	static {
			 countryCodeMap = new HashMap<String,String>();
			 countryCodeMap.put("Antigua and Barbuda", "AG");
			 countryCodeMap.put("Anguilla", "AL");
			 countryCodeMap.put("Aruba","AW");
			 countryCodeMap.put("Bahamas","BS");
			 countryCodeMap.put("Belize","BZ");
			 countryCodeMap.put("Barbados","BB");
			 countryCodeMap.put("Bermuda","BM");
			 countryCodeMap.put("Canada","CA");
			 countryCodeMap.put("Cayman Islands","KY");
			 countryCodeMap.put("Cuba","CU");
			 countryCodeMap.put("Curacao","CW");
			 countryCodeMap.put("Dominican Republic","DO");
			 countryCodeMap.put("Grenada","GD");
			 countryCodeMap.put("Guadeloupe","GP");
			 countryCodeMap.put("Haiti","HT");
			 countryCodeMap.put("Jamaica","JM");
			 countryCodeMap.put("Martinique","MQ");
			 countryCodeMap.put("Puerto Rico","PR");
			 countryCodeMap.put("Brazil","BR");
			 countryCodeMap.put("Saint Barthélemy","BL");
			 countryCodeMap.put("St Croix US VI","US");
			 countryCodeMap.put("St. Kitts & Nevis","KN");
			 countryCodeMap.put("St. Lucia","LC");
			 countryCodeMap.put("St Thomas US VI","US");
			 countryCodeMap.put("St. Vincent and the Grenadines","VC");
			 countryCodeMap.put("Trinidad & Tobago","TT");
			 countryCodeMap.put("Turks & Caicos Islands","TC");
			 countryCodeMap.put("United Kindom","GB");
			 countryCodeMap.put("United States","US");
			 countryCodeMap.put("Costa Rica","CR");
			 countryCodeMap.put("El Salvador","SV");
			 countryCodeMap.put("Guatemala","GT");
			 countryCodeMap.put("Honduras","HN");
			 countryCodeMap.put("Mexico","MX");
			 countryCodeMap.put("Nicaragua","NI");
			 countryCodeMap.put("Panama","PA");
			 countryCodeMap.put("Venezuela","VE");
			 countryCodeMap.put("Guyana","GY");
			/* countryCodeMap.put("","");
			 countryCodeMap.put("","");
			 countryCodeMap.put("","");
			 countryCodeMap.put("","");*/
			 
			 
			 
			 
			 
			 
			 
	}
	
	public static String getResultTitle(String url) throws IOException
	{
		String pgTitle = null;
		Connection con = Jsoup.connect(url);
		con.timeout(CONNECTION_TIMEOUT);
		pgTitle = con.get().title();
		
		return pgTitle;
		
	}
	
	public static List<SearchResultTO> convertCSERestResp(GoogleCSESearchResponse srcResult,String searchTerm)
	{
		List<SearchResultTO> resultList = null;
		if(srcResult != null)
		{
			_log.info("CSE Rest search returned-"+ srcResult.getItems().size() + " results");
			resultList = new ArrayList<SearchResultTO>(srcResult.getItems().size());
			SearchResultTO cseResult = null;
			Map<Object,Object> pageMapObj = null;
			List<Object> resultItemsList = null;
			LinkedHashMap itemObj = null;
			CseSearchResultThumbNail thumbs = null;
			ArrayList<CseSearchResultThumbNail> thumbList = null;
			ArrayList<CseResultsMetaTag> metaTagList = null;
			
			CseResultsMetaTag mTag = null;
			for(CSESearchResultItems items: srcResult.getItems())
			{
				if(items != null)
				{
					pageMapObj = items.getPagemap();
					cseResult = new SearchResultTO();
					cseResult.setSearchPhrase(searchTerm);
					cseResult.setResultUrl(items.getLink());
					cseResult.setResultPageTitle(items.getTitle());
					cseResult.setResultSnippet(items.getSnippet());
					cseResult.setResultHtmlSnippet(items.getHtmlSnippet());
					thumbList = new ArrayList<CseSearchResultThumbNail>();
					 metaTagList = new ArrayList<CseResultsMetaTag>();
					if(!pageMapObj.isEmpty())
					{
						_log.debug("Search Result Item has pagemap object");
						for(Map.Entry<Object, Object> ent : pageMapObj.entrySet())
						{
							resultItemsList = (List<Object>) ent.getValue();
							if(resultItemsList != null)
							{
								itemObj = (LinkedHashMap) resultItemsList.get(0);
								Set<Map.Entry<Object, Object>> linkedObj = itemObj.entrySet();
								String keyName = (String)ent.getKey();
								Iterator<Entry<Object, Object>> thumbIt = null;
								if(keyName.equalsIgnoreCase("cse_thumbnail"))
								{
									thumbIt = linkedObj.iterator();
									 _log.debug("Adding thumbnails");
									thumbs = new CseSearchResultThumbNail();
									while(thumbIt.hasNext())
									{
										Entry<Object, Object> stEnt = thumbIt.next();
										String key = (String)stEnt.getKey();
										if(key.trim().equals("width"))
										{
											
											thumbs.setWidth(stEnt.getValue().toString());
										}
										else if(key.trim().equals("height"))
										{
											
											thumbs.setHeight(stEnt.getValue().toString());
										}
										else
										{
											thumbs.setSrc(stEnt.getValue().toString());
										}
										
																			
									}
									
									thumbList.add(thumbs);
								}
								else if(keyName.equalsIgnoreCase("metatags"))
								{
									Iterator<Entry<Object, Object>> metaIt = linkedObj.iterator();
									 while(metaIt.hasNext())
									 {
										 mTag = new CseResultsMetaTag();
										 Entry<Object, Object> stEnt = metaIt.next();
										 String key = (String)stEnt.getKey();
										 mTag.setName(key);
										 mTag.setValue((String)stEnt.getValue());
										 metaTagList.add(mTag);
									 }
									 
								}
							
							}
						}
							
					}
					cseResult.setThumbList(thumbList);
					cseResult.setMetaTagList(metaTagList);
					resultList.add(cseResult);
				}
			}
		}
		
		return resultList;
	}
	
	
	public static String getISOTwoCountryCode(String countryStr)
	{
		String iso2CountryCode = null;
		
		if(countryStr != null)
		{
			iso2CountryCode = countryCodeMap.get(countryStr);
			_log.debug("The 2 letter country code for -" + countryStr + " is- " + iso2CountryCode);
		}
		
		return iso2CountryCode;
	}
	

}
