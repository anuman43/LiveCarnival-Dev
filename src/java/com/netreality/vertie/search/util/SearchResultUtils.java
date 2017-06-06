/**
 * @date Oct 18, 2014
 */
package com.netreality.vertie.search.util;

import java.io.IOException;
import java.util.ArrayList;
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

}
