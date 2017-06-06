/**
 * 
 */
package com.netreality.vertie.search;

import java.util.List;

import com.netreality.live4carnival.integration.to.CSESearchResponseUrl;
import com.netreality.live4carnival.integration.to.CSESearchResultContext;
import com.netreality.live4carnival.integration.to.CSESearchResultItems;
import com.netreality.live4carnival.integration.to.CSESearchResultQueries;
import com.netreality.live4carnival.integration.to.CSESearchResultRequestQuery;
import com.netreality.live4carnival.integration.to.CSESearchResultSearchInfo;
import com.netreality.live4carnival.integration.to.CSESearchResultSpelling;

/**
 * @author JahLion
 *
 */
public class GoogleCSESearchResponse {
	
	private String kind;
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public CSESearchResponseUrl getUrl() {
		return url;
	}
	public void setUrl(CSESearchResponseUrl url) {
		this.url = url;
	}
	
	public CSESearchResultContext getContext() {
		return context;
	}
	public void setContext(CSESearchResultContext context) {
		this.context = context;
	}
	public CSESearchResultSearchInfo getSearchInformation() {
		return searchInformation;
	}
	public void setSearchInformation(CSESearchResultSearchInfo searchInformation) {
		this.searchInformation = searchInformation;
	}
	
	public CSESearchResultSpelling getSpelling() {
		return spelling;
	}
	public void setSpelling(CSESearchResultSpelling spelling) {
		this.spelling = spelling;
	}
	private CSESearchResponseUrl url;
	private CSESearchResultQueries queries ;
	
	
	
	
	
	public CSESearchResultQueries getQueries() {
		return queries;
	}
	public void setQueries(CSESearchResultQueries queries) {
		this.queries = queries;
	}
	private CSESearchResultContext context;
	private CSESearchResultSearchInfo searchInformation;
	private List<CSESearchResultItems> items;
	public List<CSESearchResultItems> getItems() {
		return items;
	}
	public void setItems(List<CSESearchResultItems> items) {
		this.items = items;
	}
	private CSESearchResultSpelling spelling;
}
